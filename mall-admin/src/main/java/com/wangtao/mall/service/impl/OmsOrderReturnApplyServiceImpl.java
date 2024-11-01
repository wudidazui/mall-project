package com.wangtao.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.wangtao.mall.dao.OmsOrderReturnApplyDao;
import com.wangtao.mall.dto.OmsOrderReturnApplyResult;
import com.wangtao.mall.dto.OmsReturnApplyQueryParam;
import com.wangtao.mall.dto.OmsUpdateStatusParam;
import com.wangtao.mall.mapper.OmsOrderReturnApplyMapper;
import com.wangtao.mall.model.OmsOrderReturnApply;
import com.wangtao.mall.model.OmsOrderReturnApplyExample;
import com.wangtao.mall.service.OmsOrderReturnApplyService;
import com.wangtao.mall.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService {

    @Autowired
    private OmsOrderReturnApplyDao orderReturnApplyDao;

    @Autowired
    private OmsOrderReturnApplyMapper orderReturnApplyMapper;

    @Override
    public List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return orderReturnApplyDao.getList(queryParam);
    }

    @Override
    public int delete(List<Long> ids) {
        OmsOrderReturnApplyExample example = new OmsOrderReturnApplyExample();
        example.createCriteria().andIdIn(ids).andStatusEqualTo(3);
        return orderReturnApplyMapper.deleteByExample(example);
    }

    @Override
    public OmsOrderReturnApplyResult getItem(Long id) {
        return orderReturnApplyDao.getDetail(id);
    }

    @Override
    public int updateStatus(Long id, OmsUpdateStatusParam statusParam) {
        Integer status = statusParam.getStatus();
        OmsOrderReturnApply returnApply = new OmsOrderReturnApply();
        if(status.equals(1)){
            //确认退货
            returnApply.setId(id);
            returnApply.setStatus(1);
            returnApply.setReturnAmount(statusParam.getReturnAmount());
            returnApply.setCompanyAddressId(statusParam.getCompanyAddressId());
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else if(status.equals(2)){
            //完成退货
            returnApply.setId(id);
            returnApply.setStatus(2);
            returnApply.setReceiveTime(new Date());
            returnApply.setReceiveMan(statusParam.getReceiveMan());
            returnApply.setReceiveNote(statusParam.getReceiveNote());
        }else if(status.equals(3)){
            //拒绝退款
            returnApply.setId(id);
            returnApply.setStatus(3);
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else {
            return 0;
        }
        return orderReturnApplyMapper.updateByPrimaryKeySelective(returnApply);
    }
}
