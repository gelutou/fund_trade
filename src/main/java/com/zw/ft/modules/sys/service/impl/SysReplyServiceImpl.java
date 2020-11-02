package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.modules.sys.entity.SysNeeds;
import com.zw.ft.modules.sys.entity.SysReply;
import com.zw.ft.modules.sys.repository.SysNeedsMapper;
import com.zw.ft.modules.sys.repository.SysReplyMapper;
import com.zw.ft.modules.sys.service.SysReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  系统需求回复表  服务实现类
 * </p>
 *
 * @author Oliver
 * @since 2020-11-02
 */
@Service("sysReplyService")
public class SysReplyServiceImpl extends ServiceImpl<SysReplyMapper, SysReply> implements SysReplyService {

    @Resource
    SysReplyMapper sysReplyMapper;

    @Override
    public List<SysReply> getReplyInfo(long needId) {

        //查询父级回复
        QueryWrapper<SysReply> replyQueryWrapper = new QueryWrapper<>();
        replyQueryWrapper.eq("need_id",needId).isNull("parent_id");
        List<SysReply> replies = sysReplyMapper.selectList(replyQueryWrapper);
        for(SysReply reply : replies){
            putChildrenReply(reply);
        }
        return replies;
    }

    /*
     * 功能描述: <br>
     * 〈设置系统需求子集〉
     * @Param:
     * @Return:
     * @Author: Oliver
     * @Date: 2020/11/2 11:28
     */

    public void putChildrenReply(SysReply reply){

        //查询出其所有子集
        Long id = reply.getId();
        QueryWrapper<SysReply> replyQueryWrapper = new QueryWrapper<>();
        replyQueryWrapper.eq("parent_id",id);
        List<SysReply> replies = sysReplyMapper.selectList(replyQueryWrapper);
        if(replies.size() > 0){
            reply.setChildren(replies);
            for(SysReply replyEntity : replies){
                putChildrenReply(replyEntity);
            }
        }
    }
}
