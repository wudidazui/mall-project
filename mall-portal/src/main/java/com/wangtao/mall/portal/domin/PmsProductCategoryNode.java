package com.wangtao.mall.portal.domin;

import com.wangtao.mall.model.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PmsProductCategoryNode extends PmsProductCategory {
    @ApiModelProperty("子分类列表")
    private List<PmsProductCategoryNode> children;
}
