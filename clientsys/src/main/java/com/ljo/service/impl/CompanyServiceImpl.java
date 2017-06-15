package com.ljo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljo.dao.ICompanyDao;
import com.ljo.dto.Company;
import com.ljo.dto.User;
import com.ljo.service.ICompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by jb.liang on 2017/4/10.
 */
@Service
public class CompanyServiceImpl implements ICompanyService {

    @Resource
    private ICompanyDao companyDao;

    public void saveCompany(Company company) {
        companyDao.insert(company);
    }

    public PageInfo<Company> findAllCompanysByUm(Map param, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Company> list = companyDao.findCompanys(param);
        //用PageInfo对结果进行包装
        PageInfo<Company> page = new PageInfo<Company>(list);
        return page;
    }

    public void editCompany(Company company) {
        this.companyDao.updateByPrimaryKeySelective(company);
    }

    public void removeCompany(Company company) {

    }

    public Company findCompanyById(int companyId) {
        return companyDao.selectByPrimaryKey(companyId);
    }

    public List<Company> findCompanysByComp(String comp) {
        return this.companyDao.findCompanyByCopm(comp);
    }
}
