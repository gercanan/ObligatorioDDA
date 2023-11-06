/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import common.Observable;
import common.Observador;
import dominio.Crupier;
import dominio.Eventos;
import dominio.Jugador;
import dominio.Mesa;
import java.util.ArrayList;
import logica.Fachada;
import ui.VentanaJugadorSeleccionMesa;

/**
 *
 * @author gcana
 */
public class ControllerJugador implements Observador{
    private VentanaJugadorSeleccionMesa vista;
    private Jugador jugador;
    
    
    public ControllerJugador(VentanaJugadorSeleccionMesa vista, Jugador jugador) {
        this.vista = vista;
        this.jugador = jugador;
        Fachada.getInstance().agregar(this); //me agrego para escuchar si fachada anuncia un cambio!
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if(Eventos.LOGIN_USUARIO.equals(evento)){
            vista.getMesas();
        }

    }

    public Jugador getJugador() {
        return jugador;
    }

    
    public void Apostar50al23() {
        Fachada.getInstance().Apostar50al23(jugador);
    }
    
    public ArrayList<Mesa> getMesas(){
        ArrayList<Mesa> mesas = Fachada.getInstance().getMesasDisponibles();
        return mesas;
    }

    public void agregarJugadorAMesa(Mesa mesaSeleccionada) {
        Fachada.getInstance().agregarJugadorAMesa(mesaSeleccionada, jugador);
    }
}
