package com.ljo.action;

import com.github.pagehelper.PageInfo;
import com.ljo.dto.Company;
import com.ljo.dto.Contact;
import com.ljo.service.ICompanyService;
import com.ljo.service.IContactService;
import com.ljo.util.NumberUtil;
import com.ljo.util.StringUtil;
import net.sf.json.JSONArray;
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
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by jb.liang on 2017/4/10.
 */
@Controller
@RequestMapping("/company")
public class CompanyAction {

    public static Log LOGGER = LogFactory.getLog(CompanyAction.class);

    @Resource
    public ICompanyService companyService;
    @Resource
    public IContactService contactService;

    @ResponseBody
    @RequestMapping("/savecompany")
    public String saveCompany(HttpServletRequest request) {
        try {
            int companyId = NumberUtil.safeToInteger(request.getParameter("id"), 0);
            String companyname = StringUtil.safeToString(request.getParameter("companyname"), null);
            String companycode = StringUtil.safeToString(request.getParameter("companycode"), null);
            String companytype = StringUtil.safeToString(request.getParameter("companytype"), null);
            String industryname = StringUtil.safeToString(request.getParameter("industryname"), null);
            String area = StringUtil.safeToString(request.getParameter("area"), null);
            String gm = StringUtil.safeToString(request.getParameter("gm"), null);
            String legal = StringUtil.safeToString(request.getParameter("legal"), null);
            String f1 = StringUtil.safeToString(request.getParameter("f1"), null);
            String f2 = StringUtil.safeToString(request.getParameter("f2"), null);
            String f3 = StringUtil.safeToString(request.getParameter("f3"), null);
            String f4 = StringUtil.safeToString(request.getParameter("f4"), null);
            String deletecontactids = StringUtil.safeToString(request.getParameter("deletecontactids"), null);
            String contacts = StringUtil.safeToString(request.getParameter("contacts"), null);
            Company company = companyService.findCompanyById(companyId);
            if(company == null){
                company = new Company();
                company.setCratetime(new Date());
            }
            company.setCompanyname(companyname);
            company.setCompanycode(companycode);
            company.setUpdatetime(new Date());
            if(company.getId() != null && company.getId().intValue() > 0){
                companyService.editCompany(company);
            } else {
                companyService.saveCompany(company);
                companyId = company.getId();
            }
            if(StringUtils.isNotBlank(deletecontactids)){
                String[] cIds = deletecontactids.split(",");
                for(int i = 0; i < cIds.length; i++){
                    int cId = NumberUtil.safeToInteger(cIds[i], 0);
                    if(cId > 0) {
                        contactService.removeContact(cId);
                    }
                }
            }
            if(StringUtils.isNotBlank(contacts)){
                JSONArray array = JSONArray.fromObject(contacts);
                if(array != null){
                    for(int i = 0; i < array.size(); i++){
                        Map map = new HashMap(array.getJSONObject(i));
                        int contactId = NumberUtil.safeToInteger(map.get("contactid"), 0);
                        String contactname = StringUtil.safeToString(map.get("contactname"), null);
                        String contactposition = StringUtil.safeToString(map.get("contactposition"), null);
                        String contacttel = StringUtil.safeToString(map.get("contacttel"), null);
                        String contactphone = StringUtil.safeToString(map.get("contactphone"), null);
                        String contactno = StringUtil.safeToString(map.get("contactno"), null);
                        String contactemail = StringUtil.safeToString(map.get("contactemail"), null);
                        Integer iscore = NumberUtil.safeToInteger(map.get("iscore"), null);
                        Contact contact = contactService.findContactById(contactId);
                        if(contact == null){
                            contact = new Contact();
                        }
                        contact.setCompanyid(companyId);
                        contact.setContactname(contactname);
                        contact.setContactposition(contactposition);
                        contact.setContacttel(contacttel);
                        contact.setContactphone(contactphone);
                        contact.setContactno(contactno);
                        contact.setContactemail(contactemail);
                        contact.setIscore(iscore);
                        if(contact.getId() != null && contact.getId().intValue() > 0){
                            contactService.editContact(contact);
                        } else {
                            contactService.saveContact(contact);
                        }
                    }
                }
            }
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
            try {
                compinput = new String(compinput.getBytes("ISO-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                LOGGER.error("转码失败！", e);
            }
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

    @RequestMapping("/loadcompany")
    public String loadCompany(Model model, @Param("cid") Integer cid) {
        Company company = this.companyService.findCompanyById(cid);
        if(company != null){
            model.addAttribute("company", company);
            List<Map> list = contactService.findContactByComId(cid);
            if(CollectionUtils.isNotEmpty(list)){
                for(Map m : list){
                    m.put("contstr", JSONObject.fromObject(m).toString());
                }
            }
            model.addAttribute("contlist", list == null ? new ArrayList<Map>() : list);
            model.addAttribute("contsize", list == null ? 0 : list.size());
        }
        return "company/editcompany";
    }
}
