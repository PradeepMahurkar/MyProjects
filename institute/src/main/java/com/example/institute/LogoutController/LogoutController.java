package com.example.institute.LogoutController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Logout")
public class LogoutController {

    @PostMapping
    public String logout(HttpServletRequest request) {
        // Invalidate the session to log out the user
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Redirect to the login page after logout
        return "redirect:/login";
    }

}
