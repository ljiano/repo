package com.ljo.dao;

import com.ljo.dto.Access;

import java.util.List;
import java.util.Map;

public interface IAccessDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Access record);

    int insertSelective(Access record);

    Access selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Access record);

    int updateByPrimaryKey(Access record);

    List<Map<String, Object>> findAccesses(Map param);
}