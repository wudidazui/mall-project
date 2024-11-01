package com.wangtao.mall.portal.domin;

import com.wangtao.mall.model.PmsProduct;
import com.wangtao.mall.model.PmsProductFullReduction;
import com.wangtao.mall.model.PmsProductLadder;
import com.wangtao.mall.model.PmsSkuStock;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PromotionProduct extends PmsProduct {

    //商品库存信息
    private List<PmsSkuStock> skuStockList;

    //商品打折信息
    private List<PmsProductLadder> productLadderList;

    //商品满减信息
    private List<PmsProductFullReduction> productFullReductionList;
}
