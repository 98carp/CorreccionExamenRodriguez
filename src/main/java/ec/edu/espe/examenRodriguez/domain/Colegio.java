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
@Table(name = "COLEGIO")
public class Colegio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_COLEGIO", nullable = false)
    private Integer codColegio;

    @Column(name = "NOMBRE",length = 100)
    private String nombre;

    public Colegio() {
    }

    public Colegio(Integer codColegio) {
        this.codColegio = codColegio;
    }

    @Override
    public String toString() {
        return "Colegio{" +
                "codColegio=" + codColegio +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colegio colegio = (Colegio) o;
        return Objects.equals(codColegio, colegio.codColegio) && Objects.equals(nombre, colegio.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codColegio, nombre);
    }
}
