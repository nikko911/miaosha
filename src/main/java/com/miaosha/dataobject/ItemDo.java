package com.miaosha.dataobject;

public class ItemDo {
    private Integer id;

    private String title;

    private Double price;

    private String decription;

    private Integer sales;

    private String imgurl;

    public ItemDo(Integer id, String title, Double price, String decription, Integer sales, String imgurl) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.decription = decription;
        this.sales = sales;
        this.imgurl = imgurl;
    }

    public ItemDo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription == null ? null : decription.trim();
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }
}