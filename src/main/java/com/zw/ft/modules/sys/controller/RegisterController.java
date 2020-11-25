package com.zw.ft.modules.sys.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysUser;
import com.zw.ft.modules.sys.entity.SysUserExpansion;
import com.zw.ft.modules.sys.service.SysUserExpansionService;
import com.zw.ft.modules.sys.service.SysUserService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName RegisterController
 * @Description 注册控制器
 * @Author Oliver
 * @Date 2020/9/19 23:20
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/ft/sys")
public class RegisterController {

    @Resource
    SysUserService sysUserService;
    @Resource
    SysUserExpansionService sysUserExpansionService;

    @Resource(name = "transactionManager")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * 功能描述: <br>
     * 〈用户注册，管理员添加用户〉
     *
     * @Param: [username, password]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/19 23:23
     */
    @PostMapping("/signup")
    public R signup(@RequestBody Map<String, Object> params) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        Digester digester = new Digester(DigestAlgorithm.SHA256);
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = platformTransactionManager.getTransaction(def);
        SysUser sysUser = Convert.convert(SysUser.class, params);
        String password = sysUser.getPassword();
        sysUser.setPassword(digester.digestHex(password));
        SysUserExpansion sysUserExpansion = Convert.convert(SysUserExpansion.class, params);

        try {
            sysUserService.save(sysUser);
            if (sysUser.getId() == null) {
                platformTransactionManager.rollback(status);
                return R.error("注册失败");
            }
            sysUserExpansion.setUserId(sysUser.getId());
            sysUserExpansionService.save(sysUserExpansion);
            if (sysUserExpansion.getId() == null) {
                platformTransactionManager.rollback(status);
                return R.error("注册失败");
            }
        } catch (Exception e) {
            platformTransactionManager.rollback(status);
            return R.error("参数异常");
        }
        platformTransactionManager.commit(status);
        return R.ok();
    }
}
