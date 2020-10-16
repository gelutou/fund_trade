package com.zw.ft.initdb;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.modules.fund.entity.TCompany;
import com.zw.ft.modules.fund.entity.TCustomer;
import com.zw.ft.modules.fund.entity.TOrgan;
import com.zw.ft.modules.fund.entity.TUser;
import com.zw.ft.modules.fund.repository.TCompanyMapper;
import com.zw.ft.modules.fund.repository.TCustomerMapper;
import com.zw.ft.modules.fund.repository.TOrganMapper;
import com.zw.ft.modules.fund.repository.TUserMapper;
import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.entity.SysUser;
import com.zw.ft.modules.sys.entity.SysUserExpansion;
import com.zw.ft.modules.sys.repository.SysCompanyMapper;
import com.zw.ft.modules.sys.repository.SysUserExpansionMapper;
import com.zw.ft.modules.sys.repository.SysUserMapper;
import com.zw.ft.modules.trade.entity.BdmCustomer;
import com.zw.ft.modules.trade.entity.SysCompanyTrade;
import com.zw.ft.modules.trade.entity.SysOrgan;
import com.zw.ft.modules.trade.entity.SysUserTrade;
import com.zw.ft.modules.trade.repository.BdmCustomerMapper;
import com.zw.ft.modules.trade.repository.SysCompanyTradeMapper;
import com.zw.ft.modules.trade.repository.SysOrganMapper;
import com.zw.ft.modules.trade.repository.SysUserTradeMapper;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName SysInit
 * @Description TODO
 * @Author Oliver
 * @Date 2020/10/12 14:04
 * @Version 1.0
 **/
@SpringBootTest
public class InitDatabaseServiceTest {

    @Resource
    SysUserMapper sysUserMapper;
    @Resource
    SysUserTradeMapper sysUserTradeMapper;
    @Resource
    TUserMapper tUserMapper;
    @Resource
    SysUserExpansionMapper sysUserExpansionMapper;

    @Resource
    SysCompanyMapper sysCompanyMapper;
    @Resource
    SysCompanyTradeMapper sysCompanyTradeMapper;
    @Resource
    BdmCustomerMapper bdmCustomerMapper;
    @Resource
    TCompanyMapper tCompanyMapper;
    @Resource
    TCustomerMapper tCustomerMapper;

    @Resource
    SysDepartmentMapper sysDepartmentMapper;
    @Resource
    SysOrganMapper organTradeMapper;
    @Resource
    TOrganMapper tOrganMapper;
    /*select b.*
                from (select user_code
                        from sys_user
                        group by user_code
                        having count(*) >= 2) as a
                        left join sys_user b
                        on a.user_code = b.user_code
                        order by user_code;
                        */

