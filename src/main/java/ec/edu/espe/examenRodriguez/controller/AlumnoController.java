package ec.edu.espe.examenRodriguez.controller;

import ec.edu.espe.examenRodriguez.domain.Alumno;
import ec.edu.espe.examenRodriguez.service.AlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/alumno")
public class AlumnoController {
    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }
    @PostMapping
    public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno alumno){
        try{
            Alumno alumnoTmp=alumnoService.crearAlumno(alumno);
            return ResponseEntity.ok(alumnoTmp);
        }catch (RuntimeException ex){
            return ResponseEntity.badRequest().build();
        }
    }


}
