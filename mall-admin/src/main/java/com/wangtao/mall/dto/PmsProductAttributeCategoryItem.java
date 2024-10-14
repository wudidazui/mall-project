package com.wangtao.mall.dto;

import com.wangtao.mall.model.PmsProductAttribute;
import com.wangtao.mall.model.PmsProductAttributeCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {

    @Getter
    @Setter
    @ApiModelProperty(value = "商品属性列表")
    private List<PmsProductAttribute> productAttributeList;
}
