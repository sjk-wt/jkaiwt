package com.eliteams.quick4j.web.controller.administrate.kehu;

import com.eliteams.quick4j.core.feature.orm.mybatis.Page;
import com.eliteams.quick4j.core.util.StringUtil;
import com.eliteams.quick4j.core.util.responsebeans.ResultJson;
import com.eliteams.quick4j.web.model.administrate.Customer;
import com.eliteams.quick4j.web.model.administrate.CustomerExample;
import com.eliteams.quick4j.web.service.administrate.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hccl on 2017/10/31.
 */
@Controller
@RequestMapping("customer")
public class KehuController {

    Logger logger = Logger.getLogger(KehuController.class);

    @Resource
    private CustomerService customerService;

    @RequestMapping("/kehuxinxi")
    public String kehuxinxi() {
        return "adminstrateHtml/kehuxinxi";
    }

    @ResponseBody
    @RequestMapping(value = "customerSearch", method = RequestMethod.GET)
    public Map<String, Object> getCustomerList(
            HttpServletRequest request,
            @RequestParam(value = "pagenum", defaultValue = "1") final int pageNum,
            @RequestParam(value = "pagesize", defaultValue = "20") final int pageSize
    ) {

        String cusname = request.getParameter("cusname");

        Page<Customer> page = new Page<>(pageNum + 1, pageSize);
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        example.createCriteria().andIdIsNotNull();

        if (StringUtil.isNotEmpty(cusname)) {
            criteria.andNameEqualTo("%" + cusname + "%");
        }
        example.setOrderByClause("instertime desc");

        List<Customer> cusinfos = customerService.selectByExample(page, example);
        Map<String, Object> engMap = new HashMap<>();
        engMap.put("page", page);
        engMap.put("content", cusinfos);
        return engMap;
    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    private ResultJson deleteLan(
            @RequestParam(value = "id") final String idstr
    ) {
        logger.info("【语种信息删除方法】语种【ids = " + idstr + "】");

        String[] ids = idstr.split(",");
        for (String id : ids) {
            customerService.deleteByPrimaryKey(id);
        }
        logger.info("【语种信息删除方法】共删除类【" + ids.length + "】条数据");
        return ResultJson.success();
    }
}
