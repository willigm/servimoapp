package ni.com.servimo.ServimoSa.repositorio;
import ni.com.servimo.ServimoSa.pojos.ContratoClienteJuridico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContratoClienteJuridicoRepository extends JpaRepository<ContratoClienteJuridico,Long> {

    /**
     * Retorna el contrato con un codigo especifico
     * @param codigoContrato Codigo fisico del contrato
     * @return Contrato
     */
    ContratoClienteJuridico findByCodigoContratoEquals(String codigoContrato);


}
