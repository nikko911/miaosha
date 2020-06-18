package com.miaosha.dao;

import com.miaosha.dataobject.UserDo;

public interface UserDoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserDo record);

    int insertSelective(UserDo record);

    UserDo selectByPrimaryKey(Integer id);

    UserDo selectByTelephone(String telephone);

    int updateByPrimaryKeySelective(UserDo record);

    int updateByPrimaryKey(UserDo record);
}