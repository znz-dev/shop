package org.znz.entity;

import java.util.Date;

/**
 * Created by zhouxin on 17-4-30.
 */
public class Good {

    private int goodId;

    private String name;

    private float price;

    private int status;

    private String description;

    private int sales;

    private int remainder;

    private Date createTime;

    private int categoryId;

//    private int shopId;

//    private Shop shop;

    @Override
    public String toString() {
        return "Good{" +
                "good_id=" + goodId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", sales=" + sales +
                ", remainder=" + remainder +
                ", createTime=" + createTime +
//                ", shop=" + shop +
                '}';
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getRemainder() {
        return remainder;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

//    public int getShopId() {
//        return shopId;
//    }
//
//    public void setShopId(int shopId) {
//        this.shopId = shopId;
//    }
//
//    public Shop getShop() {
//        return shop;
//    }
//
//    public void setShop(Shop shop) {
//        this.shop = shop;
//    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
