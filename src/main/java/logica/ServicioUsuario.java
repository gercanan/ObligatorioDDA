/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import common.Observable;
import dominio.Crupier;
import dominio.Eventos;
import dominio.Jugador;
import dominio.Mesa;
import dominio.Sesion;
import dominio.Usuario;
import java.util.ArrayList;

/**
 *
 * @author gcana
 */
public class ServicioUsuario extends Observable{
    private final ArrayList<Crupier> crupiers;
    private final ArrayList<Jugador> jugadores;
    private final ArrayList<Sesion> sesiones;
    
    public ServicioUsuario(){
        this.crupiers = new ArrayList();
        this.jugadores = new ArrayList();
        this.sesiones = new ArrayList();
    }
    
    public void agregarSesion(Sesion sesion){
       sesiones.add(sesion);
       avisar(Eventos.LOGIN_USUARIO);
    }
    
    public void agregar(Crupier c){
        crupiers.add(c);
    }
    public void agregar(Jugador j){
        jugadores.add(j);
    }
    public ArrayList<Crupier> getCrupiers(){
        return crupiers;
    }
    public ArrayList<Mesa> getMesasDisponibles(){
        ArrayList<Mesa> mesas = new ArrayList();
        for(Sesion s: sesiones){
            if(s.getUsuario() instanceof Crupier){
                Crupier c = (Crupier)s.getUsuario();
                mesas.add(c.getMesaAsignada());
            }
        }
        return mesas;
    }

    public Crupier loginCrupier(String cedula, String password) {
        return (Crupier)loginGenerico(cedula, password, (ArrayList)crupiers);
    }
    
    public Jugador loginJugador(String cedula, String password){
        return (Jugador)loginGenerico(cedula, password, (ArrayList)jugadores);
    }
    
    private Usuario loginGenerico(String cedula, String password, ArrayList<Usuario> listaUsuarios) {
        for (Usuario u : listaUsuarios) {
            if (u.getCedula().equals(cedula) && u.esPassordValida(password)) {
                return u;
            }
        }
        return null;
    }

    public Sesion getUltimoJugador() {
        return sesiones.get(sesiones.size() -1);
    }

    void agregarJugadorAMesa(Mesa mesaSeleccionada, Jugador jugador) {
        //recorro los crupiers y busco la mesa
        for(Crupier c: crupiers){
            if(c.getMesaAsignada().equals(mesaSeleccionada)){
                //agrego el jugador a esa mesa
                c.getMesaAsignada().agregarJugador(jugador);
            }
        }
        avisar(Eventos.INGRESO_JUGADOR_MESA);
    }

  
    
}
