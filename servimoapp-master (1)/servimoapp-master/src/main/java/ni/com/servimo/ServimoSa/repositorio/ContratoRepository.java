package ni.com.servimo.ServimoSa.repositorio;

import ni.com.servimo.ServimoSa.pojos.Contrato;
import ni.com.servimo.ServimoSa.pojos.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

    /**
     * Retorna el contrato con un codigo especifico
     * @param codigoContrato Codigo fisico del contrato
     * @return Contrato
     */
    Contrato findByCodigoContratoEquals(String codigoContrato);

    /**
     * Metodo que obtiene los registros en dependencia de su estado
     * @param estado Estado del contrato
     * @return Retorna todos los contratos que tienen un estado.
     */
    List<Contrato> findByEstadoEquals(Estado estado);

    /**
     * Rango de fechas de contratacion
     * @param fechaContrato1 fecha de inicio
     * @param fechaContrato2 fecha fin
     * @return Retorna los contratos que se encuentran en un rango de fechas
     */
    List<Contrato> findByFechaContratoBetween(LocalDate fechaContrato1, LocalDate fechaContrato2);

    /**
     * Contratos cuyo dia de pago es el que se especifica como parametro
     * @param diaPago dia de pago
     * @return Retorna todas las coincidencias con el dia de pago.
     */
    List<Contrato> findByDiaPagoEquals(int diaPago);
}
