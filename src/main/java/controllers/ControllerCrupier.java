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
import logica.Fachada;
import dominio.Sesion;
import dominio.Usuario;
import java.util.ArrayList;
import ui.VentanaCrupier;

/**
 *
 * @author gcana
 */
public class ControllerCrupier implements Observador{
    //private final VistaCrupier vistaCrupier
    //private final VistaJugador vistaJugador
    //private final Mesa mesa = null;
    //private Sesion sesion;
    private VentanaCrupier vista;
    private Crupier crupier;
    private Mesa mesa;

    
    
    public ControllerCrupier(VentanaCrupier vista, Crupier crupier) {
        this.vista = vista;
        this.crupier = crupier;
        this.mesa = crupier.getMesaAsignada();
        mesa.agregar(this);
        Fachada.getInstance().agregar(this); //me agrego para escuchar si fachada anuncia un cambio!
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if(Eventos.LOGIN_USUARIO.equals(evento)){
            inicioSesionUnJugador(); 
        }
        if(Eventos.INGRESO_JUGADOR_MESA.equals(evento)){
            getJugadoresMesa();
        }
        if(Eventos.NUEVA_RONDA.equals(evento) || Eventos.NUEVA_APUESTA.equals(evento)){
            mostrarInfo();
            getJugadoresMesa();
        }
    }
    public Crupier getCrupier() {
        return crupier;
    }

    private void inicioSesionUnJugador() {
        Sesion sesion = Fachada.getInstance().getUltimoJugador();
        vista.inicioSesionUnJugador(sesion);
    }

    public void getJugadoresMesa() {
        //le digo a la vista que se unio un jugador y le paso la lista de jugadores
        vista.jugadorUnido(crupier.getMesaAsignada().getJugadores());
    }

    private void mostrarInfo() {
        vista.mostrarInfo();
    }

    
    
    
}
