package com.zw.ft.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.sys.entity.SysReply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统需求回复表  服务类
 * </p>
 *
 * @author Oliver
 * @since 2020-11-02
 */
public interface SysReplyService extends IService<SysReply> {

    /*
     * 功能描述: <br>
     * 〈查询一个系统需求的回复〉
     * @Param: needId 系统需求ID
     * @Author: Oliver
     * @Date: 2020/11/2 11:27
     */

    List<SysReply> getReplyInfo(long needId);

}
