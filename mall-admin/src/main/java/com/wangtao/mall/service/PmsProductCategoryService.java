package com.wangtao.mall.service;

import com.wangtao.mall.dto.PmsProductCategoryParam;
import com.wangtao.mall.dto.PmsProductCategoryWithChildrenItem;
import com.wangtao.mall.model.PmsProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PmsProductCategoryService {
    /**
     * 创建商品分类
     */
    @Transactional
    int create(PmsProductCategoryParam productCategoryParam);


    /**
     * 修改商品分类
     */
    @Transactional
    int update(Long id, PmsProductCategoryParam productCategoryParam);

    /**
     * 分页获取商品分类
     */
    List<PmsProductCategory> getList(Long parentId, Integer pageNum, Integer pageSize);

    /**
     * 根据ID获取商品分类
     */
    PmsProductCategory getItem(Long id);

    /**
     * 删除商品分类
     */
    int delete(Long id);

    /**
     * 批量修改导航状态
     */
    int updateNavStatus(List<Long> ids, Integer navStatus);

    /**
     * 批量修改显示状态
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * 以层级形式获取商品分类
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
