package devoir1.springdev.controlleur;

import devoir1.springdev.dao.*;
import devoir1.springdev.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/operations")
public class OperationController {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CommissionRepository commissionRepository;
    @Autowired
    private ParametrageRepository parametrageRepository;
    @Autowired
    private CompteRepository compteRepository;
    @GetMapping("/all")
    public String OperationPage(Model model) {
        Operation operation = new Operation();
        List<Operation> operationList = operationRepository.findAll();
        model.addAttribute("operation", operation);
        model.addAttribute("operations", operationList);
        return "operations/liste";
    }
    @PostMapping("/add")
    public String addoperation(@ModelAttribute("operation") Operation operation) {
        Commission commission = new Commission();
        Parametrage param = parametrageRepository.getOne((long) 1);
        Client cl1 = clientRepository.getOne((long)1);
        Client cl2 = clientRepository.getOne((long)2);
        //Provisoir
        Users u1 = usersRepository.getOne((long) 3);
        Users u2 = usersRepository.getOne((long) 4);
        operation.setCaissier_env(u1);
        operation.setCaissier_rec(u2);
        operation.setClient_env(cl1);
        operation.setClient_rec(cl2);
       /* if(!code.isEmpty())
        {
            Operation op = operationRepository.findByCode_envoi(operation.getcode());
            Client c = clientRepository.findByNumero_piece(client.getNum_piece());
            if(op!=null AND c!=null){
                 //operation.setUser(user);
                  augmenter le solde du caissier recepteur
                 u1.getCompte().setSolde(operation.getMontant_envoi());
                 compteRepository.save(u1.getCompte());
                operation.setDate_envoi(new Date());
                operation.setDate_retrait(new Date());
                //u1.getCompte().setSolde(operation.getMontant_envoi());
                operation.setCode_envoi(operation.code_envoi());
                //operation.setFrais_envoi(5*operation.getMontant_envoi()/100);
            }

        }
        else{*/
            //operation.setUser(user);

            operation.setDate_envoi(new Date());
            operation.setDate_retrait(new Date());
            operation.setCode_envoi(operation.code_envoi());
            //Calcul des frais
            operation.setFrais_envoi(5*operation.getMontant_envoi()/100);
        Operation op = operationRepository.save(operation);
        //CALCUL DES COMMISSIONS
            commission.setOperation(op);
            commission.setCom_systeme(op.getFrais_envoi()*param.getCom_systeme());
            commission.setCom_taxe_etat(op.getFrais_envoi()*param.getCom_taxe_etat());
            commission.setCom_caissier_env(op.getFrais_envoi()*param.getCom_caissier_env());
            commission.setCom_caissier_rec(op.getFrais_envoi()*param.getCom_caissier_rec());
            //Diminuer le solde du compte du caissier envoyeur

            u1.getCompte().diminuerSolde(operation.getMontant_envoi());

            compteRepository.save(u1.getCompte());

            commissionRepository.save(commission);
        //}


        return "redirect:/operations/all";
    }
    @GetMapping("/commissions")
    public String commissions(Model model) {
        Commission commission = new Commission();
        List<Commission> commissionList = commissionRepository.findAll();
        model.addAttribute("commissions", commissionList);
        return "commissions/liste";
    }
}
