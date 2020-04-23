package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import web.service.OrderService;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

}
