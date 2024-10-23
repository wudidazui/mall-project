package com.wangtao.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.wangtao.mall.dao.PmsSkuStockDao;
import com.wangtao.mall.mapper.PmsSkuStockMapper;
import com.wangtao.mall.model.PmsSkuStock;
import com.wangtao.mall.model.PmsSkuStockExample;
import com.wangtao.mall.service.PmsSkuStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PmsSkuStockServiceImpl implements PmsSkuStockService {

    @Autowired
    private PmsSkuStockMapper skuStockMapper;

    @Autowired
    private PmsSkuStockDao skuStockDao;

    @Override
    public List<PmsSkuStock> getList(Long pid, String keyword) {
        PmsSkuStockExample example = new PmsSkuStockExample();
        PmsSkuStockExample.Criteria criteria = example.createCriteria().andProductIdEqualTo(pid);
        if(!StrUtil.isEmpty(keyword)){
            criteria.andSkuCodeLike("%" + keyword + "%");
        }
        return skuStockMapper.selectByExample(example);
    }

    @Override
    public int update(Long pid, List<PmsSkuStock> skuStockList) {
        return skuStockDao.replaceList(skuStockList);
    }
}
