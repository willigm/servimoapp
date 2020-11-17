package ni.com.servimo.ServimoSa.controlador;

import ni.com.servimo.ServimoSa.pojos.ClienteNatural;
import ni.com.servimo.ServimoSa.repositorio.ClienteNaturalRepository;
import ni.com.servimo.ServimoSa.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteNaturalController {
    /**
     * Auto injeccion de spring framework
     */
    private ClienteNaturalRepository repository;

    /**
     * Injecta la propiedada repository via constructor
     * @param repository Instancia de una clase que implementa la interfaz ClienteNaturalRepository
     */
    public ClienteNaturalController(ClienteNaturalRepository repository) {
        this.repository = repository;
    }

    /**
     * Metodo que devuelve todos los registros
     * @return todos los registros
     */
    @GetMapping("/clientes/natural")
    public List<ClienteNatural> all(){
        return repository.findAll();
    }

    /**
     * Devuelve la coincidencia de un registro
     * @param id id del registro
     * @return Retorna el registro encontrado
     * @throws Exception No existe el ide expecificado
     */
    @GetMapping("/clientes/natural/{id}")
    public ClienteNatural getClienteNatural(@PathVariable Long id) throws Exception{
        Optional<ClienteNatural> clienteNatural = repository.findById(id);
        if (!clienteNatural.isPresent()){
            throw new Exception("No se encontro el cliente con id: "+ id);
        }
        return clienteNatural.get();
    }

    /**
     * Busca por primer nombre, noCedula, correo electronico
     * @param search valor a buscar
     * @return Retorna las coincidencias de la busqueda
     */
    @GetMapping("/clientes/natural/")
    public List<ClienteNatural> getClientNaturalSearch(@RequestParam(name = "search") String search){
        search = StringUtils.addLikeNotation(search);
        return repository.findByNoCedulaLikeOrCorreoLikeOrPrimerNombreLike(search, search , search);
    }

    /**
     * Agrega un Cliente Natural a la base de datos
     * @param clienteNatural Cliente Natural que se agregara
     * @return Retorna el objeto creado en base de datos con su identity
     */
    @PostMapping("/clientes/natural/")
    public ClienteNatural newClienteNatural(@RequestBody ClienteNatural clienteNatural){
        return repository.save(clienteNatural);
    }

    /**
     * Actualiza un objeto mediante su id, si no lo encuentra lo agrega
     * @param clienteNatural Objeto con las actualizaciones
     * @param id Id del objeto a actualizar
     * @return Reporta el objeto actualizado en base de datos.
     */
    @PutMapping("/clientes/natural/{id}")
    public ClienteNatural updateClienteNatural(@RequestBody ClienteNatural clienteNatural, Long id){
        return repository.findById(id).map(c -> {
            c.setCorreo(clienteNatural.getCorreo());
            c.setDireccion(clienteNatural.getDireccion());
            c.setEdad(clienteNatural.getEdad());
            c.setEstadoCivil(clienteNatural.getEstadoCivil());
            c.setNoCedula(clienteNatural.getNoCedula());
            c.setPrimerApellido(clienteNatural.getPrimerApellido());
            c.setSegundoApellido(clienteNatural.getSegundoApellido());
            c.setSegundoNombre(clienteNatural.getSegundoNombre());
            c.setSexo(clienteNatural.getSexo());
            c.setTelefono(clienteNatural.getTelefono());
            return c;
        }).orElseGet(() -> {
            clienteNatural.setId(id);
            return repository.save(clienteNatural);
        });
    }

    /**
     * Elimina un registro
     * @param id id del registro a eliminar
     * @return Retorna true si se elimino
     * @throws Exception Exepcion es lanzada si no se encuentra el registro a eliminar.
     */
    @DeleteMapping("/clientes/natural/{id}")
    public boolean deleteClienteNatural(@PathVariable Long id) throws Exception{
        Optional<ClienteNatural> c = repository.findById(id);

        if (!c.isPresent()){
            throw new Exception("No se encontro el registro con identificadot " + id);
        }
        repository.delete(c.get());
        return true;
    }
}
