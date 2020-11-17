package ni.com.servimo.ServimoSa.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Contrato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                //id contrato

    @Column(nullable = false, length = 5, unique = true)
    private String codigoContrato;  //codigo del contrato.

    @Column(columnDefinition = "DATETIME default GETDATE()",nullable = false)
    private LocalDate fechaContrato;//fecha en que se elaboro el contrato.

    @Column(nullable = true)
    private LocalDate fechaInicio;  //fecha en que el contrato se inicia.

    @Column(nullable = true)
    private LocalDate fechaExpira;  //fecha en que expira el contrato

    @Column(columnDefinition = "SMALLINT default 01", nullable = false)
    private int diaPago;            //dia del mes en que se paga

    @Column(columnDefinition = "SMALLINT default 0" , nullable = false)
    private Estado estado;          //estado del contrato

    public Contrato() {
    }

    public Contrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public Contrato(String codigoContrato, LocalDate fechaContrato, LocalDate fechaInicio, LocalDate fechaExpira, int diaPago, Estado estado) {
        this.codigoContrato = codigoContrato;
        this.fechaContrato = fechaContrato;
        this.fechaInicio = fechaInicio;
        this.fechaExpira = fechaExpira;
        this.diaPago = diaPago;
        this.estado = estado;
    }

    public Contrato(Long id, String codigoContrato, LocalDate fechaContrato, LocalDate fechaInicio, LocalDate fechaExpira, int diaPago, Estado estado) {
        this.id = id;
        this.codigoContrato = codigoContrato;
        this.fechaContrato = fechaContrato;
        this.fechaInicio = fechaInicio;
        this.fechaExpira = fechaExpira;
        this.diaPago = diaPago;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(LocalDate fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaExpira() {
        return fechaExpira;
    }

    public void setFechaExpira(LocalDate fechaExpira) {
        this.fechaExpira = fechaExpira;
    }

    public int getDiaPago() {
        return diaPago;
    }

    public void setDiaPago(int diaPago) {
        this.diaPago = diaPago;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contrato)) return false;
        Contrato contrato = (Contrato) o;
        return getDiaPago() == contrato.getDiaPago() &&
                Objects.equals(getId(), contrato.getId()) &&
                Objects.equals(getCodigoContrato(), contrato.getCodigoContrato()) &&
                Objects.equals(getFechaContrato(), contrato.getFechaContrato()) &&
                Objects.equals(getFechaInicio(), contrato.getFechaInicio()) &&
                Objects.equals(getFechaExpira(), contrato.getFechaExpira()) &&
                getEstado() == contrato.getEstado();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCodigoContrato(), getFechaContrato(), getFechaInicio(), getFechaExpira(), getDiaPago(), getEstado());
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id=" + id +
                ", codigoContrato='" + codigoContrato + '\'' +
                ", fechaContrato=" + fechaContrato +
                ", fechaInicio=" + fechaInicio +
                ", fechaExpira=" + fechaExpira +
                ", diaPago=" + diaPago +
                ", estado=" + estado +
                '}';
    }
}
