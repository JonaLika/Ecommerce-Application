package com.ecommerce.customer.controller;

import com.ecommerce.library.model.Customer;
import com.ecommerce.library.model.Order;
import com.ecommerce.library.model.ShoppingCart;
import com.ecommerce.library.service.CustomerService;
import com.ecommerce.library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;


    @GetMapping("/check-out")
    public String checkout(Model model, Principal principal){
        if(principal == null){
            return "redirect:/login";
        }
        String username = principal.getName();
        Customer customer = customerService.findByUsername(username);
        if(customer.getPhoneNumber().trim().isEmpty() || customer.getAddress().trim().isEmpty()
                || customer.getCity().trim().isEmpty() || customer.getCountry().trim().isEmpty()){

            model.addAttribute("customer", customer);
            model.addAttribute("error", "You must fill the information after checkout!");
            return "account";
        }else{
            model.addAttribute("customer", customer);
            ShoppingCart cart = customer.getShoppingCart();
            model.addAttribute("cart", cart);
        }
        return "checkout";
    }


    @GetMapping("/order")
    public String order(Principal principal,Model model){
        if(principal==null){
            return "redirect:/login";
        }

        Customer customer=customerService.findByUsername(principal.getName());
        List<Order> orderList=customer.getOrders();
        model.addAttribute("orders",orderList);
        return "order";
    }

    @GetMapping("/save-order")
    private String saveOrder(Principal principal){
        if(principal==null){
            return "redirect:/login";
        }

        Customer customer=customerService.findByUsername(principal.getName());
        orderService.saveOrder(customer.getShoppingCart());
        return "redirect:/order";
    }

    @GetMapping("/cancel-order")
    private String cancelOrder(Principal principal,Long id){
        if(principal==null){
            return "redirect:/login";
        }
        Customer customer=customerService.findByUsername(principal.getName());
        orderService.cancelOrder(id);
        return "redirect:/order";
    }


}
