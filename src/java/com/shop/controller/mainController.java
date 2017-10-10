package com.shop.controller;

import com.shop.entity.Admin;
import com.shop.entity.User;
import com.shop.entity.login;
import com.shop.model.adminModel;
import com.shop.model.userModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({"session"})

public class mainController {

    @RequestMapping({"/", "index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "userReg", method = RequestMethod.GET)
    public String userReg() {
        return "registration";
    }

    @RequestMapping(value = "insert_user", method = RequestMethod.POST)
    public String insertUser(@ModelAttribute(value = "User") User u) {

        userModel model = new userModel();
        String email = u.getEmail();
        System.out.println("\n");
        System.out.println(email);
        boolean reg = model.checkEmail(email);

        if (reg == true) {
            model.insertUser(u);
            return "index";
        } else {
            return "error_email";
        }

    }
    @RequestMapping(value = "login",method=RequestMethod.GET)
    public String viewIndex()
    {
        return "index";
    }
    @RequestMapping(value = "login",method=RequestMethod.POST)
    public String login(@ModelAttribute(value = "login") login info, HttpServletRequest req) {
        boolean user_login = false;
        HttpSession session;
        String email = info.getEmail();
        String password = info.getPassword();

        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            userModel model = new userModel();
            user_login = model.userLogin(info);
            System.out.println(user_login);
            if (user_login == true) {
                session = req.getSession(false);
                session=req.getSession();
                User user_info=model.getInfo(info);
                String name=user_info.getName();
                System.out.println("User Login");
                session.setAttribute("session", user_info);
                return "index";
            } else {
                return "noMatch";
            }
        } else {
            adminModel model = new adminModel();
            user_login = model.adminLogin(info);

            if (user_login == true) {
                session=req.getSession(false);
                session=req.getSession();
                Admin admin_info=model.getInfo(info);
                String name=admin_info.getName();
                System.out.println("Admin Login");
                session.setAttribute("session", admin_info);
                return "admin_dash";
            } else {
                return "noMatch";
            }

        }

    }
    
    @RequestMapping(value="logout")
    public String logout(HttpServletRequest req)
    {
        return "logout";
    }
    
    
}
