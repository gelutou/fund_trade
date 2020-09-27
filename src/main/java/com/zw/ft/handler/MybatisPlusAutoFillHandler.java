package com.zw.ft.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.zw.ft.common.utils.ShiroUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

/**
 * @ClassName DataObjectHandler
 * @Description mysql-plus的自动填充
 * @Author Oliver
 * @Date 2020/8/14 10:55
 * @Version 1.0
 **/
@Component
public class MybatisPlusAutoFillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createdTime", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "updatedTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "createdBy", Long.class, ShiroUtils.getUserId());
        this.strictInsertFill(metaObject, "deleted", Integer.class, 0);
        this.strictInsertFill(metaObject, "revision", Integer.class, 1);
        //this.strictInsertFill(metaObject, "status", Integer.class, 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updatedTime", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "updatedBy",  Long.class, ShiroUtils.getUserId());
    }
}
