/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import common.Observable;

/**
 *
 * @author gcana
 */
public abstract class Usuario extends Observable{
    protected String cedula;
    protected String password;
    protected String nombre;

    public Usuario(String cedula, String password, String nombre) {
        this.cedula = cedula;
        this.password = password;
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }
    
    public boolean esPassordValida(String password) {
        return this.password.equals(password);
    }
    
}
