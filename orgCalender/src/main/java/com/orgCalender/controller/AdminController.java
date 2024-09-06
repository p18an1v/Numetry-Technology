package com.orgCalender.controller;
import com.orgCalender.DB.UserDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/login")
    public String adminLoginPage() {
        System.out.println("admin login");
        return "adminLogin";
    }

    @PostMapping("/login")
    public String adminLogin(String admin, String adminPswd, RedirectAttributes redirectAttributes) {
        // Check if admin credentials are valid
        if (admin.equals("admin") && adminPswd.equals("pswd")) {
            System.out.println("admin dashboard");
            return "adminDashboard";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid admin credentials");
            System.out.println("redirected to login due to login and pswd is incorrect");
            return "login";
        }
    }

    // Other methods for adding users, notes, etc.
    @GetMapping("/addUser")
    public String addUserPage() {
        return "addUser"; // Assuming there's an HTML template for adding users
    }

    @PostMapping("/addUser")
    public String addUser(String username, String password, RedirectAttributes redirectAttributes) {
        if (UserDatabase.userExists(username)) {
            redirectAttributes.addFlashAttribute("error", "User already exists");
            System.out.println("adding user failed");
            return "adminDashboard";
        } else {
            UserDatabase.addUser(username, password);
            redirectAttributes.addFlashAttribute("success", "User added successfully");
            System.out.println("adding user successful");
            return "adminDashboard";
        }
    }

    private List<String> notes = new ArrayList<>();

    @GetMapping("/showNotes")
    public String showNotes(String noteContent,Model model) {
        notes.add(noteContent);
        model.addAttribute("notes", notes);
        return "showNotes";
    }

    @GetMapping("/addNote")
    public String addNotePage() {
        // This method seems incomplete. You might want to remove it or complete it.
        System.out.println("Add notes request get");
        return "addNote";
    }

    @PostMapping("/addNote")
    public String addNote(String noteContent, RedirectAttributes redirectAttributes) {
        // Logic to add a new note with provided content
        notes.add(noteContent);
        redirectAttributes.addFlashAttribute("success", "Note added successfully");
        System.out.println("Note controller invoked");
        return "showNotes";
    }

    @GetMapping("/showUsers") //request is not coming in this solve this issue
    public String showUsers(Model model) {
        // Retrieve all users from the UserDatabase
        Map<String, String> users = UserDatabase.getAllUsers();
        // Add users to the model
        model.addAttribute("users", users);

        System.out.println("user shown");
        // Return the view name
        return "showUsers";
    }

}



//http://localhost:9090/admin/login