package com.miaosha.dataobject;

public class ItemColor {
    private Integer id;

    private Integer itemId;

    private String color;

    public ItemColor(Integer id, Integer itemId, String color) {
        this.id = id;
        this.itemId = itemId;
        this.color = color;
    }

    public ItemColor() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }
}