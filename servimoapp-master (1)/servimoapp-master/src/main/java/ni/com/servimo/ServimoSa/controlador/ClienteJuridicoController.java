package ni.com.servimo.ServimoSa.controlador;

import ni.com.servimo.ServimoSa.pojos.ClienteJuridico;
import ni.com.servimo.ServimoSa.pojos.ClienteNatural;
import ni.com.servimo.ServimoSa.repositorio.ClienteJuridicoRepository;
import ni.com.servimo.ServimoSa.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class ClienteJuridicoController {
    private ClienteJuridicoRepository repository;

    public ClienteJuridicoController(ClienteJuridicoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/clientes/Juridico")
    public List<ClienteJuridico> all() {
        return repository.findAll();
    }

    @PostMapping("/clientes/Juridico")
    public ClienteJuridico newclienteJuridico(@RequestBody ClienteJuridico clienteJuridico) {
        return repository.save(clienteJuridico);
    }
    /**
     * Busca por primer nombre, noRuc, correo electronico
     * @param search valor a buscar
     * @return Retorna las coincidencias de la busqueda
     */
    @GetMapping("/clientes/Juridico/")
    public List<ClienteJuridico> getClienteJuridicoSearch(@RequestParam(name = "search") String search){
        search = StringUtils.addLikeNotation(search);
        return repository.findByNoRucLikeOrCorreoLikeOrNombreLike(search, search , search);
    }
    @GetMapping("/clientes/Juridico/{id}")
    public ClienteJuridico getclienteJuridicobyid(@PathVariable Long id) throws Exception {
        Optional<ClienteJuridico> c = repository.findById(id);
        if (c.isPresent()) {
            return c.get();
        } else {
            throw new Exception("No se ha encontrado el cliente con el id :" + id);

        }
    }

    @PutMapping("/clientes/Juridico/{id}")
    public ClienteJuridico updateclienteJuridico(@RequestBody ClienteJuridico clienteJuridico, @PathVariable Long id) {
        return repository.findById(id).map(e -> {
            e.setNoRuc(clienteJuridico.getNoRuc());
            e.setNombre(clienteJuridico.getNombre());
            e.setCorreo(clienteJuridico.getCorreo());
            e.setTelefono(clienteJuridico.getTelefono());
            e.setDireccion(clienteJuridico.getDireccion());

            return repository.save(e);
        }).orElseGet(() -> {
            clienteJuridico.setId(id);
            return repository.save(clienteJuridico);

        });
    }

    @DeleteMapping("/clientes/Juridico/{id}")
    public void deleteclienteJuridico(@PathVariable Long id) throws Exception {
        Optional<ClienteJuridico> c = repository.findById(id);
        if (c.isPresent()) {
            repository.delete(c.get());
        } else {
            throw new Exception("No se ha encontrado el cliente con el id :" + id);

        }
    }
}