    @Test
    void initSysDept() {
        long start = System.currentTimeMillis();
        List<SysDepartment> allDepts = sysDepartmentMapper.selectList(null);
        List<SysOrgan> sysOrgans = organTradeMapper.selectFatherDepts();

        List<TOrgan> allEffective = tOrganMapper.getAllEffective();
        List<TCustomer> tCustomers = tCustomerMapper.selectList(null);

        List<SysOrgan> sysOrgansTrade = new LinkedList<>();

        //根据父部门查询出所有子部门
        for (SysOrgan so : sysOrgans) {
            List<SysOrgan> sysOrgans1 = organTradeMapper.selectChildrenDepts(so.getParentPkid());
            sysOrgansTrade.addAll(sysOrgans1);
        }
        //循环部门 开始比对
        int insertTime = 0;
        int updateTime = 0;
        int delTime = 0;

        for (SysOrgan sysOrgan : sysOrgansTrade) {
            boolean insert = true;
            for (SysDepartment department : allDepts) {
                if (sysOrgan.getPkId().equals(department.getOldPkidWilldel())) {
                    insert = false;
                    break;
                }
            }
            SysDepartment dept = new SysDepartment();
            QueryWrapper<SysCompany> companyQueryWrapper = new QueryWrapper<>();
            companyQueryWrapper.eq("old_pkid_willdel", sysOrgan.getCompPkid());
            if (insert) {
                dept.setDeptName(sysOrgan.getOrganName());
                //根据部门的com_pkID 查询对应的新表部门ID
                SysCompany sysCompany = sysCompanyMapper.selectOne(companyQueryWrapper);
                if(sysCompany ==null){
                    sysCompany = new SysCompany();
                    sysCompany.setId(-1L);
                }
                dept.setComId(sysCompany.getId());
                dept.setLeader(sysOrgan.getManager());
                dept.setParentId(sysCompany.getId());
                dept.setDeptLevel(1);
                dept.setCreatedTime(Convert.convert(LocalDateTime.class, sysOrgan.getMakeTime()));
                dept.setUpdatedTime(Convert.convert(LocalDateTime.class, sysOrgan.getModifyTime()));
                dept.setDeleted(sysOrgan.getFlagDelete());
                dept.setRevision(1);
                dept.setOldPkidWilldel(sysOrgan.getPkId());
                sysDepartmentMapper.insert(dept);
                insertTime++;
            } else {
                UpdateWrapper<SysDepartment> departmentUpdateWrapper = new UpdateWrapper<>();
                departmentUpdateWrapper.eq("old_pkid_willdel", sysOrgan.getCompPkid());
                dept.setDeptName(sysOrgan.getOrganName());
                //根据部门的com_pkID 查询对应的新表部门ID
                SysCompany sysCompany = sysCompanyMapper.selectOne(companyQueryWrapper);
                dept.setComId(sysCompany.getId());
                dept.setLeader(sysOrgan.getManager());
                dept.setParentId(sysCompany.getId());
                dept.setDeptLevel(1);
                dept.setCreatedTime(Convert.convert(LocalDateTime.class, sysOrgan.getMakeTime()));
                dept.setUpdatedTime(Convert.convert(LocalDateTime.class, sysOrgan.getModifyTime()));
                dept.setDeleted(sysOrgan.getFlagDelete());
                dept.setRevision(1);
                sysDepartmentMapper.update(dept,departmentUpdateWrapper);
                //sysDepartmentMapper.update(dept, departmentUpdateWrapper);
                updateTime++;
            }
        }

        SysDepartment dept = new SysDepartment();

        for(TCustomer customer:tCustomers){
            UpdateWrapper<SysDepartment> departmentUpdateWrapper = new UpdateWrapper<>();
            //根据customer的ID查询出新公司表ID
            QueryWrapper<SysCompany> sysCompanyQueryWrapper = new QueryWrapper<>();
            sysCompanyQueryWrapper.eq("old_pkid_willdel",customer.getId());
            SysCompany sysCompany = sysCompanyMapper.selectOne(sysCompanyQueryWrapper);
            departmentUpdateWrapper.eq("com_id",sysCompany.getId());
            //删除然后新建
            sysDepartmentMapper.delete(departmentUpdateWrapper);
            delTime++;

            //开始循环加部门
            for(TOrgan sysOrgan : allEffective){

                dept.setDeptName(sysOrgan.getOrganName());
                //根据部门的com_pkID 查询对应的新表部门ID
                dept.setComId(sysCompany.getId());
                //dept.setLeader(sysOrgan.get);
                dept.setParentId(sysCompany.getId());
                dept.setDeptLevel(1);
                dept.setCreatedTime(Convert.convert(LocalDateTime.class, sysOrgan.getMakeTime()));
                dept.setUpdatedTime(Convert.convert(LocalDateTime.class, sysOrgan.getModifyTime()));
                dept.setDeleted(sysOrgan.getFlagDelete());
                dept.setRevision(1);
                dept.setOldPkidWilldel(sysOrgan.getId());
                sysDepartmentMapper.insert(dept);
                insertTime++;
            }
        }

        System.out.println("部门表：一共增加了" + insertTime + "条数据,更新了条" + updateTime + "数据,删除了"+delTime+"条数据");
        long end = System.currentTimeMillis();
        System.out.println("初始化sys_department用时 ： " + (end - start) + "毫秒");

    }

