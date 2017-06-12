package com.ljo.dao;

import com.ljo.dto.Attachment;

public interface IAttachmentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    Attachment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKeyWithBLOBs(Attachment record);

    int updateByPrimaryKey(Attachment record);
}