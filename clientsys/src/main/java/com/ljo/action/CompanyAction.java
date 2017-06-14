package com.ljo.action;

import com.github.pagehelper.PageInfo;
import com.ljo.dto.Company;
import com.ljo.dto.User;
import com.ljo.service.ICompanyService;
import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jb.liang on 2017/4/10.
 */
@Controller
@RequestMapping("/company")
public class CompanyAction {

    public static Log LOGGER = LogFactory.getLog(CompanyAction.class);

    @Resource
    public ICompanyService companyService;

    @ResponseBody
    @RequestMapping("/savecompany")
    public String saveCompany(Company company) {
        try {
            companyService.saveCompany(company);
            return "ok";
        } catch (Exception e){
            LOGGER.error("保存企业失败！", e);
            return "err";
        }
    }

    @RequestMapping("/findcompanys")
    public String findCompanys(Model model, @Param(value = "pageNo") Integer pageNo,
                            @Param(value = "pageSize")Integer pageSize){
        if(pageNo == null) pageNo = 1;
        if(pageSize == null) pageSize = 10;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("companyname", "");
        PageInfo<Company> pageInfo = companyService.findAllCompanysByUm(param, pageNo, pageSize);
        if(pageInfo != null){
            //List<User> list = pageInfo.getList();
            model.addAttribute("page", pageInfo);
            model.addAttribute("pageNo", pageNo);
            model.addAttribute("pageSize", pageSize);
        }

        return "company/listcompany";
    }

    @ResponseBody
    @RequestMapping("/findcompanystr")
    public String findCompanyOfJSON(@Param("companyname") String companyname, @Param(value = "pageNo") Integer pageNo,
                                 @Param(value = "pageSize")Integer pageSize){
        if(pageNo == null) pageNo = 1;
        if(pageSize == null) pageSize = 10;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("companyname", "%" + companyname + "%");
        PageInfo<Company> pageInfo = companyService.findAllCompanysByUm(param, pageNo, pageSize);
        if(pageInfo != null){
            return JSONObject.fromObject(pageInfo).toString();
        }
        return "";
    }

    @ResponseBody
    @RequestMapping("/comps")
    public List<Company> findCompanys2(@Param("compinput") String compinput) {
        if(StringUtils.isNotBlank(compinput)){
            List<Company> list = this.companyService.findCompanysByComp("%" + compinput + "%");
            if(CollectionUtils.isNotEmpty(list)){
                return list;
            }
        }
        return new ArrayList<Company>();
    }

    @ResponseBody
    @RequestMapping("/comp")
    public Company findCompany2(@Param("comp") String comp) {
        return null;
    }
}
