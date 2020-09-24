package devoir1.springdev.dao;

import devoir1.springdev.model.Commission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommissionRepository extends JpaRepository<Commission,Long> {
}
