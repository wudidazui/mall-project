package com.wangtao.mall.portal.dao;

import com.wangtao.mall.model.SmsCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PortalProductDao {
    /**
     * 获取可用优惠券列表
     */
    List<SmsCoupon> getAvailableCouponList(@Param("productId") Long id, @Param("productCategoryId")Long productCategoryId);
}
