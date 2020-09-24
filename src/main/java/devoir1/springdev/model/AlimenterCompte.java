package devoir1.springdev.model;


import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "alimentation_compte")
public class AlimenterCompte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long alimentation_id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_alimentation;
    @NotNull
    @Column(name = "montant")
    private float montant;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    public long getAlimentation_id() {
        return alimentation_id;
    }

    public void setAlimentation_id(long alimentation_id) {
        this.alimentation_id = alimentation_id;
    }

    public Date getDate_alimentation() {
        return date_alimentation;
    }

    public void setDate_alimentation(Date date_alimentation) {
        this.date_alimentation = date_alimentation;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }


    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
