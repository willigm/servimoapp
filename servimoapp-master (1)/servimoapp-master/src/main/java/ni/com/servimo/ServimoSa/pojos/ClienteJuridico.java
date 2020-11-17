package ni.com.servimo.ServimoSa.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ClienteJuridico {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @Column(nullable = false, length = 40)
    private String noRuc;
    @Column(nullable = false, length = 40)
    private String nombre;
    @Column(nullable = false, length = 40)
    private String correo;
    @Column(nullable = false, length = 10)
    private String telefono;
    @Column(nullable = false, length = 60)
    private String direccion;

    public ClienteJuridico() {

    }

    public ClienteJuridico(Long id, String noRuc, String nombre, String correo, String telefono, String direccion) {
        this.id=id;
        this.noRuc = noRuc;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoRuc() {
        return noRuc;
    }

    public void setNoRuc(String noRuc) {
        this.noRuc = noRuc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteJuridico that = (ClienteJuridico) o;
        return Objects.equals(noRuc, that.noRuc) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(correo, that.correo) &&
                Objects.equals(telefono, that.telefono) &&
                Objects.equals(direccion, that.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noRuc, nombre, correo, telefono, direccion);
    }

    @Override
    public String toString() {
        return "clienteJuridico{" +
                "noRuc='" + noRuc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

}
