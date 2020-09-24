package devoir1.springdev.controlleur;

import devoir1.springdev.dao.*;
import devoir1.springdev.model.AlimenterCompte;
import devoir1.springdev.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/comptes")
public class CompteController {

    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private AlimenterCompteRepository alimenterCompteRepository;
    @Autowired
    private ParametrageRepository parametrageRepository;
    @GetMapping("/all")
    public String comptePage(Model model) {
        List<Compte> compteList = compteRepository.findAll();
        Compte compte = new Compte();
        Client client = new Client();
        Users users = new Users();
        AlimenterCompte alimenterCompte = new AlimenterCompte();
        Operation operation = new Operation();
        model.addAttribute("alimenterCompte",alimenterCompte);
        model.addAttribute("compte",compte);
        model.addAttribute("operation",operation);
        model.addAttribute("client",client);
        model.addAttribute("comptes", compteList);
        model.addAttribute("users", users);
        return "comptes/liste";
    }
    @PostMapping("/add")
    public String addcompte(@ModelAttribute("compte") Compte compte,Users user) {
        Parametrage param = parametrageRepository.getOne((long)1);
        user.setCode(user.code_caissier());
        user.setNum_contrat(user.num_contrat_caissier(2)+user.code_caissier());
        compte.setUser(user);
        compte.setMontant_init(param.getMontant_initiale());
        compte.setSolde(compte.getMontant_init());
        compteRepository.save(compte);

        return "redirect:/comptes/all";
    }
    @GetMapping("/caissiers")
    public String caissiers(Model model) {
        List<Users> usersList = usersRepository.findAll();
        model.addAttribute("caissiers", usersList);
        return "caissiers/liste";
    }

    @PostMapping("/alimenter")
    public String alimenter(@ModelAttribute("alimenter") AlimenterCompte alimenterCompte,Long idcompte) {
        Compte compte = compteRepository.getOne(idcompte);
        compte.setSolde(alimenterCompte.getMontant());
        alimenterCompte.setDate_alimentation(new Date());
        alimenterCompte.setCompte(compte);
        alimenterCompteRepository.save(alimenterCompte);
        return "redirect:/comptes/all";
    }
    @GetMapping("/{id}")
    public @ResponseBody
    Compte OneCompte(@PathVariable(name = "id") long idcomptedetail){
        return compteRepository.findById(idcomptedetail).get();
    }

}
