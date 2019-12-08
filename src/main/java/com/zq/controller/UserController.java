package com.zq.controller;

import com.zq.entity.User;
import com.zq.service.UserService;
import com.zq.util.SecurityCode;
import com.zq.util.SecurityImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @author zhaoqi
 * @version 1.8
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(User user,String security,HttpServletRequest request) throws Exception {
        String security1 = (String) request.getSession().getAttribute("security");
        String message = "";
        if (!security1.equals(security)){
            message = "验证码错误!~";
            return "redirect:/login.jsp?message="+ URLEncoder.encode(message,"utf-8");
        }
        System.out.println(user);
        User user1 = userService.selectByUsername(user);
        if (user1==null || !user1.getPassword().equals(user.getPassword())){
            return "redirect:/login.jsp?message="+URLEncoder.encode(message,"UTF-8");
        }
        return "redirect:/file/selectAll";
    }

    @RequestMapping("security")
    public void security(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        生成验证码随机数
        String secutityCode = SecurityCode.getSecurityCode();
//        绘制生成验证图片
        BufferedImage image = SecurityImage.createImage(secutityCode);
//        响应到客户端
        OutputStream out = response.getOutputStream();
        ImageIO.write(image, "png", out);
//        将验证码加入session域中
        request.getSession().setAttribute("security",secutityCode);
    }
}
