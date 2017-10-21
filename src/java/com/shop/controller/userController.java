
package com.shop.controller;

import com.shop.entity.Cart;
import com.shop.entity.OrderList;
import com.shop.entity.Product;
import com.shop.entity.Recharge;
import com.shop.entity.User;
import com.shop.entity.UserBalance;
import com.shop.entity.login;
import com.shop.entity.orderInfo;
import com.shop.model.HibernateUtil;
import com.shop.model.productModel;
import com.shop.model.userModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    @RequestMapping(value="userCart")
    public String getId()
    {
        return "getUserId";
    }
    
    @RequestMapping(value="myCart",method=RequestMethod.GET)
    public String myCart(@RequestParam(value="userId") int userId,Model cart,Model pdetail)
    {
        List<Cart> userCart=new ArrayList();
        List<Product> productDetail=new ArrayList();
        if(userId>0)
        {
            productModel productmodel=new productModel();
            
            userCart=productmodel.getUserCart(userId);
            for(int i=0;i< userCart.size();i++)
            {
                int pid=userCart.get(i).getProductId();
                Product product=productmodel.getProductById(pid);
                productDetail.add(product);
            }
            cart.addAttribute("userCart", userCart);
            pdetail.addAttribute("productDetail", productDetail);
            return"myCart";
        }
        return"loginError";
    }
    
    @RequestMapping(value="cartDelete",method=RequestMethod.GET)
    public String cartDelete(@RequestParam(value="cid") int cid)
    {
        productModel product=new productModel();
        product.deleteCart(cid);
        return "cartDelete";
    }
    
    @RequestMapping(value="viewCartProduct",method=RequestMethod.GET)
    public String viewCartProduct(@RequestParam(value="pid") int pid,@RequestParam(value="cid") int cid,Model model)
    {
        productModel productmodel=new productModel();
        Product product=productmodel.getProductById(pid);
        model.addAttribute("product", product);
        model.addAttribute("cid", cid);
        return"viewCartProduct";
    }
    
    @RequestMapping(value="updateToCart",method=RequestMethod.POST)
    public String updateToCart(@ModelAttribute(value="Cart") Cart cart)
    {
        productModel productmodel=new productModel();
        int cid=cart.getId();
        int quantity=cart.getQuantity();
        productmodel.updateCart(quantity,cid);
        return "updateCartSuccess";
    }
    
    @RequestMapping(value="userRecharge")
    public String viewRecharge()
    {
        return "userRecharge";
    }
    
    @RequestMapping(value="userRecharge",method=RequestMethod.POST)
    public String recharge(@ModelAttribute(value="Rcharge") Recharge Rcharge)
    {
        boolean valid=false;
        
        userModel umodel=new userModel();
        valid=umodel.checkCreditCard(Rcharge);
        
        if(valid==true)
        {
            int balanceAmount=umodel.getCreditCardBalance(Rcharge);
            Date d = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = dateFormat.format(d);
            
            UserBalance addBalance=new UserBalance();
            
            addBalance.setUserId(Rcharge.getUid());
            addBalance.setCredit(balanceAmount);
            addBalance.setDate(date);
            addBalance.setDebit(0);
            addBalance.setProductId("0");
            
            umodel.insertUserBalance(addBalance);
            
        }
        else
            return "UserRechargeError";
        
        return "UserRechargeSuccess";
    }
    
    @RequestMapping(value="addToOrder",method=RequestMethod.GET)
    public String addToOrderList(@RequestParam(value="cid") int cid)
    {
        productModel pmodel=new productModel();
        pmodel.cartToOrder(cid);
        return "orderListSuccess";
    }
    
    @RequestMapping(value="myOrderList",method=RequestMethod.GET)
    public String viewOrderList(@RequestParam(value="userId") int userId,Model olist,Model pdetail)
    {
        List<Cart> userCart=new ArrayList();
        List<Product> productDetail=new ArrayList();
        if(userId>0)
        {
            productModel productmodel=new productModel();
            userCart=productmodel.getOrderedList(userId);
            for(int i=0;i< userCart.size();i++)
            {
                int pid=userCart.get(i).getProductId();
                Product product=productmodel.getProductById(pid);
                productDetail.add(product);
            }
            userModel umodel=new userModel();
            int credit=umodel.getUserCredit(userId);
            int debit=umodel.getUserDebit(userId);
            credit=credit-debit;
            int cost=0;
            List<Cart> costList=umodel.getOrderCost(userId);
            for(int i=0;costList.size()>i;i++)
            {
                int tempPrice=costList.get(i).getPrice();
                int tempQuantity=costList.get(i).getQuantity();
                cost=cost+(tempPrice*tempQuantity);
            }
            olist.addAttribute("userCart", userCart);
            pdetail.addAttribute("productDetail", productDetail);
            olist.addAttribute("credit", credit);
            olist.addAttribute("cost", cost);
            return"myOrderList";
        }

        return"loginError";
    }
    
    
    @RequestMapping(value="moveToCart",method=RequestMethod.GET)
    public String moveIntoCart(@RequestParam(value="cid") int cid)
    {
        productModel pmodel=new productModel();
        pmodel.orderToCart(cid);
        return "CartListSuccess";
    }
    
    @RequestMapping(value="userPlaceOrder",method=RequestMethod.POST)
    public String userPlaceOrder(@ModelAttribute(value="orderInfo") orderInfo orderinfo,@RequestParam(value="userId") int uid,
            @RequestParam(value="credit") int credit,@RequestParam(value="cost") int cost)
    {
        productModel pmodel=new productModel();
        
        List<Cart> orderProduct=pmodel.getOrderedList(uid);
        if(orderProduct.size()>0)
        {
            
            if(credit >= cost)
            {
                OrderList order=new OrderList();
                for(int i=0; i<orderProduct.size();i++)
                {
                    order.setUserId(uid);
                    order.setProductId(orderProduct.get(i).getProductId());
                    order.setQuantity(orderProduct.get(i).getQuantity());
                    order.setDeliveryType(orderinfo.getDeliveryType());
                    order.setAddress(orderinfo.getAddress());
                    order.setContactNo(orderinfo.getContactNo());
                    int debit=(orderProduct.get(i).getPrice()) * (orderProduct.get(i).getQuantity());
                    order.setPrice(debit);
                    order.setName(orderinfo.getName());
                    Date d = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String date = dateFormat.format(d);
                    order.setDate(date);
                    order.setStatus(0);/* Status 0=placed,1=Accepted,2=delivered , 3=delete+refund*/
                    
                    userModel umodel=new userModel();
                    umodel.placeOrder(order);
                    pmodel.deleteCart(orderProduct.get(i).getId());
                    
                    UserBalance ubalance=new UserBalance();
                    ubalance.setCredit(0);
                    ubalance.setDate(date);
                    
                    ubalance.setDebit(debit);
                    int pid=orderProduct.get(i).getProductId();
                    ubalance.setProductId(Integer.toString(pid));
                    ubalance.setUserId(uid);
                    
                    umodel.insertUserBalance(ubalance);
                    pmodel.deleteCart(orderProduct.get(i).getId());
                }
            }
            else
                return "notEnoughBalance";
        }
        else
            return "noProductInOrderList";
        return "orderSuccess";
    }
    
    @RequestMapping(value="myAccount",method=RequestMethod.GET)
    public String userAccount(@RequestParam(value="userId") int uid,Model model)
    {
        userModel umodel=new userModel();
        List<UserBalance> history=umodel.getAccountHistory(uid);
        model.addAttribute("history", history);
        return "myAccount";
    }
}
