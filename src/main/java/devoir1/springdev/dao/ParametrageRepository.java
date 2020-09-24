package devoir1.springdev.dao;

import devoir1.springdev.model.Parametrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametrageRepository extends JpaRepository<Parametrage,Long> {
}
