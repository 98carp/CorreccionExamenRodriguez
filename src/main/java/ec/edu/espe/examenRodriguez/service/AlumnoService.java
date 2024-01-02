package ec.edu.espe.examenRodriguez.service;

import ec.edu.espe.examenRodriguez.service.exception.CreateException;
import ec.edu.espe.examenRodriguez.service.exception.NotFoundException;
import ec.edu.espe.examenRodriguez.dao.AlumnoRepository;
import ec.edu.espe.examenRodriguez.dao.ColegioRepository;
import ec.edu.espe.examenRodriguez.domain.Alumno;
import ec.edu.espe.examenRodriguez.domain.Colegio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AlumnoService {
    private  final AlumnoRepository alumnoRepository;
    private final ColegioRepository colegioRepository;

    public AlumnoService(AlumnoRepository alumnoRepository, ColegioRepository colegioRepository) {
        this.alumnoRepository = alumnoRepository;
        this.colegioRepository = colegioRepository;
    }

    public Alumno crearAlumno(Alumno alumno){
        Colegio colegio=this.colegioRepository.findColegiosByCodColegio(alumno.getColegio().getCodColegio());
        if (colegio == null) {
            throw new NotFoundException("Colegio no encontrado con el código: " + alumno.getColegio().getCodColegio());
        }
        LocalDate fechaActual = LocalDate.now();
        if (alumno.getFecNacimiento() != null && alumno.getFecNacimiento().isAfter(fechaActual)) {
            throw new CreateException("La fecha de nacimiento no puede ser posterior a la fecha actual");
        }

        return this.alumnoRepository.save(alumno);
    }




}
