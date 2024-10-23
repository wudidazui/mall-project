package com.wangtao.mall.portal.controller;

import com.wangtao.mall.common.api.CommonPage;
import com.wangtao.mall.common.api.CommonResult;
import com.wangtao.mall.model.PmsBrand;
import com.wangtao.mall.model.PmsProduct;
import com.wangtao.mall.portal.service.PmsPortalBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页品牌推荐管理Controller
 */
@Controller
@Api(tags = "PmsPortalBrandController")
@Tag(name = "PmsPortalBrandController",description = "前台品牌管理")
@RequestMapping("/brand")
public class PmsPortalBrandController {

    @Autowired
    private PmsPortalBrandService portalBrandService;

    @ApiOperation("分页获取推荐商品")
    @RequestMapping(value = "/recommendList",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> recommendList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize",defaultValue = "6") Integer pageSize) {
        List<PmsBrand> brandList = portalBrandService.recommendList(pageNum,pageSize);
        return CommonResult.success(brandList);
    }

    @ApiOperation("获取品牌详情")
    @RequestMapping(value = "/detail/{brandId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult detail(@PathVariable Long brandId){
        PmsBrand brand = portalBrandService.detail(brandId);
        return CommonResult.success(brand);
    }

    @ApiOperation("分页获取品牌相关商品")
    @RequestMapping(value = "/productList",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult productList(@RequestParam Long brandId,
                                    @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "6") Integer pageSize){
        CommonPage<PmsProduct> result = portalBrandService.productList(brandId,pageNum,pageSize);
        return CommonResult.success(result);
    }

}
