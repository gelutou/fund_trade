package com.zw.ft.modules.sys.controller;


import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysDictionary;
import com.zw.ft.modules.sys.service.SysDictionaryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 系统字典表  前端控制器
 * </p>
 *
 * @author Oliver
 * @since 2020-12-03
 */
@RestController
@RequestMapping("/ft/sys-dictionary")
public class SysDictionaryController {

    @Resource
    SysDictionaryService sysDictionaryService;

    /*
     * 包含中文正则
     */

    Pattern p = Pattern.compile("[\u4e00-\u9fa5]");

    /*
     * 功能描述: <br>
     * 〈获取字典表信息〉
     * @Author: Oliver
     * @Date: 2020/12/3 9:45
     */

    @RequestMapping(value = "/get_dictionary_page")
    public R getDictionaryPage(@RequestBody(required = false) Map<String, Object> params) {
        if (params == null) {
            params = new HashMap<>(1);
        }
        return R.page(sysDictionaryService.getDictionaryPage(params));
    }

    /*
     * 功能描述: <br>
     * 〈查询字典项详情〉
     * @Author: Oliver
     * @Date: 2020/12/3 9:23
     */

    @RequestMapping(value = "/get_dictionary_children")
    public R getDictionaryChildren(@RequestBody(required = false) Map<String, Object> params) {
        return sysDictionaryService.getDictionaryChildren(params);
    }



    @RequestMapping(value = "/add_dictionary")
    public R addDictionary(@RequestBody(required = false) Map<String, Object> params) {
        SysDictionary dictionary = Convert.convert(SysDictionary.class, params);
        List<SysDictionary> children = dictionary.getChildren();
        if(children == null){
            children = new ArrayList<>();
        }

        QueryWrapper<SysDictionary> sysDictionaryQueryWrapper = new QueryWrapper<>();
        sysDictionaryQueryWrapper.eq("p_id", "").or().isNull("p_id");
        List<SysDictionary> list = sysDictionaryService.list(sysDictionaryQueryWrapper);

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
        sysDictionaryService.save(dictionary);

        Long id = dictionary.getId();
        for (SysDictionary dictionary1 : children) {
            dictionary1.setPId(id);
            sysDictionaryService.save(dictionary1);
        }
        return R.ok();
    }

    /*
     * 功能描述: <br>
     * 〈修改字典项〉
     * @Author: Oliver
     * @Date: 2020/12/3 13:36
     */

    @RequestMapping(value = "/update_dictionary")
    public R updateDictionary(@RequestBody(required = false) Map<String, Object> params) {

        SysDictionary dictionary = Convert.convert(SysDictionary.class, params);
        List<SysDictionary> children = dictionary.getChildren();
        if(children == null){
            children = new ArrayList<>();
        }

        //查询数据是否合法
        String name = dictionary.getName();
        Matcher m = p.matcher(name);

        QueryWrapper<SysDictionary> sysDictionaryQueryWrapper = new QueryWrapper<>();
        sysDictionaryQueryWrapper.eq("p_id", "").or().isNull("p_id");
        Consumer<QueryWrapper<SysDictionary>> consumer = queryWrapper -> queryWrapper.ne("name",name);
        sysDictionaryQueryWrapper.and(consumer);
        List<SysDictionary> list = sysDictionaryService.list(sysDictionaryQueryWrapper);

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

        sysDictionaryService.updateById(dictionary);
        for(SysDictionary dictionary1 : children){
            Long id = dictionary1.getId();
            Long pId = dictionary.getId();
            dictionary1.setPId(pId);
            if(id == null){
                sysDictionaryService.save(dictionary1);
            }
            sysDictionaryService.updateById(dictionary1);
        }
        return R.ok();
    }

    /*
     * 功能描述: <br>
     * 〈删除字典项〉
     * @Author: Oliver
     * @Date: 2020/12/3 13:50
     */

    @RequestMapping(value = "/delete_dictionary")
    public R deleteDictionary(@RequestBody(required = false) Map<String, Object> params) {
        String ids = params.get("ids").toString();
        String[] id;
        if(ids.contains(",")){
            id = ids.split(",");
        }else {
            id = new String[1];
            id[0] = ids;
        }

        for(String str : id){
            sysDictionaryService.removeById(str);
            QueryWrapper<SysDictionary> dictionaryQueryWrapper = new QueryWrapper<>();
            dictionaryQueryWrapper.eq("p_id",str);
            sysDictionaryService.remove(dictionaryQueryWrapper);
        }
        return R.ok();
    }
}

