package com.shop.controller;

import com.shop.entity.Admin;
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

    @RequestMapping(value = "admin_dash")
    public String viewAdminDash() {
        return "admin_dash";
    }

    @RequestMapping(value = "admin_uploadProduct", method = RequestMethod.GET)
    public String viewUpload() {
        return "admin_uploadProduct";
    }

    @RequestMapping(value = "admin_uploadProduct", method = RequestMethod.POST)
    public String uploadProduct(@RequestParam CommonsMultipartFile file, @ModelAttribute("Product") Product product) {

        String fileName = file.getOriginalFilename();

        String mimetype = new MimetypesFileTypeMap().getContentType(fileName);
        String type = mimetype.split("/")[0];
        if (type.equals("image")) {
            String imagePath = "E:\\Programming Practice\\JSP\\onlineShop\\web\\resources\\product_image\\" + fileName;

            try {
                File destination = new File(imagePath);
                file.transferTo(destination);
                product.setImagePath("resources\\product_image\\" + fileName);

                adminModel model = new adminModel();

                model.insertProduct(product);
                product = null;
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            return "admin_imageError";
        }

        return "admin_uploadProductSuccess";
    }

    @RequestMapping(value = "admin_productList")
    public String productList(Model m) {
        adminModel model = new adminModel();

        List productList = model.getAllProduct();
        m.addAttribute("productList", productList);
        return "admin_productList";
    }

    @RequestMapping(value = "admin_updateProduct", method = RequestMethod.GET)
    public String viewUpdate(@RequestParam(value = "id") int id, Model m) {
        adminModel model = new adminModel();
        Product productDetail = model.getProductDetailById(id);

        m.addAttribute("productDetail", productDetail);

        return "admin_updateProduct";
    }

    @RequestMapping(value = "admin_updateProduct", method = RequestMethod.POST)
    public String productUpdate(@ModelAttribute(value = "Product") Product product, @RequestParam CommonsMultipartFile file) {
        String fileName = file.getOriginalFilename();
        adminModel model = new adminModel();
        if (fileName.isEmpty()) {

            model.updateProduct(product);
        } else {
            String mimetype = new MimetypesFileTypeMap().getContentType(fileName);
            String type = mimetype.split("/")[0];

            if (type.equals("image")) {
                String imagePath = "E:\\Programming Practice\\JSP\\onlineShop\\web\\resources\\product_image\\" + fileName;

                try {
                    File destination = new File(imagePath);
                    file.transferTo(destination);
                    product.setImagePath("resources\\product_image\\" + fileName);
                    model.updateProduct(product);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                return "admin_imageError";
            }

        }
        return "admin_updateProductSuccess";
    }

    @RequestMapping(value = "admin_searchById", method = RequestMethod.POST)
    public String searchByID(@RequestParam(value = "id") int id, Model m) {
        adminModel model = new adminModel();
        List productList = model.getProductById(id);

        m.addAttribute("productList", productList);
        return "admin_productList";
    }

    @RequestMapping(value = "admin_searchByCategory", method = RequestMethod.POST)
    public String searchByCategory(@RequestParam(value = "category") String category, Model m) {
        adminModel model = new adminModel();

        List productList = model.getProductByCategory(category);
        m.addAttribute("productList", productList);
        return "admin_productList";
    }

    @RequestMapping(value = "admin_searchByBrand", method = RequestMethod.POST)
    public String searchByBrand(@RequestParam(value = "brand") String brand, Model m) {
        adminModel model = new adminModel();

        List productList = model.getProductByBrand(brand);
        m.addAttribute("productList", productList);
        return "admin_productList";
    }

    @RequestMapping(value = "admin_sortByQuantity")
    public String sortByQuantity(@RequestParam(value = "sort") int val, Model m) {
        adminModel model = new adminModel();

        List productList = model.sortProduct(val);

        m.addAttribute("productList", productList);
        return "admin_productList";
    }
    
    @RequestMapping(value="admin_register",method=RequestMethod.GET)
    public String viewAdminRegister()
    {
        return "admin_register";
    }
    
    @RequestMapping(value="admin_register",method=RequestMethod.POST)
    public String AdminRegister(@ModelAttribute(value="Admin") Admin admin)
    {
        adminModel model=new adminModel();
        model.insertAdmin(admin);
        return "admin_register";
    }
    
    @RequestMapping(value="admin_list")
    public String adminList(Model m)
    {
        adminModel model=new adminModel();
        List<Admin> adminList=model.getAdminList();
        
        m.addAttribute("adminList", adminList);
        return "admin_list";
    }
}
