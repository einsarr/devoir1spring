package devoir1.springdev.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SecurityController {
    @GetMapping("/notAuthorized")
    public String notfound(){
        return "/assets/notAuthorized";
    }
    @GetMapping("/")
    public String home(){
        return "/assets/dashboard";
    }


    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/login";
    }
    @GetMapping("/changepassword")
    public String changepassword(Model model){
        return "/assets/changepassword";
    }
}
