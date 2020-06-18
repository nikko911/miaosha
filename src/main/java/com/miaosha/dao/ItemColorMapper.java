package com.miaosha.dao;

import com.miaosha.dataobject.ItemColor;

import java.util.List;

public interface ItemColorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemColor record);

    int insertSelective(ItemColor record);

    ItemColor selectByPrimaryKey(Integer id);

    List<ItemColor> selectByItemId(Integer itemId);

    int updateByPrimaryKeySelective(ItemColor record);

    int updateByPrimaryKey(ItemColor record);
}