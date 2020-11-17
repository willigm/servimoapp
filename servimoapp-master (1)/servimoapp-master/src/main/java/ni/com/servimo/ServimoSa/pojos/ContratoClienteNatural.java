package ni.com.servimo.ServimoSa.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class ContratoClienteNatural extends Contrato{
    @Column(nullable = false, precision = 2)
    private float costoSercio;
    @Column(nullable = false, length = 5)
    private String nomeda;

    @ManyToOne
    @JoinColumn
    private ClienteNatural clienteNatural;

    public ContratoClienteNatural() {
    }

    public ContratoClienteNatural(float costoSercio, String nomeda, ClienteNatural clienteNatural) {
        this.costoSercio = costoSercio;
        this.nomeda = nomeda;
        this.clienteNatural = clienteNatural;
    }

    public ContratoClienteNatural(String codigoContrato, LocalDate fechaContrato, LocalDate fechaInicio, LocalDate fechaExpira, int diaPago, Estado estado, float costoSercio, String nomeda, ClienteNatural clienteNatural) {
        super(codigoContrato, fechaContrato, fechaInicio, fechaExpira, diaPago, estado);
        this.costoSercio = costoSercio;
        this.nomeda = nomeda;
        this.clienteNatural = clienteNatural;
    }

    public ContratoClienteNatural(Long id, String codigoContrato, LocalDate fechaContrato, LocalDate fechaInicio, LocalDate fechaExpira, int diaPago, Estado estado, float costoSercio, String nomeda, ClienteNatural clienteNatural) {
        super(id, codigoContrato, fechaContrato, fechaInicio, fechaExpira, diaPago, estado);
        this.costoSercio = costoSercio;
        this.nomeda = nomeda;
        this.clienteNatural = clienteNatural;
    }

    public float getCostoSercio() {
        return costoSercio;
    }

    public void setCostoSercio(float costoSercio) {
        this.costoSercio = costoSercio;
    }

    public String getNomeda() {
        return nomeda;
    }

    public void setNomeda(String nomeda) {
        this.nomeda = nomeda;
    }

    public ClienteNatural getClienteNatural() {
        return clienteNatural;
    }

    public void setClienteNatural(ClienteNatural clienteNatural) {
        this.clienteNatural = clienteNatural;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContratoClienteNatural)) return false;
        if (!super.equals(o)) return false;
        ContratoClienteNatural that = (ContratoClienteNatural) o;
        return Float.compare(that.getCostoSercio(), getCostoSercio()) == 0 &&
                Objects.equals(getNomeda(), that.getNomeda()) &&
                Objects.equals(getClienteNatural(), that.getClienteNatural());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCostoSercio(), getNomeda(), getClienteNatural());
    }
}
