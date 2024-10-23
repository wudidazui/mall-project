package com.wangtao.mall.dao;

import com.wangtao.mall.model.PmsProductCategoryAttributeRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductCategoryAttributeRelationDao {
    void insertList(@Param("list") List<PmsProductCategoryAttributeRelation> relationList);
}
