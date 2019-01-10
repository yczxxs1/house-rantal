package com.netflix.houserental.business.dao;

import com.netflix.houserental.business.condition.Condition;
import com.netflix.houserental.business.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    User selectByUsernameAndPass(Condition condition);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}