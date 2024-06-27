package net.vinograd.tacocloud.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import net.vinograd.tacocloud.data.OrderRepository;
import net.vinograd.tacocloud.model.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @ModelAttribute("tacoOrder")
    public TacoOrder tacoOrder(){
        return new TacoOrder();
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus status){
        
        if (errors.hasErrors())
            return "orderForm";

        orderRepository.save(tacoOrder);
        status.setComplete();

        return "redirect:/";
    }

}
