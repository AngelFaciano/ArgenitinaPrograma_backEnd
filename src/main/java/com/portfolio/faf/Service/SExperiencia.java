package com.portfolio.faf.Service;

import com.portfolio.faf.Entity.Experiencia;
import com.portfolio.faf.Repository.RExperencia;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperencia rExperiencia;
    public List<Experiencia>list(String usuarioe){
        return rExperiencia.existsByUsuariE(usuarioe);
    }
    public Optional<Experiencia> getOne(int id){
        return rExperiencia.findById(id);
    }
    public Optional<Experiencia>getByNombreE(String nombreE){
        return rExperiencia.findByNombreE(nombreE);
    }
    public void save(Experiencia expe){
        rExperiencia.save(expe);
    }
    public void delete(int id){
        rExperiencia.deleteById(id);
    }
    public boolean existsById(int id){
        return rExperiencia.existsById(id);
    }
    public boolean existsByNombreE(String nombreE){
        return rExperiencia.existsByNombreE(nombreE);
    }
}
