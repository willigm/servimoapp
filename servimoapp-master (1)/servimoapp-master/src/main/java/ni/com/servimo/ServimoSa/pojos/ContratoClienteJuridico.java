package ni.com.servimo.ServimoSa.pojos;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class ContratoClienteJuridico extends Contrato {

    @Column(nullable = false)
    private String Costoservicio;
    @Column(nullable = false, length = 15)
    private String moneda;
    @ManyToOne
    @JoinColumn
    private ClienteJuridico noRuc;


    public ContratoClienteJuridico() {
    }

    public ContratoClienteJuridico(String codigoContrato, LocalDate fechaContrato, LocalDate fechaInicio, LocalDate fechaExpira, int diaPago, Estado estado, String costoservicio, String moneda, ClienteJuridico noRuc) {
        super(codigoContrato, fechaContrato, fechaInicio, fechaExpira, diaPago, estado);
        Costoservicio = costoservicio;
        this.moneda = moneda;
        this.noRuc = noRuc;
    }

    public ContratoClienteJuridico(Long id, String codigoContrato, LocalDate fechaContrato, LocalDate fechaInicio, LocalDate fechaExpira, int diaPago, Estado estado, String costoservicio, String moneda, ClienteJuridico noRuc) {
        super(id, codigoContrato, fechaContrato, fechaInicio, fechaExpira, diaPago, estado);
        Costoservicio = costoservicio;
        this.moneda = moneda;
        this.noRuc = noRuc;
    }

    public ContratoClienteJuridico(String costoservicio, String moneda, ClienteJuridico noRuc) {
        Costoservicio = costoservicio;
        this.moneda = moneda;
        this.noRuc = noRuc;
    }

    public String getCostoservicio() {
        return Costoservicio;
    }

    public void setCostoservicio(String costoservicio) {
        Costoservicio = costoservicio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
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
        ContratoClienteJuridico that = (ContratoClienteJuridico) o;
        return Objects.equals(Costoservicio, that.Costoservicio) &&
                Objects.equals(moneda, that.moneda) &&
                Objects.equals(noRuc, that.noRuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Costoservicio, moneda, noRuc);
    }

    @Override
    public String toString() {
        return "ContratoClienteJuridico{" +
                "Costoservicio='" + Costoservicio + '\'' +
                ", moneda='" + moneda + '\'' +
                ", noRuc=" + noRuc +
                '}';
    }
}