    @Test
    void initSysCompanyTrade() {
        long start = System.currentTimeMillis();
        int insertTime = 0;
        int updateTime = 0;

        /*------整合内部公司----------------------------------*/
        List<SysCompany> allComs = sysCompanyMapper.selectList(null);
        List<SysCompanyTrade> allComsTrade = sysCompanyTradeMapper.selectList(null);

        for(SysCompanyTrade companyTrade : allComsTrade){
            boolean insert = true;
            for(SysCompany com : allComs){
                if(com.getOldPkidWilldel().equals(companyTrade.getPkId())){
                    insert = false;
                    break;
                }
            }
            SysCompany sysCompany = new SysCompany();
            if(insert){
                sysCompany.setOldPkidWilldel(companyTrade.getPkId());
                sysCompany.setComCode(companyTrade.getCompCode());
                System.out.println("添加公司代码 = " + companyTrade.getCompCode());
                sysCompany.setUpdatedBy(1L);
                sysCompany.setCreatedBy(1L);
                sysCompany.setAddress(companyTrade.getCompAddress());
                sysCompany.setCity(companyTrade.getCompCity());
                sysCompany.setComName(companyTrade.getCompName());
                sysCompany.setContactUser(companyTrade.getContactName());
                sysCompany.setMobile(companyTrade.getContactPhone());
                sysCompany.setProvince(companyTrade.getCompProvince());
                sysCompany.setDistrict(companyTrade.getCompDistrict());
                sysCompany.setShortComName(companyTrade.getShortCompName());
                sysCompany.setCreatedTime(Convert.convert(LocalDateTime.class,companyTrade.getMakeTime()));
                sysCompany.setUpdatedTime(Convert.convert(LocalDateTime.class,companyTrade.getModifyTime()));
                sysCompany.setDeleted(companyTrade.getFlagDelete());
                sysCompany.setRevision(1);
                sysCompanyMapper.insert(sysCompany);
                insertTime++;
            }else {
                UpdateWrapper<SysCompany> companyUpdateWrapper = new UpdateWrapper<>();
                companyUpdateWrapper.eq("old_pkid_willdel",companyTrade.getPkId());
                System.out.println("更新公司代码 = " + companyTrade.getCompCode());
                sysCompany.setUpdatedBy(1L);
                sysCompany.setCreatedBy(1L);
                sysCompany.setAddress(companyTrade.getCompAddress());
                sysCompany.setCity(companyTrade.getCompCity());
                sysCompany.setComName(companyTrade.getCompName());
                sysCompany.setContactUser(companyTrade.getContactName());
                sysCompany.setMobile(companyTrade.getContactPhone());
                sysCompany.setProvince(companyTrade.getCompProvince());
                sysCompany.setDistrict(companyTrade.getCompDistrict());
                sysCompany.setShortComName(companyTrade.getShortCompName());
                sysCompany.setCreatedTime(Convert.convert(LocalDateTime.class,companyTrade.getMakeTime()));
                sysCompany.setUpdatedTime(Convert.convert(LocalDateTime.class,companyTrade.getModifyTime()));
                sysCompany.setDeleted(companyTrade.getFlagDelete());
                sysCompany.setRevision(1);
                sysCompanyMapper.update(sysCompany,companyUpdateWrapper);
                updateTime++;
            }
        }

        System.out.println("公司表：一共增加了" + insertTime + "条数据,更新了条" + updateTime + "数据");
        long end = System.currentTimeMillis();
        System.out.println("初始化sys_company用时 ： " + (end - start) + "毫秒");
    }

