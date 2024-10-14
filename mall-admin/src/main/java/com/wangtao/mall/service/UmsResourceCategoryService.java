package com.wangtao.mall.service;

import com.wangtao.mall.model.UmsResource;
import com.wangtao.mall.model.UmsResourceCategory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UmsResourceCategoryService {
    /**
     * 添加资源
     */
    List<UmsResourceCategory> listAll();

    /**
     * 创建资源分类
     */
    int create(UmsResourceCategory umsResourceCategory);

    /**
     * 修改资源分类
     */
    int update(Long id, UmsResourceCategory umsResourceCategory);

    /**
     * 删除资源分类
     */
    int delete(Long id);
}
