
package com.shop.controller;

import com.shop.entity.Product;
import com.shop.model.adminModel;
import javax.activation.MimetypesFileTypeMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@SessionAttributes("session")
@Controller
public class adminController {
    
    @RequestMapping(value="admin_uploadProduct",method=RequestMethod.GET)
    public String viewUpload()
    {
        return "admin_uploadProduct";
    }
    
    @RequestMapping(value="admin_uploadProduct",method=RequestMethod.POST)
    public String uploadProduct(@RequestParam CommonsMultipartFile file,@ModelAttribute ("Product") Product prod)
    {
        adminModel model=new adminModel();
        
        String fileName=file.getOriginalFilename();
        
        String mimetype= new MimetypesFileTypeMap().getContentType(fileName);
        String type = mimetype.split("/")[0];
        if(type.equals("image"))
            System.out.println("It is an Image");
        else
            return "admin_imageError";
        return "admin_uploadProduct";
    }
}
