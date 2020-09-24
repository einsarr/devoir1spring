package devoir1.springdev.dao;

import devoir1.springdev.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
    @Query("SELECT o From Operation o WHERE o.code_envoi = ?1")
    public Operation findByCode_envoi(String code);
}
