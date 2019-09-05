package com.zyx.ssm.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 用户实体类
 */
public class UserInfo implements Serializable {
    private String id;     //主键id
    private String email;   //邮箱非空，唯一
    private String userName;//用户名
    private String passWord;//密码(加密)
    private String phoneNum;//电话
    private Integer status; //状态    0 未开启 1开启
    private String statusStr;
    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        if(status!=null){
            if(status==0){
                statusStr="关闭";
            } else if (status==1) {
                statusStr="开启";
            }
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", status=" + status +
                '}';
    }
}
