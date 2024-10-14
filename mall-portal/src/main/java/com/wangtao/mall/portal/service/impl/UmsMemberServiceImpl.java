package com.wangtao.mall.portal.service.impl;

import com.wangtao.mall.model.UmsMember;
import com.wangtao.mall.portal.service.UmsMemberCacheService;
import com.wangtao.mall.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private UmsMemberCacheService memberCacheService;

    @Override
    public UmsMember getByUsername(String username) {
        UmsMember member = memberCacheService.getMember(username);
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        getByUsername(username);
        return null;
    }
}
