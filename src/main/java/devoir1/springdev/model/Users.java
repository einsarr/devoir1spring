package devoir1.springdev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long user_id;
    @Column(length = 10)
    private String code;
    @Column(length = 30)
    @NotNull
    private String prenom;
    @Column(length = 25)
    @NotNull
    private String nom;
    @Column(length = 25,nullable = true)
    private String num_piece;
    @Column(length = 25,nullable = true)
    private String contrats;
    @Column(length = 10)
    private String num_contrat;
    @Column(length = 50)
    private String username;
    @Column(length = 255,nullable = true)
    private String password;
    @Column(length = 10)
    private boolean etat;
    private boolean changed;
    @Column(length = 255)
    private String photo;
    @OneToMany(mappedBy = "user")
    private List<Client> clients;

    //@Transient
    //private MultipartFile[] files;
    @OneToMany(mappedBy = "caissier_env")
    private List<Operation> caissier_envois;
    @OneToMany(mappedBy = "caissier_rec")
    private List<Operation> caissier_recus;
    @OneToOne(mappedBy = "user")
    private Compte compte;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnoreProperties("user")
    private List<Roles> roles;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNum_contrat() {
        return num_contrat;
    }

    public void setNum_contrat(String num_contrat) {
        this.num_contrat = num_contrat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Operation> getCaissier_envois() {
        return caissier_envois;
    }

    public void setCaissier_envois(List<Operation> caissier_envois) {
        this.caissier_envois = caissier_envois;
    }

    public List<Operation> getCaissier_recus() {
        return caissier_recus;
    }

    public void setCaissier_recus(List<Operation> caissier_recus) {
        this.caissier_recus = caissier_recus;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public String getNum_piece() {
        return num_piece;
    }

    public void setNum_piece(String num_piece) {
        this.num_piece = num_piece;
    }

    public String getContrats() {
        return contrats;
    }

    public void setContrats(String contrats) {
        this.contrats = contrats;
    }

    public boolean isEtat() {
        return etat;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
/*
    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }*/

    public String num_contrat_caissier(int n){
        //choisissez un caractére au hasard à partir de cette chaîne
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder s = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(str.length() * Math.random());
            s.append(str.charAt(index));
        }
        return s.toString();
    }
    public String code_caissier(){
        String code="";
        int n;
        for(int i=0;i<6;i++)
        {
            n = (int)(Math.random() * 10);
            code += n+"";
        }
        return code;
    }

}
