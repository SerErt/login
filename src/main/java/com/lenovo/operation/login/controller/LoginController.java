package com.lenovo.operation.login.controller;

import com.lenovo.operation.login.MD5Demo;
import com.lenovo.operation.login.Service.UserService;
import com.lenovo.operation.login.entity.User;
import com.lenovo.operation.login.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;


@Controller
@RequestMapping("/user/*")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/tologin")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        MD5Demo md5code = new MD5Demo();
        String pwd;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        pwd = (String) md5code.md5(password);
        String code = request.getParameter("validcode");
        String validcode = (String) session.getAttribute("imageCode");
        User userEntity = userService.FindNameAndPswd(username, pwd);
        String str = "";
        if(validcode.toLowerCase().equals(code.toLowerCase())) {
              if(userEntity != null) {
                  request.getSession().setAttribute("_session_user",userEntity);
                  str = "index";
              }else {
                  str = "login";

              }
            }else {
            str = "login";
        }
        return str;
        }

    @RequestMapping(value="/createValicode",method=RequestMethod.GET)
    public void validcode(HttpServletResponse response,HttpSession session) throws Exception{
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = VerifyUtil.createImage();
        //将验证码存入Session
        session.setAttribute("imageCode",objs[0]);
        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }
}

