package com.miaosha.controller;

import com.miaosha.controller.viewobject.ItemVo;
import com.miaosha.error.BusinessException;
import com.miaosha.error.EmBusinessError;
import com.miaosha.response.CommonReturnType;
import com.miaosha.service.ItemService;
import com.miaosha.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller("item")
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ItemController extends BaseController {
    @Autowired
    private ItemService itemService;
    //创建商品
    @RequestMapping(value ="/create", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType createItem(@RequestParam(name = "title")String title,
                                       @RequestParam(name = "price")BigDecimal price,
                                       @RequestParam(name = "stock")Integer stock,
                                       @RequestParam(name = "description")String description,
                                       @RequestParam(name = "imgurl")String imgurl) throws BusinessException {


        ItemModel itemModel = new ItemModel();
        itemModel.setTitle(title);
        itemModel.setPrice(price);
        itemModel.setStock(stock);
        itemModel.setDecription(description);
        itemModel.setImgurl(imgurl);
        ItemModel itemModelReturn = itemService.createItem(itemModel);
        //转换为ItemVo
        ItemVo itemVo = this.convertFromItemModel(itemModelReturn);
        return CommonReturnType.cteate(itemVo);
    }

    //根据Id获取商品信息
    @RequestMapping(value = "/getItemById", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getItemById(@RequestParam(name = "id") Integer id) throws BusinessException {
        ItemModel itemModel = itemService.getItemById(id);
        if (itemModel==null){
            throw new BusinessException(EmBusinessError.ITEM_NOT_EXIST);
        }
        ItemVo itemVo = convertFromItemModel(itemModel);
        return CommonReturnType.cteate(itemVo);
    }

    //获取商品列表
    @RequestMapping(value = "/itemList", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType listItem() {
        List<ItemModel> itemModelList = itemService.listItem();
        //使用stream api将List的itemModel转化为itemVo
        List<ItemVo> itemVoList = itemModelList.stream().map(itemModel -> {
            ItemVo itemVo = this.convertFromItemModel(itemModel);
            return itemVo;
        }).collect(Collectors.toList());
        return CommonReturnType.cteate(itemVoList);
    }


    private ItemVo convertFromItemModel(ItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        ItemVo itemVo = new ItemVo();
        BeanUtils.copyProperties(itemModel, itemVo);

        if (itemModel.getPromoModel()!=null){
            //表示有活动正在进行或即将开始
            itemVo.setPromoStatus(itemModel.getPromoModel().getStatus());
            itemVo.setPromoId(itemModel.getPromoModel().getId());
            itemVo.setStartDate(itemModel.getPromoModel().getStartDate());
            itemVo.setPromoPrice(itemModel.getPromoModel().getPromoItemPrice());
            itemVo.setEndDate(itemModel.getPromoModel().getEndDate());
        }else {
            itemVo.setPromoStatus(0);
        }
        return itemVo;
    }

    private ItemModel converFromItemVo(ItemVo itemVo) {
        if (itemVo == null) {
            return null;
        }
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(itemVo, itemModel);
        return itemModel;
    }

}
