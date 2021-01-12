package com.zw.ft.modules.sys.service.impl;

import cn.hutool.core.convert.Convert;
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

        String condition = FormatUtil.isSelectKey("condition", params);

        //银行编码、银行全称、银行简称、银行账户 模糊搜索
        if (Constant.TRUE.equals(condition)) {
            queryWrapper.nested(i -> i.like("su.code",params.get("condition"))
                    .or().like("su.bank_name",params.get("condition"))
                    .or().like("su.short_name",params.get("condition"))
                    .or().like("su.account",params.get("condition"))
            );
        }

        //根据客商id模糊搜索银行信息
        String cusId = FormatUtil.isSelectKey("cusId", params);
        if(Constant.TRUE.equals(cusId)){
            String[] convert = Convert.convert(String[].class, params.get("cusId"));
            queryWrapper.in("su.cus_id",convert);
        }

        //账号类别
        String type = FormatUtil.isSelectKey("type", params);
        if (Constant.TRUE.equals(type)) {
            queryWrapper.eq("su.type", params.get("type"));
        } else if ("".equals(type)) {
            queryWrapper.eq("su.type", "");
        }

        //账号性质
        String nature = FormatUtil.isSelectKey("nature", params);
        if (Constant.TRUE.equals(nature)) {
            queryWrapper.eq("su.nature", params.get("nature"));
        } else if ("".equals(nature)) {
            queryWrapper.eq("su.nature", "");
        }
        queryWrapper.orderByAsc("su.UPDATED_time","su.CREATED_TIME");
        return sysBankMapper.querySysBankPageByWrapper(page, queryWrapper);
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
