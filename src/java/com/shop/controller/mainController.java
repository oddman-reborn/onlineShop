
package com.shop.controller;

import com.shop.entity.User;
import com.shop.entity.login;
import com.shop.model.userModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class mainController {
    
    @RequestMapping({"/","index"})
    public String index()
    {
        return "index";
    }
    
    @RequestMapping (value="userReg",method=RequestMethod.GET)
    public String userReg()
    {
        return "registration";
    }
    
    @RequestMapping (value="insert_user",method=RequestMethod.POST)
    public String insertUser(@ModelAttribute(value="User") User u)
    {
        
        userModel model=new userModel();
        String email=u.getEmail();
        System.out.println("\n");
        System.out.println(email);
        boolean reg= model.checkEmail(email);
        
        if(reg==true)
        {
            model.insertUser(u);
            return "index";
        }
        else
            return "error_email";
        
    }
    
    @RequestMapping(value="")
    public String login(@ModelAttribute(value="login") login info)
    {
        
        return "";
    }
}
