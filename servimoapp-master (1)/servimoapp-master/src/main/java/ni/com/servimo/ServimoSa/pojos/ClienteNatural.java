package ni.com.servimo.ServimoSa.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class ClienteNatural extends Persona{

    @Column(nullable = false, length = 50, unique = true)
    private String correo;

    @Column(nullable = false, length = 250)
    private String direccion;

    public ClienteNatural() {
    }

    public ClienteNatural(String correo, String direccion) {
        this.correo = correo;
        this.direccion = direccion;
    }

    public ClienteNatural(Long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String noCedula, int edad, char sexo, String estadoCivil, String telefono, String correo, String direccion) {
        super(id, primerNombre, segundoNombre, primerApellido, segundoApellido, noCedula, edad, sexo, estadoCivil, telefono);
        this.correo = correo;
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        if (!(o instanceof ClienteNatural)) return false;
        if (!super.equals(o)) return false;
        ClienteNatural that = (ClienteNatural) o;
        return Objects.equals(getCorreo(), that.getCorreo()) &&
                Objects.equals(getDireccion(), that.getDireccion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCorreo(), getDireccion());
    }

    @Override
    public String toString() {
        return "ClienteNatural{" +
                "correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
