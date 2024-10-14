package com.wangtao.mall.service;

import com.wangtao.mall.model.UmsMenu;
import com.wangtao.mall.model.UmsResource;
import com.wangtao.mall.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UmsRoleService {

    /**
     * 根据管理员ID获取对应菜单
     */
    List<UmsMenu> getMenuList(Long adminId);
    /**
     * 添加角色
     */
    int create(UmsRole role);
    /**
     * 修改角色信息
     */
    int update(Long id, UmsRole role);

    /**
     * 批量删除角色
     */
    int delete(List<Long> ids);

    /**
     * 获取所有角色列表
     */
    List<UmsRole> listAll();

    /**
     * 分页获取角色列表
     */
    List<UmsRole> list(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 根据管理员ID获取对应菜单
     */
    List<UmsMenu> listMenu(Long roleId);

    /**
     * 根据管理员ID获取对应菜单
     */
    List<UmsResource> listResource(Long roleId);

    /**
     * 根据管理员ID获取对应菜单
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);
}
