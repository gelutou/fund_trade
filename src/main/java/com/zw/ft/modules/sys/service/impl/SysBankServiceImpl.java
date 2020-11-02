package com.zw.ft.modules.sys.service.impl;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.common.base.Constant;
import com.zw.ft.common.utils.FormatUtil;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysBank;
import com.zw.ft.modules.sys.repository.SysBankMapper;
import com.zw.ft.modules.sys.service.SysBankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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
            queryWrapper.like("su.BANK_NAME",params.get("bankName"));
        }else if("".equals(bankName)){
            queryWrapper.like("su.BANK_NAME","");
        }



        //模糊搜索公司id
        String comId =FormatUtil.isSelectKey("comId",params);
        String string = JSON.toJSONString(params);
        string = string.replace("[","").replace("]","");
        String[] convert1 = Convert.convert(String[].class, string);
        if(Constant.TRUE.equals(comId)){
            if (params.toString().contains(",")) {
                //convert1.replace("[","").replace("]",""));
                queryWrapper.in("su.com_id", convert1);
            }
        }

        //模糊搜索公司名称
        String comName =FormatUtil.isSelectKey("comName",params);
        if(Constant.TRUE.equals(comName)){
                queryWrapper.like("scy.com_name",params.get("comName").toString().replace("[","").replace("]",""));
        }else if("".equals(comName)){
                queryWrapper.like("scy.com_name","");
        }


        //模糊搜索银行账号
        String bankAccount = FormatUtil.isSelectKey("bankAccount", params);
        if(Constant.TRUE.equals(bankAccount)){
            queryWrapper.like("su.BANK_ACCOUNT",params.get("bankAccount"));
        }else if("".equals(bankAccount)){
            queryWrapper.like("su.BANK_ACCOUNT","");
        }
        //模糊搜索账号类别
        String accountStyle = FormatUtil.isSelectKey("accountStyle", params);
        if(Constant.TRUE.equals(accountStyle)){
            queryWrapper.like("su.ACCOUNT_STYLE",params.get("accountStyle"));
        }else if("".equals(accountStyle)){
            queryWrapper.like("su.ACCOUNT_STYLE","");
        }
        //模糊搜索账号性质
        String accountType = FormatUtil.isSelectKey("accountType", params);
        if(Constant.TRUE.equals(accountType)){
            queryWrapper.like("su.ACCOUNT_TYPE",params.get("accountType"));
        }else if("".equals(accountType)){
            queryWrapper.like("su.ACCOUNT_TYPE","");
        }
        queryWrapper.eq("su.deleted",0);
        queryWrapper.orderByAsc("su.updated_time");
        return sysBankMapper.querySysBankPageByComId(page,queryWrapper);
    }

    @Override
    public R delBank(String delIds) {
        List<String> lists = new LinkedList<>();
        if(delIds.contains(",")){
            String[] split = delIds.split(",");
            Collections.addAll(lists, split);
        }else {
            lists.add(delIds);
        }
        sysBankMapper.deleteBatchIds(lists);
        return R.ok();
    }

}
