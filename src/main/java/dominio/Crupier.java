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
public class Crupier extends Usuario{

    private Mesa mesaAsignada;
    private int edadCrupier;
    
    public enum Eventos{cambioEdad, cambioMesa};

    public Crupier(String cedula, String password, String nombre, Mesa mesa, int edad) {
        super(cedula, password, nombre);
        //this.cedula = cedula;
        //this.password = password;
        //this.nombre = nombre;
        this.mesaAsignada = mesa;
        this.edadCrupier = edad;
    }

    public Mesa getMesaAsignada() {
        return mesaAsignada;
    }

    public void sumar() {
        edadCrupier++;
        avisar(Eventos.cambioEdad);
    }

    public int getEdadCrupier() {
        return edadCrupier;
    }
    
    
    
    
    
}
