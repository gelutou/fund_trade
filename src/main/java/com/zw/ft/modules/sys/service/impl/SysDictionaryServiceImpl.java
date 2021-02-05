package com.zw.ft.modules.sys.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.constants.Constant;
import com.zw.ft.common.utils.FormatUtil;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysDictionary;
import com.zw.ft.modules.sys.repository.SysDictionaryMapper;
import com.zw.ft.modules.sys.service.SysDictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 系统字典表  服务实现类
 * </p>
 *
 * @author Oliver
 * @since 2020-12-03
 */
@Service("sysDictionaryService")
public class SysDictionaryServiceImpl extends ServiceImpl<SysDictionaryMapper, SysDictionary> implements SysDictionaryService {

    /*
     * 包含中文正则
     */

    Pattern p = Pattern.compile("[\u4e00-\u9fa5]");

    @Override
    public R addDictionary(Map<String, Object> params) {
        SysDictionary dictionary = Convert.convert(SysDictionary.class, params);
        List<SysDictionary> children = dictionary.getChildren();
        if(children == null){
            children = new ArrayList<>();
        }

        QueryWrapper<SysDictionary> sysDictionaryQueryWrapper = new QueryWrapper<>();
        sysDictionaryQueryWrapper.eq("p_id", "").or().isNull("p_id");
        List<SysDictionary> list = this.baseMapper.selectList(sysDictionaryQueryWrapper);

        //查询数据是否合法
        String name = dictionary.getName();

        Matcher m = p.matcher(name);
        if (m.find()) {
            return R.error("项标识不能包含中文");
        } else {
            for (SysDictionary d : list) {
                String name1 = d.getName();
                if (name.equals(name1)) {
                    return R.error("父项标识与原有标识有冲突，请修改");
                }
            }

            for (SysDictionary d : children) {
                String name1 = d.getName();
                if (!name.equals(name1)) {
                    return R.error("所有子项标识必须和父项标识相同");
                }
            }
        }
        this.baseMapper.insert(dictionary);

        Long id = dictionary.getId();
        for (SysDictionary dictionary1 : children) {
            dictionary1.setPId(id);
            this.baseMapper.insert(dictionary1);
        }
        return R.ok();
    }

    @Override
    public R updateDictionary(Map<String, Object> params) {
        SysDictionary dictionary = Convert.convert(SysDictionary.class, params);

        //oldDictionaries 原有的字典子项
        QueryWrapper<SysDictionary> dictionaryQueryWrapper = new QueryWrapper<>();
        dictionaryQueryWrapper.eq("p_id",dictionary.getId());
        List<SysDictionary> oldDictionaries = this.baseMapper.selectList(dictionaryQueryWrapper);

        List<SysDictionary> children = dictionary.getChildren();
        if(children == null){
            children = new ArrayList<>();
        }

        //查询数据是否合法
        String name = dictionary.getName();
        Matcher m = p.matcher(name);

        QueryWrapper<SysDictionary> sysDictionaryQueryWrapper = new QueryWrapper<>();
        sysDictionaryQueryWrapper.eq("p_id", "").or().isNull("p_id");
        Consumer<QueryWrapper<SysDictionary>> consumer = queryWrapper -> queryWrapper.ne("id",dictionary.getId());
        sysDictionaryQueryWrapper.and(consumer);
        List<SysDictionary> list = this.baseMapper.selectList(sysDictionaryQueryWrapper);

        if (m.find()) {
            return R.error("项标识不能包含中文");
        } else {

            for (SysDictionary d : list) {
                String name1 = d.getName();
                if (name.equals(name1)) {
                    return R.error("父项标识与原有标识有冲突，请修改");
                }
            }

            for (SysDictionary d : children) {
                String name1 = d.getName();
                if (!name.equals(name1)) {
                    return R.error("所有子项标识必须和父项标识相同");
                }
            }
        }

        this.baseMapper.updateById(dictionary);
        for(SysDictionary dictionary1 : children){
            Long id = dictionary1.getId();
            Long pId = dictionary.getId();
            dictionary1.setPId(pId);
            if(id == null){
                this.baseMapper.insert(dictionary1);
            }
            this.baseMapper.updateById(dictionary1);
        }

        //删除子项
        for(SysDictionary old : oldDictionaries){
            Long id = old.getId();
            boolean del = true;
            for(SysDictionary n : children){
                Long id1 = n.getId();
                if(id.equals(id1)){
                    del = false;
                    break;
                }
            }
            if(del){
                this.baseMapper.deleteById(id);
            }
        }
        return R.ok();
    }

    @Override
    public Page<SysDictionary> getDictionaryPage(Map<String, Object> params) {
        Page<SysDictionary> page = new QueryUtil<SysDictionary>(params).getPage();

        QueryWrapper<SysDictionary> queryWrapper = new QueryWrapper<>();

        Consumer<QueryWrapper<SysDictionary>> consumer = sysDictionaryQueryWrapper -> sysDictionaryQueryWrapper.eq("p_id","").or().isNull("p_id");
        queryWrapper.and(consumer);
        //项标识 模糊查询
        String name = FormatUtil.isSelectKey("name", params);
        if (Constant.TRUE.equals(name)) {
            queryWrapper.like("name", params.get("name"));
        } else if ("".equals(name)) {
            queryWrapper.like("name", "");
        }

        //项描述 模糊查询
        String des = FormatUtil.isSelectKey("des", params);
        if (Constant.TRUE.equals(des)) {
            queryWrapper.like("des", params.get("des"));
        } else if ("".equals(des)) {
            queryWrapper.like("des", "");
        }

        queryWrapper.orderByAsc("sort").orderByDesc("CREATED_TIME");
        return this.baseMapper.selectPage(page, queryWrapper);
    }

    @Override
    public R getDictionaryChildren(Map<String, Object> params) {
        String id = params.get("id").toString();
        SysDictionary dictionary = this.baseMapper.selectById(Long.parseLong(id));
        QueryWrapper<SysDictionary> dictionaryQueryWrapper = new QueryWrapper<>();
        dictionaryQueryWrapper.eq("p_id",dictionary.getId());
        List<SysDictionary> sysDictionaries = this.baseMapper.selectList(dictionaryQueryWrapper);
        setChildren(sysDictionaries);
        dictionary.setChildren(sysDictionaries);
        return R.data(dictionary);
    }

    /*
     * 功能描述: <br>
     * 〈设置字典表里子项〉
     * @Author: Oliver
     * @Date: 2020/12/3 9:41
     */

    public void setChildren(List<SysDictionary> sysDictionaries){

        for(SysDictionary dictionary : sysDictionaries){
            Long id = dictionary.getId();
            QueryWrapper<SysDictionary> sysDictionaryQueryWrapper = new QueryWrapper<>();
            sysDictionaryQueryWrapper.eq("p_id",id);
            List<SysDictionary> sysDictionaries1 = this.baseMapper.selectList(sysDictionaryQueryWrapper);
            dictionary.setChildren(sysDictionaries1);
            if(sysDictionaries1.size() != 0){
                setChildren(sysDictionaries1);
            }
        }
    }
}
