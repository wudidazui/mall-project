package com.wangtao.mall.portal.dao;

import com.wangtao.mall.model.SmsCoupon;
import com.wangtao.mall.portal.domin.CartProduct;
import com.wangtao.mall.portal.domin.PromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * 前台购物车商品管理自定义Dao
 */
public interface PortalProductDao {
    /**
     * 获取可用优惠券列表
     */
    List<SmsCoupon> getAvailableCouponList(@Param("productId") Long id, @Param("productCategoryId")Long productCategoryId);

    /**
     * 获取促销商品信息列表
     */
    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);

    /**
     * 获取购物车商品信息
     */
    CartProduct getCartProduct(@Param("id") Long productId);
}
