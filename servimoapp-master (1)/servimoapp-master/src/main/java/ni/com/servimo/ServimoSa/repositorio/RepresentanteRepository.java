package ni.com.servimo.ServimoSa.repositorio;
import ni.com.servimo.ServimoSa.pojos.Empleado;
import ni.com.servimo.ServimoSa.pojos.Representante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface RepresentanteRepository extends JpaRepository<Representante,Long> {

    List<Representante> findByNoCedulaLikeOrPrimerNombreLike(String noCedula,String primernombre);


}
