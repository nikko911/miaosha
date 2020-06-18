package com.miaosha.service.model;

import com.miaosha.dataobject.ItemColor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class ItemModel {

    private Integer id;

    //商品名
    @NotBlank(message = "商品名不能为空")
    private String title;

    //商品价格
    @NotNull(message = "商品价格不能为空")
    @Min(value = 0, message = "商品价格不能低于0")
    private BigDecimal price;

    //商品库存
    @NotNull(message = "商品库存不能为空")
    @Min(value = 0, message = "库存须大于0")
    @Max(value = 10000, message = "库存小于10000")
    private Integer stock;

    //商品描述
    @NotBlank(message = "商品描述不能为空")
    private String decription;

    //商品销量
    private Integer sales;

    //商品图片的URL
    @NotBlank(message = "商品图片不能为空")
    private String imgurl;

    //使用聚合模型
    private PromoModel promoModel;

    //商品颜色列表
    private List<String> itemColors;

    public List<String> getItemColors() {
        return itemColors;
    }

    public void setItemColors(List<String> itemColors) {
        this.itemColors = itemColors;
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

    public PromoModel getPromoModel() {
        return promoModel;
    }

    public void setPromoModel(PromoModel promoModel) {
        this.promoModel = promoModel;
    }
}
