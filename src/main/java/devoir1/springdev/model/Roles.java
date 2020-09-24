package devoir1.springdev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Roles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long role_id;
    @Column(length = 20)
    private String libelle_role;
    private int etat_role;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties("roles")
    private List<Users> users;


    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public String getLibelle_role() {
        return libelle_role;
    }

    public void setLibelle_role(String libelle_role) {
        this.libelle_role = libelle_role;
    }

    public int getEtat_role() {
        return etat_role;
    }

    public void setEtat_role(int etat_role) {
        this.etat_role = etat_role;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
