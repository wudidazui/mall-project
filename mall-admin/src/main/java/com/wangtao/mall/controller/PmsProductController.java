package com.wangtao.mall.controller;

import com.wangtao.mall.common.api.CommonPage;
import com.wangtao.mall.common.api.CommonResult;
import com.wangtao.mall.dto.PmsProductParam;
import com.wangtao.mall.dto.PmsProductQueryParam;
import com.wangtao.mall.dto.PmsProductResult;
import com.wangtao.mall.model.PmsProduct;
import com.wangtao.mall.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "PmsProductController")
@Tag(name = "PmsProductController",description = "商品管理")
@RequestMapping("/product")
public class PmsProductController {

    @Autowired
    private PmsProductService productService;

    @ApiOperation("创建商品")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody PmsProductParam productParam){
        int count = productService.create(productParam);
        if(count > 0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据商品id获取商品编辑信息")
    @RequestMapping(value = "/updateInfo/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsProductResult> getUpdateInfo(@PathVariable("id") Long id){
        PmsProductResult productResult = productService.getUpdateInfo(id);
        return CommonResult.success(productResult);
    }

    @ApiOperation("更新商品")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id,@RequestBody PmsProductParam productParam){
       int count = productService.update(id,productParam);
       if(count > 0){
           return CommonResult.success(count);
       }else{
           return CommonResult.failed();
       }
    }

    @ApiOperation("查询商品")
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsProduct>> getList(PmsProductQueryParam productQueryParam,
                                                        @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        List<PmsProduct> productList = productService.list(productQueryParam,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(productList));
    }

    @ApiOperation("根据商品名称或货号模糊查询")
    @RequestMapping(value = "/simpleList",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProduct>> getList(@RequestParam(value = "keyword")String keyword){
        List<PmsProduct> productList = productService.list(keyword);
        return CommonResult.success(productList);
    }

    @ApiOperation("批量修改审核状态")
    @RequestMapping(value = "/update/verifyStatus",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateVerifyStatus(@RequestParam("ids") List<Long> ids,
                                           @RequestParam("verifyStatus") Integer verifyStatus,
                                           @RequestParam("detail") String detail){
        int count = productService.updateVerifyStatus(ids,verifyStatus,detail);
        if(count > 0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量上下架商品")
    @RequestMapping(value = "/update/publishStatus",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePublishStatus(@RequestParam("ids") List<Long> ids,
                                           @RequestParam("publishStatus") Integer publishStatus){
        int count = productService.updatePublishStatus(ids,publishStatus);
        if(count > 0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量推荐商品")
    @RequestMapping(value = "/update/recommendStatus",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                              @RequestParam("recommendStatus") Integer recommendStatus){
        int count = productService.updateRecommendStatus(ids,recommendStatus);
        if(count > 0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量设为新品")
    @RequestMapping(value = "/update/newStatus",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateNewStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("newStatus") Integer newStatus){
        int count = productService.updateNewStatus(ids,newStatus);
        if(count > 0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量修改删除状态")
    @RequestMapping(value = "/update/deleteStatus",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateDeleteStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("deleteStatus") Integer deleteStatus){
        int count = productService.updateDeleteStatus(ids,deleteStatus);
        if(count > 0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }
}
