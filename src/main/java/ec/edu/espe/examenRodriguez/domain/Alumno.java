package ec.edu.espe.examenRodriguez.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "ALUMNO")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_ALUMNO", nullable = false)
    private Integer codAlumno;

    @Column(name = "CEDULA",length = 10,unique = true)
    private String cedula;

    @Column(name = "NOMBRE",length = 100)
    private String nombre;

    @Column(name = "FECHA_NACIMIENTO")
    private LocalDate fecNacimiento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_CREACION")
    private LocalDateTime fecCreacion;

    @Column(name = "COD_COLEGIO",insertable = false,updatable = false)
    private Integer codColegio;

    @ManyToOne()
    @JoinColumn(name = "COD_COLEGIO",nullable = false,updatable = false,insertable = true)
    private Colegio colegio;

    public Alumno() {

    }

    public Alumno(Integer codAlumno) {
        this.codAlumno = codAlumno;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "codAlumno=" + codAlumno +
                ", cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecNacimiento=" + fecNacimiento +
                ", fecCreacion=" + fecCreacion +
                ", codColegio=" + codColegio +
                ", colegio=" + colegio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(codAlumno, alumno.codAlumno) && Objects.equals(cedula, alumno.cedula) && Objects.equals(nombre, alumno.nombre) && Objects.equals(fecNacimiento, alumno.fecNacimiento) && Objects.equals(fecCreacion, alumno.fecCreacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAlumno, cedula, nombre, fecNacimiento, fecCreacion);
    }
}
