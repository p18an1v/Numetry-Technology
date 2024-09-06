package com.ticketBooking.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/App")
public class registerController {

    @PostMapping("/register")
    public String registration(){
        System.out.println("request come to registration controller");
        return "register";
    }
}

//http://localhost:8080/App/register
