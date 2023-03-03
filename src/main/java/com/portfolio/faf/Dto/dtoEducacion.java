/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.faf.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author angel
 */
public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank 
    private String descripcionE;
    @NotBlank 
    public String UsuarioE;

    public String getUsuarioE() {
        return UsuarioE;
    }

    public void setUsuarioE(String UsuarioE) {
        this.UsuarioE = UsuarioE;
    }

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
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
    
}
