
package com.shop.controller;

import com.shop.entity.User;
import com.shop.entity.login;
import com.shop.model.adminModel;
import com.shop.model.userModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@SessionAttributes("session")
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
    
    @RequestMapping(value="login")
    public String login(@ModelAttribute(value="login") login info)
    {
        boolean user_login=false;
        
        String email=info.getEmail();
        String password=info.getPassword();
        
        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(email);
        
        if(matcher.find())
        {
            userModel model=new userModel();
            user_login=model.userLogin(info);
            System.out.println(user_login);
            if(user_login==true)
                return "u_dash";
            else
                return "noMatch";
        }
        else
        {
            adminModel model=new adminModel();
            user_login=model.Login(info);
            
            if (user_login == true)
                return "admin_dash";
            else 
                return "noMatch";
                    
        }
        
        
    }
}
