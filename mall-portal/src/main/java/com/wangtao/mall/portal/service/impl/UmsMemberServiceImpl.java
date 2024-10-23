package com.wangtao.mall.portal.service.impl;

import com.wangtao.mall.mapper.UmsMemberMapper;
import com.wangtao.mall.model.UmsMember;
import com.wangtao.mall.model.UmsMemberExample;
import com.wangtao.mall.portal.domin.MemberDetails;
import com.wangtao.mall.portal.service.UmsMemberCacheService;
import com.wangtao.mall.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private UmsMemberCacheService memberCacheService;

    @Autowired
    private UmsMemberMapper memberMapper;

    @Override
    public UmsMember getByUsername(String username) {
        UmsMember member = memberCacheService.getMember(username);
        if(member != null) return member;
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(memberList)){
            member = memberList.get(0);
            memberCacheService.setMember(member);
            return member;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UmsMember member = getByUsername(username);
        if(member != null){
            return new MemberDetails(member);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
}
