package com.miaosha.service;

import com.miaosha.error.BusinessException;
import com.miaosha.service.model.UserModel;

public interface UserService {

    //通过用户Id查找用户
    UserModel getUserById(Integer id);

    void register(UserModel userModel) throws BusinessException;
    /*
    telephone为用户注册手机
    password用户加密的密码
    */
    public UserModel validataLogin(String telephone, String encrptPassword) throws BusinessException;
}
