package com.zw.ft.modules.sys.controller;


import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.base.Constant;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.common.utils.R;
import com.zw.ft.common.utils.ShiroUtils;
import com.zw.ft.modules.sys.entity.*;
import com.zw.ft.modules.sys.service.RelUserDepartmentService;
import com.zw.ft.modules.sys.service.SysDepartmentService;
import com.zw.ft.modules.sys.service.SysNeedsService;
import com.zw.ft.modules.sys.service.SysReplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
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
public class SysNeedsController extends AbstractController{

    @Resource
    SysNeedsService sysNeedsService;
    @Resource
    SysReplyService sysReplyService;
    @Resource
    SysDepartmentService sysDepartmentService;

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
        //获取当前登录人的部门ID
        Long userId = ShiroUtils.getUserId();
        SysDepartment deptByUserId = sysDepartmentService.getDeptByUserId(userId);
        sysNeeds.setDeptId(deptByUserId.getId());
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

        if(!ObjectUtil.isEmpty(sysNeeds.getStatus())){
            Integer status = sysNeeds.getStatus();
            SysUser user = getUser();
            if(status.equals(Constant.NeedStatus.resolved.getValue())){
                //修改处理人和处理时间
                sysNeeds.setHandler(user.getId());
                sysNeeds.setHandlerTime(DateUtil.now());
            }else if(status.equals(Constant.NeedStatus.confirmed.getValue())){
                //修改确认人和确认时间
                sysNeeds.setConfirmer(user.getId());
                sysNeeds.setConfirmTime(DateUtil.now());
            }
        }
        UpdateWrapper<SysNeeds> needsUpdateWrapper = new UpdateWrapper<>();
        needsUpdateWrapper.eq("id",sysNeeds.getId());
        sysNeedsService.update(sysNeeds, needsUpdateWrapper);
        return R.ok();
    }

    /*
     * 功能描述: <br>
     * 〈删除系统需求〉
     * @Param:
     * @Return:
     * @Author: Oliver
     * @Date: 2020/10/30 16:53
     */

    @RequestMapping("/delete/{needIds}")
    public R delete(@PathVariable("needIds") String needIds){
        String[] ids;
        if(needIds.contains(",")){
            ids = needIds.split(",");
        }else {
            ids = new String[1];
            ids[0] = needIds;
        }
        UpdateWrapper<SysNeeds> needsUpdateWrapper = new UpdateWrapper<>();
        needsUpdateWrapper.in("id",ids);
        StringBuilder stringBuilder = new StringBuilder();
        //判断需求，只有未处理的可以删除
        List<SysNeeds> list = sysNeedsService.list(needsUpdateWrapper);
        for(int i=0;i<list.size();i++){
            SysNeeds needs = list.get(i);
            Integer status = needs.getStatus();
            if(status != 0){
                stringBuilder.append(needs.getTitle()).append(",");
            }else {
                sysNeedsService.removeById(needs.getId());
            }
        }
        if(!"".equals(stringBuilder.toString())){
            return R.ok(stringBuilder.append("状态不是未处理,不能删除").toString());
        }
        return R.ok();
    }

    /*************以下是回复功能***************/

    /*
     * 功能描述: <br>
     * 〈回复一个需求回复〉
     * @Param: [params]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/11/2 11:09
     */

    @RequestMapping("/reply/add")
    public R addReply(@RequestBody(required = false) Map<String,Object> params){
        SysReply sysReply = Convert.convert(SysReply.class, params);
        sysReplyService.save(sysReply);
        return R.ok();
    }

    /*
     * 功能描述: <br>
     * 〈修改一个需求回复〉
     * @Param: [params]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/11/2 11:09
     */

    @RequestMapping("/reply/update")
    public R updateReply(@RequestBody(required = false) Map<String,Object> params){
        SysReply sysReply = Convert.convert(SysReply.class, params);
        sysReplyService.updateById(sysReply);
        return R.ok();
    }

    /*
     * 功能描述: <br>
     * 〈删除一个需求回复〉
     * @Param: [params]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/11/2 11:09
     */

    @RequestMapping("/reply/delete/{replyIds}")
    public R deleteReply(@PathVariable("replyIds") String replyIds){
        String[] ids;
        if(replyIds.contains(",")){
            ids = replyIds.split(",");
        }else {
            ids = new String[1];
            ids[0] = replyIds;
        }

        UpdateWrapper<SysReply> replyUpdateWrapper = new UpdateWrapper<>();
        replyUpdateWrapper.in("id",ids);
        sysReplyService.remove(replyUpdateWrapper);
        return R.ok();
    }

    /*
     * 功能描述: <br>
     * 〈查询一个系统需求的回复〉
     * @Param: needId 系统需求ID
     * @Author: Oliver
     * @Date: 2020/11/2 11:27
     */

    @RequestMapping("/reply/queryOne/{needId}")
    public R deleteReply(@PathVariable("needId") long needId){
        return R.data(sysReplyService.getReplyInfo(needId));
    }
}

