package devoir1.springdev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float com_systeme;
    private float com_taxe_etat;
    private float com_caissier_env;
    private float com_caissier_rec;
    @OneToOne
    @JoinColumn(name = "operation_id")
    private Operation operation;

}
