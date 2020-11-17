package ni.com.servimo.ServimoSa.controlador;

import ni.com.servimo.ServimoSa.pojos.ClienteNatural;
import ni.com.servimo.ServimoSa.pojos.ContratoClienteNatural;
import ni.com.servimo.ServimoSa.repositorio.ContratoClienteNaturalRepository;
import ni.com.servimo.ServimoSa.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class ContratoClienteNaturalController {
    private ContratoClienteNaturalRepository repository;

    public ContratoClienteNaturalController(ContratoClienteNaturalRepository repository) {
        this.repository = repository;
    }

    /**
     * Metodo que devuelve todos los registros
     * @return todos los registros
     */
    @GetMapping("/contrato/clientes/natural")
    public List<ContratoClienteNatural> all(){
        return repository.findAll();
    }

    /**
     * Devuelve la coincidencia de un registro
     * @param id del contrato general
     * @return Retorna el registro encontrado
     * @throws Exception No existe el codigo expecificado
     */
    @GetMapping("/contrato/clientes/natural/{id}")
    public ContratoClienteNatural getContratoClienteNatural(@PathVariable Long id) throws Exception{
        Optional<ContratoClienteNatural> contratoClienteNatural = repository.findById(id);
        if (!contratoClienteNatural.isPresent()){
            throw new Exception("No se encontro el cliente con id: "+ id);
        }
        return contratoClienteNatural.get();
    }

    /**
     * Busca contratos en intervalos de dos fechas
     * @param fechaIncio Fecha inicial
     * @param fechaFin Fecha final que es opcional
     * @return  Si se pasa la fecha inicia, retorna los contratos cuyo dia de pago es el establecido
     *          si se pasan la fecha de inicio y la fecha final obtiene los contratos cuyas fechas de contratacion estan en el rango.
     */
    @GetMapping("/contrato/clientes/natural/")
    public List<ContratoClienteNatural> getContratoClienteNaturalSearch(@RequestParam(name = "fechaIncio") String fechaIncio, @RequestParam(name = "fechaFin", required = false) String fechaFin) throws Exception {

        if (fechaIncio != null && fechaIncio.length() > 0 && fechaFin != null && fechaFin.length() > 0)
            return repository.findByFechaContratoBetweenOrderByFechaContrato(LocalDate.parse(fechaIncio),LocalDate.parse(fechaFin));
        if (fechaIncio != null && fechaIncio.length() > 0 )
            return repository.findByDiaPagoEquals(LocalDate.parse(fechaIncio).getDayOfMonth());

        throw new Exception("Los parametros especificados no son correctos para buscar por fechas.");
    }

    /**
     * Agrega contrato cliente natural
     * @param contratoClienteNatural Cliente Natural que se agregara
     * @return Retorna el objeto creado en base de datos con su identity
     */
    @PostMapping("/contrato/clientes/natural/")
    public ContratoClienteNatural newContratoClienteNatural(@RequestBody ContratoClienteNatural contratoClienteNatural){
        return repository.save(contratoClienteNatural);
    }

    /**
     * Actualiza un objeto mediante su id, si no lo encuentra lo agrega
     * @param contrato Objeto con las actualizaciones
     * @param id Id del objeto a actualizar
     * @return Reporta el objeto actualizado en base de datos.
     */
    @PutMapping("/contrato/clientes/natural/{id}")
    public ContratoClienteNatural updateContratoClienteNatural(@RequestBody ContratoClienteNatural contrato,@PathVariable Long id){
        return repository.findById(id).map(c -> {
            c.setCodigoContrato(contrato.getCodigoContrato());
            c.setDiaPago(contrato.getDiaPago());
            c.setEstado(contrato.getEstado());
            c.setFechaContrato(contrato.getFechaContrato());
            c.setFechaExpira(contrato.getFechaExpira());
            c.setFechaInicio(contrato.getFechaInicio());
            c.setCostoSercio(contrato.getCostoSercio());
            c.setNomeda(contrato.getNomeda());
            repository.save(c);
            return c;
        }).orElseGet(() -> {
            contrato.setId(id);
            return repository.save(contrato);
        });
    }

    /**
     * Elimina un registro
     * @param id id del registro a eliminar
     * @return Retorna true si se elimino
     * @throws Exception Exepcion es lanzada si no se encuentra el registro a eliminar.
     */
    @DeleteMapping("/contrato/clientes/natural/{id}")
    public boolean deleteClienteNatural(@PathVariable Long id) throws Exception{
        Optional<ContratoClienteNatural> c = repository.findById(id);

        if (!c.isPresent()){
            throw new Exception("No se encontro el registro con identificador " + id);
        }
        repository.delete(c.get());
        return true;
    }
}
