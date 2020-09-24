package devoir1.springdev.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long client_id;
    @Column(length = 17)
    @NotNull
    private String numero_piece;
    @Column(length = 30)
    @NotNull
    private String nom;
    @Column(length = 40)
    @NotNull
    private String prenom;
    @Column(length = 16)
    @NotNull
    private String telephone;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "client_env")
    private List<Operation> envois;

    @OneToMany(mappedBy = "client_rec")
    private List<Operation> recus;


    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public String getNumero_piece() {
        return numero_piece;
    }

    public void setNumero_piece(String numero_piece) {
        this.numero_piece = numero_piece;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Operation> getEnvois() {
        return envois;
    }

    public void setEnvois(List<Operation> envois) {
        this.envois = envois;
    }

    public List<Operation> getRecus() {
        return recus;
    }

    public void setRecus(List<Operation> recus) {
        this.recus = recus;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
