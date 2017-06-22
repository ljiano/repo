package com.ljo.service;

import com.github.pagehelper.PageInfo;
import com.ljo.dto.Contact;

import java.util.List;
import java.util.Map;

/**
 * Created by jb.liang on 2017/6/22.
 */
public interface IContactService {
    /**
     * 新增
     * @param contact
     */
    public void saveContact(Contact contact);

    /**
     * 获取
     * @param companyId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Contact> findContactByCompanyId(Integer companyId, Integer pageNo, Integer pageSize);

    /**
     * 编辑
     * @param contact
     */
    public void editContact(Contact contact);

    /**
     * 删除
     * @param contactId
     */
    public void removeContact(Integer contactId);

    public Contact findContactById(int id);

    public List<Map> findContactByComId(int compId);
}
