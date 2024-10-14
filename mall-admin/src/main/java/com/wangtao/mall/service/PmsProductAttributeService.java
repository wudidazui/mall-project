package com.wangtao.mall.service;

import com.wangtao.mall.dto.PmsProductAttributeParam;
import com.wangtao.mall.dto.ProductAttrInfo;
import com.wangtao.mall.model.PmsProductAttribute;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PmsProductAttributeService {
    /**
     * 根据分类分页获取商品属性
     * @param cid 分类id
     * @param type 0->规格；1->参数
     */
    List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageNum, Integer pageSize);
    /**
     * 添加商品属性
     */
    @Transactional
    int create(PmsProductAttributeParam productAttributeParam);
    /**
     * 修改商品属性
     */
    int update(Long id, PmsProductAttributeParam productAttributeParam);
    /**
     * 获取单个商品属性信息
     */
    PmsProductAttribute getItem(Long id);
    /**
     * 批量删除商品属性
     */
    @Transactional
    int delete(List<Long> ids);
    /**
     * 获取商品分类对应属性列表
     */
    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);
}
