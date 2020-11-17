package ni.com.servimo.ServimoSa.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;
@Entity
public class Representante  extends Persona{
    @Column(nullable = false, length = 70)
     private  String cargoRepresentante;
    @ManyToOne
    @JoinColumn
    private ClienteJuridico noRuc;

    public Representante() {
    }

    public Representante(Long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String noCedula, int edad, char sexo, String estadoCivil, String telefono, String cargoRepresentante, ClienteJuridico noRuc) {
        super(id, primerNombre, segundoNombre, primerApellido, segundoApellido, noCedula, edad, sexo, estadoCivil, telefono);
        this.cargoRepresentante = cargoRepresentante;
        this.noRuc = noRuc;
    }

    public Representante(String cargoRepresentante, ClienteJuridico noRuc) {
        this.cargoRepresentante = cargoRepresentante;
        this.noRuc = noRuc;
    }

    public String getCargoRepresentante() {
        return cargoRepresentante;
    }

    public void setCargoRepresentante(String cargoRepresentante) {
        this.cargoRepresentante = cargoRepresentante;
    }

    public ClienteJuridico getNoRuc() {
        return noRuc;
    }

    public void setNoRuc(ClienteJuridico noRuc) {
        this.noRuc = noRuc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Representante that = (Representante) o;
        return Objects.equals(cargoRepresentante, that.cargoRepresentante) &&
                Objects.equals(noRuc, that.noRuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargoRepresentante, noRuc);
    }

    @Override
    public String toString() {
        return "Representante{" +
                "cargoRepresentante='" + cargoRepresentante + '\'' +
                ", noRuc=" + noRuc +
                '}';
    }

}
