package com.orgCalender.controller;
import com.orgCalender.DB.UserDatabase;
import com.orgCalender.model.LeaveApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String userLoginPage() {
        System.out.println("User login");
        return "userLogin";
    }

    @PostMapping("/login")
    public String userLogin(@RequestParam("userName") String username, @RequestParam("userPswd") String password) {
        // Validate user credentials
        if (UserDatabase.isValidUser(username, password)) {
            System.out.println("User dashboard");
            return "userDashboard"; // Corrected template name
        } else {
            return "userLogin";
        }
    }

    @GetMapping("/addNote")
    public String addNotePage() {
        return "addNote"; // Assuming "addNote.html" is located in "src/main/resources/static/user/"
    }
    // Other methods for user functionalities

    @GetMapping("/LeaveApplication")
    public String leaveApplication() {
        System.out.println("Leave form is accessed");
        return "LeaveApplication"; // Assuming "addNote.html" is located in "src/main/resources/static/user/"
    }


    /*-------------------------------SMTP-----------------------------------*/

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("/leaveApplication")
    public String applyLeave(@RequestParam("userEmail") String userEmail,
                             @RequestParam("leaveDate") String leaveDate,
                             @RequestParam("leaveReason") String leaveReason) {
        try {
            // Create email message
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("your-email@gmail.com"); // Set a fixed from address
            message.setTo("pranavmhargude@gmail.com");
            message.setSubject("Leave Application");
            message.setText("User Email: " + userEmail + "\nLeave Date: " + leaveDate + "\nLeave Reason: " + leaveReason);

            // Send email
            emailSender.send(message);

            return "LeaveSuccess";
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            return "LeaveFailed";
        }
    }
    /*-------------------------------SMTP-----------------------------------*/
}
