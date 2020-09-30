package com.zw.ft.modules.sys.entity;

import com.zw.ft.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * <p>
 * 系统参数配置实体
 * </p>
 *
 * @author Oliver
 * @since 2020-09-30
 */
public class ModelConfiguration extends BaseEntity {

    private static final long serialVersionUID = -1135379310221837422L;
    /**
     * 标识 模块名_功能名_标识
     */
    private String identification;

    /**
     * 内容	{} 占位符，按顺序替换参数	$today 当天	$datetime 当天日期时间	--大小写不敏感
     */
    private String content;

    /**
     * 描述
     */
    private String des;


    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }


    @Override
    public String toString() {
        return "ModelConfiguration{" +
        "identification=" + identification +
        ", content=" + content +
        ", des=" + des +
        "}";
    }
}
