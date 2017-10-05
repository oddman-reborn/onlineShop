
package com.shop.controller;

import com.shop.entity.Cart;
import com.shop.entity.Product;
import com.shop.entity.User;
import com.shop.entity.login;
import com.shop.model.HibernateUtil;
import com.shop.model.productModel;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @RequestMapping(value="viewByProduct",method=RequestMethod.GET)
    public String detailByProduct(@RequestParam(value="pid") int pid,Model m)
    {
        productModel pmodel=new productModel();
        Product product=pmodel.getProductById(pid);
        m.addAttribute("product", product);
        return "viewByProduct";
    }
    
    @RequestMapping(value="productList",method=RequestMethod.GET)
    public String productListByCategory(@RequestParam(value="category") String category,Model m)
    {
        productModel product=new productModel();
        List <Product> productList=product.getProductByCategory(category);
        m.addAttribute("productList", productList);
        return "productListByCategory";
    }
    
    @RequestMapping(value="addToCart",method=RequestMethod.POST)
    public String addToCart(@ModelAttribute(value="Cart") Cart cart)
    {
        int id=cart.getUserId();
        System.out.println(id);
        System.out.println("here");
        if(id>0)
        {
            productModel product=new productModel();
            product.insertCart(cart);
            return "cartSuccess";
        }
        else
            return"loginError";
    }
    
    @RequestMapping(value="myCart",method=RequestMethod.GET)
    public String myCart(@RequestParam(value="userId") int userId)
    {
        if(userId>0)
        {
            productModel product=new productModel();
            Product productList;
        }
        return"myCart";
    }
}
