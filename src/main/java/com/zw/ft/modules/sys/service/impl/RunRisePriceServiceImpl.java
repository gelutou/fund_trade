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
import com.zw.ft.modules.sys.entity.RunRisePrice;
import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.repository.RunRisePriceMapper;
import com.zw.ft.modules.sys.repository.SysCompanyMapper;
import com.zw.ft.modules.sys.service.RunRisePriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 加价档案表 服务实现类
 * </p>
 *
 * @author Savior
 * @since 2020-09-21
 */
@Service
public class RunRisePriceServiceImpl extends ServiceImpl<RunRisePriceMapper, RunRisePrice> implements RunRisePriceService {

    @Resource
    RunRisePriceMapper runRisePriceMapper;

    @Resource
    SysCompanyMapper sysCompanyMapper;

    /**
     * @Author savior
     * @Description 各个公司加价档案列表
     * @Date: 2020/11/11
     */
    @Override
    public Page<RunRisePrice> getRun(Map<String, Object> params) {
        Page<RunRisePrice> page = new QueryUtil<RunRisePrice>(params).getPage();
        QueryWrapper<RunRisePrice> queryWrapper = new QueryWrapper<>();
        //模糊搜索公司名称
        String comName = FormatUtil.isSelectKey("comName", params);
        if (Constant.TRUE.equals(comName)) {
            queryWrapper.like("scy.com_name", params.get("comName").toString().replace("[", "").replace("]", ""));
        } else if ("".equals(comName)) {
            queryWrapper.like("scy.com_name", "");
        }

        //模糊搜索公司id
        String id = FormatUtil.isSelectKey("id", params);
        String string = JSON.toJSONString(params);
        string = string.replace("[", "").replace("]", "");
        String[] convert = Convert.convert(String[].class, string);
        if (Constant.TRUE.equals(id)) {
            if (params.toString().contains(",")) {
                queryWrapper.in("scy.id", convert);
            }
        }

        //模糊搜索城市
        String city = FormatUtil.isSelectKey("city", params);
        if (Constant.TRUE.equals(city)) {
            queryWrapper.like("scy.city", params.get("city").toString().replace("[", "").replace("]", ""));
        } else if ("".equals(city)) {
            queryWrapper.like("scy.city", "");
        }

        queryWrapper.eq("scy.deleted", 0);
        queryWrapper.eq("scy.STATUS", 0);
        queryWrapper.orderByDesc("pi.rise_price", "pi.updated_time");
        return runRisePriceMapper.queryRunRisePrice(page, queryWrapper);
    }

    /**
     * @Author savior
     * @Description 当没有这条数据是会自动添加有时就修改
     * @Date: 2020/11/17
     */
    @Override
    public R getRunRise(RunRisePrice runRisePrice) {
        QueryWrapper<RunRisePrice> RunWrapper = new QueryWrapper<>();
        RunWrapper.eq("com_id", runRisePrice.getComId());
        List<RunRisePrice> runRisePrices = runRisePriceMapper.selectList(RunWrapper);
        if (runRisePrices.size() == 0) {
            QueryWrapper<SysCompany> sysWrapper = new QueryWrapper<>();
            sysWrapper.eq("id", runRisePrice.getComId());
            List<SysCompany> sysCompanies = sysCompanyMapper.selectList(sysWrapper);
            for (SysCompany sys : sysCompanies) {
                runRisePrice.setComId(sys.getId().toString());
            }
            int insert = runRisePriceMapper.insert(runRisePrice);
            if (insert!=0){
                return R.ok("添加成功");
            }else {
                return R.error("添加失败");
            }
        } else {
            int update = runRisePriceMapper.update(runRisePrice, RunWrapper);
            if (update!=0){
                return R.ok("更新成功");
            }else {
                return R.error("更新失败");
            }
        }

    }

}