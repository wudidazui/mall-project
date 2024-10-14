package com.wangtao.mall.controller;


import com.wangtao.mall.common.api.CommonPage;
import com.wangtao.mall.common.api.CommonResult;
import com.wangtao.mall.dto.PmsProductAttributeParam;
import com.wangtao.mall.dto.ProductAttrInfo;
import com.wangtao.mall.model.PmsProductAttribute;
import com.wangtao.mall.service.PmsProductAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品属性管理Controller
 */
@Controller
@Api(tags = "PmsProductAttributeController")
@Tag(name = "PmsProductAttributeController",description = "商品属性管理")
@RequestMapping("/productAttribute")
public class PmsProductAttributeController {

    @Autowired
    private PmsProductAttributeService productAttributeService;

    //  paramType = "query" paramType = "query"，  paramType = "path" path的形式：getUser/user/admin
    @ApiOperation("根据分类查询属性列表或参数列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "type",value = "0表示属性，1表示参数",required = true,paramType = "query",dataType = "integer")})
    @RequestMapping(value = "/list/{cid}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getList(@PathVariable Long cid,
                                @RequestParam(value = "type") Integer type,
                                @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        List<PmsProductAttribute> productAttributeList = productAttributeService.getList(cid,type,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(productAttributeList));
    }

    @ApiOperation("添加商品属性信息")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody PmsProductAttributeParam productAttributeParam){
       int count = productAttributeService.create(productAttributeParam);
       if(count > 0){
           return CommonResult.success(count);
       }else{
           return CommonResult.failed();
       }
    }

    @ApiOperation("修改商品属性信息")
    @RequestMapping(value="/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,@RequestBody PmsProductAttributeParam productAttributeParam){
        int count = productAttributeService.update(id,productAttributeParam);
        if(count > 0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("查询单个商品属性")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsProductAttribute> getItem(@PathVariable Long id){
        PmsProductAttribute productAttribute = productAttributeService.getItem(id);
        return CommonResult.success(productAttribute);
    }

    @ApiOperation("批量删除属性")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        int count = productAttributeService.delete(ids);
        if(count > 0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据商品分类的id获取商品属性及属性分类")
    @RequestMapping(value = "/attrInfo/{productCategoryId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ProductAttrInfo>> getAttrInfo(@PathVariable Long productCategoryId){
        List<ProductAttrInfo> productAttrInfoList = productAttributeService.getProductAttrInfo(productCategoryId);
        return CommonResult.success(productAttrInfoList);
    }

}
