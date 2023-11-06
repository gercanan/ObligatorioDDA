/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dominio.Crupier;
import dominio.Jugador;
import dominio.Usuario;
import logica.Fachada;
import ui.LoginCrupier;
import ui.LoginJugador;

/**
 *
 * @author gcana
 */
public class ControllerLogin {
    private LoginCrupier vistaCrupier;
    private LoginJugador vistaJugador;

    public ControllerLogin(LoginCrupier vista) {
        this.vistaCrupier = vista;
    }
    public ControllerLogin(LoginJugador vista) {
        this.vistaJugador = vista;
    }

    public void loginCrupier(String cedula, String password) {
        //UsuarioGenerico usuario = loginInterno(nombreUsuario, password);
        Crupier crupier = Fachada.getInstance().loginCrupier(cedula, password);
        if (crupier == null) {
            vistaCrupier.mostrarMensajeDeError("Nombre y/o la contraseña no son correctos");
        } else {
            vistaCrupier.ejecutarCasoUsoInicial(crupier);
            vistaCrupier.cerrarVentana();
        }
    }
    public void loginJugador(String cedula, String password) {
        //UsuarioGenerico usuario = loginInterno(nombreUsuario, password);
        Jugador jugador = Fachada.getInstance().loginJugador(cedula, password);
        if (jugador == null) {
            vistaJugador.mostrarMensajeDeError("Nombre y/o la contraseña no son correctos");
        } else {
            vistaJugador.ejecutarCasoUsoInicial(jugador);
            vistaJugador.cerrarVentana();
        }
    }
    
    
    
}
