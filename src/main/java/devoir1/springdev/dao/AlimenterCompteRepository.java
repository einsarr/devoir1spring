package devoir1.springdev.dao;

import devoir1.springdev.model.AlimenterCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimenterCompteRepository extends JpaRepository<AlimenterCompte,Long> {
}
