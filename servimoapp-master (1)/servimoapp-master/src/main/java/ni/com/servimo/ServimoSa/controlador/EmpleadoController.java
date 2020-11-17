package ni.com.servimo.ServimoSa.controlador;

import ni.com.servimo.ServimoSa.pojos.Empleado;
import ni.com.servimo.ServimoSa.repositorio.EmpleadoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadoController {

    private EmpleadoRepository repository;

    public EmpleadoController(EmpleadoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/empleado")
    public List<Empleado> all(){
        return repository.findAll();
    }

    @GetMapping("/empleado/{noCedula}")
    public List<Empleado> findByNoCedula(@PathVariable String noCedula){
        return repository.findByNoCedula(noCedula);
    }

    @PostMapping("/empleado")
    public Empleado newEmpleado(@RequestBody Empleado empleado){
        return repository.save(empleado);
    }

    @PutMapping("/empleado/{id}")
    public Empleado updateEmpleado(@RequestBody Empleado empleado, @PathVariable Long id){
        return repository.findById(id).map(e -> {
            e.setCargo(empleado.getCargo());
            e.setCodTrabajador(empleado.getCodTrabajador());
            e.setDireccion(empleado.getDireccion());
            e.setEstado(empleado.isEstado());
            e.setFoto(empleado.getFoto());
            e.setEdad(empleado.getEdad());
            e.setEstadoCivil(empleado.getEstadoCivil());
            e.setNoCedula(empleado.getNoCedula());
            e.setPrimerApellido(empleado.getPrimerApellido());
            e.setPrimerNombre(empleado.getPrimerNombre());
            e.setSegundoApellido(empleado.getSegundoApellido());
            e.setSegundoNombre(empleado.getSegundoNombre());
            e.setSexo(empleado.getSexo());
            e.setTelefono(empleado.getTelefono());
            return repository.save(e);
        }).orElseGet(() -> {
            empleado.setId(id);
            return repository.save(empleado);
        });
    }

    @DeleteMapping("/empleado/{id}")
    public void deleteEmpleado(@PathVariable Long id) throws Exception {
        Optional<Empleado> e = repository.findById(id);
        if(e.isPresent()){
            repository.delete(e.get());
        }else{
           throw new Exception("No se ha encontrado el empleado con el id :" +id);
        }

    }



}
