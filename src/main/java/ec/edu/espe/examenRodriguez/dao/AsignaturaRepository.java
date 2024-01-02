package ec.edu.espe.examenRodriguez.dao;
import ec.edu.espe.examenRodriguez.domain.Alumno;
import ec.edu.espe.examenRodriguez.domain.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura,Integer> {
    Asignatura findAsignaturaByCodAsignatura(Integer codeAsignatura);
}
