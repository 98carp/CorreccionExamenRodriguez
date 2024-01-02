package ec.edu.espe.examenRodriguez.dao;
import ec.edu.espe.examenRodriguez.domain.Colegio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColegioRepository extends JpaRepository<Colegio,Integer> {
    List<Colegio>findByNombreContaining(String colegioPattern);
    Colegio findColegiosByCodColegio(Integer codColegio);
}
