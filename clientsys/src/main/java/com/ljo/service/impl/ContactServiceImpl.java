package com.ljo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljo.dao.IContactDao;
import com.ljo.dto.Contact;
import com.ljo.service.IContactService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by jb.liang on 2017/6/22.
 */
@Service
public class ContactServiceImpl implements IContactService{

    @Resource
    private IContactDao contactDao;

    public void saveContact(Contact contact) {
        contactDao.insertSelective(contact);
    }

    public PageInfo<Contact> findContactByCompanyId(Integer companyId, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        //List<Contact> list = contactDao.findContactByCompanyId(companyId);
        //用PageInfo对结果进行包装
        PageInfo<Contact> page = new PageInfo<Contact>(null);
        return page;
    }

    public void editContact(Contact contact) {
        this.contactDao.updateByPrimaryKeySelective(contact);
    }

    public void removeContact(Integer contactId) {
        contactDao.deleteByPrimaryKey(contactId);
    }

    public Contact findContactById(int id) {
        return contactDao.selectByPrimaryKey(id);
    }

    public List<Map> findContactByComId(int compId) {
        return contactDao.findContactByCompanyId(compId);
    }
}
