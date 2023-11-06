/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import controllers.ControllerLogin;
import dominio.Crupier;
import dominio.Sesion;
import dominio.Usuario;
import java.util.Date;
import javax.swing.JOptionPane;
import logica.Fachada;


/**
 *
 * @author gcana
 */
public class LoginCrupier extends Login{
    
    private ControllerLogin controllerLogin;
    
    public LoginCrupier(){
        super();
        this.controllerLogin = crearControlador();
        this.setTitle("Bienvenido crupier");
    }
    
    @Override
    protected void ingresar(String cedula, String password) {
        controllerLogin.loginCrupier(cedula, password);
    }

    @Override
    public void ejecutarCasoUsoInicial(Usuario usuario) {
        //inicio el dialogo correspondiente
        new VentanaCrupier((Crupier)usuario).setVisible(true);
        Fachada.getInstance().agregarSesion(new Sesion(usuario, new Date()));
    }

    private ControllerLogin crearControlador() {
        return new ControllerLogin(this);
    }
    
    @Override
    public void mostrarMensajeDeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Login incorrecto", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void cerrarVentana() {
        dispose();
    }
    
}
