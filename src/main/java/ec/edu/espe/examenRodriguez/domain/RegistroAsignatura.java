package ec.edu.espe.examenRodriguez.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "ALUMNO_ASIGNATURA")
public class RegistroAsignatura {
    @EmbeddedId
    private RegistroAsignaturaPK registroAsignaturaCode;

    @Column(name = "CALIFICACION1", precision =4, scale = 2)
    private BigDecimal calif1;
    @Column(name = "CALIFICACION2", precision =4, scale = 2)
    private BigDecimal calif2;
    @Column(name = "CALIFICACION3", precision =4, scale = 2)
    private BigDecimal calif3;
    @Column(name = "PROMEDIO", precision =4, scale = 2)
    private BigDecimal promedio;

    @Column(name = "ESTADO",length = 3)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "COD_ALUMNO", referencedColumnName = "COD_ALUMNO", insertable = false, updatable = false, nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "COD_ASIGNATURA", referencedColumnName = "COD_ASIGNATURA", insertable = false, updatable = false, nullable = false)
    private Asignatura asignatura;

    public RegistroAsignatura() {
    }

    public RegistroAsignatura(RegistroAsignaturaPK registroAsignaturaCode) {
        this.registroAsignaturaCode = registroAsignaturaCode;
    }

    @Override
    public String toString() {
        return "RegistroAsignatura{" +
                "registroAsignaturaCode=" + registroAsignaturaCode +
                ", calif1=" + calif1 +
                ", calif2=" + calif2 +
                ", calif3=" + calif3 +
                ", promedio=" + promedio +
                ", estado='" + estado + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroAsignatura that = (RegistroAsignatura) o;
        return Objects.equals(registroAsignaturaCode, that.registroAsignaturaCode) && Objects.equals(calif1, that.calif1) && Objects.equals(calif2, that.calif2) && Objects.equals(calif3, that.calif3) && Objects.equals(promedio, that.promedio) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registroAsignaturaCode, calif1, calif2, calif3, promedio, estado);
    }
}
