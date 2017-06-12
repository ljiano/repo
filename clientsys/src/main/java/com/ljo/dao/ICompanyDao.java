package com.ljo.dao;

import com.ljo.dto.Company;

import java.util.List;
import java.util.Map;

public interface ICompanyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<Company> findCompanys(Map<String, Object> param);
}