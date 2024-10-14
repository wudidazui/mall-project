package com.wangtao.mall.dao;

import com.wangtao.mall.dto.ProductAttrInfo;

import java.util.List;

public interface PmsProductAttributeDao {
    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);
}
