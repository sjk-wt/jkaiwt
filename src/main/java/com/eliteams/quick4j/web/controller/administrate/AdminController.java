package com.eliteams.quick4j.web.controller.administrate;

import com.eliteams.quick4j.web.model.administrate.Admin;
import com.eliteams.quick4j.web.model.administrate.AdminExample;
import com.eliteams.quick4j.web.service.administrate.AdminService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hccl on 2017/10/20.
 */
@Controller
@RequestMapping("/adminstrate")
public class AdminController {

    @Resource
    private AdminService adminService;

    @RequestMapping("/login")
    public String login() {
        return "adminstrateHtml/login";
    }

    @RequestMapping("/zhuye")
    public String zhuye() {
        return "adminstrateHtml/zhuye";
    }

    @RequestMapping("/home")
    public String home() {
        return "adminstrateHtml/home";
    }

    @RequestMapping("/chanpinxinxi")
    public String chanPinXinxi() {
        return "adminstrateHtml/chanpinxinxi";
    }

    @RequestMapping("/chanpinleixing")
    public String chanPinLeiXing() {
        return "adminstrateHtml/chanpinleixing";
    }

    @RequestMapping("/youhuihuodong")
    public String youhuihuodong() {
        return "adminstrateHtml/youhuihuodong";
    }

    @RequestMapping("/xinpinfabu")
    public String xinpinfabu() {
        return "adminstrateHtml/xinpinfabu";
    }

    //登录验证
    @ResponseBody
    @RequestMapping(value = "/toLogin", method = RequestMethod.POST)
    public String toLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Md5Hash hash = new Md5Hash(password,"加盐",2);//散裂2次
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(hash.toString());
        List<Admin> user = adminService.selectByExample(example);
        if (user.isEmpty()) {
            return "login";
        }
        return "home";
    }

    //获取admin名称
    @ResponseBody
    @RequestMapping("getAdminName")
    public String getAdminName() {
        Admin admin = adminService.selectByPrimaryKey("8f52e57f-8ffe-4b72-bd1f-27acfd8e0b45");
        return admin.getName();
    }
}
