package com.wangtao.mall.service;

import com.wangtao.mall.dto.OmsOrderReturnApplyResult;
import com.wangtao.mall.dto.OmsReturnApplyQueryParam;
import com.wangtao.mall.dto.OmsUpdateStatusParam;
import com.wangtao.mall.model.OmsOrderReturnApply;

import java.util.List;

public interface OmsOrderReturnApplyService {
    /**
     * 分页查询申请
     */
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageNum, Integer pageSize);

    /**
     * 批量删除申请
     */
    int delete(List<Long> ids);

    /**
     * 获取指定申请详情
     */
    OmsOrderReturnApplyResult getItem(Long id);

    /**
     * 修改指定申请状态
     */
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);
}
