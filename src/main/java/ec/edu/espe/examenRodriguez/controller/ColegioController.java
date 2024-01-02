package ec.edu.espe.examenRodriguez.controller;

import ec.edu.espe.examenRodriguez.domain.Colegio;
import ec.edu.espe.examenRodriguez.service.ColegioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/colegio")
public class ColegioController {
    private final ColegioService colegioService;

    public ColegioController(ColegioService colegioService) {
        this.colegioService = colegioService;
    }
    @PostMapping
    public ResponseEntity<Colegio>crearColegio(@RequestBody Colegio colegio){
        try{
            Colegio colegioTmp=this.colegioService.crearColegio(colegio);
            return ResponseEntity.ok(colegioTmp);
        }catch (RuntimeException ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{patron}")
    public ResponseEntity<List<Colegio>> encontrarColegiosPorPatron(@PathVariable(name = "patron") String patron){
        return ResponseEntity.ok(colegioService.encontrarColegiosPorPatron(patron));
    }

}
