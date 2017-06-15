package com.ljo.action;

import com.github.pagehelper.PageInfo;
import com.ljo.dto.Product;
import com.ljo.service.IProductService;
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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/14.
 */
@Controller
@RequestMapping("/product")
public class ProductAction {

    public static Log LOGGER = LogFactory.getLog(ProductAction.class);

    @Resource
    public IProductService productService;

    @ResponseBody
    @RequestMapping("/saveproduct")
    public String saveProduct(Product product) {
        try {
            productService.saveProduct(product);
            return "ok";
        } catch (Exception e){
            LOGGER.error("保存产品失败！", e);
            return "err";
        }
    }

    @RequestMapping("/findproducts")
    public String findProducts(Model model, @Param(value = "pageNo") Integer pageNo,
                               @Param(value = "pageSize")Integer pageSize){
        if(pageNo == null) pageNo = 1;
        if(pageSize == null) pageSize = 10;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name", "");
        PageInfo<Product> pageInfo = productService.findAllProductsByUm(param, pageNo, pageSize);
        if(pageInfo != null){
            //List<User> list = pageInfo.getList();
            model.addAttribute("page", pageInfo);
            model.addAttribute("pageNo", pageNo);
            model.addAttribute("pageSize", pageSize);
        }

        return "product/listproduct";
    }

    @ResponseBody
    @RequestMapping("/findproductstr")
    public String findProductOfJSON(@Param("name") String name, @Param(value = "pageNo") Integer pageNo,
                                    @Param(value = "pageSize")Integer pageSize){
        if(pageNo == null) pageNo = 1;
        if(pageSize == null) pageSize = 10;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name", "%" + name + "%");
        PageInfo<Product> pageInfo = productService.findAllProductsByUm(param, pageNo, pageSize);
        if(pageInfo != null){
            return JSONObject.fromObject(pageInfo).toString();
        }
        return "";
    }

    @ResponseBody
    @RequestMapping("/comps")
    public List<Product> findProducts2(@Param("compinput") String compinput) {
        if(StringUtils.isNotBlank(compinput)){
            try {
                compinput = new String(compinput.getBytes("ISO-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                LOGGER.error("转码失败！", e);
            }
            List<Product> list = this.productService.findProductsByPm("%" + compinput + "%");
            if(CollectionUtils.isNotEmpty(list)){
                return list;
            }
        }
        return new ArrayList<Product>();
    }

    @ResponseBody
    @RequestMapping("/comp")
    public Product findProduct2(@Param("comp") String comp) {
        return null;
    }
}
