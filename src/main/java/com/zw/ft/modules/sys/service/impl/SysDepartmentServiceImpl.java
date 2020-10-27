package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.modules.sys.entity.SysDepartment;
import com.zw.ft.modules.sys.repository.SysDepartmentMapper;
import com.zw.ft.modules.sys.service.SysDepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统部门表 服务实现类
 * </p>
 *
 * @author Oliver
 * @since 2020-10-16
 */
@Service
public class SysDepartmentServiceImpl extends ServiceImpl<SysDepartmentMapper, SysDepartment> implements SysDepartmentService {

    @Resource
    SysDepartmentMapper sysDepartmentMapper;

    /**
     * @Author savior
     * @Description 根据树节点主节点公司ID,获取部门档案树信息 转换为json格式
     * @Date: 2020/9/24
     * @return
     */
    @Override
    public List<SysDepartment> getMenu(Map<String,Object> params) {
    String comId = params.get("comId").toString();
    if(!"".equals(comId)){
        return sysDepartmentMapper.getCompanyNameBesomId(comId);
    }
        return null;
    }

    @Override
    public List<SysDepartment> getTree(List<SysDepartment> allDepts, long fatherId){
        List<SysDepartment> trees = new LinkedList<>();
        for(SysDepartment sysDepartment : allDepts){
            if(sysDepartment.getParentId() == fatherId){
                trees.add(sysDepartment);
            }
        }
        return trees;
    }


}
