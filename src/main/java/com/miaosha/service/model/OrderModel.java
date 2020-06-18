package com.miaosha.service.model;

import java.math.BigDecimal;

public class OrderModel {
    //交易订单号日期+加单号
    private String id;
    //用户Id
    private Integer userId;
    //商品Id
    private Integer itemId;
    //商品单价
    private BigDecimal itemPrice;
    //购买数量
    private Integer amount;
    //购买金额
    private BigDecimal orderPrice;



    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

}
