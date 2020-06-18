package com.miaosha.dataobject;

public class OrderDo {
    private String id;

    private Integer userId;

    private Integer itemId;

    private Double itemPrice;

    private Integer amount;

    private Double orderPrice;

    public OrderDo(String id, Integer userId, Integer itemId, Double itemPrice, Integer amount, Double orderPrice) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.itemPrice = itemPrice;
        this.amount = amount;
        this.orderPrice = orderPrice;
    }

    public OrderDo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }
}