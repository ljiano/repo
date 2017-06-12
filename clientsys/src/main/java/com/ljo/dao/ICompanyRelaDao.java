package com.ljo.dao;

import com.ljo.dto.CompanyRela;

public interface ICompanyRelaDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyRela record);

    int insertSelective(CompanyRela record);

    CompanyRela selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyRela record);

    int updateByPrimaryKey(CompanyRela record);
}