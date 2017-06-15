package com.ljo.service;

import com.github.pagehelper.PageInfo;
import com.ljo.dto.Access;

import java.util.Map;

/**
 * Created by jb.liang on 2017/6/15.
 */
public interface IAccessService {

    public void saveAccess(Access access);

    public PageInfo<Map<String, Object>> findAccesses(Map param, Integer pageNo, Integer pageSize);
}
