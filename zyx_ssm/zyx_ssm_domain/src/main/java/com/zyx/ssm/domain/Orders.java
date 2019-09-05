package com.zyx.ssm.domain;

import com.zyx.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 */
public class Orders implements Serializable {

    private String id; //主键
    private String orderNum;    //产品编号
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date orderTime;   //下单时间
    private int peopleCount; //出行人数
    private String orderDesc;   //订单描述
    private Integer payType;    //支付方式 0 支付宝 1 微信 2其它
    private Integer orderStatus; //订单状态  0未支付，1已支付

    private Product product;
    private Member member;
    private List<Travellers> travellers;

    private String orderTimeStr;    //在下面三行
    private String payTypeStr;
    private String orderStatusStr;


    public List<Travellers> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Travellers> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPayTypeStr() {
        if(payType!=null){
            switch (payType){
                case 0:
                    payTypeStr="支付宝";
                    break;
                case 1:
                    payTypeStr="微信";
                    break;
                case 2:
                    payTypeStr="其它";
                    break;
            }
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderStatusStr() {
        if(orderStatus!=null){
            switch (orderStatus){
                case 0:
                    orderStatusStr="未支付";
                    break;
                case 1:
                    orderStatusStr="已支付";
                    break;
            }
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getOrderTimeStr() {
        if(orderTime!=null){
            orderTimeStr= DateUtils.dateToString(orderTime,"yyyy/MM/dd hh:mm");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }
}
