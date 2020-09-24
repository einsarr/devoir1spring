package devoir1.springdev.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long operation_id;
    @Column(length = 9,nullable = true)
    private String code_envoi;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = true)
    private Date date_envoi;
    @Column(length = 10)
    private String type_operation;
    @Column(nullable = true)
    private float montant_envoi;
    @Column(nullable = true)
    private float frais_envoi;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = true)
    private Date date_retrait;
    @Column(columnDefinition = "float default 0")
    private float etat_traitement;

    @ManyToOne
    @JoinColumn(name = "client_env_id",nullable = true)
    private Client client_env;

    @ManyToOne
    @JoinColumn(name = "client_rec_id",nullable = true)
    private Client client_rec;

    @ManyToOne
    @JoinColumn(name = "caissier_env_id",nullable = true)
    private Users caissier_env;

    @ManyToOne
    @JoinColumn(name = "caissier_rec_id",nullable = true)
    private Users caissier_rec;


    public long getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(long operation_id) {
        this.operation_id = operation_id;
    }

    public String getCode_envoi() {
        return code_envoi;
    }

    public void setCode_envoi(String code_envoi) {
        this.code_envoi = code_envoi;
    }

    public Date getDate_envoi() {
        return date_envoi;
    }

    public void setDate_envoi(Date date_envoi) {
        this.date_envoi = date_envoi;
    }

    public String getType_operation() {
        return type_operation;
    }

    public void setType_operation(String type_operation) {
        this.type_operation = type_operation;
    }

    public float getMontant_envoi() {
        return montant_envoi;
    }

    public void setMontant_envoi(float montant_envoi) {
        this.montant_envoi = montant_envoi;
    }

    public float getFrais_envoi() {
        return frais_envoi;
    }

    public void setFrais_envoi(float frais_envoi) {
        this.frais_envoi = frais_envoi;
    }

    public Date getDate_retrait() {
        return date_retrait;
    }

    public void setDate_retrait(Date date_retrait) {
        this.date_retrait = date_retrait;
    }

    public float getEtat_traitement() {
        return etat_traitement;
    }

    public void setEtat_traitement(float etat_traitement) {
        this.etat_traitement = etat_traitement;
    }

    public Client getClient_env() {
        return client_env;
    }

    public void setClient_env(Client client_env) {
        this.client_env = client_env;
    }

    public Client getClient_rec() {
        return client_rec;
    }

    public void setClient_rec(Client client_rec) {
        this.client_rec = client_rec;
    }

    public Users getCaissier_env() {
        return caissier_env;
    }

    public void setCaissier_env(Users caissier_env) {
        this.caissier_env = caissier_env;
    }

    public Users getCaissier_rec() {
        return caissier_rec;
    }

    public void setCaissier_rec(Users caissier_rec) {
        this.caissier_rec = caissier_rec;
    }

    public String code_envoi(){
        String code="";
        int n;
        for(int i=0;i<9;i++)
        {
            n = (int)(Math.random() * 10);
            code += n+"";
        }
        return code;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operation_id=" + operation_id +
                ", code_envoi='" + code_envoi + '\'' +
                ", date_envoi=" + date_envoi +
                ", type_operation='" + type_operation + '\'' +
                ", montant_envoi=" + montant_envoi +
                ", frais_envoi=" + frais_envoi +
                ", date_retrait=" + date_retrait +
                ", etat_traitement=" + etat_traitement +
                ", client_env=" + client_env +
                ", client_rec=" + client_rec +
                ", caissier_env=" + caissier_env +
                ", caissier_rec=" + caissier_rec +
                '}';
    }
}
