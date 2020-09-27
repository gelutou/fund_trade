package com.zw.ft.sys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mysql.cj.xdevapi.JsonArray;
import com.zw.ft.modules.sys.entity.SysDepartment;
import com.zw.ft.modules.sys.repository.SysDepartmentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    SysDepartmentMapper sysDepartment;
    @Test
    public void getMenu(){

        QueryWrapper<SysDepartment> departmentQueryWrapper = new QueryWrapper<>();
        departmentQueryWrapper.eq("com_id","1");
        departmentQueryWrapper.orderByAsc("parent_id");

        List<SysDepartment> sysDepartments = sysDepartment.selectList(departmentQueryWrapper);

        JSONArray result = new JSONArray();
        Set<Long> idSet = new HashSet<>();
        for(SysDepartment dept : sysDepartments){
            long parentId = dept.getParentId();
            long id = dept.getId();
            String name = dept.getDeptName();
            //如果是一级部门，添加第一层
            if(parentId == -1){
                JSONObject firstObj = new JSONObject(2);
                firstObj.put("label:",name);
                firstObj.put("id",id);
                idSet.add(id);
                //查询所有下级
                List<SysDepartment> trees = getTree(sysDepartments, id);
                JSONArray childArray = new JSONArray();
                for(SysDepartment sd : trees){
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("label",sd.getDeptName());
                    jsonObject.put("id",sd.getId());
                    List<SysDepartment> childTrees = getTree(sysDepartments, sd.getId());
                    JSONArray grandArray = new JSONArray();
                    for(SysDepartment child : childTrees){
                        JSONObject childObject = new JSONObject();
                        childObject.put("label",child.getDeptName());
                        childObject.put("id",child.getId());
                        grandArray.add(childObject);
                    }
                    jsonObject.put("children",grandArray);
                    childArray.add(jsonObject);
                }
                firstObj.put("children",childArray);
                result.add(firstObj);
            }
        }
        System.out.println("result = " + result);
    }

    public List<SysDepartment> getTree(List<SysDepartment> allDepts,long fatherId){
        List<SysDepartment> trees = new LinkedList<>();
        for(SysDepartment sysDepartment : allDepts){
            if(sysDepartment.getParentId() == fatherId){
                trees.add(sysDepartment);
            }
        }
        return trees;
    }

    /*@Test
    public void aa(){
        sysDepartment
    }*/
}
