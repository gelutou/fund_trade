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
 * @since 2020-09-20
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
    /*@Override
    public JSONArray getMenu(Map<String,Object> params) {
        String comId = params.get("comId").toString();
        QueryWrapper<SysDepartment> departmentQueryWrapper = new QueryWrapper<>();
        departmentQueryWrapper.eq("com_id",comId);
        List<SysDepartment> sysDepartments = sysDepartmentMapper.selectList(departmentQueryWrapper);
        List<SysCompany> treeTwo = sysDepartmentMapper.getCompanyNameBesomId(comId);
        JSONArray result = new JSONArray();
        for (SysDepartment dept : sysDepartments) {
            long parentId1 = dept.getParentId();
            long id = dept.getId();
            //如果是一级部门，添加第一层
            if (parentId1 == -1) {
                JSONObject firstObj = new JSONObject(2);
                for (SysCompany sysCompany:treeTwo){
                firstObj.put("label", sysCompany.getComName());
                }
                firstObj.put("id", id);
                //查询所有下级
                List<SysDepartment> trees = getTree(sysDepartments, id);
                JSONArray childArray = new JSONArray();
                for (SysDepartment sd : trees) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("label", sd.getDeptName());
                    jsonObject.put("id", sd.getId());
                    List<SysDepartment> childTrees = getTree(sysDepartments, sd.getId());
                    JSONArray grandArray = new JSONArray();
                    for (SysDepartment child : childTrees) {
                        JSONObject childObject = new JSONObject();
                        childObject.put("label", child.getDeptName());
                        childObject.put("id", child.getId());
                        grandArray.add(childObject);
                    }
                    jsonObject.put("children", grandArray);
                    childArray.add(jsonObject);
                }
                firstObj.put("children", childArray);
                result.add(firstObj);
            }
        }
        return result;
    }*/

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


   /**
    * @Author savior
    * @Description 添加部门信息
    * @Date: 2020/9/24
    * @return
    */
    @Override
    public Integer deptAddto(SysDepartment sysDepartment) {
        sysDepartment.setParentId(sysDepartment.getParentId());
        sysDepartment.setComId(sysDepartment.getComId());
        sysDepartment.setDeptName(sysDepartment.getDeptName());
        return sysDepartmentMapper.insert(sysDepartment);
    }

    /**
     * @Author savior
     * @Description 根据id逻辑删除部门
     * @Date: 2020/9/24
     */
    @Override
    public int deleteDept(String id) {
        return sysDepartmentMapper.deleteById(id);
    }

    /**
     * @Author savior
     * @Description 根据id修改部门
     * @Date: 2020/9/25
     */
    @Override
    public int updaDept(SysDepartment sysDepartment) {
        return sysDepartmentMapper.update(sysDepartment);
    }

}





