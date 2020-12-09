package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;

import java.math.BigDecimal;

/**
 * <p>
 * 货品价格扩展信息表
 * </p>
 *
 * @author Savior
 * @since 2020-12-08
 */
@TableName(value = "sys_cargo_month_price")
public class SysCargoMonthPrice extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("CUS_PKID")
    private String cusPkid;

    /**
     * 货品类别ID
     */
    @TableField("CARGO_CATEGORY_PKID")
    private String cargoCategoryPkid;

    /**
     * 一月价格
     */
    @TableField("JANUARY_PRICE")
    private BigDecimal januaryPrice;

    /**
     * 二月价格
     */
    @TableField("FEBRUARY_PRICE")
    private BigDecimal februaryPrice;

    /**
     * 三月价格
     */
    @TableField("MARCH_PRICE")
    private BigDecimal marchPrice;

    /**
     * 四月价格
     */
    @TableField("APRIL_PRICE")
    private BigDecimal aprilPrice;

    /**
     * 五月价格
     */
    @TableField("MAY_PRICE")
    private BigDecimal mayPrice;

    /**
     * 六月价格
     */
    @TableField("JUNE_PRICE")
    private BigDecimal junePrice;

    /**
     * 七月价格
     */
    @TableField("JULY_PRICE")
    private BigDecimal julyPrice;

    /**
     * 八月价格
     */
    @TableField("AUGUST_PRICE")
    private BigDecimal augustPrice;

    /**
     * 九月价格
     */
    @TableField("SEPTEMBER_PRICE")
    private BigDecimal septemberPrice;

    /**
     * 十月价格
     */
    @TableField("OCTOBER_PRICE")
    private BigDecimal octoberPrice;

    /**
     * 十一月价格
     */
    @TableField("NOVEMBER_PRICE")
    private BigDecimal novemberPrice;

    /**
     * 十二月价格
     */
    @TableField("DECEMBER_PRICE")
    private BigDecimal decemberPrice;

    /**
     * 年份
     */
    private String year;


    public String getCusPkid() {
        return cusPkid;
    }

    public void setCusPkid(String cusPkid) {
        this.cusPkid = cusPkid;
    }

    public String getCargoCategoryPkid() {
        return cargoCategoryPkid;
    }

    public void setCargoCategoryPkid(String cargoCategoryPkid) {
        this.cargoCategoryPkid = cargoCategoryPkid;
    }

    public BigDecimal getJanuaryPrice() {
        return januaryPrice;
    }

    public void setJanuaryPrice(BigDecimal januaryPrice) {
        this.januaryPrice = januaryPrice;
    }

    public BigDecimal getFebruaryPrice() {
        return februaryPrice;
    }

    public void setFebruaryPrice(BigDecimal februaryPrice) {
        this.februaryPrice = februaryPrice;
    }

    public BigDecimal getMarchPrice() {
        return marchPrice;
    }

    public void setMarchPrice(BigDecimal marchPrice) {
        this.marchPrice = marchPrice;
    }

    public BigDecimal getAprilPrice() {
        return aprilPrice;
    }

    public void setAprilPrice(BigDecimal aprilPrice) {
        this.aprilPrice = aprilPrice;
    }

    public BigDecimal getMayPrice() {
        return mayPrice;
    }

    public void setMayPrice(BigDecimal mayPrice) {
        this.mayPrice = mayPrice;
    }

    public BigDecimal getJunePrice() {
        return junePrice;
    }

    public void setJunePrice(BigDecimal junePrice) {
        this.junePrice = junePrice;
    }

    public BigDecimal getJulyPrice() {
        return julyPrice;
    }

    public void setJulyPrice(BigDecimal julyPrice) {
        this.julyPrice = julyPrice;
    }

    public BigDecimal getAugustPrice() {
        return augustPrice;
    }

    public void setAugustPrice(BigDecimal augustPrice) {
        this.augustPrice = augustPrice;
    }

    public BigDecimal getSeptemberPrice() {
        return septemberPrice;
    }

    public void setSeptemberPrice(BigDecimal septemberPrice) {
        this.septemberPrice = septemberPrice;
    }

    public BigDecimal getOctoberPrice() {
        return octoberPrice;
    }

    public void setOctoberPrice(BigDecimal octoberPrice) {
        this.octoberPrice = octoberPrice;
    }

    public BigDecimal getNovemberPrice() {
        return novemberPrice;
    }

    public void setNovemberPrice(BigDecimal novemberPrice) {
        this.novemberPrice = novemberPrice;
    }

    public BigDecimal getDecemberPrice() {
        return decemberPrice;
    }

    public void setDecemberPrice(BigDecimal decemberPrice) {
        this.decemberPrice = decemberPrice;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "SysCargoMonthPrice{" +
        "cusPkid=" + cusPkid +
        ", cargoCategoryPkid=" + cargoCategoryPkid +
        ", januaryPrice=" + januaryPrice +
        ", februaryPrice=" + februaryPrice +
        ", marchPrice=" + marchPrice +
        ", aprilPrice=" + aprilPrice +
        ", mayPrice=" + mayPrice +
        ", junePrice=" + junePrice +
        ", julyPrice=" + julyPrice +
        ", augustPrice=" + augustPrice +
        ", septemberPrice=" + septemberPrice +
        ", octoberPrice=" + octoberPrice +
        ", novemberPrice=" + novemberPrice +
        ", decemberPrice=" + decemberPrice +
        ", year=" + year +
        "}";
    }
}
