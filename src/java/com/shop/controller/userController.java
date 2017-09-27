
package com.shop.controller;

import com.shop.entity.Product;
import com.shop.entity.User;
import com.shop.entity.login;
import com.shop.model.HibernateUtil;
import com.shop.model.productModel;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@SessionAttributes("session")
@Controller
public class userController {
    
    @RequestMapping(value="products")
    public String viewProducts(Model product,Model cat)
    {
        productModel pm=new productModel();
        List productList=pm.getAllProduct();
        
        List category=new ArrayList();
        category.add("Electronic goods");
        category.add("Computer(Desktop)");
        category.add("Computer(Laptop)");
        cat.addAttribute("category", category);
        product.addAttribute("productList", productList);
        return "products";
    }
    
}
