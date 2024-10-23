package com.wangtao.mall.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.wangtao.mall.common.api.CommonPage;
import com.wangtao.mall.mapper.PmsBrandMapper;
import com.wangtao.mall.mapper.PmsProductMapper;
import com.wangtao.mall.model.PmsBrand;
import com.wangtao.mall.model.PmsProduct;
import com.wangtao.mall.model.PmsProductExample;
import com.wangtao.mall.portal.dao.HomeDao;
import com.wangtao.mall.portal.service.PmsPortalBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PmsPortalBrandServiceImpl implements PmsPortalBrandService {

    @Autowired
    private HomeDao homeDao;

    @Autowired
    private PmsBrandMapper brandMapper;

    @Autowired
    private PmsProductMapper productMapper;


    @Override
    public List<PmsBrand> recommendList(Integer pageNum, Integer pageSize) {
        int offset = (pageNum - 1) * pageSize;
        System.out.println(homeDao);

        List<PmsBrand> recommendBrandList1 = homeDao.getRecommendBrandList(offset, pageSize);
        return recommendBrandList1;
    }

    @Override
    public PmsBrand detail(Long brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andDeleteStatusEqualTo(0)
                .andPublishStatusEqualTo(1)
                .andBrandIdEqualTo(brandId);
        List<PmsProduct> productList = productMapper.selectByExample(example);
        return CommonPage.restPage(productList);
    }


}
