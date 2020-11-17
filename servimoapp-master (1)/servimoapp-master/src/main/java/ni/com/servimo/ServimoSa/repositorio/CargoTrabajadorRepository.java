package ni.com.servimo.ServimoSa.repositorio;

import ni.com.servimo.ServimoSa.pojos.CargoTrabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoTrabajadorRepository extends JpaRepository<CargoTrabajador,Long> {
}
