package ec.edu.espe.examenRodriguez.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@Embeddable
public class RegistroAsignaturaPK implements Serializable {

    @Column(name = "COD_ALUMNO", nullable = false)
    private Integer codAlumno;

    @Column(name = "COD_ASIGNATURA", nullable = false)
    private Integer codAsignatura;

    public RegistroAsignaturaPK() {
    }

    public RegistroAsignaturaPK(Integer codAlumno, Integer codAsignatura) {
        this.codAlumno = codAlumno;
        this.codAsignatura = codAsignatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroAsignaturaPK that = (RegistroAsignaturaPK) o;
        return Objects.equals(codAlumno, that.codAlumno) && Objects.equals(codAsignatura, that.codAsignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAlumno, codAsignatura);
    }
}
