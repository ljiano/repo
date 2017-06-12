package com.ljo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljo.dao.IUserDao;
import com.ljo.dto.User;
import com.ljo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by jb.liang on 2017/3/29.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User getuserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }

    public List findAllUsers() {
        return userDao.findAllUsers();
    }

    public void saveUser(User user) {
        userDao.insert(user);
    }

    public PageInfo<User> findUsersByParam(Map param, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<User> list = userDao.findUsers(param);
        //用PageInfo对结果进行包装
        PageInfo<User> page = new PageInfo<User>(list);

//        测试PageInfo全部属性
//        System.out.println(page.getPageNum());
//        System.out.println(page.getPageSize());
//        System.out.println(page.getStartRow());
//        System.out.println(page.getEndRow());
//        System.out.println(page.getTotal());
//        System.out.println(page.getPages());
//        System.out.println(page.getFirstPage());
//        System.out.println(page.getLastPage());
//        System.out.println(page.isHasPreviousPage());
//        System.out.println(page.isHasNextPage());
        return page;
    }

    public PageInfo<Map<String, Object>> findUserCompanys(Integer uId, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Map<String, Object>> list = userDao.findUserCompanys(uId);
        //用PageInfo对结果进行包装
        PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
        return page;
    }
}
