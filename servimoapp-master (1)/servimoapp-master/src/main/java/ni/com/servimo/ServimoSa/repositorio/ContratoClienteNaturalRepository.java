package ni.com.servimo.ServimoSa.repositorio;

import ni.com.servimo.ServimoSa.pojos.ContratoClienteNatural;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContratoClienteNaturalRepository extends JpaRepository<ContratoClienteNatural, Long> {

    Optional<ContratoClienteNatural> findByCodigoContratoEquals(String codigo);
    List<ContratoClienteNatural> findByDiaPagoEquals(int diaPago);
    List<ContratoClienteNatural> findByFechaContratoBetweenOrderByFechaContrato(LocalDate fechaContratato1, LocalDate fechaContratato2);
}
