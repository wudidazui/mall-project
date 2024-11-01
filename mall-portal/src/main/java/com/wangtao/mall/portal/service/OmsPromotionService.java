package com.wangtao.mall.portal.service;

import com.wangtao.mall.model.OmsCartItem;
import com.wangtao.mall.portal.domin.CartPromotionItem;

import java.util.List;

public interface OmsPromotionService {
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}
