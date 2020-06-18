package com.miaosha.dao;

import com.miaosha.dataobject.UserPasswordDo;

public interface UserPasswordDoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPasswordDo record);

    int insertSelective(UserPasswordDo record);

    UserPasswordDo selectByPrimaryKey(Integer id);

    UserPasswordDo selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(UserPasswordDo record);

    int updateByPrimaryKey(UserPasswordDo record);
}