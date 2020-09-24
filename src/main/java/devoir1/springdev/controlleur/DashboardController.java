package devoir1.springdev.controlleur;

import devoir1.springdev.model.Compte;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
    @RequestMapping("/dashboard")
    public String home()
    {
        return "/assets/dashboard";
    }
    @RequestMapping("/changepassword")
    public String change(@ModelAttribute("compte") Compte compte)
    {
        return "redirect:/dashboard";
    }
}
