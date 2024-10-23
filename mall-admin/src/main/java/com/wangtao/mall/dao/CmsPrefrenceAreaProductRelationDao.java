package com.wangtao.mall.dao;

import com.wangtao.mall.model.CmsPrefrenceAreaProductRelation;
import com.wangtao.mall.model.CmsPrefrenceAreaProductRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优选和商品关系自定义Dao
 */
public interface CmsPrefrenceAreaProductRelationDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);
}
