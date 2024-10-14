package com.wangtao.mall.dao;


import com.wangtao.mall.model.UmsMenu;
import com.wangtao.mall.model.UmsResource;

import java.util.List;

/**
 * 后台角色管理自定义Dao
 */
public interface UmsRoleDao {
    List<UmsMenu> getMenuList(Long adminId);
    /**
     * 根据角色ID获取菜单
     */
    List<UmsMenu> getMenuListByRoleId(Long roleId);
    /**
     * 根据角色ID获取资源
     */
    List<UmsResource> getResourceListByRoleId(Long roleId);
}
