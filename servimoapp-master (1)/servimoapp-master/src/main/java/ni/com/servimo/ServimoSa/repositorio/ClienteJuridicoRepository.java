package ni.com.servimo.ServimoSa.repositorio;
import ni.com.servimo.ServimoSa.pojos.ClienteJuridico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteJuridicoRepository extends JpaRepository<ClienteJuridico,Long> {
    List<ClienteJuridico> findByNoRucLikeOrCorreoLikeOrNombreLike(String noRuc, String correo, String nombre);
}
