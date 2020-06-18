package com.miaosha.dataobject;

import java.util.Date;

public class PromoDo {
    private Integer id;

    private String promoName;

    private Date startTime;

    private Date endTime;

    private Integer itemId;

    private Double promoItemPrice;

    public PromoDo(Integer id, String promoName, Date startTime, Date endTime, Integer itemId, Double promoItemPrice) {
        this.id = id;
        this.promoName = promoName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.itemId = itemId;
        this.promoItemPrice = promoItemPrice;
    }

    public PromoDo() {
        super();
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
        this.promoName = promoName == null ? null : promoName.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Double getPromoItemPrice() {
        return promoItemPrice;
    }

    public void setPromoItemPrice(Double promoItemPrice) {
        this.promoItemPrice = promoItemPrice;
    }
}