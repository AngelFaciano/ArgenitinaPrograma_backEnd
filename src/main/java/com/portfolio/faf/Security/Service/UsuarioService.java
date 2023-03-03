
package com.portfolio.faf.Security.Service;

import com.portfolio.faf.Security.Entity.Usuario;
import com.portfolio.faf.Security.Repository.IUsuario;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuario iusuario;
    public Optional<Usuario>getByNombreUsuario(String nombreUsuario){
        return iusuario.findByNombreUsuario(nombreUsuario);
    }
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuario.existsByNombreUsuario(nombreUsuario);
    }
    public boolean existsByEmail(String email){
        return iusuario.existsByNombreUsuario(email);
    }
    public void save(Usuario usuario){
        iusuario.save(usuario);
    }
    
}