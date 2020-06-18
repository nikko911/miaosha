package com.miaosha.service.impl;

import com.miaosha.dao.ItemColorMapper;
import com.miaosha.dao.ItemDoMapper;
import com.miaosha.dao.ItemStockDoMapper;
import com.miaosha.dataobject.ItemDo;
import com.miaosha.dataobject.ItemStockDo;
import com.miaosha.dataobject.ItemColor;
import com.miaosha.error.BusinessException;
import com.miaosha.error.EmBusinessError;
import com.miaosha.service.ItemService;
import com.miaosha.service.PromoService;
import com.miaosha.service.model.ItemModel;
import com.miaosha.service.model.PromoModel;
import com.miaosha.validator.ValidationResult;
import com.miaosha.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ValidatorImpl validator;
    @Autowired
    private ItemDoMapper itemDoMapper;
    @Autowired
    private ItemStockDoMapper itemStockDoMapper;
    @Autowired
    private PromoService promoService;
    @Autowired
    private ItemColorMapper itemColorMapper;
    @Override
    @Transactional
    public ItemModel createItem(ItemModel itemModel) throws BusinessException {
        //校验入参
       ValidationResult result= validator.validate(itemModel);
       if (result.isHasErrors()){
           throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,result.getErrorMsg());
       }
        //转换数ItemModel-->ItemDo
       ItemDo itemDo= this.convertFromItemModel(itemModel);
        //写入数据库
       itemDoMapper.insertSelective(itemDo);
       //写入新增后的商品Id以备更新库存中的商品ID
       itemModel.setId(itemDo.getId());

       ItemStockDo itemStockDo=new ItemStockDo();
       itemStockDo=this.convertStockFromItemModel(itemModel);
        //写入数据库
       itemStockDoMapper.insertSelective(itemStockDo);
       System.out.println("Stock----->"+itemStockDo.getId());

      itemModel=this.getItemById(itemDo.getId());

        return itemModel;
    }
    //获取商品列表
    @Override
    public List<ItemModel> listItem() {
    List<ItemDo> itemDoList=itemDoMapper.listItem();
    List<ItemModel>ItemModelList=itemDoList.stream().map(itemDo -> {
        ItemStockDo itemStockDo=itemStockDoMapper.selectByItemId(itemDo.getId());
        ItemModel itemModel=convertFromItemDoItemStockDo(itemDo,itemStockDo);
        return itemModel;
    }).collect(Collectors.toList());
        return ItemModelList;
    }

    @Override
    public ItemModel getItemById(Integer id) {
        ItemDo itemDo=itemDoMapper.selectByPrimaryKey(id);
        if (itemDo==null){
            return null;
        }
        ItemStockDo itemStockDo=itemStockDoMapper.selectByItemId(itemDo.getId());

        ItemModel itemModel=convertFromItemDoItemStockDo(itemDo,itemStockDo);

        //获取颜色列表
        List<ItemColor> itemColors=itemColorMapper.selectByItemId(itemDo.getId());
        List<String> colors=new ArrayList<>();

        if (itemColors!=null){
            for (ItemColor cc:itemColors){
                colors.add(cc.getColor());

            }
            itemModel.setItemColors(colors);
        }

        //获取活动商品信息
        PromoModel promoModel=promoService.getPromoByItemId(itemModel.getId());
        if (promoModel!=null && promoModel.getStatus()!=3){
            itemModel.setPromoModel(promoModel);
        }
        return itemModel;
    }

    //库存扣减
    @Override
    @Transactional
    public Boolean decreaseStock(Integer itemId, Integer amount) throws BusinessException {
        int affectRow=itemStockDoMapper.decreaseStock(itemId,amount);
        if (affectRow>0){
            //更新库存成功
            return true;
        }else {
            //更新库存失败
            return false;
        }

    }

    private ItemDo convertFromItemModel(ItemModel itemModel){
        if (itemModel==null){
            return null;
        }
        ItemDo itemDo=new ItemDo();
       // BeanUtils.copyProperties(itemModel,itemDo);
        itemDo.setTitle(itemModel.getTitle());
        itemDo.setDecription(itemModel.getDecription());
        itemDo.setImgurl(itemModel.getImgurl());
        itemDo.setPrice(itemModel.getPrice().doubleValue());
        return itemDo;
    }

    private ItemStockDo convertStockFromItemModel(ItemModel itemModel){
        if (itemModel==null){
            return null;
        }
        ItemStockDo itemStockDo=new ItemStockDo();
        itemStockDo.setItemId(itemModel.getId());
        itemStockDo.setStock(itemModel.getStock());
        return itemStockDo;
    }

    private ItemModel convertFromItemDoItemStockDo(ItemDo itemDo,ItemStockDo itemStockDo){
        if (itemDo==null || itemStockDo==null){
            return null;
        }
        ItemModel itemModel=new ItemModel();
        BeanUtils.copyProperties(itemDo,itemModel);
        itemModel.setPrice(new BigDecimal(itemDo.getPrice()));
        itemModel.setStock(itemStockDo.getStock());
        return itemModel;
    }

}
