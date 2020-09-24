package devoir1.springdev.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long compte_id;
    private float montant_init;
    private float solde;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user;


    @OneToMany(mappedBy = "compte")
    private List<AlimenterCompte> alimenterComptes;

    public long getCompte_id() {
        return compte_id;
    }

    public void setCompte_id(long compte_id) {
        this.compte_id = compte_id;
    }

    public float getMontant_init() {
        return montant_init;
    }

    public void setMontant_init(float montant_init) {
        this.montant_init = montant_init;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde += solde;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<AlimenterCompte> getAlimenterComptes() {
        return alimenterComptes;
    }

    public void setAlimenterComptes(List<AlimenterCompte> alimenterComptes) {
        this.alimenterComptes = alimenterComptes;
    }

}
