package devoir1.springdev.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alimentations")
public class AlimenterCompteController {

    @GetMapping("/all")
    public String index(){
        return "alimentations";
    }
}
