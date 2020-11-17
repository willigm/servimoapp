package ni.com.servimo.ServimoSa.controlador;

import ni.com.servimo.ServimoSa.pojos.Contrato;
import ni.com.servimo.ServimoSa.pojos.Recibo;
import ni.com.servimo.ServimoSa.repositorio.ReciboRepository;
import ni.com.servimo.ServimoSa.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@RestController
public class ReciboController {
    private ReciboRepository repository;

    public ReciboController(ReciboRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtine todos los registros
     * @return Retorna los registros almacenados en bd
     */
    @GetMapping("/contrato/recibo")
    public List<Recibo> all(){
        return repository.findAll();
    }

    /**
     * Retorna un registro, el que coincida con el id
     * @param id requiere el id del registro
     * @return Retorna el registro con el id definido
     * @throws Exception Sino encuentra el id
     */
    @GetMapping("/contrato/recibo/{id}")
    public Recibo findById(@PathVariable Long id) throws Exception {
        Optional<Recibo> recibo = repository.findById(id);
        if (recibo.isPresent()){
            return recibo.get();
        }

        throw new Exception("No se ha encontrado el id: " + id);
    }

    /**
     * Busca por rango de fechas, si ambos parametros son pasados (el segundo es opcional),
     * si solo se pasa el primer parametro se buscara los recibos cuya fecha coincida con esa,
     * si search1 no es una fecha, entonces buscara por codigo de contrato
     * @param search1 Puede ser el codigo de contrato o la fecha inicial o fecha a buscar
     * @param search2 es la fecha final
     * @return Retorna los registros correspondientes a la cantidad de parametros pasada
     * @throws Exception si no se pasa ningun parametro.
     */
    @GetMapping("/contrato/recibo/")
    public List<Recibo> findByRecibo(@RequestParam(name = "search1") String search1, @RequestParam(name = "search2", required = false) String search2) throws Exception {
        if (search1 != null && search2 != null){
            return repository.findByFechaPagadaBetween(LocalDate.parse(search1, DateTimeFormatter.ofPattern("yyyy-M-dd")),
                    LocalDate.parse(search2, DateTimeFormatter.ofPattern("yyyy-M-dd")));
        }

        if (search1 != null){
            try{
                LocalDate fecha = LocalDate.parse(search1, DateTimeFormatter.ofPattern("yyyy-M-dd"));
                return repository.findByFechaPagadaEquals(fecha);
            }catch (DateTimeParseException e){
                System.out.println("No se logro convertir a una fecha");
            }
        }

        if (search1 != null) {
            search1 = StringUtils.addLikeNotation(search1);
            return repository.findByContrato_CodigoContratoLike(search1);
        }
        throw new Exception("Se requiere almenos un parametro");
    }

    /**
     * Guarda un nuevo recibo
     * @param recibo El recibo aguardar
     * @return Retorna el recibo que se ha guardado.
     */
    @PostMapping("/contrato/recibo/")
    public Recibo newRecibo(@RequestBody Recibo recibo){
        return repository.save(recibo);
    }

    /**
     * Actualiza un recibo
     * @param recibo Recibo a actualizar
     * @param id id del recibo a actualizar
     * @return El recibo actualizado
     */
    @PutMapping("/contrato/recibo/{id}")
    public Recibo updateRecibo(@RequestBody Recibo recibo, @PathVariable Long id){
        return repository.findById(id).map(r -> {
            r.setContrato(recibo.getContrato());
            r.setDescripcion(recibo.getDescripcion());
            r.setEmpleado(recibo.getEmpleado());
            r.setFechaPagada(recibo.getFechaPagada());
            r.setFechaPago(recibo.getFechaPago());
            r.setMonto(recibo.getMonto());
            r.setMontoMora(recibo.getMontoMora());
            r.setMontoTotal((recibo.getMontoTotal() + recibo.getMontoMora()) * 1.15f);
            r.setNoRecibo(recibo.getNoRecibo());
            return repository.save(r);
        }).orElseGet(()  ->{
            recibo.setId(id);
            return repository.save(recibo);
        });
    }

    /**
     * ELimina el registro
     * @param id del registro a eliminar
     * @return Retorna true si se elimina
     * @throws Exception Si no se encuentra un registro con el ID
     */
    @DeleteMapping("/contrato/recibo/{id}")
    public boolean deleteRecibo(@PathVariable Long id) throws Exception {
        Optional<Recibo> recibo = repository.findById(id);
        if (recibo.isPresent()){
            repository.delete(recibo.get());
            return true;
        }

        throw new Exception("No se ha encontrado el id: " + id);
    }
}
