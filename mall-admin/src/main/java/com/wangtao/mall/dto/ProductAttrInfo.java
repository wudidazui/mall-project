package com.wangtao.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ProductAttrInfo {
    @ApiModelProperty("商品属性ID")
    private Long attributeId;
    @ApiModelProperty("商品属性分类ID")
    private Long attributeCategoryId;
}
