package com.miaosha.service.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;


public class PromoModel {
    //秒杀活动状态,1:表示还未开始，2：进行中，3：表示已结束
    private Integer status;

    private Integer id;
    //秒杀活动名称

    private String promoName;
    //开始时间
    private DateTime startDate;
    //结束时间
    private DateTime endDate;
    //活动适用商品ID
    private Integer itemId;
    //活动时的商品价格
    private BigDecimal promoItemPrice;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPromoItemPrice() {
        return promoItemPrice;
    }

    public void setPromoItemPrice(BigDecimal promoItemPrice) {
        this.promoItemPrice = promoItemPrice;
    }
}
