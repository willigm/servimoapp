package ni.com.servimo.ServimoSa.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    public Persona() {
    }

    public Persona(Long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String noCedula, int edad, char sexo, String estadoCivil, String telefono) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.noCedula = noCedula;
        this.edad = edad;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.telefono = telefono;
    }

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @Column(nullable = false, length = 50)
    private String primerNombre;

    @Column(length = 50)
    private String segundoNombre;

    @Column(nullable = false, length = 50)
    private String primerApellido;

    @Column(length = 50)
    private String segundoApellido;

    @Column(nullable = false, length = 16, unique = true)
    private String noCedula;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false, length = 1)
    private char sexo;

    @Column(nullable = false, length = 50)
    private String estadoCivil;

    @Column(nullable = false, length = 15)
    private String telefono;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNoCedula() {
        return noCedula;
    }

    public void setNoCedula(String noCedula) {
        this.noCedula = noCedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return getEdad() == persona.getEdad() &&
                getSexo() == persona.getSexo() &&
                Objects.equals(getId(), persona.getId()) &&
                Objects.equals(getPrimerNombre(), persona.getPrimerNombre()) &&
                Objects.equals(getSegundoNombre(), persona.getSegundoNombre()) &&
                Objects.equals(getPrimerApellido(), persona.getPrimerApellido()) &&
                Objects.equals(getSegundoApellido(), persona.getSegundoApellido()) &&
                Objects.equals(getNoCedula(), persona.getNoCedula()) &&
                Objects.equals(getEstadoCivil(), persona.getEstadoCivil()) &&
                Objects.equals(getTelefono(), persona.getTelefono());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrimerNombre(), getSegundoNombre(), getPrimerApellido(), getSegundoApellido(), getNoCedula(), getEdad(), getSexo(), getEstadoCivil(), getTelefono());
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", primerNombre='" + primerNombre + '\'' +
                ", segundoNombre='" + segundoNombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", noCedula='" + noCedula + '\'' +
                ", edad=" + edad +
                ", sexo=" + sexo +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}