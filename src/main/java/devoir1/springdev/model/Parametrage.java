package devoir1.springdev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor@AllArgsConstructor @ToString
public class Parametrage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "float default 0.45")
    private float com_systeme;
    @Column(columnDefinition = "float default 0.25")
    private float com_taxe_etat;
    @Column(columnDefinition = "float default 0.15")
    private float com_caissier_env;
    @Column(columnDefinition = "float default 0.15")
    private float com_caissier_rec;
    @Column(columnDefinition = "float default 0.05")
    private float frais;
    @Column(columnDefinition = "float default 100000")
    private float montant_initiale;
}
