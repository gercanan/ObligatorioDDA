/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.obligatoriodda;

import dominio.Casillero;
import dominio.Crupier;
import dominio.Jugador;
import dominio.Mesa;
import dominio.TipoApuesta;
import logica.Fachada;
import logica.ServicioUsuario;
import ui.VentanaInicioSesion;

/**
 *
 * @author gcana
 */
public class ObligatorioDDA {

    public static void main(String[] args) {
        Mesa mesa1 = new Mesa();
        Mesa mesa2 = new Mesa();
        Mesa mesa3 = new Mesa();
        
        Crupier crupier1 = new Crupier("aaa", "101", "German Canan", mesa1, 40);
        Crupier crupier2 = new Crupier("bbb", "102", "Pepito Rodriguez", mesa2, 40);
        Crupier crupier3 = new Crupier("ccc", "103", "Don Omar", mesa3, 40);
        
        Jugador jugador1 = new Jugador("aaa", "201", "Daniel Fernandez", 1000);
        Jugador jugador2 = new Jugador("bbb", "202", "Daddy Yankee", 500);
        Jugador jugador3 = new Jugador("ccc", "203", "Ozuna", 100);
        Jugador jugador4 = new Jugador("ddd", "204", "ABBA", 50);
        Jugador jugador5 = new Jugador("eee", "205", "Lucas Sugo", 10);
        
        
        TipoApuesta tipoApuesta = new TipoApuesta(36, "Directa");
        TipoApuesta tipoApuesta1 = new TipoApuesta(3, "Docena");
        TipoApuesta tipoApuesta3 = new TipoApuesta(2, "Colores");
        
        for(int i=0; i<=36; i++){
            Casillero casillero = new Casillero(i, tipoApuesta);
            Fachada.getInstance().agregar(casillero);
        }
        
        Casillero casillero1 = new Casillero(40, tipoApuesta1);
        Fachada.getInstance().agregar(casillero1);
        Casillero casillero2 = new Casillero(41, tipoApuesta1);
        Fachada.getInstance().agregar(casillero2);
        Casillero casillero3 = new Casillero(42, tipoApuesta1);
        Fachada.getInstance().agregar(casillero3);
        
        Casillero casillero4 = new Casillero(43, tipoApuesta3);
        Fachada.getInstance().agregar(casillero4);
        Casillero casillero5 = new Casillero(44, tipoApuesta3);
        Fachada.getInstance().agregar(casillero5);
        
        
        
        Fachada.getInstance().agregar(crupier1);
        Fachada.getInstance().agregar(crupier2);
        Fachada.getInstance().agregar(crupier3);
        
        Fachada.getInstance().agregar(jugador1);
        Fachada.getInstance().agregar(jugador2);
        Fachada.getInstance().agregar(jugador3);
        Fachada.getInstance().agregar(jugador4);
        Fachada.getInstance().agregar(jugador5);
        
       
        new VentanaInicioSesion().setVisible(true);
        
    }
}
