
package com.portfolio.faf.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
     @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String usuarioE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    public dtoExperiencia(String nombreE, String descripcionE,String usuarioE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.usuarioE = usuarioE;
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
