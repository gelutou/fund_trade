package com.zw.ft.modules.bdm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.common.constants.Constant;
import com.zw.ft.common.utils.FormatUtil;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmCargoInfo;
import com.zw.ft.modules.bdm.repository.BdmCargoInfoMapper;
import com.zw.ft.modules.bdm.service.BdmCargoInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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
public class BdmCargoInfoServiceImpl extends ServiceImpl<BdmCargoInfoMapper, BdmCargoInfo> implements BdmCargoInfoService {

    @Resource
    BdmCargoInfoMapper bdmCargoInfoMapper;

    /**
     * @Author savior
     * @Description 分页查询货品信息
     * @Date: 2020/11/19
     */
    @Override
    public Page<BdmCargoInfo> getCargoInfo(Map<String, Object> params) {
        Page<BdmCargoInfo> page = new QueryUtil<BdmCargoInfo>(params).getPage();
        QueryWrapper<BdmCargoInfo> queryWrapper = new QueryWrapper<>();
        String keyWord = FormatUtil.isSelectKey("keyWord", params);
        if (Constant.TRUE.equals(keyWord)) {
            queryWrapper.and(i-> i
                    //模糊搜索货品编号
                    .like("bci.cargo_code", params.get("keyWord").toString()).or()
                    //模糊搜索货品名称
                    .like("bci.cargo_name", params.get("keyWord").toString()).or()
                    //模糊搜索货品品牌
                    .like("bci.brand", params.get("keyWord")).or()
                    //模糊搜索货品规格
                    .like("bci.specification", params.get("keyWord")).or()
                    //模糊搜索货品型号
                    .like("bci.cargo_model", params.get("keyWord")).or()
                    //模糊搜索货品类型
                    .like("bcc.category_name", params.get("keyWord"))
            );
        }
        queryWrapper.eq("bci.deleted", 0);
        queryWrapper.orderByDesc("bci.created_time");
        return bdmCargoInfoMapper.queryCargoInfo(page,queryWrapper);
    }

    /**
     * @Author savior
     * @Description 根据id逻辑批量删除
     * @Date: 2020/11/24
     */
    @Override
    public R delCargo(String delIds) {
        List<String> lists = new LinkedList<>();
        if (delIds.contains(",")) {
            String[] split = delIds.split(",");
            Collections.addAll(lists, split);
        } else {
            lists.add(delIds);
        }
        bdmCargoInfoMapper.deleteBatchIds(lists);
        return R.ok();
    }
}
