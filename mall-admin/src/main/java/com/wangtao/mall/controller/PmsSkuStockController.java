package com.wangtao.mall.controller;

import com.wangtao.mall.common.api.CommonResult;
import com.wangtao.mall.model.PmsSkuStock;
import com.wangtao.mall.service.PmsSkuStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "PmsSkuStockController")
@Tag(name = "PmsSkuStockController",description = "sku商品库存管理")
@RequestMapping("/sku")
public class PmsSkuStockController {
    @Autowired
    private PmsSkuStockService stockService;

    @ApiOperation("根据商品ID及sku编码模糊搜索sku库存")
    @RequestMapping(value = "/{pid}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getList(@PathVariable Long pid, @RequestParam(value = "keyword",required = false) String keyword) {
        List<PmsSkuStock> skuStockList = stockService.getList(pid,keyword);
        return CommonResult.success(skuStockList);
    }

    @ApiOperation("批量更新sku库存信息")
    @RequestMapping(value = "/update/{pid}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long pid, @RequestBody List<PmsSkuStock> skuStockList) {
        int count = stockService.update(pid,skuStockList);
        if (count > 0) {
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }
}
