
package com.portfolio.faf.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String usuarioE;    
    private String nombreE;
    private String descripcionE;
    
    //Constructores

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    public Experiencia( String nombreE, String descripcionE,String usuarioE) {
        this.usuarioE = usuarioE;
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getUsuarioE() {
        return usuarioE;
    }

    public void setUsuarioE(String usuarioE) {
        this.usuarioE = usuarioE;
    }
    
}