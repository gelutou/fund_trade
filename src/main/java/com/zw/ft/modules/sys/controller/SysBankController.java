package com.zw.ft.modules.sys.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysBank;
import com.zw.ft.modules.sys.service.SysBankService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
     * 功能描述: <br>
     *
     * @Author savior
     * @Description 分页查询银行基本信息
     * @Date: 2020/9/28
     */
    @PostMapping("/bankall")
    public R Banckall(@RequestBody Map<String, Object> params) {
        return R.page(sysBankService.getBank(params));
    }


    /**
     * 功能描述: <br>
     *
     * @Author savior
     * @Description 跟据Id逻辑批量删除银行信息
     * @Date: 2020/10/16
     */
    @PostMapping("/deleteByIds/{ids}")
    public R bankDeleteId(@PathVariable("ids") String ids) {
        return sysBankService.delBank(ids);
    }

    /**
     * 功能描述: <br>
     *
     * @Author savior
     * @Description 修改银行
     * @Date: 2020/10/16
     */
    @PostMapping("/updateBank")
    public R updateBank(@RequestBody(required = false) SysBank sysBank) {
        UpdateWrapper<SysBank> bankUpdateWrapper = new UpdateWrapper<>();
        bankUpdateWrapper.eq("id", sysBank.getId());
        boolean update = sysBankService.update(sysBank, bankUpdateWrapper);
        if (update) {
            return R.ok("更新成功");
        } else {
            return R.error("更新失败");
        }
    }

    /**
     * 功能描述: <br>
     *
     * @Author savior
     * @Description 添加银行
     * @Date: 2020/10/16
     */
    @PostMapping("/addBank")
    public R addBank(@RequestBody(required = false) Map<String, Object> params) {
        SysBank sysBank = Convert.convert(SysBank.class, params);
        boolean save = sysBankService.save(sysBank);
        if (save) {
            return R.ok("添加成功");
        } else {
            return R.error("添加失败");
        }
    }

}
