package com.wangtao.mall.portal.service;

import com.wangtao.mall.common.api.CommonPage;
import com.wangtao.mall.model.PmsBrand;
import com.wangtao.mall.model.PmsProduct;

import java.util.List;

public interface PmsPortalBrandService {
    /**
     * 分页获取推荐品牌
     */
    List<PmsBrand> recommendList(Integer pageNum, Integer pageSize);

    /**
     * 获取品牌详情
     */
    PmsBrand detail(Long brandId);

    /**
     * 分页获取品牌关联商品
     */
    CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize);
}
