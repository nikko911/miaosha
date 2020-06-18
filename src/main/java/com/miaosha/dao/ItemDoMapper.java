package com.miaosha.dao;

import com.miaosha.dataobject.ItemDo;

import java.util.List;

public interface ItemDoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ItemDo record);

    int insertSelective(ItemDo record);

    ItemDo selectByPrimaryKey(Integer id);

    List<ItemDo> listItem();

    int updateByPrimaryKeySelective(ItemDo record);

    int updateByPrimaryKey(ItemDo record);
}