package ni.com.servimo.ServimoSa.repositorio;

import ni.com.servimo.ServimoSa.pojos.Contrato;
import ni.com.servimo.ServimoSa.pojos.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo,Long> {
    /**
     * Los recibos de un contrato
     * @param contrato Recibos pagados sobre el contrato
     * @return Los recibos que pertenecen a un contrato especifico
     */
    List<Recibo> findByContrato_CodigoContratoLike(String codigoContrato);

    /**
     * Los recibo pagados de una fecha
     * @param fechaPagada Fecha en el que se pago el recibo
     * @return Los recibos que fueron pagados en la fecha especificada
     */
    List<Recibo> findByFechaPagadaEquals(LocalDate fechaPagada);

    /**
     * Los recibos pagados en un rango de fechas
     * @param fechaPagada1 Fecha inicial
     * @param fechaPagada2 Fecha final
     * @return Retorna los recibos que has sido pagados en ese rango de fechas.
     */
    List<Recibo> findByFechaPagadaBetween(LocalDate fechaPagada1, LocalDate fechaPagada2);
}
