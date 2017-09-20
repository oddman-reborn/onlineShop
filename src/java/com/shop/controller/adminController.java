
package com.shop.controller;

import com.shop.entity.Product;
import com.shop.model.adminModel;
import java.io.File;
import java.util.List;
import javax.activation.MimetypesFileTypeMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String uploadProduct(@RequestParam CommonsMultipartFile file,@ModelAttribute ("Product") Product product)
    {
        
        
        String fileName=file.getOriginalFilename();
        
        String mimetype= new MimetypesFileTypeMap().getContentType(fileName);
        String type = mimetype.split("/")[0];
        if(type.equals("image"))
        {
            String imagePath="E:\\Programming Practice\\JSP\\onlineShop\\web\\resources\\product_image\\"+fileName;
            
            try
            {
                File destination=new File(imagePath);
                file.transferTo(destination);
                product.setImagePath("resources\\product_image\\"+fileName);
                
                adminModel model=new adminModel();
                
                model.insertProduct(product);
                product=null;
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else
            return "admin_imageError";
        
        
        return "admin_uploadProductSuccess";
    }
    
    @RequestMapping(value="admin_productList",method=RequestMethod.GET)
    public String productList(Model m)
    {
        adminModel model=new adminModel();
        
        List productList=model.getAllProduct();
        m.addAttribute("productList",productList);
        return "admin_productList";
    }
    
    @RequestMapping(value="admin_updateProduct",method=RequestMethod.GET)
    public String viewUpdate()
    {
        return "admin_updateProduct";
    }
}
