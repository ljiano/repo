package com.ljo.action;

import com.github.pagehelper.PageInfo;
import com.ljo.dto.Access;
import com.ljo.service.IAccessService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jb.liang on 2017/6/15.
 */
@Controller
@RequestMapping("/access")
public class AccessAction {

    public static Log LOGGER = LogFactory.getLog(AccessAction.class);

    @Resource
    public IAccessService accessService;

    @ResponseBody
    @RequestMapping("/saveaccess")
    public String saveAccsee(HttpServletRequest request) {
        Integer companyid = null;
        Integer userid = 1;
        Date _startDate = null;
        Date _endDate = null;
        SimpleDateFormat sdf = null;
        try{
            companyid = Integer.parseInt(request.getParameter("company_hiddenname"));
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            _startDate = sdf.parse(request.getParameter("startdate"));
            _endDate = sdf.parse(request.getParameter("enddate"));
        } catch (Exception e){
            LOGGER.error("格式转换失败！", e);
        }
        Access access = new Access();
        access.setUserid(userid);
        access.setCompanyid(companyid);
        access.setAccesstime(_startDate);
        access.setEndtime(_endDate);
        accessService.saveAccess(access);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/findaccessstr")
    public String findUserCompanys(HttpServletRequest request, @Param(value = "pageNo") Integer pageNo,
                                   @Param(value = "pageSize")Integer pageSize) {
        if(pageNo == null) pageNo = 1;
        if(pageSize == null) pageSize = 10;
        Map param = new HashMap();
        String username = request.getParameter("username");
        String cid = request.getParameter("cid");
        if(StringUtils.isNotBlank(username)){
            param.put("username", "%"+username+"%");
        }
        if(StringUtils.isNotBlank(cid)){
            param.put("cid", cid);
        }
        PageInfo<Map<String, Object>> pageInfo = this.accessService.findAccesses(param, pageNo, pageSize);
        if(pageInfo != null){
            return JSONObject.fromObject(pageInfo).toString();
        }
        return "";
    }
}
