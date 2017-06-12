package com.ljo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.ljo.dto.User;

import java.util.List;
import java.util.Map;

/**
 * Created by jb.liang on 2017/3/29.
 */
public interface IUserService {

    public User getuserById(int userId);

    public List findAllUsers();

    public void saveUser(User user);

    /**
     *
     * @param param
     * @param pageNo     第几页
     * @param pageSize   每页数量
     * @return
     */
    public PageInfo<User> findUsersByParam(Map param, Integer pageNo, Integer pageSize);

    public PageInfo<Map<String, Object>> findUserCompanys(Integer uId, Integer pageNo, Integer pageSize);

}
