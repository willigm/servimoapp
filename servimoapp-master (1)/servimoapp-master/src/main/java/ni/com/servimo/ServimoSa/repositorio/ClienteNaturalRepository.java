package ni.com.servimo.ServimoSa.repositorio;

import ni.com.servimo.ServimoSa.pojos.ClienteNatural;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface ClienteNaturalRepository extends JpaRepository<ClienteNatural, Long>{
    /**
     * Busqueda por numero de cedula, por correo, primer nombre
     * @param noCedula Numero de cedula
     * @param correo Correo electronico
     * @param primerNombre Primer nombre de la persona
     * @return Retorna todas las coincidencias resultantes de la busqueda.
     */
    List<ClienteNatural> findByNoCedulaLikeOrCorreoLikeOrPrimerNombreLike(String noCedula,String correo,String primerNombre);
}
