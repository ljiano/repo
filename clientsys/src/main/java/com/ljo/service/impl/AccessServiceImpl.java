package com.ljo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljo.dao.IAccessDao;
import com.ljo.dto.Access;
import com.ljo.service.IAccessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by jb.liang on 2017/6/15.
 */
@Service
public class AccessServiceImpl implements IAccessService {

    @Resource
    public IAccessDao accessDao;

    public void saveAccess(Access access) {
        accessDao.insert(access);
    }

    public PageInfo<Map<String, Object>> findAccesses(Map param, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Map<String, Object>> list = accessDao.findAccesses(param);
        //用PageInfo对结果进行包装
        PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
        return page;
    }
}
