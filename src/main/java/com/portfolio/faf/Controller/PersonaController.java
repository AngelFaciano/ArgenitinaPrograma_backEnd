package com.portfolio.faf.Controller;

import com.portfolio.faf.Dto.dtoPersona;
import com.portfolio.faf.Entity.Persona;
import com.portfolio.faf.Interface.IPersonaService;
import com.portfolio.faf.Security.Controller.Mensaje;
import com.portfolio.faf.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"http://localhost:4200/","https://portfoliofaciano.web.app/","https://portfoliofaciano.web.app"})
public class PersonaController {
    
    @Autowired
    ImpPersonaService sEducacion;
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>>list(){
        List<Persona>lista=sEducacion.list();
        return new ResponseEntity(lista,HttpStatus.OK); 
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona>getById(@PathVariable("id")int id){
        /*if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.BAD_REQUEST);
        }*/
        Persona educacion=sEducacion.getOne(id).get();
        return new ResponseEntity(educacion,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.NOT_FOUND);
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"),HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody dtoPersona dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByNombre(dtoeducacion.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        Persona educacion=new Persona(dtoeducacion.getNombre(),dtoeducacion.getApellido(),dtoeducacion.getDescripcion(),dtoeducacion.getImg());
        educacion.setNombre(dtoeducacion.getNombre());
        educacion.setApellido(dtoeducacion.getApellido());
        educacion.setDescripcion(dtoeducacion.getDescripcion());
        educacion.setImg(dtoeducacion.getImg());
        return new ResponseEntity(new Mensaje("Educacion creada"),HttpStatus.OK);
        
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id")int id,@RequestBody dtoPersona dtoeducacion){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.NOT_FOUND);
        }
        if(sEducacion.existsByNombre(dtoeducacion.getNombre())&&sEducacion.getByNombre(dtoeducacion.getNombre()).get().getId()!=id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getNombre())){
            return new ResponseEntity(new Mensaje ("El campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
        }
        Persona educacion=sEducacion.getOne(id).get();
        educacion.setNombre(dtoeducacion.getNombre());
        educacion.setApellido(dtoeducacion.getApellido());
        educacion.setDescripcion(dtoeducacion.getDescripcion());
        educacion.setImg(dtoeducacion.getImg());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"),HttpStatus.OK);
    }
}
