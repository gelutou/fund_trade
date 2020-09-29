package com.zw.ft.modules.sys.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zw.ft.modules.sys.entity.SysDepartment;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统部门表 服务类
 * </p>
 *
 * @author Oliver
 * @since 2020-09-20
 */
public interface SysDepartmentService extends IService<SysDepartment> {

      /**
       * @Author savior
       * @Description 根据树节点主节点公司ID查询部门所有信息
       * @Date: 2020/9/24
       */
      JSONArray getMenu( Map<String,Object> params);

      List<SysDepartment> getTree(List<SysDepartment> allDepts, long fatherId);

      /**
       * @Author savior
       * @Description 添加部门信息
       * @Date: 2020/9/24
       * @return
       */
      Integer DeptAddto(SysDepartment sysDepartment);

      /**
       * @Author savior
       * @Description 根据id逻辑删除部门
       * @Date: 2020/9/24
       */
      int DeleteDept(String id);

<<<<<<< HEAD
      int UpdaDept(String id, @Param("deptName") String deptName);
=======
     // public int UpdaDept(String id, @Param("deptName") String deptName);

      public int UpdaDept(SysDepartment sysDepartment);
>>>>>>> 83d01973eb47054cf84279144640c79d3c64503d
}
