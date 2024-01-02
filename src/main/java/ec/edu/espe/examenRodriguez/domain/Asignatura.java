package ec.edu.espe.examenRodriguez.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "ASIGNATURA")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_ASIGNATURA", nullable = false)
    private Integer codAsignatura;

    @Column(name = "NOMBRE",length = 100)
    private String nombre;

    @Column(name = "CREDITOS",length = 1)
    private Integer creditos;

    public Asignatura() {
    }

    public Asignatura(Integer codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return Objects.equals(codAsignatura, that.codAsignatura) && Objects.equals(nombre, that.nombre) && Objects.equals(creditos, that.creditos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAsignatura, nombre, creditos);
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "codAsignatura=" + codAsignatura +
                ", nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                '}';
    }
}
