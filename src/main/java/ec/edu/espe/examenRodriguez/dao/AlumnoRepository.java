package ec.edu.espe.examenRodriguez.dao;

import ec.edu.espe.examenRodriguez.domain.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {
    Alumno findAlumnoByCedula(String cedula);
}
