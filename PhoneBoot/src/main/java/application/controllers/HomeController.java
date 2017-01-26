package application.controllers;

/**
 * PhoneBoot
 * Created by Grzegorz Kossowski on 22.01.17.
 */

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"})
    public String homePage() {
        return "home";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutUser(HttpServletRequest request, HttpServletResponse response, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout";
    }

}
