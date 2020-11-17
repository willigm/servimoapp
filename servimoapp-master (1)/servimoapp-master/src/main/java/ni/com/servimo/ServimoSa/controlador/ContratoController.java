package ni.com.servimo.ServimoSa.controlador;

import ni.com.servimo.ServimoSa.pojos.Contrato;
import ni.com.servimo.ServimoSa.pojos.Estado;
import ni.com.servimo.ServimoSa.repositorio.ContratoRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
public class ContratoController {
    /**
     * Auto Iject by Spring Framework
     */
    private ContratoRepository repository;

    public ContratoController(ContratoRepository repository){this.repository = repository;}

    /**
     * Obtiene todos los registros
     * @return Regresa todos los registros sin ningun criterio
     */
    @GetMapping("/contrato")
    public List<Contrato> all(){
        return repository.findAll();
    }

    /**
     * Obtiene el contrato especifico
     * @param id Ide logico del contrato
     * @return Objeto que representa un contrato
     */
    @GetMapping("/contrato/{id}")
    public Contrato getContrato(@PathVariable Long id) throws Exception{
        Optional<Contrato> contrato = repository.findById(id);
        if (!contrato.isPresent()){
            new Exception("No se encontro el id " + id);
        }
        return contrato.get();
    }

    /**
     * Contratos por estado
     * @param estado el estado del contrato {ACTIVO, INACTIVO}
     * @return Retorna todos los contratos que coincidan con el estado especificado
     */
    @GetMapping("/contrato/estados/")
    public List<Contrato> getContratoByEstado(@RequestParam(name = "estado", required = false, defaultValue = "ACTIVO") Estado estado){
        return  repository.findByEstadoEquals(estado);
    }

    /**
     * Obtiene un contrato Especifico
     * @param codigo codigo fisico del contrato
     * @return Devuelve un objeto que representa el contrato fisico
     */
    @GetMapping("/contrato/codigos/{codigo}")
    public Contrato getContratoByCodigo(@PathVariable String codigo){
        return  repository.findByCodigoContratoEquals(codigo);
    }

    /**
     * Contratos por rango de fechas
     * @param fecha1 fecha inicial
     * @param fecha2 fecha final
     * @return Obtiene los contrato por fecha de creacion en un rango de fechas
     */
    @GetMapping("/contrato/fechas")
    public List<Contrato> getContratoByFechas(
            @RequestParam(name = "f1", required = false, defaultValue = "2020-11-06") String fecha1,
            @RequestParam(name = "f2", required = false, defaultValue = "2020-11-31") String fecha2){
        System.out.println("FindFechas: " + fecha1 + " a " + fecha2);
        return  repository.findByFechaContratoBetween(
                LocalDate.parse(fecha1, DateTimeFormatter.ofPattern("yyyy-M-dd")),
                LocalDate.parse(fecha1, DateTimeFormatter.ofPattern("yyyy-M-dd")));
    }

    @PostMapping("/contrato")
    public Contrato newContrato(@RequestBody Contrato contrato) {return repository.save(contrato);}

    @PutMapping("/contrato/{id}")
    public Contrato updateContrato(@RequestBody Contrato contrato, @PathVariable Long id){
        return repository.findById(id).map(c -> {
            c.setCodigoContrato(contrato.getCodigoContrato());
            c.setDiaPago(contrato.getDiaPago());
            c.setEstado(contrato.getEstado());
            c.setFechaContrato(contrato.getFechaContrato());
            c.setFechaExpira(contrato.getFechaExpira());
            c.setFechaInicio(contrato.getFechaInicio());
            return c;
        }).orElseGet(() -> {
            contrato.setId(id);
            return repository.save(contrato);
        });
    }

    @DeleteMapping("/contrato/{id}")
    public boolean deleteContrato(@PathVariable Long id){
        Optional<Contrato> contrato = repository.findById(id);
        if (contrato.isPresent()){
            repository.delete(contrato.get());
            return true;
        }
        return false;
    }
}
