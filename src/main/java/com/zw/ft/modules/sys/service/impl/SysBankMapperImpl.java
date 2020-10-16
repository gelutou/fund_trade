package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SysBankMapperImpl extends ServiceImpl<SysBankMapper, SysBank> implements SysBankService {

    @Resource
    SysBankMapper sysBankMapper;

    @Override
    public Page<SysBank> getBank(Map<String,Object> params) {
        String current = params.get("current") == null?"":params.get("current").toString();
        String size = params.get("size") == null?"":params.get("size").toString();
        Page<SysBank> page = new Page<>();
        if (!"".equals(current)){
            page.setCurrent(Long.parseLong(current));
        }
        if (!"".equals(size)){
            page.setSize(Long.parseLong(size));
        }
        return sysBankMapper.querySysBankPageByComId(page);
    }

}
