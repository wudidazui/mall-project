package com.wangtao.mall.dao;

import com.wangtao.mall.dto.OmsOrderDeliveryParam;
import com.wangtao.mall.dto.OmsOrderDetail;
import com.wangtao.mall.dto.OmsOrderQueryParam;
import com.wangtao.mall.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OmsOrderDao {

    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);
    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(Long id);
}
