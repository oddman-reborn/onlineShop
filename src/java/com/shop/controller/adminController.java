
package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@SessionAttributes("session")
@Controller
public class adminController {
    
    @RequestMapping(value="admin_uploadProduct",method=RequestMethod.GET)
    public String viewUpload()
    {
        return "admin_uploadProduct";
    }
    
    @RequestMapping(value="admin_uploadProduct",method=RequestMethod.POST)
    public String uploadProduct()
    {
        
        return "";
    }
}
