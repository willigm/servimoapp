package ni.com.servimo.ServimoSa.controlador;
import ni.com.servimo.ServimoSa.pojos.ContratoClienteJuridico;
import ni.com.servimo.ServimoSa.repositorio.ContratoClienteJuridicoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ContratoClienteJuridicoController {
    private ContratoClienteJuridicoRepository repository;

    public ContratoClienteJuridicoController(ContratoClienteJuridicoRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/contrato/clientes/juridico")
    public List<ContratoClienteJuridico> all(){
        return repository.findAll();
    }

    @GetMapping("/contrato/clientes/juridico/{id}")
    public ContratoClienteJuridico getContratoClienteJuridico(@PathVariable Long id) throws Exception{
        Optional<ContratoClienteJuridico> contratocliente = repository.findById(id);
        if (!contratocliente.isPresent()){
            new Exception("No se encontro el id " + id);
        }
        return contratocliente.get();
    }



    @PostMapping("/contrato/clientes/juridico")
    public ContratoClienteJuridico newContratoClieneJuridico(@RequestBody ContratoClienteJuridico contratoClienteJuridico) {
        return repository.save(contratoClienteJuridico);
    }

    @PutMapping("/contrato/clientes/juridico/{id}")
    public ContratoClienteJuridico updateContratoClienteJuridico(@RequestBody ContratoClienteJuridico contratoClienteJuridico, @PathVariable Long id){
        return repository.findById(id).map(c -> {
          c.setCostoservicio(c.getCostoservicio());
          c.setMoneda(c.getMoneda());
            return c;
        }).orElseGet(() -> {
            contratoClienteJuridico.setId(id);
            return repository.save(contratoClienteJuridico);
        });
    }

    @DeleteMapping("/contrato/clientes/juridico/{id}")
    public boolean deleteContratoClienteJuridico(@PathVariable Long id){
        Optional<ContratoClienteJuridico> contrato = repository.findById(id);
        if (contrato.isPresent()){
            repository.delete(contrato.get());
            return true;
        }
        return false;
    }
}
