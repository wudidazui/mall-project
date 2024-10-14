package com.wangtao.mall.service;

import com.wangtao.mall.model.UmsResource;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UmsResourceService {

    /**
     * 查询全部资源
     */
    List<UmsResource> listAll();

    /**
     * 添加资源
     */
    int create(UmsResource umsResource);

    /**
     * 修改资源
     */
    int update(Long id, UmsResource umsResource);

    /**
     * 根据ID获取资源详情
     */
    UmsResource getItem(Long id);

    /**
     * 删除资源
     */
    int delete(Long id);

    /**
     * 分页查询资源
     */
    List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);
}
