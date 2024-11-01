package com.wangtao.mall.dto;
import com.wangtao.mall.model.OmsOrder;
import com.wangtao.mall.model.OmsOrderItem;
import com.wangtao.mall.model.OmsOrderOperateHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class OmsOrderDetail extends OmsOrder{
    @ApiModelProperty("订单商品列表")
    private List<OmsOrderItem> orderItemList;

    @ApiModelProperty("订单操作记录列表")
    private List<OmsOrderOperateHistory> historyList;
}
