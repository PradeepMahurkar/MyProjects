package com.example.institute.Controller;

import com.example.institute.model.UserEntity;
import com.example.institute.service.IUser;
import jakarta.servlet.Registration;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller

@Slf4j
public class UserController {

    @Autowired
    IUser userService;


    @GetMapping("/register")
    public String showRegistrationForm(Model model,UserEntity userEntity1){
//        UserEntity userEntity=userService.registerUser(userEntity1);
//        model.addAttribute("register",userEntity);
        log.info("Inside signUp_page method");
        model.addAttribute("registerData",new UserEntity());
        log.info("Returning signup_page template");
        return "Register";
    }


    @PostMapping("/save-register-details")
    public String saveRegisterDetails(@Valid  @ModelAttribute("registerData") BindingResult result, Model model,UserEntity userEntity){
//        public String registerUser(@Valid  @ModelAttribute("registerData") SignInUserRequestDto signInUserRequestDto, BindingResult bindingResult, Model model) {
        if (result.hasErrors()) {
           log.info(String.valueOf(result));
            return "Register"; // Replace with your Thymeleaf template name
        }
        try {
            userService.saveRegisterUser(userEntity);
        }catch (Exception exception){
            model.addAttribute("error",exception.getMessage());
            return "Register";
        }
        return "dashboard";
//        if (bindingResult.hasErrors()) {
//            log.info(String.valueOf(bindingResult));
//            return "signup_page"; // Replace with your Thymeleaf template name
//        }
//        try {
//            // Using the IUserService registration process to the service layer
//            iUserService.registerUser(signInUserRequestDto);
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "signup_page";
//        }
//        // Redirect to a success page

    }

//    @PostMapping("/save-register-details")
//    public String saveRegistration(@Valid Registration registration, BindingResult result, RedirectAttributes redirectAttributes) {
//        if (result.hasErrors()) {
//            redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
//            return "redirect:/register"; // Redirect to the registration page with errors
//        }
//        // Process registration and save user data
//        return "redirect:/success";
//    }

    @GetMapping("/")
    public String dashboardPage(){
        return "login";
    }

//    @PostMapping("/save-login-details")
//    public String saveLoginDetails(UserEntity userEntity){
//        userService.saveLoginUser(userEntity);
//        return "dashboard";
//    }


    @GetMapping("/course")
    public String showcourse(){
        return "course";
    }

    @GetMapping("/dashboard")
    public String showdashboard(){

        return "dashboard";
    }

//    check login details

    @PostMapping("/check-login-details")
    public String loginAuthentication(@RequestParam String email, @RequestParam String password) {
        boolean isValidUser = userService.validateUserCredentials(email, password);

        if (isValidUser) {
            return "dashboard"; // Redirect to the dashboard on successful login
        } else {
            return "login"; // Redirect back to login on failure
        }
    }

//    @GetMapping("/register")
//    public String showRegisterPage(){
//        return "Register";
//    }

    @GetMapping("/registration-details")
    public String showRegistrationDetails(Model model){
        List<UserEntity> userEntity=userService.getUserDetailsFromDb();
        model.addAttribute("courses",userEntity);
        return "RegistrationDetails";
    }

//    @GetMapping("/login")
//    public String showLogin(){
//
//        return "login";
//    }
    @GetMapping("/logout")
    public String showLogout(){

        return "logout";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<UserEntity> user = userService.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return switch (user.get().getRole()) {
                case "Admin" -> "redirect:/admin/dashboard";
                case "Instructor" -> "redirect:/instructor/dashboard";
                case "Student" -> "redirect:/student/dashboard";
                default -> "login";
            };

        }
        return "dashboard";
    }
}
