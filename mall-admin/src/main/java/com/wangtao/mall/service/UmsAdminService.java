package com.wangtao.mall.service;

import com.wangtao.mall.dto.UmsAdminParam;
import com.wangtao.mall.dto.UpdateAdminPasswordParam;
import com.wangtao.mall.model.UmsAdmin;
import com.wangtao.mall.model.UmsResource;
import com.wangtao.mall.model.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    List<UmsResource> getResourceList(Long adminId);
    /**
     * 根据用户id获取用户
     */
    UmsAdmin getItem(Long id);

    /**
     * 获取缓存服务
     */
    UmsAdminCacheService getCacheService();

    /**
     * 根据用户名或昵称分页查询用户
     */
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);


    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * 刷新token的功能
     * @param oldToken 旧的token
     */
    String refreshToken(String oldToken);

    /**
     * 获取用户对应角色
     */
    List<UmsRole> getRoleList(Long id);

    /**
     * 修改指定用户信息
     */
    int update(Long id, UmsAdmin admin);

    /**
     * 修改密码
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * 获取用户对应角色
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 删除指定用户
     */
    int delete(Long id);
}
