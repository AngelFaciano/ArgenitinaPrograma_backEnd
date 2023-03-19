package com.portfolio.faf.Security.Controller;

import com.portfolio.faf.Security.Dto.JwtDto;
import com.portfolio.faf.Security.Dto.LoginUsuario;
import com.portfolio.faf.Security.Dto.NuevoUsuario;
import com.portfolio.faf.Security.Entity.Rol;
import com.portfolio.faf.Security.Entity.Usuario;
import com.portfolio.faf.Security.Enums.RolNombre;
import com.portfolio.faf.Security.Service.RolService;
import com.portfolio.faf.Security.Service.UsuarioService;
import com.portfolio.faf.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;







@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:4200/","https://portfoliofaciano.web.app/","https://portfoliofaciano.web.app"})
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider; 
    @PostMapping("/nuevo")
    public ResponseEntity<?>nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResulta ){
        if(bindingResulta.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"),HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())){
            return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())){
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        }
        Usuario usuario=new Usuario(nuevoUsuario.getNombre(),nuevoUsuario.getNombreUsuario(),nuevoUsuario.getEmail(),passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol>roles=new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("Usuario guardado"),HttpStatus.CREATED);
    }
   @PostMapping("/login")
   public ResponseEntity<JwtDto>login(@Valid @RequestBody LoginUsuario loginUsuario,BindingResult bindingResult){
       if(bindingResult.hasErrors())
           return new ResponseEntity(new Mensaje("Campos mal puestos"),HttpStatus.BAD_REQUEST);
       if(!usuarioService.existsByNombreUsuario( loginUsuario.getNombreUsuario())){
            return new ResponseEntity(new Mensaje("El Nombre de Usuario no Existe"), HttpStatus.BAD_REQUEST);
        }
       if(usuarioService.existsByNombreUsuario( loginUsuario.getNombreUsuario())&&!usuarioService.existsByNombreUsuario( loginUsuario.getPassword())){
            return new ResponseEntity(new Mensaje("Contraseña incorrecta"), HttpStatus.BAD_REQUEST);
        }
       Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),loginUsuario.getPassword()));
       SecurityContextHolder.getContext().setAuthentication(authentication);
       
       String jwt=jwtProvider.generateToken(authentication);
       UserDetails userDetails=(UserDetails) authentication.getPrincipal();
       JwtDto jwtDto=new JwtDto(jwt,userDetails.getUsername(),userDetails.getAuthorities());
       
       return new ResponseEntity(jwtDto,HttpStatus.OK);
   }
}
