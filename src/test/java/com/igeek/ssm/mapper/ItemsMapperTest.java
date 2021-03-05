package com.igeek.ssm.mapper;

import com.igeek.ssm.pojo.Items;
import com.igeek.ssm.pojo.ItemsExample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = "classpath:spring/applicationContext.xml")
class ItemsMapperTest {

    @Autowired
    private ItemsMapper itemsMapper;

    @Test
    void selectByPrimaryKey() {
        Items items = itemsMapper.selectByPrimaryKey(1);
        System.out.println(items.getName()+" : "+items.getDetail());
    }

    @Test
    void countByExample() {
        //需求：查询3000~6000之间的商品数量
        //1.封装条件
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andPriceBetween(3000F,6000F);
        //2.执行查询
        int count = itemsMapper.countByExample(itemsExample);
        System.out.println("count = "+count);
    }

    @Test
    void updateByExampleSelective() {  //Selective 非空
        //1.查询Items对象，并修改部分字段
        Items items = itemsMapper.selectByPrimaryKey(1);
        items.setDetail("今天风和日丽，适宜睡觉....");
        items.setName(null);
        //2.创建条件
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andIdEqualTo(1);
        //3.执行
        itemsMapper.updateByExampleSelective(items,itemsExample);
    }

    @Test
    void updateByExampleWithBLOBs() {  //BLOBs  大文本，MySQL数据类型text
        //1.查询Items对象，并修改部分字段
        Items items = itemsMapper.selectByPrimaryKey(1);
        items.setDetail("今天风和日丽，适宜跑步....");
        //items.setName(null);
        //2.创建条件
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andIdEqualTo(1);
        //3.执行
        itemsMapper.updateByExampleWithBLOBs(items,itemsExample);
    }
}