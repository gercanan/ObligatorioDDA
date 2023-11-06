/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import common.Observable;
import common.Observador;
import dominio.Casillero;
import dominio.Crupier;
import dominio.Eventos;
import dominio.Jugador;
import dominio.Mesa;
import dominio.Usuario;
import dominio.Sesion;
import java.util.ArrayList;

/**
 *
 * @author gcana
 */
public class Fachada extends Observable implements Observador{
    private static Fachada instancia;
    private ServicioUsuario servicioUsuario;
    private ServicioMesa servicioMesa;
    
    private Fachada(){
        servicioUsuario = new ServicioUsuario();
        servicioMesa = new ServicioMesa();
        servicioUsuario.agregar(this); //me agrego para escuchar si servicioUsuario anuncia un cambio!
    }
    public synchronized static Fachada getInstance() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }
    public void agregar(Crupier crupier){
        servicioUsuario.agregar(crupier);
    }
    public void agregar(Jugador jugador){
        servicioUsuario.agregar(jugador);
    }
    public void agregarSesion(Sesion sesion){
       servicioUsuario.agregarSesion(sesion);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if(Eventos.LOGIN_USUARIO.equals(evento)){
            avisar(Eventos.LOGIN_USUARIO); //le aviso a quien me este escuchando (los controladores)
        }
        if(Eventos.INGRESO_JUGADOR_MESA.equals(evento)){
            avisar(Eventos.INGRESO_JUGADOR_MESA); //le aviso a quien me este escuchando (los controladores)
        }
        
    }


    public Crupier loginCrupier(String cedula, String password) {
        return servicioUsuario.loginCrupier(cedula, password);
    }
    public Jugador loginJugador(String cedula, String password){
        return servicioUsuario.loginJugador(cedula, password);
    }

    public Sesion getUltimoJugador() {
        return servicioUsuario.getUltimoJugador();
    }

    public void Apostar50al23(Jugador jugador) {
        //servicioMesa.setApuesta(jugador);
        //mesa.setApuesta(jugador, monto, universallCellCode);
        
        
        //jugador.setApuesta(); 
    }

    public ArrayList<Crupier> getCrupiers() {
        return servicioUsuario.getCrupiers();
    }
    public ArrayList<Mesa> getMesasDisponibles(){
        return servicioUsuario.getMesasDisponibles();
    }

    public void agregarJugadorAMesa(Mesa mesaSeleccionada, Jugador jugador) {
        servicioUsuario.agregarJugadorAMesa(mesaSeleccionada, jugador);
    }

    public void agregar(Casillero casillero) {
        servicioMesa.agregar(casillero);
    }

    public Casillero obtenerCasilleroAlAzar() {
        return servicioMesa.obtenerCasilleroAlAzar();
    }

    public Casillero getCasillero(int universalCellCode) {
        return servicioMesa.getCasillero(universalCellCode);
    }
    
    
}
