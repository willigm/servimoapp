package ni.com.servimo.ServimoSa.controlador;

import ni.com.servimo.ServimoSa.pojos.Persona;
import ni.com.servimo.ServimoSa.repositorio.PersonaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    private final PersonaRepository repository;

    public PersonaController(PersonaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persona")
    public List<Persona> all(){
        return repository.findAll();
    }

    @PostMapping("/persona")
    public Persona newPersona(@RequestBody Persona persona){
        return repository.save(persona);
    }

    @PutMapping("/persona/{id}")
    public Persona newPersona(@RequestBody Persona persona, @PathVariable Long id){
        return repository.findById(id).map(e -> {
            e.setPrimerNombre(persona.getPrimerNombre());
            e.setSegundoNombre(persona.getSegundoNombre());
            e.setPrimerApellido(persona.getPrimerApellido());
            e.setEdad(persona.getEdad());
            e.setSexo(persona.getSexo());
            e.setEstadoCivil(persona.getEstadoCivil());
            e.setNoCedula(persona.getNoCedula());
            e.setTelefono(persona.getTelefono());
            return repository.save(e);
        }).orElseGet(() -> {
            persona.setId(id);
            return repository.save(persona);
        });
    }

    @DeleteMapping("/persona/{id}")
    public void deletePersona(@PathVariable Long id){
        repository.delete(repository.findById(id).get());
    }


}
