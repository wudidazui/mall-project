package com.wangtao.mall.stream;

import com.wangtao.mall.mapper.UmsMenuMapper;
import com.wangtao.mall.model.UmsMenu;
import com.wangtao.mall.model.UmsMenuExample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
public class StreamApiTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamApiTest.class);

    @Autowired
    private UmsMenuMapper menuMapper;
    private List<UmsMenu> menuList;

    @BeforeEach
    void eachInfo(){
        menuList = menuMapper.selectByExample(new UmsMenuExample());
        LOGGER.info("before(),在测试环境前执行");
    }

    @Test
    public void filterTest(){
        List<UmsMenu> collect = menuList.stream().filter(menu -> menu.getParentId() == 0L).collect(Collectors.toList());
        LOGGER.info("filter",collect);
        System.out.println(collect);
    }

    @Test
    public void mapTest(){
        List<Long> idList = menuList.stream().map(menu -> menu.getId()).collect(Collectors.toList());
        LOGGER.info("mapTest",idList);
    }

    @Test
    public void limitTest(){
        List<UmsMenu> firstFiveList = menuList.stream().limit(5).collect(Collectors.toList());
        LOGGER.info("limitTest",firstFiveList);
    }

    @Test
    public void countTest(){
        long count = menuList.stream().filter(menu -> menu.getParentId() == 0L).count();
        LOGGER.info("countTest",count);
    }

    @Test
    public void sortedTest(){
        List<UmsMenu> sortedList = menuList.stream()
                .sorted((menu1,menu2) -> {return menu2.getSort().compareTo(menu1.getSort());}).collect(Collectors.toList());
        LOGGER.info("sortedList",sortedList);
    }

    @Test
    public void skipTest(){
        List<UmsMenu> skipList = menuList.stream()
                .skip(5).collect(Collectors.toList());
        LOGGER.info("skipList",skipList);
    }

    @Test
    public void collect2mapTest(){
        Map<Long,UmsMenu> menuMap = menuList.stream().collect(Collectors.toMap(menu -> menu.getId(), menu -> menu));
        LOGGER.info("skipList",menuMap);
    }

}