    @Test
    void initSysCompanyFund() {
        long start = System.currentTimeMillis();
        int insertTime = 0;
        int updateTime = 0;

        /*------整合内部公司----------------------------------*/
        List<SysCompany> allComs = sysCompanyMapper.selectList(null);
        List<TCompany> allComsFund = tCompanyMapper.selectList(null);

        for(TCompany companyTrade : allComsFund){
            boolean insert = true;
            for(SysCompany com : allComs){
                if(com.getOldPkidWilldel().equals(companyTrade.getId())){
                    insert = false;
                    break;
                }
            }
            SysCompany sysCompany = new SysCompany();
            if(insert){
                sysCompany.setOldPkidWilldel(companyTrade.getId());
                sysCompany.setComCode(companyTrade.getCompCode());
                System.out.println("添加公司代码 = " + companyTrade.getCompCode());
                sysCompany.setUpdatedBy(1L);
                sysCompany.setCreatedBy(1L);
                sysCompany.setAddress(companyTrade.getCompAddress());
                sysCompany.setCity(companyTrade.getCompCity());
                sysCompany.setComName(companyTrade.getCompName());
                sysCompany.setContactUser(companyTrade.getContactName());
                sysCompany.setMobile(companyTrade.getContactPhone());
                sysCompany.setProvince(companyTrade.getCompProvince());
                sysCompany.setDistrict(companyTrade.getCompDistrict());
                sysCompany.setShortComName(companyTrade.getShortCompName());
                sysCompany.setCreatedTime(Convert.convert(LocalDateTime.class,companyTrade.getMakeTime()));
                sysCompany.setUpdatedTime(Convert.convert(LocalDateTime.class,companyTrade.getModifyTime()));
                sysCompany.setDeleted(companyTrade.getFlagDelete());
                sysCompany.setRevision(1);
                sysCompanyMapper.insert(sysCompany);
                insertTime++;
            }else {
                UpdateWrapper<SysCompany> companyUpdateWrapper = new UpdateWrapper<>();
                companyUpdateWrapper.eq("old_pkid_willdel",companyTrade.getId());
                System.out.println("添加公司代码 = " + companyTrade.getCompCode());
                sysCompany.setUpdatedBy(1L);
                sysCompany.setCreatedBy(1L);
                sysCompany.setAddress(companyTrade.getCompAddress());
                sysCompany.setCity(companyTrade.getCompCity());
                sysCompany.setComName(companyTrade.getCompName());
                sysCompany.setContactUser(companyTrade.getContactName());
                sysCompany.setMobile(companyTrade.getContactPhone());
                sysCompany.setProvince(companyTrade.getCompProvince());
                sysCompany.setDistrict(companyTrade.getCompDistrict());
                sysCompany.setShortComName(companyTrade.getShortCompName());
                sysCompany.setCreatedTime(Convert.convert(LocalDateTime.class,companyTrade.getMakeTime()));
                sysCompany.setUpdatedTime(Convert.convert(LocalDateTime.class,companyTrade.getModifyTime()));
                sysCompany.setDeleted(companyTrade.getFlagDelete());
                sysCompany.setRevision(1);
                sysCompanyMapper.update(sysCompany,companyUpdateWrapper);
                updateTime++;
            }
        }
        System.out.println("公司表：一共增加了" + insertTime + "条数据,更新了条" + updateTime + "数据");
        long end = System.currentTimeMillis();
        System.out.println("初始化sys_company用时 ： " + (end - start) + "毫秒");
    }
    /*
     * 功能描述: <br>
     * 〈初始化客商〉
     */
    @Test
     void initKs(){
        long start = System.currentTimeMillis();
        int insertTime = 0;
        int updateTime = 0;
        /*---------整合客商----------*/
        List<SysCompany> allComsTwo = sysCompanyMapper.selectList(null);

        QueryWrapper<BdmCustomer> bdmCustomerQueryWrapper = new QueryWrapper<>();
        bdmCustomerQueryWrapper.ne("customer_type","1");
        List<BdmCustomer> bdmCustomers = bdmCustomerMapper.selectList(bdmCustomerQueryWrapper);
        bdmCustomers.forEach(System.out::println);

        QueryWrapper<TCustomer> tCustomerQueryWrapper = new QueryWrapper<>();
        tCustomerQueryWrapper.ne("customer_type","1");
        List<TCustomer> tCustomers = tCustomerMapper.selectList(tCustomerQueryWrapper);

        for (BdmCustomer companyTrade : bdmCustomers) {
            boolean insert = true;
            for (SysCompany com : allComsTwo) {
                if (com.getOldPkidWilldel().equals(companyTrade.getPkId())) {
                    insert = false;
                    break;
                }
            }
            SysCompany sysCompany = new SysCompany();
            //查询customer里没有的字段
            QueryWrapper<SysCompanyTrade> companyTradeQueryWrapper = new QueryWrapper<>();
            companyTradeQueryWrapper.eq("pk_id", companyTrade.getCompPkid());
            SysCompanyTrade companyTrade1 = sysCompanyTradeMapper.selectOne(companyTradeQueryWrapper);
            if (companyTrade1 == null) {
                companyTrade1 = new SysCompanyTrade();
            }
            if (insert) {
                sysCompany.setComCode(companyTrade.getCustomerCode());
                sysCompany.setUpdatedBy(1L);
                sysCompany.setCreatedBy(1L);
                sysCompany.setFundOrTrade(1);

                sysCompany.setAddress(companyTrade1.getCompAddress());
                sysCompany.setCity(companyTrade1.getCompCity());
                sysCompany.setComName(companyTrade.getCustomerName());
                sysCompany.setTaxNumber(companyTrade.getTaxNumber());
                sysCompany.setContactUser(companyTrade1.getContactName());
                sysCompany.setMobile(companyTrade.getCustomerPhone());
                sysCompany.setProvince(companyTrade1.getCompProvince());
                sysCompany.setDistrict(companyTrade1.getCompDistrict());
                sysCompany.setShortComName(companyTrade.getCustomerShortName());
                sysCompany.setCreatedTime(Convert.convert(LocalDateTime.class, companyTrade.getMakeTime()));
                sysCompany.setUpdatedTime(Convert.convert(LocalDateTime.class, companyTrade.getModifyTime()));
                sysCompany.setDeleted(companyTrade.getFlagDelete());
                sysCompany.setRevision(1);
                sysCompany.setStatus(companyTrade.getFlagStatus());
                sysCompany.setOldPkidWilldel(companyTrade.getPkId());
                sysCompanyMapper.insert(sysCompany);
                insertTime++;
            } else {
                UpdateWrapper<SysCompany> companyUpdateWrapper = new UpdateWrapper<>();
                companyUpdateWrapper.eq("old_pkid_willdel", companyTrade.getCompPkid());
                sysCompany.setAddress(companyTrade1.getCompAddress());
                sysCompany.setCity(companyTrade1.getCompCity());
                sysCompany.setComName(companyTrade.getCustomerName());
                sysCompany.setTaxNumber(companyTrade.getTaxNumber());
                sysCompany.setContactUser(companyTrade1.getContactName());
                sysCompany.setMobile(companyTrade.getCustomerPhone());
                sysCompany.setProvince(companyTrade1.getCompProvince());
                sysCompany.setDistrict(companyTrade1.getCompDistrict());
                sysCompany.setShortComName(companyTrade.getCustomerShortName());
                sysCompany.setCreatedTime(Convert.convert(LocalDateTime.class, companyTrade.getMakeTime()));
                sysCompany.setUpdatedTime(Convert.convert(LocalDateTime.class, companyTrade.getModifyTime()));
                sysCompany.setDeleted(companyTrade.getFlagDelete());
                sysCompany.setRevision(1);
                sysCompany.setStatus(companyTrade.getFlagStatus());
                sysCompanyMapper.update(sysCompany, companyUpdateWrapper);
                updateTime++;
            }
        }
        for (TCustomer companyTrade : tCustomers) {
            boolean insert = true;
            for (SysCompany com : allComsTwo) {
                if (com.getOldPkidWilldel().equals(companyTrade.getId())) {
                    insert = false;
                    break;
                }
            }
            SysCompany sysCompany = new SysCompany();
            //查询customer里没有的字段
            QueryWrapper<TCompany> companyTradeQueryWrapper = new QueryWrapper<>();
            companyTradeQueryWrapper.eq("id", companyTrade.getId());
            TCompany companyTrade1 = tCompanyMapper.selectOne(companyTradeQueryWrapper);
            if (companyTrade1 == null) {
                companyTrade1 = new TCompany();
            }
            if (insert) {
                sysCompany.setComCode(companyTrade.getCustomerCode());
                sysCompany.setUpdatedBy(1L);
                sysCompany.setCreatedBy(1L);
                sysCompany.setFundOrTrade(0);

                sysCompany.setAddress(companyTrade1.getCompAddress());
                sysCompany.setCity(companyTrade1.getCompCity());
                sysCompany.setComName(companyTrade.getCustomerName());
                sysCompany.setContactUser(companyTrade1.getContactName());
                sysCompany.setMobile(companyTrade.getContactPhone());
                sysCompany.setProvince(companyTrade1.getCompProvince());
                sysCompany.setDistrict(companyTrade1.getCompDistrict());
                sysCompany.setShortComName(companyTrade.getCustomerShortName());
                sysCompany.setCreatedTime(Convert.convert(LocalDateTime.class, companyTrade.getMakeTime()));
                sysCompany.setUpdatedTime(Convert.convert(LocalDateTime.class, companyTrade.getModifyTime()));
                sysCompany.setDeleted(companyTrade.getFlagDelete());
                sysCompany.setRevision(1);
                sysCompany.setStatus(companyTrade.getFlagStatus());
                sysCompany.setOldPkidWilldel(companyTrade.getId());
                sysCompanyMapper.insert(sysCompany);
                insertTime++;
            } else {
                UpdateWrapper<SysCompany> companyUpdateWrapper = new UpdateWrapper<>();
                companyUpdateWrapper.eq("old_pkid_willdel", companyTrade.getId());
                sysCompany.setAddress(companyTrade1.getCompAddress());
                sysCompany.setCity(companyTrade1.getCompCity());
                sysCompany.setComName(companyTrade.getCustomerName());
                sysCompany.setContactUser(companyTrade1.getContactName());
                sysCompany.setMobile(companyTrade.getContactPhone());
                sysCompany.setProvince(companyTrade1.getCompProvince());
                sysCompany.setDistrict(companyTrade1.getCompDistrict());
                sysCompany.setShortComName(companyTrade.getCustomerShortName());
                sysCompany.setCreatedTime(Convert.convert(LocalDateTime.class, companyTrade.getMakeTime()));
                sysCompany.setUpdatedTime(Convert.convert(LocalDateTime.class, companyTrade.getModifyTime()));
                sysCompany.setDeleted(companyTrade.getFlagDelete());
                sysCompany.setRevision(1);
                sysCompany.setStatus(companyTrade.getFlagStatus());
                sysCompanyMapper.update(sysCompany, companyUpdateWrapper);
                updateTime++;
            }
        }

        System.out.println("公司表：一共增加了" + insertTime + "条数据,更新了条" + updateTime + "数据");
        long end = System.currentTimeMillis();
        System.out.println("初始化sys_company用时 ： " + (end - start) + "毫秒");

    }

