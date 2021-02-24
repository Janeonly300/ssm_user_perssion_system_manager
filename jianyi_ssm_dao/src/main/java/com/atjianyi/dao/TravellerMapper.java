package com.atjianyi.dao;

import com.atjianyi.pojo.Traveller;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 简一
 * @className TravellerMapper
 * @Date 2021/2/22 22:06
 **/
@Repository
public interface TravellerMapper {
    /**
     * 根据订单ID查询游客
     * @return
     */
    List<Traveller> findTravellerByOrderId(String ordersId);
}
