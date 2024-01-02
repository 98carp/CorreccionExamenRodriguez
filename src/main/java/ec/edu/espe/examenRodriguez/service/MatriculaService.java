package ec.edu.espe.examenRodriguez.service;

import ec.edu.espe.examenRodriguez.dao.AlumnoRepository;
import ec.edu.espe.examenRodriguez.dao.AsignaturaRepository;
import ec.edu.espe.examenRodriguez.dao.RegistroAsignaturaRepository;
import ec.edu.espe.examenRodriguez.domain.Alumno;
import ec.edu.espe.examenRodriguez.domain.Asignatura;
import ec.edu.espe.examenRodriguez.domain.RegistroAsignatura;
import ec.edu.espe.examenRodriguez.service.exception.AsignException;
import ec.edu.espe.examenRodriguez.service.exception.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {
    private final AlumnoRepository alumnoRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final RegistroAsignaturaRepository registroAsignaturaRepository;

    public MatriculaService(AlumnoRepository alumnoRepository, AsignaturaRepository asignaturaRepository, RegistroAsignaturaRepository registroAsignaturaRepository) {
        this.alumnoRepository = alumnoRepository;
        this.asignaturaRepository = asignaturaRepository;
        this.registroAsignaturaRepository = registroAsignaturaRepository;
    }

    public RegistroAsignatura asignaEstudiante(String alumnoCedula, Integer asignaturaCode){
        Alumno alumnoTemp=this.alumnoRepository.findAlumnoByCedula(alumnoCedula);
        Asignatura asignaturaTemp=this.asignaturaRepository.findAsignaturaByCodAsignatura(asignaturaCode);
        if (alumnoTemp==null){
            throw new NotFoundException("Alumno no encontrado con la cedula: " + alumnoCedula);
        }
        if (asignaturaTemp==null){
            throw new NotFoundException("Asignatura no encontrado con el código: " + asignaturaCode);
        }
        RegistroAsignatura registroAsignatura=this.registroAsignaturaRepository.findRegistroAsignaturaByAsignaturaAndAlumno(asignaturaTemp,alumnoTemp);
        if (registroAsignatura!=null){
            throw new AsignException("No se puede asignar al estudiante "+alumnoTemp.getNombre()+" a la asignatura "+asignaturaTemp.getNombre()+" debido a que ya se encuentra asignado");
        }
        registroAsignatura=new RegistroAsignatura();
        registroAsignatura.setAsignatura(asignaturaTemp);
        registroAsignatura.setAlumno(alumnoTemp);
        registroAsignatura.setEstado("ACT");
        this.registroAsignaturaRepository.save(registroAsignatura);


        return registroAsignatura;
    }

}
