/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.Random;
import logica.Fachada;

/**
 *
 * @author gcana
 */
public class Ronda {
    private int id;
    private static int idNext = 1;
    private Efecto efecto;
    private Casillero casillero;
    private ArrayList<Apuesta> apuestas = new ArrayList();
    private ArrayList<EstadisticasRondaJugador> estadisticasRondaJugador = new ArrayList();
    
    public Ronda(){
        this.id = idNext;
        idNext++;
    }

    public int getId() {
        return id;
    }

    
    
    public Casillero getCasillero() {
        return casillero;
    }
    
    
    public void setNumeroSorteado(){
        //tengo que sacar uno al azar de servicioMesa!
        casillero = Fachada.getInstance().obtenerCasilleroAlAzar();
    }
    
    public void setApuesta(Jugador jugador, int monto, int universalCellCode){
        //creo una nueva apuesta
        //tengo que ir a buscar el casillero!
        Casillero casillero = Fachada.getInstance().getCasillero(universalCellCode);
        Apuesta apuesta = new Apuesta(jugador, monto, casillero);
        //la agrego al array
        apuestas.add(apuesta);
    }
    public int getNumeroSorteado() {
        if(casillero != null){
            return casillero.getUniversalCellCode();
        }else{
            return -1;
        }
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public ArrayList<EstadisticasRondaJugador> getEstadisticasRondaJugador() {
        return estadisticasRondaJugador;
    }
    
    
    

    public int getTotalApuestas() {
        int total = 0;
        for(Apuesta a: apuestas){
            total += a.getMonto();
        }
        return total;
    }


    
    
    
    
}
