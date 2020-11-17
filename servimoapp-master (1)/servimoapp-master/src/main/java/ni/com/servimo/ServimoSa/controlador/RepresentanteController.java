package ni.com.servimo.ServimoSa.controlador;
import ni.com.servimo.ServimoSa.pojos.ClienteJuridico;
import ni.com.servimo.ServimoSa.pojos.Empleado;
import ni.com.servimo.ServimoSa.pojos.Representante;
import ni.com.servimo.ServimoSa.repositorio.RepresentanteRepository;
import ni.com.servimo.ServimoSa.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RepresentanteController {
private RepresentanteRepository repository;

    public RepresentanteController(RepresentanteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/representante")
    public List<Representante> all(){
        return repository.findAll();
    }

    @GetMapping("/representante/")
    public List<Representante> findByNoCedulaLikeOrPrimerNombreLike(@RequestParam(name = "search") String  search){
        search = StringUtils.addLikeNotation(search);
        return repository.findByNoCedulaLikeOrPrimerNombreLike(search,search);
    }



    @PostMapping("/representante")
    public Representante newRepresentante(@RequestBody Representante representante){
        return repository.save(representante);
    }

    @PutMapping("/representante/{id}")
    public Representante updateRepresentante(@RequestBody Representante representante, @PathVariable Long id){
        return repository.findById(id).map(e -> {
            e.setCargoRepresentante(representante.getCargoRepresentante());
            e.setEdad(representante.getEdad());
            e.setEstadoCivil(representante.getEstadoCivil());
            e.setNoCedula(representante.getNoCedula());
            e.setPrimerApellido(representante.getPrimerApellido());
            e.setPrimerNombre(representante.getPrimerNombre());
            e.setSegundoApellido(representante.getSegundoApellido());
            e.setSegundoNombre(representante.getSegundoNombre());
            e.setSexo(representante.getSexo());
            e.setTelefono(representante.getTelefono());
            return repository.save(e);
        }).orElseGet(() -> {
            representante.setId(id);
            return repository.save(representante);
        });
    }

    @DeleteMapping("/representante/{id}")
    public void deleteRepresentante(@PathVariable Long id) throws Exception {
        Optional<Representante> e = repository.findById(id);
        if(e.isPresent()){
            repository.delete(e.get());
        }else{
            throw new Exception("No se ha encontrado el representante con el id :" +id);
        }

    }
}
