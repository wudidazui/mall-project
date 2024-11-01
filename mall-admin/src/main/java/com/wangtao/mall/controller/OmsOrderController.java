package com.wangtao.mall.controller;

import com.wangtao.mall.common.api.CommonPage;
import com.wangtao.mall.common.api.CommonResult;
import com.wangtao.mall.dto.*;
import com.wangtao.mall.model.OmsOrder;
import com.wangtao.mall.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@Api(tags = "OmsOrderController")
@Tag(name = "OmsOrderController",description = "订单管理")
@RequestMapping("/order")
public class OmsOrderController {

    @Autowired
    private OmsOrderService orderService;

    @ApiOperation("查询订单")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrder>> list(OmsOrderQueryParam queryParam,
                                                   @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                   @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        List<OmsOrder> orderList = orderService.list(queryParam,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(orderList));
    }

    @ApiOperation("批量发货")
    @RequestMapping(value = "/update/delivery",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delivery(@RequestBody List<OmsOrderDeliveryParam> deliveryParamList){
       int count = orderService.delivery(deliveryParamList);
       if(count > 0){
           return CommonResult.success(count);
       }else{
           return CommonResult.failed();
       }
    }

    @ApiOperation("批量关闭订单")
    @RequestMapping(value = "/update/close",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult close(@RequestParam("ids")List<Long> ids,@RequestParam String note){
        int count = orderService.close(ids,note);
        if(count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
    @ApiOperation("批量删除订单")
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids")List<Long> ids){
        int count = orderService.delete(ids);
        if(count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取订单详情：订单信息、商品信息、操作记录")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OmsOrderDetail> detail(@PathVariable("id") Long id){
       OmsOrderDetail orderDetailResult = orderService.detail(id);
       return CommonResult.success(orderDetailResult);
    }

    @ApiOperation("修改收货人信息")
    @RequestMapping(value = "/update/receiverInfo",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateReceiverInfo(@RequestBody OmsReceiverInfoParam receiverInfoParam){
       int count = orderService.updateReceiverInfo(receiverInfoParam);
       if(count > 0){
           return CommonResult.success(count);
       }
       return CommonResult.failed();
    }

    @ApiOperation("修改订单费用信息")
    @RequestMapping(value = "/update/moneyInfo",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateReceiverInfo(@RequestBody OmsMoneyInfoParam moneyInfoParam){
        int count = orderService.updateMoneyInfo(moneyInfoParam);
        if(count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("备注订单")
    @RequestMapping(value = "/update/note",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateNote(@RequestParam("id") Long id,
                                   @RequestParam("note") String note,
                                   @RequestParam("status") Integer status){
        int count = orderService.updateNode(id,note,status);
        if(count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
