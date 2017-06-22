package com.ljo.dao;

import com.ljo.dto.Contact;

import java.util.List;
import java.util.Map;

public interface IContactDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Contact record);

    int insertSelective(Contact record);

    Contact selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);

    List<Map> findContactByCompanyId(Integer companyid);
}