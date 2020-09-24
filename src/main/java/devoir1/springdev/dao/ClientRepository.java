package devoir1.springdev.dao;

import devoir1.springdev.model.Client;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("SELECT c From Client c WHERE c.numero_piece = ?1")
    public Client findByNumero_piece(String num_piece_env);
    @Query("select c from Client c where c.user.user_id =:user_id")
    public List<Client> rechercherClientByUser(@Param("user_id") Long user_id);
}
