package com.zyx.ssm.dao;

import com.zyx.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层产品接口
 */

@Repository("productDao")
public interface IProductDao {

    //查询所有产品的信息
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    //增加商品信息
    @Insert("insert into product(productNum,productName,departureTime,cityName,productPrice,productStatus,productDesc) values(#{productNum},#{productName},#{departureTime},#{cityName},#{productPrice},#{productStatus},#{productDesc})")
    void save(Product product) throws Exception;

    @Select("select * from product where id = #{id}")
    Product findById(String id) throws Exception;
}
