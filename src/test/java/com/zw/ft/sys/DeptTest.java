package com.zw.ft.sys;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.modules.sys.entity.SysDepartment;
import com.zw.ft.modules.sys.repository.SysDepartmentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName DeptTest
 * @Description TODO
 * @Author Oliver
 * @Date 2020/9/23 11:34
 * @Version 1.0
 **/
@SpringBootTest
public class DeptTest {

    @Resource
    SysDepartmentMapper sysDepartmentMapper;

    @Test
    public void getMenu() {

        QueryWrapper<SysDepartment> departmentQueryWrapper = new QueryWrapper<>();
        departmentQueryWrapper.eq("com_id", "1");
        departmentQueryWrapper.orderByAsc("parent_id");

        List<SysDepartment> sysDepartments = sysDepartmentMapper.selectList(departmentQueryWrapper);

        JSONArray result = new JSONArray();
        for (SysDepartment dept : sysDepartments) {
            long parentId = dept.getParentId();
            long id = dept.getId();
            String name = dept.getDeptName();
            //如果是一级部门，添加第一层
            if (parentId == -1) {
                JSONObject firstObj = new JSONObject(2);
                firstObj.put("label:", name);
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
        System.out.println("result = " + result);
    }

    public List<SysDepartment> getTree(List<SysDepartment> allDepts, long fatherId) {
        List<SysDepartment> trees = new LinkedList<>();
        for (SysDepartment sysDepartment : allDepts) {
            if (sysDepartment.getParentId() == fatherId) {
                trees.add(sysDepartment);
            }
        }
        return trees;
    }


    /**
     * @return
     * @Author savior
     * @Description 添加部门信息
     * @Date: 2020/9/24
     */

    @Test
    public void DeptAddto() {
        SysDepartment sysDepartment = new SysDepartment();
        sysDepartment.setComId(1);
        sysDepartment.setDeptName("测试部门名称二");
        int insert = sysDepartmentMapper.insert(sysDepartment);
        System.out.println(insert);
    }

    @Test
    public void add() {
        SysDepartment sysDepartment = new SysDepartment();
        sysDepartment.setComId(1L);
        sysDepartment.setDeptName("测试部门名称");
        int insert = sysDepartmentMapper.insert(sysDepartment);
        System.out.println("insert = " + insert);
    }
}