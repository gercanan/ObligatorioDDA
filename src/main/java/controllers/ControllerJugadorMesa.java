/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import common.Observable;
import common.Observador;
import dominio.Eventos;
import dominio.Jugador;
import dominio.Mesa;
import logica.Fachada;
import ui.VentanaJugadorMesa;

/**
 *
 * @author gcana
 */
public class ControllerJugadorMesa implements Observador{
    private VentanaJugadorMesa vista;
    private Jugador jugador;
    private Mesa mesa;

    public ControllerJugadorMesa(VentanaJugadorMesa vista, Mesa mesa, Jugador jugador) {
        this.vista = vista;
        this.mesa = mesa;
        this.jugador = jugador;
        mesa.agregar(this);
        Fachada.getInstance().agregar(this); //me agrego a la lista de escuchadores de fachada para saber si tengo que actualizar algo
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if(Eventos.NUEVA_RONDA.equals(evento) || Eventos.NUEVA_APUESTA.equals(evento)){
            mostrarInfo();
        }
        if(Eventos.NUEVA_RONDA.equals(evento)){
            mostrarInfoEstadisticas();
        }
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Mesa getMesa() {
        return mesa;
    }

    private void mostrarInfo() {
        vista.mostrarInfo();
    }
    private void mostrarInfoEstadisticas(){
        vista.mostrarInfoEstadisticas();
    }
    
    
    
    
}
