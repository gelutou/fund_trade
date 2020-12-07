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
        return sysDictionaryService.addDictionary(params);
    }

    /*
     * 功能描述: <br>
     * 〈修改字典项〉
     * @Author: Oliver
     * @Date: 2020/12/3 13:36
     */

    @RequestMapping(value = "/update_dictionary")
    public R updateDictionary(@RequestBody(required = false) Map<String, Object> params) {
        return sysDictionaryService.updateDictionary(params);
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

