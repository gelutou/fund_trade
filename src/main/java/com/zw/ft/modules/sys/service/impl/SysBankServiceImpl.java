package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.common.base.Constant;
import com.zw.ft.common.utils.FormatUtil;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.modules.sys.entity.SysBank;
import com.zw.ft.modules.sys.repository.SysBankMapper;
import com.zw.ft.modules.sys.service.SysBankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 银行信息表 服务实现类
 * </p>
 *
 * @author Savior
 * @since 2020-09-21
 */
@Service
public class SysBankServiceImpl extends ServiceImpl<SysBankMapper, SysBank> implements SysBankService {

    @Resource
    SysBankMapper sysBankMapper;

    @Override
    public Page<SysBank> getBank(Map<String,Object> params) {
        Page<SysBank> page = new QueryUtil<SysBank>(params).getPage();
        QueryWrapper<SysBank> queryWrapper = new QueryWrapper<>();
        //模糊搜索开户行全称
        String bankName = FormatUtil.isSelectKey("bankName", params);
        if(Constant.TRUE.equals(bankName)){
            queryWrapper.like("BANK_NAME",params.get("bankName"));
        }else if("".equals(bankName)){
            queryWrapper.like("BANK_NAME","");
        }
        //模糊搜索公司名称
        String comName = FormatUtil.isSelectKey("comName", params);
        if(Constant.TRUE.equals(comName)){
                queryWrapper.like("com_name",params.get("comName"));
        }else if("".equals(comName)){
                queryWrapper.like("com_name","");
        }

        //模糊搜索银行账号
        String bankAccount = FormatUtil.isSelectKey("bankAccount", params);
        if(Constant.TRUE.equals(bankAccount)){
            queryWrapper.like("BANK_ACCOUNT",params.get("bankAccount"));
        }else if("".equals(bankAccount)){
            queryWrapper.like("BANK_ACCOUNT","");
        }
        //模糊搜索账号类别
        String accountStyle = FormatUtil.isSelectKey("accountStyle", params);
        if(Constant.TRUE.equals(accountStyle)){
            queryWrapper.like("ACCOUNT_STYLE",params.get("accountStyle"));
        }else if("".equals(accountStyle)){
            queryWrapper.like("ACCOUNT_STYLE","");
        }
        //模糊搜索账号性质
        String accountType = FormatUtil.isSelectKey("accountType", params);
        if(Constant.TRUE.equals(accountType)){
            queryWrapper.like("ACCOUNT_TYPE",params.get("accountType"));
        }else if("".equals(accountType)){
            queryWrapper.like("ACCOUNT_TYPE","");
        }
        return sysBankMapper.querySysBankPageByComId(page,queryWrapper);
    }

}
