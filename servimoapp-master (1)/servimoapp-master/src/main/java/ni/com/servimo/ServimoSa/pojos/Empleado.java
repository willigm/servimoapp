package ni.com.servimo.ServimoSa.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Empleado extends Persona{
    @Column(nullable = false, unique = true, length = 5)
    private String codTrabajador;

    @Column(nullable = true)
    private byte[] foto;

    @Column(nullable = false, length = 255)
    private String direccion;

    @Column(nullable = false)
    private boolean estado;

    @ManyToOne
    @JoinColumn
    private CargoTrabajador cargo;

    public Empleado() {
    }

    public Empleado(String codTrabajador, byte[] foto, String direccion, boolean estado, CargoTrabajador cargo) {
        this.codTrabajador = codTrabajador;
        this.foto = foto;
        this.direccion = direccion;
        this.estado = estado;
        this.cargo = cargo;
    }

    public Empleado(Long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String noCedula, int edad, char sexo, String estadoCivil, String telefono, String codTrabajador, byte[] foto, String direccion, boolean estado, CargoTrabajador cargo) {
        super(id, primerNombre, segundoNombre, primerApellido, segundoApellido, noCedula, edad, sexo, estadoCivil, telefono);
        this.codTrabajador = codTrabajador;
        this.foto = foto;
        this.direccion = direccion;
        this.estado = estado;
        this.cargo = cargo;
    }

    public String getCodTrabajador() {
        return codTrabajador;
    }

    public void setCodTrabajador(String codTrabajador) {
        this.codTrabajador = codTrabajador;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public CargoTrabajador getCargo() {
        return cargo;
    }

    public void setCargo(CargoTrabajador cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empleado)) return false;
        if (!super.equals(o)) return false;
        Empleado empleado = (Empleado) o;
        return isEstado() == empleado.isEstado() &&
                Objects.equals(getCodTrabajador(), empleado.getCodTrabajador()) &&
                Arrays.equals(getFoto(), empleado.getFoto()) &&
                Objects.equals(getDireccion(), empleado.getDireccion()) &&
                Objects.equals(getCargo(), empleado.getCargo());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), getCodTrabajador(), getDireccion(), isEstado(), getCargo());
        result = 31 * result + Arrays.hashCode(getFoto());
        return result;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codTrabajador='" + codTrabajador + '\'' +
                ", foto=" + Arrays.toString(foto) +
                ", direccion='" + direccion + '\'' +
                ", estado=" + estado +
                ", cargo=" + cargo +
                '}';
    }
}
