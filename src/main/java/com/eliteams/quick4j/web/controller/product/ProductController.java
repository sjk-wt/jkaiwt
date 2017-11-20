package com.eliteams.quick4j.web.controller.product;

import com.eliteams.quick4j.core.entity.JSONResult;
import com.eliteams.quick4j.web.model.product.*;
import com.eliteams.quick4j.web.service.product.ActivitService;
import com.eliteams.quick4j.web.service.product.ProductService;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hccl on 2017/10/10.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    private static Logger logger = Logger.getLogger(ProductController.class);

    @Resource
    private ProductService productService;

    @Resource
    private ActivitService activitService;

    //首页
    @RequestMapping("/index")
    public String index(
            HttpServletRequest request
    ){
        request.setAttribute("activit", getActivitWithBLOBs());
        request.setAttribute("products", getProductWithBLOBs());
        return "product/index";
    }

    //产品列表
    @RequestMapping("/productList")
    public String goProductList(
            HttpServletRequest request
    ) {
        request.setAttribute("activit", getActivitWithBLOBs());
        request.setAttribute("productsName", getProductWithBLOBs());
        return "product/productList";
    }

    //联系方式跳转
    @RequestMapping("/contactMessage")
    public String contactMessage(
            HttpServletRequest request
    ){
        request.setAttribute("activit", getActivitWithBLOBs());
        request.setAttribute("productsName", getProductWithBLOBs());
        return "product/contactMessage";
    }

    //产品详情跳转
    @RequestMapping("/productMessage")
    public String productMessage(
            HttpServletRequest request,
            @RequestParam(value = "id") final String id
    ){
        ProductWithBLOBs product = productService.selectByPrimaryKey(id);
        request.setAttribute("title", product.getName());
        request.setAttribute("pcolor", product.getPcolor());
        request.setAttribute("proCode", product.getCode());
        request.setAttribute("proId", product.getId());
        request.setAttribute("instartTime", product.getInstarttime());
        request.setAttribute("productsName", getProductWithBLOBs());
        request.setAttribute("activit", getActivitWithBLOBs());

        return "product/productMessage";
    }

    //新品发布跳转
    @RequestMapping("/activityMessage")
    public String activityMessage(
            HttpServletRequest request,
            @RequestParam(value = "id") final String id
    ) {
        ActivitWithBLOBs activit = activitService.selectByPrimaryKey(id);
        request.setAttribute("title", activit.getName());
        request.setAttribute("instartTime", activit.getActivitystarttime());
        request.setAttribute("endTime", activit.getActivityendtime());
        request.setAttribute("productsName", getProductWithBLOBs());
        request.setAttribute("actId", activit.getId());
        request.setAttribute("activit", getActivitWithBLOBs());

        return "product/activityMessage";
    }

    //产品详情页面内容请求方法
    @ResponseBody
    @RequestMapping(value = "/getProMessage", method = RequestMethod.GET)
    public JSONResult getProMessage(
            @RequestParam(value = "id") final String id
    ) {
        return JSONResult.success(productService.selectByPrimaryKey(id));
    }

    //所有产品信息(除优源洗护套装)
    @ResponseBody
    @RequestMapping(value = "/getProducts", method = RequestMethod.POST)
    public JSONResult getProducts() {
        return JSONResult.success(getProductWithBLOBs());
    }


    //获取活动详细信息
    @ResponseBody
    @RequestMapping(value = "/getActivityMessage", method = RequestMethod.POST)
    public JSONResult getActivityMessage(
            @RequestParam(value = "id") final String id
    ) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        List<ActivitWithBLOBs> activits = activitService.selectByExampleWithBLOBsByMessage(map);
        return JSONResult.success(activits.get(0));
    }

    //活动时间结束后，将该活动修改为：不发布
    @ResponseBody
    @RequestMapping("/changeActivity")
    public JSONResult changeActivity(
            @RequestParam(value = "id") final String id
    ) {
        ActivitWithBLOBs activity = activitService.selectByPrimaryKey(id);
        activity.setIsactivity(0);
        return JSONResult.success(activitService.updateByPrimaryKeySelective(activity));
    }

    //获取右侧产品信息列表
    public  List<ProductWithBLOBs> getProductWithBLOBs() {
        ProductExample example = new ProductExample();
        example.createCriteria().andCodeNotEqualTo("YYXHTZ");
        example.setOrderByClause("instarttime asc");
        return productService.selectByExampleWithBLOBs(example);
    }

    //获取右侧新品发布/优惠活动列表
    public ActivitWithBLOBs getActivitWithBLOBs() {
        ActivitExample example = new ActivitExample();
        example.createCriteria().andIsactivityEqualTo(1);
        example.setOrderByClause("activitystarttime desc");
        List<ActivitWithBLOBs> activitWithBLOBs = activitService.selectByExampleWithBLOBs(example);
        ActivitWithBLOBs activit = null;
        if (!activitWithBLOBs.isEmpty()) {
            activit = activitWithBLOBs.get(0);
        } else {
            activit = activitService.selectByPrimaryKey("8f52e57f-8ffe-4b72-bd1f-27acfd8e0b47");
        }
        return activit;
    }

}
