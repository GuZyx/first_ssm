package com.zyx.ssm.domain;

import com.zyx.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * 产品实体类
 */
public class Product {
    private String id;  //主键
    private String productNum;  //编号，唯一
    private String productName; //产品名称
    private String cityName;    //城市名称
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    private Date departureTime; //出发时间
    private String departureTimeStr;
    private double productPrice;    //产品价格
    private String productDesc; //产品描述
    private Integer productStatus;  //状态 0关闭 1开启
    private String productStatusStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) throws ParseException {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if(departureTime!=null){
            departureTimeStr=DateUtils.dateToString(departureTime,"yyyy-MM-dd hh:mm");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if(productStatus!=null){
            //状态0关闭，1开启
            switch (productStatus){
                case 0:
                    productStatusStr="关闭";
                    break;
                case 1:
                    productStatusStr="开启";
                    break;
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