    @Test
    void initSysUser() {
        /*
         *  两张人员表中存在账号重复，相同账号有不同人员使用情况，此方法只去除了账号重复，不同人员使用情况需要手动解决
         *  select b.*
                from (select user_code
                        from sys_user
                        group by user_code
                        having count(*) >= 2) as a
                        left join sys_user b
                        on a.user_code = b.user_code
                        order by user_code;
         */
        long start = System.currentTimeMillis();

        List<SysUser> sysUsers = sysUserMapper.selectList(null);
        List<SysUserExpansion> allUserExpansions = sysUserExpansionMapper.getAllUserExpansions();

        List<SysUserTrade> sysUserTrades = sysUserTradeMapper.selectAllGroupByUserCode();
        List<TUser> tUsers = tUserMapper.selectAllGroupByUserCode();

        //处理资金账号和商贸账号冲突
        for (TUser u : tUsers) {
            for (SysUserTrade t : sysUserTrades) {
                if (u.getUserCode().toLowerCase().equals(t.getUserCode().toLowerCase())) {
                    String uc = u.getUserCode() + "123";
                    System.out.println("uc = " + uc);
                    u.setUserCode(uc);
                }
            }
        }

        UpdateWrapper<SysUserExpansion> expansionUpdateWrapper = new UpdateWrapper<>();

        int insertTime = 0;
        int updateTime = 0;

        int insertTimeExp = 0;
        int updateTimeExp = 0;

        for (SysUserTrade trade : sysUserTrades) {
            boolean insert = true;
            boolean insertFund = true;
            SysUser sysUser = null;
            for (SysUser user : sysUsers) {
                if (user.getUsername().equals(trade.getUserCode())) {
                    sysUser = user;
                    insert = false;
                    break;
                }
            }
            SysUserExpansion sysUserExpansion = new SysUserExpansion();
            if (insert) {
                sysUser = new SysUser();
                sysUser.setUsername(trade.getUserCode());
                System.out.println("添加账号 = " + sysUser.getUsername());
                insertTime++;
                sysUser.setGender(trade.getSex().equals("1") ? 0 : 1);
                sysUser.setPassword(new Sha256Hash("1", sysUser.getUsername()).toHex());
                sysUser.setRealname(trade.getUserName());
                sysUser.setCreatedBy(1L);
                sysUser.setCreatedTime(Convert.convert(LocalDateTime.class, trade.getMakeTime()));
                sysUser.setDeleted(trade.getFlagDelete());
                sysUser.setRevision(1);
                sysUser.setUpdatedBy(1L);
                sysUser.setUpdatedTime(trade.getModifyTime() == null ? Convert.convert(LocalDateTime.class, trade.getMakeTime()) : Convert.convert(LocalDateTime.class, trade.getModifyTime()));
                sysUser.setFundOrTrade(1);
                sysUserMapper.insert(sysUser);

                long userId = sysUser.getId();
                boolean insertExp = true;
                for (SysUserExpansion userExpansion : allUserExpansions) {
                    if (userExpansion.getUserId() == userId) {
                        insertExp = false;
                        break;
                    }
                }
                sysUserExpansion.setUserId(sysUser.getId());
                //此值乱码，需要手动添加
                //sysUserExpansion.setProvince(trade.getNameProvince());
                sysUserExpansion.setEmail(trade.getUserEmail());
                sysUserExpansion.setAddress(trade.getUserAddress());
                sysUserExpansion.setBirthday(trade.getBirthday());
                sysUserExpansion.setMobile(trade.getUserMobile());
                sysUserExpansion.setQq(trade.getQq());
                sysUserExpansion.setWechat(trade.getWeixin());
                if (insertExp) {
                    //更新扩展
                    sysUserExpansionMapper.insert(sysUserExpansion);
                    insertTimeExp++;

                } else {
                    expansionUpdateWrapper.eq("user_id", sysUser.getId());
                    sysUserExpansionMapper.update(sysUserExpansion, expansionUpdateWrapper);
                    updateTimeExp++;
                }
            } else {
                UpdateWrapper<SysUser> userUpdateWrapper = new UpdateWrapper<>();
                userUpdateWrapper.eq("username", trade.getUserCode());
                System.out.println("更新账号 = " + trade.getUserCode());
                updateTime++;
                sysUser.setGender(trade.getSex().equals("1") ? 0 : 1);
                sysUser.setPassword(new Sha256Hash("1", sysUser.getUsername()).toHex());
                sysUser.setRealname(trade.getUserName());
                sysUser.setCreatedBy(1L);
                sysUser.setCreatedTime(Convert.convert(LocalDateTime.class, trade.getMakeTime()));
                sysUser.setDeleted(trade.getFlagDelete());
                sysUser.setRevision(1);
                sysUser.setUpdatedBy(1L);
                sysUser.setUpdatedTime(trade.getModifyTime() == null ? Convert.convert(LocalDateTime.class, trade.getMakeTime()) : Convert.convert(LocalDateTime.class, trade.getModifyTime()));
                sysUserMapper.update(sysUser, userUpdateWrapper);

                long userId = sysUser.getId();
                boolean insertExp = true;
                for (SysUserExpansion userExpansion : allUserExpansions) {
                    if (userExpansion.getUserId() == userId) {
                        insertExp = false;
                        break;
                    }
                }
                sysUserExpansion.setUserId(sysUser.getId());
                //此值乱码，需要手动添加
                //sysUserExpansion.setProvince(trade.getNameProvince());
                sysUserExpansion.setEmail(trade.getUserEmail());
                sysUserExpansion.setAddress(trade.getUserAddress());
                sysUserExpansion.setBirthday(trade.getBirthday());
                sysUserExpansion.setMobile(trade.getUserMobile());
                sysUserExpansion.setQq(trade.getQq());
                sysUserExpansion.setWechat(trade.getWeixin());
                if (insertExp) {
                    //更新扩展
                    sysUserExpansionMapper.insert(sysUserExpansion);
                    insertTimeExp++;

                } else {
                    expansionUpdateWrapper.eq("user_id", sysUser.getId());
                    sysUserExpansionMapper.update(sysUserExpansion, expansionUpdateWrapper);
                    updateTimeExp++;
                }

            }
        }

        List<SysUser> sysUsersForFund = sysUserMapper.selectList(null);

        for (TUser fund : tUsers) {
            boolean insert = true;
            SysUser sysUser = null;
            for (SysUser user : sysUsersForFund) {
                if (user.getUsername().equals(fund.getUserCode())) {
                    sysUser = user;
                    insert = false;
                    break;
                }
            }
            SysUserExpansion sysUserExpansion = new SysUserExpansion();
            if (insert) {
                sysUser = new SysUser();
                sysUser.setUsername(fund.getUserCode());
                System.out.println("添加账号 = " + sysUser.getUsername());
                insertTime++;
                sysUser.setGender(fund.getSex() == 1 ? 0 : 1);
                sysUser.setPassword(new Sha256Hash("1", sysUser.getUsername()).toHex());
                sysUser.setRealname(fund.getUserName());
                sysUser.setCreatedBy(1L);
                sysUser.setCreatedTime(Convert.convert(LocalDateTime.class, fund.getMakeTime()));
                sysUser.setDeleted(fund.getFlagDelete());
                sysUser.setRevision(1);
                sysUser.setUpdatedBy(1L);
                sysUser.setUpdatedTime(fund.getModifyTime() == null ? Convert.convert(LocalDateTime.class, fund.getMakeTime()) : Convert.convert(LocalDateTime.class, fund.getModifyTime()));
                sysUser.setFundOrTrade(0);
                sysUserMapper.insert(sysUser);

                long userId = sysUser.getId();
                boolean insertExp = true;
                for (SysUserExpansion userExpansion : allUserExpansions) {
                    if (userExpansion.getUserId() == userId) {
                        insertExp = false;
                        break;
                    }
                }
                sysUserExpansion.setUserId(sysUser.getId());
                //此值乱码，需要手动添加
                //sysUserExpansion.setProvince(trade.getNameProvince());
                sysUserExpansion.setEmail(fund.getUserEmail());
                sysUserExpansion.setAddress(fund.getUserAddress());
                sysUserExpansion.setBirthday(fund.getBirthday());
                sysUserExpansion.setMobile(fund.getUserMobile());
                sysUserExpansion.setQq(fund.getQq());
                sysUserExpansion.setWechat(fund.getWeixin());
                if (insertExp) {
                    //更新扩展
                    sysUserExpansionMapper.insert(sysUserExpansion);
                    insertTimeExp++;

                } else {
                    expansionUpdateWrapper.eq("user_id", sysUser.getId());
                    sysUserExpansionMapper.update(sysUserExpansion, expansionUpdateWrapper);
                    updateTimeExp++;
                }
            } else {
                UpdateWrapper<SysUser> userUpdateWrapper = new UpdateWrapper<>();
                userUpdateWrapper.eq("username", fund.getUserCode());
                System.out.println("更新账号 = " + fund.getUserCode());
                updateTime++;
                sysUser.setGender(fund.getSex() == 1 ? 0 : 1);
                sysUser.setPassword(new Sha256Hash("1", sysUser.getUsername()).toHex());
                sysUser.setRealname(fund.getUserName());
                sysUser.setCreatedBy(1L);
                sysUser.setCreatedTime(Convert.convert(LocalDateTime.class, fund.getMakeTime()));
                sysUser.setDeleted(fund.getFlagDelete());
                sysUser.setRevision(1);
                sysUser.setUpdatedBy(1L);
                sysUser.setUpdatedTime(fund.getModifyTime() == null ? Convert.convert(LocalDateTime.class, fund.getMakeTime()) : Convert.convert(LocalDateTime.class, fund.getModifyTime()));
                sysUserMapper.update(sysUser, userUpdateWrapper);

                long userId = sysUser.getId();
                boolean insertExp = true;
                for (SysUserExpansion userExpansion : allUserExpansions) {
                    if (userExpansion.getUserId() == userId) {
                        insertExp = false;
                        break;
                    }
                }
                sysUserExpansion.setUserId(sysUser.getId());
                //此值乱码，需要手动添加
                //sysUserExpansion.setProvince(trade.getNameProvince());
                sysUserExpansion.setEmail(fund.getUserEmail());
                sysUserExpansion.setAddress(fund.getUserAddress());
                sysUserExpansion.setBirthday(fund.getBirthday());
                sysUserExpansion.setMobile(fund.getUserMobile());
                sysUserExpansion.setQq(fund.getQq());
                sysUserExpansion.setWechat(fund.getWeixin());
                if (insertExp) {
                    //更新扩展
                    sysUserExpansionMapper.insert(sysUserExpansion);
                    insertTimeExp++;

                } else {
                    expansionUpdateWrapper.eq("user_id", sysUser.getId());
                    sysUserExpansionMapper.update(sysUserExpansion, expansionUpdateWrapper);
                    updateTimeExp++;
                }

            }
        }


        System.out.println("用户表：一共增加了" + insertTime + "条数据,更新了条" + updateTime + "数据");
        System.out.println("用户扩展表：一共增加了" + insertTimeExp + "条数据,更新了条" + updateTimeExp + "数据");
        long end = System.currentTimeMillis();
        System.out.println("初始化sys_user用时 ： " + (end - start) + "毫秒");
    }
}
