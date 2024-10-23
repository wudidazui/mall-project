package com.wangtao.mall.dao;

import com.wangtao.mall.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品SKU管理自定义Dao
 */
public interface PmsSkuStockDao {

    /**
     * 批量插入操作
     */
    int insertList(@Param("list") List<PmsSkuStock> skuStockList);

    /**
     * 批量插入或替换操作
     */
    int replaceList(List<PmsSkuStock> skuStockList);
}
