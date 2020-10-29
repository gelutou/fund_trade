package com.zw.ft.modules.sys.controller;

import cn.hutool.core.convert.Convert;
import com.zw.ft.common.base.Constant;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysBank;
import com.zw.ft.modules.sys.service.SysBankService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 银行信息表 前端控制器
 * </p>
 *
 * @author Savior
 * @since 2020-09-21
 */
@RestController
@RequestMapping("/ft/sys-bank")
public class SysBankController {

    @Resource
    SysBankService sysBankService;

/**
 * @Author savior
 * @Description  分页查询银行基本信息
 * @Date: 2020/9/28
 */
    @PostMapping("/bankall")
    public R Banckall(@RequestBody Map<String,Object> params){
        return R.page(sysBankService.getBank(params));
    }


    /**
     * @Author savior
     * @Description 跟据Id逻辑批量删除银行信息
     * @Date: 2020/10/16
     */
    @PostMapping("/daleBankId")
    public R bankDeleteId (@RequestBody List<SysBank> idlest){
        if(idlest!=null && idlest.size()!=0){
            sysBankService.removeByIds(idlest);
            return R.ok("删除成功");
        }
        return R.error("删除失败");
    }


    /**
     * 功能描述: <br>
     * @Author savior
     * @Description 新增更新银行
     * @Date: 2020/10/16
     */
    @PostMapping("/add_update_bank")
    public R addBank(@RequestBody(required = false) Map<String,Object> params){
        String addUpdate = params.get("addUpdate").toString();
        SysBank bank = Convert.convert(SysBank.class, params);
        boolean bo;
        if(Constant.DatabaseOperation.ADD.getValue().equals(addUpdate)){
            bo =sysBankService.save(bank);
        }else if(Constant.DatabaseOperation.UPDATE.getValue().equals(addUpdate)){
            bo=sysBankService.updateById(bank);
        }else {
            return R.error("没有传入addUpdate参数");
        }
        if (bo){
            return R.ok("新增更新成功");
        }else {
            return R.error("新增更新失败");
        }
    }
}
