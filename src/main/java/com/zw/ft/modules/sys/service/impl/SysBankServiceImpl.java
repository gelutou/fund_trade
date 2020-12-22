package com.zw.ft.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.common.constants.Constant;
import com.zw.ft.common.utils.FormatUtil;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysBank;
import com.zw.ft.modules.sys.repository.SysBankMapper;
import com.zw.ft.modules.sys.service.SysBankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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
    public Page<SysBank> getBank(Map<String, Object> params) {
        Page<SysBank> page = new QueryUtil<SysBank>(params).getPage();
        QueryWrapper<SysBank> queryWrapper = new QueryWrapper<>();

        //模糊搜索开户行全称
        String bankName = FormatUtil.isSelectKey("bankName", params);
        if (Constant.TRUE.equals(bankName)) {
            queryWrapper.like("bank_name", params.get("bankName"));
        } else if ("".equals(bankName)) {
            queryWrapper.like("bank_name", "");
        }

        //根据客商id模糊搜索
        String cusId = FormatUtil.isSelectKey("cusId", params);
        String string = JSON.toJSONString(params.get("cusId"));
        string = string.replace("[", "").replace("]", "");
        List<String> lists = new LinkedList<>();
        if (Constant.TRUE.equals(cusId)) {
            if (params.toString().contains(",")) {
                String[] split = string.split(",");
                Collections.addAll(lists, split);
                queryWrapper.in("su.cus_id", lists);
            }else {
                queryWrapper.in("su.cus_id", string);
            }
        }

        //模糊搜索银行账号
        String account = FormatUtil.isSelectKey("account", params);
        if (Constant.TRUE.equals(account)) {
            queryWrapper.like("su.account", params.get("account"));
        } else if ("".equals(account)) {
            queryWrapper.like("su.account", "");
        }

        //模糊搜索账号类别
        String type = FormatUtil.isSelectKey("type", params);
        if (Constant.TRUE.equals(type)) {
            queryWrapper.like("su.type", params.get("type"));
        } else if ("".equals(type)) {
            queryWrapper.like("su.type", "");
        }

        //模糊搜索账号性质
        String nature = FormatUtil.isSelectKey("nature", params);
        if (Constant.TRUE.equals(nature)) {
            queryWrapper.like("su.nature", params.get("nature"));
        } else if ("".equals(nature)) {
            queryWrapper.like("su.nature", "");
        }

        queryWrapper.eq("su.deleted", 0);

        queryWrapper.orderByDesc("su.id");;
        return sysBankMapper.querySysBankPageByComId(page, queryWrapper);
    }


    /**
     * @Author savior
     * @Description 逻辑删除
     * @Date: 2020/11/23
     */
    @Override
    public R delBank(String delIds) {
        List<String> lists = new LinkedList<>();
        if (delIds.contains(",")) {
            String[] split = delIds.split(",");
            Collections.addAll(lists, split);
        } else {
            lists.add(delIds);
        }
        sysBankMapper.deleteBatchIds(lists);
        return R.ok();
    }
}
