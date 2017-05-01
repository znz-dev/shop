package org.znz.entity;

import java.util.Date;

/**
 * Created by zhouxin on 17-4-30.
 */
public class Good {

    private int good_id;

    private String name;

    private float price;

    private int status;

    private String description;

    private int sales;

    private int remainder;

    private Date createTime;

    private Shop shop;

    @Override
    public String toString() {
        return "Good{" +
                "good_id=" + good_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", sales=" + sales +
                ", remainder=" + remainder +
                ", createTime=" + createTime +
                ", shop=" + shop +
                '}';
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
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

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
