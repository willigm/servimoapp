package ni.com.servimo.ServimoSa.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CargoTrabajador {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @Column(nullable = false, length = 25)
    private String nombreCargo;
    @Column(nullable = false, precision = 2)
    private float salario;
    @Column(nullable = false, length = 5)
    private String moneda;

    public CargoTrabajador() {
    }

    public CargoTrabajador(Long id, String nombreCargo, float salario, String moneda) {
        this.id = id;
        this.nombreCargo = nombreCargo;
        this.salario = salario;
        this.moneda = moneda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CargoTrabajador)) return false;
        CargoTrabajador that = (CargoTrabajador) o;
        return Float.compare(that.getSalario(), getSalario()) == 0 &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getNombreCargo(), that.getNombreCargo()) &&
                Objects.equals(getMoneda(), that.getMoneda());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombreCargo(), getSalario(), getMoneda());
    }

    @Override
    public String toString() {
        return "CargoTrabajador{" +
                "id=" + id +
                ", nombreCargo='" + nombreCargo + '\'' +
                ", salario=" + salario +
                ", moneda='" + moneda + '\'' +
                '}';
    }
}
