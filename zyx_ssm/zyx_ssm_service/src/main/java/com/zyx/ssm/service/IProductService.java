package com.zyx.ssm.service;

import com.zyx.ssm.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层产品接口
 */
public interface IProductService {

    //查询所有产品的信息
    public List<Product> findAll(int page,int size) throws Exception;

    //保存商品信息
    void save(Product product) throws Exception;

    //根据id查询产品
    Product findById(String id) throws Exception;
}
