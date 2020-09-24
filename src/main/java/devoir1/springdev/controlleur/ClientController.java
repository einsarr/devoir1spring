package devoir1.springdev.controlleur;

import devoir1.springdev.dao.ClientRepository;
import devoir1.springdev.dao.UsersRepository;
import devoir1.springdev.model.Client;
import devoir1.springdev.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UsersRepository usersRepository;
    @GetMapping("/all")
    public String clientPage(Model model) {
        Client client = new Client();
        List<Client> clientList = clientRepository.rechercherClientByUser((long)3);
        model.addAttribute("clients", clientList);
        model.addAttribute("client", client);
        return "clients/liste";
    }
    @PostMapping("/add")
    public String addcompte(@ModelAttribute("client") Client client) {
        client.setUser(usersRepository.getOne((long)3));
        clientRepository.save(client);
        return "redirect:/clients/all";
    }
}
