package com.wangtao.mall.portal.domin;

import com.wangtao.mall.model.OmsCartItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CartPromotionItem extends OmsCartItem {
    @ApiModelProperty("促销活动信息")
    private String promotionMessage;

    @ApiModelProperty("促销活动减去的金额,针对每个商品")
    private BigDecimal reduceAmount;

    @ApiModelProperty("剩余库存-锁定库存")
    private Integer realStock;

    @ApiModelProperty("购买商品赠送积分")
    private Integer integeration;

    @ApiModelProperty("购买商品赠送成长值")
    private Integer growth;

}
