package ni.com.servimo.ServimoSa.controlador;

import ni.com.servimo.ServimoSa.pojos.CargoTrabajador;
import ni.com.servimo.ServimoSa.pojos.Empleado;
import ni.com.servimo.ServimoSa.repositorio.CargoTrabajadorRepository;
import ni.com.servimo.ServimoSa.repositorio.EmpleadoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CargoTrabajadorController {
    private CargoTrabajadorRepository repository;

    public CargoTrabajadorController(CargoTrabajadorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cargo")
    public List<CargoTrabajador> all(){
        return repository.findAll();
    }

    @PostMapping("/cargo")
    public CargoTrabajador newCargoTrabajador(@RequestBody CargoTrabajador cargoTrabajador){
        return repository.save(cargoTrabajador);
    }

    @PutMapping("/cargo/{id}")
    public CargoTrabajador updateCargoTrabajador(@RequestBody CargoTrabajador cargoTrabajador, @PathVariable Long id){
        return repository.findById(id).map(e -> {
            e.setMoneda(cargoTrabajador.getMoneda());
            e.setNombreCargo(cargoTrabajador.getNombreCargo());
            e.setSalario(cargoTrabajador.getSalario());

            return repository.save(e);
        }).orElseGet(() -> {
            cargoTrabajador.setId(id);
            return repository.save(cargoTrabajador);
        });
    }

    @DeleteMapping("/cargo/{id}")
    public void deleteCargoTrabajador(@PathVariable Long id) throws Exception {
        Optional<CargoTrabajador> c =repository.findById(id);
        if (c.isPresent()){
            repository.delete(c.get());
        }else{
            throw new Exception("No se ha encontrado el cargo con el id :" +id);
        }
    }

}
