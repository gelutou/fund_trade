package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.common.base.Constant;
import com.zw.ft.common.utils.FormatUtil;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.modules.sys.entity.SysCargoInfo;
import com.zw.ft.modules.sys.repository.SysCargoInfoMapper;
import com.zw.ft.modules.sys.service.SysCargoInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 货品信息表 服务实现类
 * </p>
 *
 * @author Savior
 * @since 2020-11-19
 */
@Service("SysCargoInfoService")
public class SysCargoInfoServiceImpl extends ServiceImpl<SysCargoInfoMapper, SysCargoInfo> implements SysCargoInfoService {

    @Resource
    SysCargoInfoMapper sysCargoInfoMapper;

    /**
     * @Author savior
     * @Description 分页查询货品信息
     * @Date: 2020/11/19
     */
    @Override
    public Page<SysCargoInfo> getCargoInfo(Map<String, Object> params) {
        Page<SysCargoInfo> page = new QueryUtil<SysCargoInfo>(params).getPage();
        QueryWrapper<SysCargoInfo> queryWrapper = new QueryWrapper<>();

        //模糊搜索货品编号
        String cargoCode = FormatUtil.isSelectKey("cargoCode", params);
        if (Constant.TRUE.equals(cargoCode)) {
            queryWrapper.like("sci.cargo_code", params.get("cargoCode").toString().replace("[", "").replace("]", ""));
        } else if ("".equals(cargoCode)) {
            queryWrapper.like("sci.cargo_code", "");
        }

        //模糊搜索货品名称
        String cargoName = FormatUtil.isSelectKey("cargoName", params);
        if (Constant.TRUE.equals(cargoName)) {
            queryWrapper.like("sci.cargo_name", params.get("cargoName").toString().replace("[", "").replace("]", ""));
        } else if ("".equals(cargoName)) {
            queryWrapper.like("sci.cargo_name", "");
        }

        //模糊搜索货品品牌
        String brand = FormatUtil.isSelectKey("brand", params);
        if (Constant.TRUE.equals(brand)) {
            queryWrapper.like("sci.brand", params.get("brand").toString().replace("[", "").replace("]", ""));
        } else if ("".equals(brand)) {
            queryWrapper.like("sci.brand", "");
        }

        //模糊搜索货品规格
        String specification = FormatUtil.isSelectKey("specification", params);
        if (Constant.TRUE.equals(specification)) {
            queryWrapper.like("sci.specification", params.get("specification").toString().replace("[", "").replace("]", ""));
        } else if ("".equals(specification)) {
            queryWrapper.like("sci.specification", "");
        }

        //模糊搜索货品型号
        String cargoModel = FormatUtil.isSelectKey("cargoModel", params);
        if (Constant.TRUE.equals(cargoModel)) {
            queryWrapper.like("sci.cargo_model", params.get("cargoModel").toString().replace("[", "").replace("]", ""));
        } else if ("".equals(cargoModel)) {
            queryWrapper.like("sci.cargo_model", "");
        }

        //模糊搜索货品类型
        String categoryName = FormatUtil.isSelectKey("categoryName", params);
        if (Constant.TRUE.equals(categoryName)) {
            queryWrapper.like("scc.category_name", params.get("categoryName").toString().replace("[", "").replace("]", ""));
        } else if ("".equals(categoryName)) {
            queryWrapper.like("scc.category_name", "");
        }

        queryWrapper.eq("sci.deleted", 0);
        queryWrapper.eq("sci.STATUS", 0);
        queryWrapper.orderByDesc("sci.updated_time");
        return sysCargoInfoMapper.queryCargoInfo(page,queryWrapper);
    }
}
