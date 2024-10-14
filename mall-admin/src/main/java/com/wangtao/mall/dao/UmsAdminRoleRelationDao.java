package com.wangtao.mall.dao;

import com.wangtao.mall.model.UmsAdminRoleRelation;
import com.wangtao.mall.model.UmsResource;
import com.wangtao.mall.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有可访问资源
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有角色
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<UmsAdminRoleRelation> adminRoleRelationList);
}
