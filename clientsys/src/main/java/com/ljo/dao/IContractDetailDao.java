package com.ljo.dao;

import com.ljo.dto.ContractDetail;

public interface IContractDetailDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ContractDetail record);

    int insertSelective(ContractDetail record);

    ContractDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContractDetail record);

    int updateByPrimaryKey(ContractDetail record);
}