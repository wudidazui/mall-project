package com.wangtao.mall.service;

import com.wangtao.mall.dto.PmsProductAttributeCategoryItem;
import com.wangtao.mall.model.PmsProductAttributeCategory;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 商品属性分类管理Service
 */
public interface PmsProductAttributeCategoryService {
    /**
     * 创建属性分类
     */
    int create(String name);

    /**
     * 修改属性分类
     */
    int update(Long id, String name);
    /**
     * 删除属性分类
     */
    int delete(Long id);

    /**
     * 获取属性分类详情
     */
    PmsProductAttributeCategory getItem(Long id);

    /**
     * 分页查询属性分类
     */
    List<PmsProductAttributeCategory> getList(Integer pageNum,Integer pageSize);

    /**
     * 获取包含属性的属性分类
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
