package com.zw.ft.initdb;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.modules.fund.entity.TUser;
import com.zw.ft.modules.fund.repository.TUserMapper;
import com.zw.ft.modules.sys.entity.SysUser;
import com.zw.ft.modules.sys.entity.SysUserExpansion;
import com.zw.ft.modules.sys.repository.SysUserExpansionMapper;
import com.zw.ft.modules.sys.repository.SysUserMapper;
import com.zw.ft.modules.trade.entity.SysUserTrade;
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
public class SysInit {

    @Resource
    SysUserMapper sysUserMapper;
    @Resource
    SysUserTradeMapper sysUserTradeMapper;
    @Resource
    TUserMapper tUserMapper;
    @Resource
    SysUserExpansionMapper sysUserExpansionMapper;

    @Test
    void initSysUser(){
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

        List<SysUser> sysUsers = sysUserMapper.getAllUsers();
        List<SysUserExpansion> allUserExpansions = sysUserExpansionMapper.getAllUserExpansions();

        List<SysUserTrade> sysUserTrades = sysUserTradeMapper.selectAllGroupByUserCode();
        List<TUser> tUsers = tUserMapper.selectAllGroupByUserCode();

        //处理资金账号和商贸账号冲突
        for(TUser u : tUsers){
            for(SysUserTrade t: sysUserTrades){
                if(u.getUserCode().toLowerCase().equals(t.getUserCode().toLowerCase())){
                    String uc = u.getUserCode()+"123";
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

        for(SysUserTrade trade : sysUserTrades){
            boolean insert = true;
            boolean insertFund = true;
            SysUser sysUser = null;
            for(SysUser user : sysUsers){
                if(user.getUsername().equals(trade.getUserCode())){
                    sysUser = user;
                    insert = false;
                    break;
                }
            }
            SysUserExpansion sysUserExpansion = new SysUserExpansion();
            if(insert){
                sysUser = new SysUser();
                sysUser.setUsername(trade.getUserCode());
                System.out.println("添加账号 = " + sysUser.getUsername());
                insertTime++;
                sysUser.setGender(trade.getSex().equals("1") ?0:1);
                sysUser.setPassword(new Sha256Hash("1", sysUser.getUsername()).toHex());
                sysUser.setRealname(trade.getUserName());
                sysUser.setCreatedBy(1L);
                sysUser.setCreatedTime(Convert.convert(LocalDateTime.class,trade.getMakeTime()));
                sysUser.setDeleted(trade.getFlagDelete());
                sysUser.setRevision(1);
                sysUser.setUpdatedBy(1L);
                sysUser.setUpdatedTime(trade.getModifyTime()==null?Convert.convert(LocalDateTime.class,trade.getMakeTime()):Convert.convert(LocalDateTime.class,trade.getModifyTime()));
                sysUserMapper.insert(sysUser);

                long userId = sysUser.getId();
                boolean insertExp = true;
                for(SysUserExpansion userExpansion : allUserExpansions){
                    if(userExpansion.getUserId() == userId){
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
                if(insertExp){
                    //更新扩展
                    sysUserExpansionMapper.insert(sysUserExpansion);
                    insertTimeExp++;

                }else {
                    expansionUpdateWrapper.eq("user_id",sysUser.getId());
                    sysUserExpansionMapper.update(sysUserExpansion,expansionUpdateWrapper);
                    updateTimeExp++;
                }
            }else {
                UpdateWrapper<SysUser> userUpdateWrapper = new UpdateWrapper<>();
                userUpdateWrapper.eq("username",trade.getUserCode());
                System.out.println("更新账号 = " + trade.getUserCode());
                updateTime++;
                sysUser.setGender(trade.getSex().equals("1") ?0:1);
                sysUser.setPassword(new Sha256Hash("1", sysUser.getUsername()).toHex());
                sysUser.setRealname(trade.getUserName());
                sysUser.setCreatedBy(1L);
                sysUser.setCreatedTime(Convert.convert(LocalDateTime.class,trade.getMakeTime()));
                sysUser.setDeleted(trade.getFlagDelete());
                sysUser.setRevision(1);
                sysUser.setUpdatedBy(1L);
                sysUser.setUpdatedTime(trade.getModifyTime()==null?Convert.convert(LocalDateTime.class,trade.getMakeTime()):Convert.convert(LocalDateTime.class,trade.getModifyTime()));
                sysUserMapper.update(sysUser,userUpdateWrapper);

                long userId = sysUser.getId();
                boolean insertExp = true;
                for(SysUserExpansion userExpansion : allUserExpansions){
                    if(userExpansion.getUserId() == userId){
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
                if(insertExp){
                    //更新扩展
                    sysUserExpansionMapper.insert(sysUserExpansion);
                    insertTimeExp++;

                }else {
                    expansionUpdateWrapper.eq("user_id",sysUser.getId());
                    sysUserExpansionMapper.update(sysUserExpansion,expansionUpdateWrapper);
                    updateTimeExp++;
                }

            }
        }

        List<SysUser> sysUsersForFund = sysUserMapper.getAllUsers();

        for(TUser fund : tUsers){
            boolean insert = true;
            SysUser sysUser = null;
            for(SysUser user : sysUsersForFund){
                if(user.getUsername().equals(fund.getUserCode())){
                    sysUser = user;
                    insert = false;
                    break;
                }
            }
            SysUserExpansion sysUserExpansion = new SysUserExpansion();
            if(insert){
                sysUser = new SysUser();
                sysUser.setUsername(fund.getUserCode());
                System.out.println("添加账号 = " + sysUser.getUsername());
                insertTime++;
                sysUser.setGender(fund.getSex()==1 ?0:1);
                sysUser.setPassword(new Sha256Hash("1", sysUser.getUsername()).toHex());
                sysUser.setRealname(fund.getUserName());
                sysUser.setCreatedBy(1L);
                sysUser.setCreatedTime(Convert.convert(LocalDateTime.class,fund.getMakeTime()));
                sysUser.setDeleted(fund.getFlagDelete());
                sysUser.setRevision(1);
                sysUser.setUpdatedBy(1L);
                sysUser.setUpdatedTime(fund.getModifyTime()==null?Convert.convert(LocalDateTime.class,fund.getMakeTime()):Convert.convert(LocalDateTime.class,fund.getModifyTime()));
                sysUserMapper.insert(sysUser);

                long userId = sysUser.getId();
                boolean insertExp = true;
                for(SysUserExpansion userExpansion : allUserExpansions){
                    if(userExpansion.getUserId() == userId){
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
                if(insertExp){
                    //更新扩展
                    sysUserExpansionMapper.insert(sysUserExpansion);
                    insertTimeExp++;

                }else {
                    expansionUpdateWrapper.eq("user_id",sysUser.getId());
                    sysUserExpansionMapper.update(sysUserExpansion,expansionUpdateWrapper);
                    updateTimeExp++;
                }
            }else {
                UpdateWrapper<SysUser> userUpdateWrapper = new UpdateWrapper<>();
                userUpdateWrapper.eq("username",fund.getUserCode());
                System.out.println("更新账号 = " + fund.getUserCode());
                updateTime++;
                sysUser.setGender(fund.getSex() == 1 ?0:1);
                sysUser.setPassword(new Sha256Hash("1", sysUser.getUsername()).toHex());
                sysUser.setRealname(fund.getUserName());
                sysUser.setCreatedBy(1L);
                sysUser.setCreatedTime(Convert.convert(LocalDateTime.class,fund.getMakeTime()));
                sysUser.setDeleted(fund.getFlagDelete());
                sysUser.setRevision(1);
                sysUser.setUpdatedBy(1L);
                sysUser.setUpdatedTime(fund.getModifyTime()==null?Convert.convert(LocalDateTime.class,fund.getMakeTime()):Convert.convert(LocalDateTime.class,fund.getModifyTime()));
                sysUserMapper.update(sysUser,userUpdateWrapper);

                long userId = sysUser.getId();
                boolean insertExp = true;
                for(SysUserExpansion userExpansion : allUserExpansions){
                    if(userExpansion.getUserId() == userId){
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
                if(insertExp){
                    //更新扩展
                    sysUserExpansionMapper.insert(sysUserExpansion);
                    insertTimeExp++;

                }else {
                    expansionUpdateWrapper.eq("user_id",sysUser.getId());
                    sysUserExpansionMapper.update(sysUserExpansion,expansionUpdateWrapper);
                    updateTimeExp++;
                }

            }
        }


        System.out.println("用户表：一共增加了"+insertTime+"条数据,更新了条"+updateTime+"数据");
        System.out.println("用户扩展表：一共增加了"+insertTimeExp+"条数据,更新了条"+updateTimeExp+"数据");
        long end = System.currentTimeMillis();
        System.out.println("初始化sys_user用时 ： " + (end - start) +"毫秒");
    }
}
