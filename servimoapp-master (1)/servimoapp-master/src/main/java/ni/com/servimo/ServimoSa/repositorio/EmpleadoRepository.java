package ni.com.servimo.ServimoSa.repositorio;

import ni.com.servimo.ServimoSa.pojos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    @Query("select p from Empleado p where p.noCedula = ?1")
    List<Empleado> findByNoCedula(String noCedula);
}
