package com.miaosha.service.impl;

import com.miaosha.dao.PromoDoMapper;
import com.miaosha.dataobject.PromoDo;
import com.miaosha.service.PromoService;
import com.miaosha.service.model.PromoModel;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PromoServiceImpl implements PromoService {
    @Autowired
    private PromoDoMapper promoDoMapper;
    @Override
    public PromoModel getPromoByItemId(Integer itemId) {
        //获取活动信息通过ItemId
        PromoDo promoDo=promoDoMapper.selectByItemId(itemId);
        //do转Model
        PromoModel promoModel=this.convertFromDataObject(promoDo);
        //判断当前时间是否秒杀活动即将开始或正在进行。
        if (promoModel==null){
            return null;
        }
        DateTime now=new DateTime();
        if (promoModel.getStartDate().isAfter(now)){
            promoModel.setStatus(1);
        }else if(promoModel.getEndDate().isBefore(now)){
            promoModel.setStatus(3);
        }else {
            promoModel.setStatus(2);
        }
        return promoModel;
    }
    private PromoModel convertFromDataObject(PromoDo promoDo){
        if (promoDo==null){
            return null;
        }
        PromoModel promoModel=new PromoModel();
        BeanUtils.copyProperties(promoDo,promoModel);
        promoModel.setPromoItemPrice(new BigDecimal(promoDo.getPromoItemPrice()));
        promoModel.setStartDate(new DateTime(promoDo.getStartTime()));
        promoModel.setEndDate(new DateTime(promoDo.getEndTime()));
        return promoModel;
    }
}
