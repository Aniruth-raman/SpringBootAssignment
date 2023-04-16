package com.springboot.assignment.magicofbooks.controller;

import com.springboot.assignment.magicofbooks.entity.Users;
import com.springboot.assignment.magicofbooks.service.UsersService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    UsersService usersService;

    @GetMapping("/register")
    public String registerPage(HttpServletRequest request, Map<String, List<String>> map, Map<String, String> errormap,
            @RequestParam(required = false) String error) {
        // GET
        if (error != null)
            errormap.put("error", error);
        System.out.println("Register request " + request.getMethod());
        // List<String> roles = Arrays.asList("ADMIN", "USER", "DEV");
        // map.put("roles", roles);
        return "register";
    }

    // @RequestMapping(path = "/login", method = RequestMethod.POST)
    @PostMapping("/register")
    public String registerPostPage(Users user, HttpServletRequest request, HttpSession session,
            HttpServletResponse resp) {
        // POST
        System.out.println("register request " + request.getMethod());
        System.out.println("email " + user.getEmail());
        System.out.println("pwd " + user.getPassword());
        System.out.println("username " + user.getUsername());
        try {
            if (this.usersService.findByUsername(user.getUsername()) != null) {
                // model.addAttribute("error", "Email Already Registered");
                return "redirect:register?error=Username Already Registered";
            }
            this.usersService.registerUser(user);
            Cookie cookie = new Cookie("email", user.getEmail());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("username", user.getUsername());
            resp.addCookie(cookie);
            return "redirect:dashboard";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "redirect:register?error=Invalid credentials";
        }
    }
}
