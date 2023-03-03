
package com.portfolio.faf.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private String usuarioE;    


    public Educacion() {
    }

    public Educacion(String nombreE, String descripcionE, String usuarioE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.usuarioE = usuarioE;
    }

    public Educacion(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    

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
