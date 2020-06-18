package com.miaosha.service;

import com.miaosha.error.BusinessException;
import com.miaosha.service.model.ItemModel;

import java.util.List;

public interface ItemService {

    //创建商品
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    //商品列表
    List<ItemModel> listItem();

    //商品详情（通过id查找商品）
    ItemModel getItemById(Integer id);
//
    //库存扣减
    Boolean decreaseStock(Integer itemId,Integer amount)throws BusinessException;


}
