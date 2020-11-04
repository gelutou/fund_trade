package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.modules.sys.entity.SysReply;
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
        replyQueryWrapper.eq("need_id",needId);
        replyQueryWrapper.eq("deleted","0");
        replyQueryWrapper.orderByDesc("created_time");
        return sysReplyMapper.getReply(replyQueryWrapper);
    }
}
