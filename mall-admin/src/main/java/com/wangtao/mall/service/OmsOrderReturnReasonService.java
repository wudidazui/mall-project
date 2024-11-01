package com.wangtao.mall.service;

import com.wangtao.mall.model.OmsOrderReturnReason;

import java.util.List;

/**
 * 退货原因管理Service
 */
public interface OmsOrderReturnReasonService {
    /**
     * 添加退货原因
     */
    int create(OmsOrderReturnReason returnReason);
    /**
     * 修改退货原因
     */
    int update(Long id, OmsOrderReturnReason returnReason);

    /**
     * 批量删除退货原因
     */
    int delete(List<Long> ids);

    /**
     * 分页获取退货原因
     */
    List<OmsOrderReturnReason> list(Integer pageNum, Integer pageSize);

    /**
     * 获取单个退货原因详情信息
     */
    OmsOrderReturnReason getItem(Long id);

    /**
     * 批量修改退货原因状态
     */
    int updateStatus(List<Long> ids, Integer status);
}
