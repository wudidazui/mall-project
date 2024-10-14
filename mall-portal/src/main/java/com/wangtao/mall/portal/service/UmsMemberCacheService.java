package com.wangtao.mall.portal.service;

import com.wangtao.mall.model.UmsMember;
import org.springframework.stereotype.Service;

/**
 * 会员信息缓存业务类
 */
public interface UmsMemberCacheService {
    /**
     * 获取会员用户缓存
     */
    UmsMember getMember(String username);
    /**
     * 删除会员用户缓存
     */
    void delMember(Long id);

    /**
    * 设置会员用户缓存
     */
    void setMember(UmsMember member);

    /**
     * 设置验证码
     */

    void setAuthCode(String telephone,String authCode);

    /**
     * 获取验证码
     */
    String getAuthCode(String telephone);
}
