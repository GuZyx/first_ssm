package com.zyx.ssm.dao;

import com.zyx.ssm.domain.Travellers;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 游客持久层
 */
@Repository("travellerDao")
public interface ITravellerDao {

    //查询包含该订单id的游客
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersId})")
    List<Travellers> findByOrdersId(String ordersId) throws Exception;
}
