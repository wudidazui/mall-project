package com.wangtao.mall.portal.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.wangtao.mall.mapper.OmsCartItemMapper;
import com.wangtao.mall.model.OmsCartItem;
import com.wangtao.mall.model.OmsCartItemExample;
import com.wangtao.mall.model.UmsMember;
import com.wangtao.mall.portal.dao.PortalProductDao;
import com.wangtao.mall.portal.domin.CartProduct;
import com.wangtao.mall.portal.domin.CartPromotionItem;
import com.wangtao.mall.portal.service.OmsCartItemService;
import com.wangtao.mall.portal.service.OmsPromotionService;
import com.wangtao.mall.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OmsCartItemServiceImpl implements OmsCartItemService {

    @Autowired
    private UmsMemberService memberService;

    @Autowired
    private OmsCartItemMapper cartItemMapper;

    @Autowired
    private OmsPromotionService promotionService;

    @Autowired
    private PortalProductDao productDao;

    @Override
    public int add(OmsCartItem cartItem) {
        int count;
        UmsMember currentMember = memberService.getCurrentMember();
        cartItem.setMemberId(currentMember.getId());
        cartItem.setMemberNickname(currentMember.getNickname());
        cartItem.setDeleteStatus(0);
        OmsCartItem existCardItem = getCartItem(cartItem);
        if(existCardItem == null){
            cartItem.setCreateDate(new Date());
            count = cartItemMapper.insert(cartItem);
        }else{
            cartItem.setModifyDate(new Date());
            existCardItem.setQuantity(existCardItem.getQuantity() + cartItem.getQuantity());
            count = cartItemMapper.updateByPrimaryKeySelective(existCardItem);
        }
        return count;
    }

    @Override
    public List<OmsCartItem> list(Long id) {
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andMemberIdEqualTo(id);
        return cartItemMapper.selectByExample(example);
    }

    @Override
    public List<CartPromotionItem> listPromotion(Long memberId, List<Long> cartIds) {
        List<OmsCartItem> cartItemList = list(memberId);

        if(CollUtil.isNotEmpty(cartIds)){
            cartItemList = cartItemList.stream().filter(item -> cartIds.contains(item.getId())).collect(Collectors.toList());
        }

        List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();

        if(!CollectionUtils.isEmpty(cartItemList)){
            cartPromotionItemList = promotionService.calcCartPromotion(cartItemList);
        }
        return cartPromotionItemList;
    }

    @Override
    public int updateQuantity(Long id, Long memberId, Integer quantity) {
        OmsCartItem cartItem = new OmsCartItem();
        cartItem.setQuantity(quantity);
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andDeleteStatusEqualTo(0)
                .andIdEqualTo(id).andMemberIdEqualTo(memberId);
        return cartItemMapper.updateByExampleSelective(cartItem, example);
    }

    @Override
    public CartProduct getCartProduct(Long productId) {
        return productDao.getCartProduct(productId);
    }

    @Override
    public int updateAttr(OmsCartItem cartItem) {
        //删除原有的购物车信息
        OmsCartItem updateCart = new OmsCartItem();
        updateCart.setId(cartItem.getId());
        updateCart.setModifyDate(new Date());
        updateCart.setDeleteStatus(1);
        cartItemMapper.updateByPrimaryKeySelective(updateCart);
        cartItem.setId(null);
        add(cartItem);
        return 1;
    }

    @Override
    public int delete(Long memberId, List<Long> ids) {
        OmsCartItem record = new OmsCartItem();
        record.setDeleteStatus(1);
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andIdIn(ids).andMemberIdEqualTo(memberId);
        return cartItemMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int clear(Long memberId) {
        OmsCartItem record = new OmsCartItem();
        record.setDeleteStatus(1);
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        return cartItemMapper.updateByExampleSelective(record,example);
    }

    /**
     * 根据会员id,商品id和规格 获取购物车中商品
     */
    private OmsCartItem getCartItem(OmsCartItem cartItem) {
        OmsCartItemExample examle = new OmsCartItemExample();
        OmsCartItemExample.Criteria criteria = examle.createCriteria().andMemberIdEqualTo(cartItem.getMemberId())
                    .andProductIdEqualTo(cartItem.getProductId()).andDeleteStatusEqualTo(0);
        if(cartItem.getProductSkuId() != null){
            criteria.andProductSkuIdEqualTo(cartItem.getProductSkuId());
        }

        List<OmsCartItem> cardItemList = cartItemMapper.selectByExample(examle);
        if(!CollectionUtils.isEmpty(cardItemList)){
            return cardItemList.get(0);
        }
        return null;
    }



}
