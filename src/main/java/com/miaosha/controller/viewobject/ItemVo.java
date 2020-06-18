package com.miaosha.controller.viewobject;


import org.joda.time.DateTime;
import com.miaosha.dataobject.ItemColor;
import java.math.BigDecimal;
import java.util.List;

public class ItemVo {

    private Integer id;

    //商品名
    private String title;

    //商品价格
    private BigDecimal price;

    //商品库存
    private Integer stock;

    //商品描述
    private String decription;

    //商品销量
    private Integer sales;

    //商品图片的URL
    private String imgurl;
    //记录商品是否在秒杀活动中，0：表示没有活动，1：表示活动还没有开始，2：表示活动进行中
    private Integer promoStatus;
    //
    private BigDecimal promoPrice;
    //
    private Integer promoId;
    //
    private DateTime startDate;
    //
    private DateTime endDate;


    //商品颜色列表
    private List<ItemColor> itemColors;



    public List<ItemColor> getItemColors() {
        return itemColors;
    }

    public void setItemColors(List<ItemColor> itemColors) {
        this.itemColors = itemColors;
    }

    public Integer getPromoStatus() {
        return promoStatus;
    }

    public void setPromoStatus(Integer promoStatus) {
        this.promoStatus = promoStatus;
    }

    public BigDecimal getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(BigDecimal promoPrice) {
        this.promoPrice = promoPrice;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
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
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
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
        this.imgurl = imgurl;
    }
}
