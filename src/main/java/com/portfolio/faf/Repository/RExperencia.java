
package com.portfolio.faf.Repository;

import com.portfolio.faf.Entity.Experiencia;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperencia extends JpaRepository<Experiencia,Integer> {
    public Optional<Experiencia> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    public List<Experiencia> existsByUsuariE(String usuarioe);
    
}
