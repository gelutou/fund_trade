package com.zw.ft.modules.sys.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.common.base.BaseEntity;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.service.SysCompanyService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Map;

/**
 * <p>
 * 公司信息表 前端控制器
 * </p>
 *
 * @author Oliver
 * @since 2020-09-21
 */
@RestController
@Validated
@RequestMapping("/ft/sys-company/")
public class SysCompanyController extends AbstractController {

    @Resource
    SysCompanyService sysCompanyService;

    /**
     * 功能描述: <br>
     * 〈模糊查询用户所在公司，用于登录页展示〉
     *
     * @Param: [username 员工账号, shortName 公司简称 ]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/21 10:53
     */
    @PostMapping(value = "get_fuzzy")
    public R getFuzzy(@RequestBody(required = false) Map<String, Object> params) {
        return R.data(sysCompanyService.getFuzzy(params));
    }

    /**
     * 功能描述: <br>
     * 〈添加公司〉
     *
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/21 10:53
     */
    @PostMapping(value = "/add")
    public R addCom(@RequestBody(required = false) @Validated(BaseEntity.Add.class) SysCompany sysCompany) {
        sysCompanyService.save(sysCompany);
        return R.ok();
    }

    /*
     * 功能描述: <br>
     * 〈更新公司〉
     * @Author: Oliver
     * @Date: 2020/10/21 15:12
     */

    @PostMapping(value = "/update")
    public R update(@RequestBody(required = false) @Validated(BaseEntity.Update.class) SysCompany sysCompany) {
        sysCompanyService.updateById(sysCompany);
        return R.ok();
    }

    /**
     * 功能描述: <br>
     * 〈查询符合条件的公司，公司基本数据菜单〉
     *
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/21 10:53
     */
    @PostMapping(value = "/get_by_wrapper")
    public R getByWrapper(@RequestBody(required = false) Map<String, Object> params) {
        return R.page(sysCompanyService.getComPage(params));
    }

    @PostMapping(value = "/del_coms/{ids}")
    public R delComs(@PathVariable("ids") String ids) {
        return sysCompanyService.delComs(ids);
    }

    /**
     * 功能描述: <br>
     *
     * @Author savior
     * @Description 银行搜索框显示所有公司
     * @Date: 2020/10/26
     */
    @PostMapping(value = "/get_com")
    public R getAllCom() {
        return R.data(sysCompanyService.list());
    }
}

