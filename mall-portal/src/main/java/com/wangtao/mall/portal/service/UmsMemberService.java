package com.wangtao.mall.portal.service;

import com.wangtao.mall.model.UmsMember;
import org.springframework.security.core.userdetails.UserDetails;

public interface UmsMemberService {
    /**
     * 根据用户名获取会员
     */
    UmsMember getByUsername(String username);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);
}
