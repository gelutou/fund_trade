package com.zw.ft.modules.sys.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.modules.sys.entity.SysCompany;
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
 */
    @Override
    public JSONArray getMenu(Map<String,Object> params) {
        Object comId = params.get("comId").toString();
        QueryWrapper<SysDepartment> departmentQueryWrapper = new QueryWrapper<>();
        departmentQueryWrapper.eq("com_id",comId);
        List<SysDepartment> sysDepartments = sysDepartmentMapper.selectList(departmentQueryWrapper);
        List<SysCompany> treeTwo = sysDepartmentMapper.getCompanyNameBycomId(comId.toString());
        JSONArray result = new JSONArray();
        for (SysDepartment dept : sysDepartments) {
            long parentId1 = dept.getParentId();
            long id = dept.getId();
            String name = dept.getDeptName();
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
            System.out.println("result = " + result);
        }
        return result;
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
        /*public String SeleTept(){

        }*/
   /**
    * @Author savior
    * @Description 添加部门信息
    * @Date: 2020/9/24
    * @return
    */
    @Override
    public Integer DeptAddto(SysDepartment sysDepartment) {
        int insert = sysDepartmentMapper.insert(sysDepartment);
        return insert;
    }

    /**
     * @Author savior
     * @Description 根据id逻辑删除部门
     * @Date: 2020/9/24
     */
    @Override
    public int DeleteDept(String id) {
            int byId = sysDepartmentMapper.deleteById(id);
            return byId;
    }

    /**
     * @Author savior
     * @Description 根据id修改部门
     * @Date: 2020/9/25
     * @return
     */
    @Override
    public int UpdaDept(String id, String deptName) {
        //SysDepartment sysDepartment1 = new SysDepartment();
        SysDepartment DeptId = sysDepartmentMapper.selectById(id);
        System.out.println(DeptId);
        int update = sysDepartmentMapper.update(id, deptName);
        return update;
    }

}





