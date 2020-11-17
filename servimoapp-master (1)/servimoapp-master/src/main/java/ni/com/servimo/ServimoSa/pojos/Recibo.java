package ni.com.servimo.ServimoSa.pojos;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Recibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 8, unique = true)
    private String noRecibo;

    @Column(nullable = false, precision = 4)
    private float monto;

    @Column(precision = 4)
    private float montoMora;

    @Column(precision = 4)
    private float montoTotal;

    @Column(nullable = false, length = 250)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate FechaPago;

    @Column(nullable = false)
    private LocalDate fechaPagada;

    @JoinColumn
    @ManyToOne
    private Contrato contrato;

    @JoinColumn
    @ManyToOne
    private Empleado empleado;

    public Recibo() {
    }

    public Recibo(String noRecibo, float monto, float montoMora, float montoTotal, String descripcion, LocalDate fechaPago, LocalDate fechaPagada, Contrato contrato, Empleado empleado) {
        this.noRecibo = noRecibo;
        this.monto = monto;
        this.montoMora = montoMora;
        this.montoTotal = montoTotal;
        this.descripcion = descripcion;
        FechaPago = fechaPago;
        this.fechaPagada = fechaPagada;
        this.contrato = contrato;
        this.empleado = empleado;
    }

    public Recibo(Long id, String noRecibo, float monto, float montoMora, float montoTotal, String descripcion, LocalDate fechaPago, LocalDate fechaPagada, Contrato contrato, Empleado empleado) {
        this.id = id;
        this.noRecibo = noRecibo;
        this.monto = monto;
        this.montoMora = montoMora;
        this.montoTotal = montoTotal;
        this.descripcion = descripcion;
        FechaPago = fechaPago;
        this.fechaPagada = fechaPagada;
        this.contrato = contrato;
        this.empleado = empleado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoRecibo() {
        return noRecibo;
    }

    public void setNoRecibo(String noRecibo) {
        this.noRecibo = noRecibo;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getMontoMora() {
        return montoMora;
    }

    public void setMontoMora(float montoMora) {
        this.montoMora = montoMora;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        FechaPago = fechaPago;
    }

    public LocalDate getFechaPagada() {
        return fechaPagada;
    }

    public void setFechaPagada(LocalDate fechaPagada) {
        this.fechaPagada = fechaPagada;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recibo)) return false;
        Recibo recibo = (Recibo) o;
        return Float.compare(recibo.getMonto(), getMonto()) == 0 &&
                Float.compare(recibo.getMontoMora(), getMontoMora()) == 0 &&
                Float.compare(recibo.getMontoTotal(), getMontoTotal()) == 0 &&
                Objects.equals(getId(), recibo.getId()) &&
                Objects.equals(getNoRecibo(), recibo.getNoRecibo()) &&
                Objects.equals(getDescripcion(), recibo.getDescripcion()) &&
                Objects.equals(getFechaPago(), recibo.getFechaPago()) &&
                Objects.equals(getFechaPagada(), recibo.getFechaPagada()) &&
                Objects.equals(getContrato(), recibo.getContrato()) &&
                Objects.equals(getEmpleado(), recibo.getEmpleado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNoRecibo(), getMonto(), getMontoMora(), getMontoTotal(), getDescripcion(), getFechaPago(), getFechaPagada(), getContrato(), getEmpleado());
    }

    @Override
    public String toString() {
        return "Recibo{" +
                "id=" + id +
                ", noRecibo='" + noRecibo + '\'' +
                ", monto=" + monto +
                ", montoMora=" + montoMora +
                ", montoTotal=" + montoTotal +
                ", descripcion='" + descripcion + '\'' +
                ", FechaPago=" + FechaPago +
                ", fechaPagada=" + fechaPagada +
                ", contrato=" + contrato +
                ", empleado=" + empleado +
                '}';
    }
}