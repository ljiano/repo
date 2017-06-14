package com.ljo.service;

import com.github.pagehelper.PageInfo;
import com.ljo.dto.Company;

import java.util.List;
import java.util.Map;

/**
 * Created by jb.liang on 2017/4/10.
 */
public interface ICompanyService {

    /**
     * 新增
     * @param company
     */
    public void saveCompany(Company company);

    /**
     * 获取
     * @param param
     * @return
     */
    public PageInfo<Company> findAllCompanysByUm(Map param, Integer pageNo, Integer pageSize);

    /**
     * 编辑
     * @param company
     */
    public void editCompany(Company company);

    /**
     * 删除
     * @param company
     */
    public void removeCompany(Company company);

    /**
     * 获取
     * @param companyId
     * @return
     */
    public Company findCompanyById(int companyId);


    public List<Company> findCompanysByComp(String comp);
}
