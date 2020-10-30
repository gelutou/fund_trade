package com.zw.ft.modules.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.common.utils.R;
import com.zw.ft.common.utils.ShiroUtils;
import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.entity.SysNeeds;
import com.zw.ft.modules.sys.entity.SysUser;
import com.zw.ft.modules.sys.service.SysNeedsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  系统需求表 前端控制器
 * </p>
 *
 * @author Oliver
 * @since 2020-10-29
 */
@RestController
@RequestMapping("/ft/sys-needs")
public class SysNeedsController {

    @Resource
    SysNeedsService sysNeedsService;

    /*
     * 功能描述: <br>
     * 〈查询需求列表〉
     * @Param:
     * @Return:
     * @Author: Oliver
     * @Date: 2020/10/30 16:44
     */

    @RequestMapping("/queryPage")
    public R queryPage(@RequestBody(required = false) Map<String,Object> params){
        SysUser userEntity = ShiroUtils.getUserEntity();
        Long userId = ShiroUtils.getUserId();
        System.out.println("userId = " + userId);
        System.out.println("userEntity = " + userEntity);
        return R.page(sysNeedsService.queryPage(params));
    }

    /*
     * 功能描述: <br>
     * 〈添加一个需求〉
     * @Author: Oliver
     * @Date: 2020/10/30 16:45
     */

    @RequestMapping("/add")
    public R add(@RequestBody(required = false) SysNeeds sysNeeds){
        sysNeedsService.save(sysNeeds);
        return R.ok();
    }

    /*
     * 功能描述: <br>
     * 〈修改一个需求〉
     * @Author: Oliver
     * @Date: 2020/10/30 16:45
     */

    @RequestMapping("/update")
    public R update(@RequestBody(required = false) SysNeeds sysNeeds){
        sysNeedsService.updateById(sysNeeds);
        return R.ok();
    }

    /*
     * 功能描述: <br>
     * 〈删除公司需求〉
     * @Param:
     * @Return:
     * @Author: Oliver
     * @Date: 2020/10/30 16:53
     */

    @RequestMapping("/delete/{needIds}")
    public R delete(@PathVariable("needIds") String needIds){
        UpdateWrapper<SysNeeds> needsUpdateWrapper = new UpdateWrapper<>();
        needsUpdateWrapper.in("id",needIds);
        sysNeedsService.remove(needsUpdateWrapper);
        return R.ok();
    }
}

