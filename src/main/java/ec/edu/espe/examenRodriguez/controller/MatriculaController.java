package ec.edu.espe.examenRodriguez.controller;

import ec.edu.espe.examenRodriguez.domain.RegistroAsignatura;
import ec.edu.espe.examenRodriguez.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/matricula")
public class MatriculaController {
    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping("/registroAsignatura/{alumnoCedula}/{asignaturaCode}")
    public ResponseEntity<RegistroAsignatura> asignaEstudiante(
            @PathVariable(name = "alumnoCedula") String alumnoCedula,
            @PathVariable(name = "asignaturaCode") Integer asignaturaCode
    ){
        return ResponseEntity.ok(matriculaService.asignaEstudiante(alumnoCedula,asignaturaCode));
    }
}
