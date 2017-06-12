package com.ljo.dao;

import com.ljo.dto.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findAllUsers();

    List<User> findUsers(Map<String, Object> param);

    public List<Map<String, Object>> findUserCompanys(Integer uId);

}