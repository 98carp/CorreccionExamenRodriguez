package ec.edu.espe.examenRodriguez.service;

import ec.edu.espe.examenRodriguez.dao.ColegioRepository;
import ec.edu.espe.examenRodriguez.domain.Colegio;
import ec.edu.espe.examenRodriguez.service.exception.CreateException;
import ec.edu.espe.examenRodriguez.service.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColegioService {
    private final ColegioRepository colegioRepository;

    public ColegioService(ColegioRepository colegioRepository) {
        this.colegioRepository = colegioRepository;
    }
    public Colegio crearColegio(Colegio colegio){
        try{
            return this.colegioRepository.save(colegio);
        }catch (Exception e){
            throw new CreateException("Error al crear el colegio"+colegio.toString(),e);
        }

    }
    public List<Colegio> encontrarColegiosPorPatron(String colegioPatron){
        List<Colegio> colegios=this.colegioRepository.findColegiosByNombreLike(colegioPatron);
        if(colegios.isEmpty()){
            throw new NotFoundException("No se encontraron colegios con el patrón: " + colegioPatron);
        }
        return colegios;
    }

}
