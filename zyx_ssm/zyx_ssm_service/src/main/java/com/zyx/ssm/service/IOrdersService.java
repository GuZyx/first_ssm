package com.zyx.ssm.service;

import com.zyx.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {

    //查询所有订单信息
    List<Orders> findAll(int page, int size) throws Exception;

    //根据id查询
    Orders findById(String ordersId) throws Exception;
}
