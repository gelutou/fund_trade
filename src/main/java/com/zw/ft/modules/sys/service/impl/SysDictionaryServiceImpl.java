package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.base.Constant;
import com.zw.ft.common.utils.FormatUtil;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysDictionary;
import com.zw.ft.modules.sys.repository.SysDictionaryMapper;
import com.zw.ft.modules.sys.service.SysDictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

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
