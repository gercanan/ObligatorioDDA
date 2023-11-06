/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import common.Observable;
import java.util.ArrayList;




/**
 *
 * @author gcana
 */
public class Mesa extends Observable{
    private int id;
    private static int idNext = 1;
    private int balance;
    //private Crupier crupier;
    private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Ronda> rondas = new ArrayList();
    private ArrayList<TipoApuesta> tiposApuesta  = new ArrayList();

    @Override
    public String toString() {
        return "Mesa " + id;
    }

    public ArrayList<Apuesta> getApuestasJugador(Jugador jugador){
        ArrayList<Apuesta> arrayApuestas = new ArrayList();
        for(Ronda r: rondas){
            for(Apuesta a: r.getApuestas()){
                if(a.getJugador().equals(jugador)){
                    arrayApuestas.add(a);
                }
            }
        }
        return arrayApuestas;
    }
    
    public void nuevaRonda(){
        //tengo que setear el numero sorteado
        Ronda rondaActual = rondas.get(rondas.size() -1);
        rondaActual.setNumeroSorteado();

        //tengo que pagar las apuestas
        pagarApuestas();
        //tambien tengo que crear las estadisticas
        crearEstadisticas(rondaActual);
        //y creo la nueva ronda
        rondas.add(new Ronda());
        avisar(Eventos.NUEVA_RONDA);
    }
    
    
    public Mesa(){
        this.id = idNext;
        idNext++;
        this.balance = 0;
        rondas.add(new Ronda());
    }
    public int getId() {
        return id;
    }
    public ArrayList<TipoApuesta> getTiposApuesta() {
        return tiposApuesta;
    }

    public int getBalance() {
        return balance;
    }

    public ArrayList<Ronda> getRondas() {
        return rondas;
    }
    
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mesa other = (Mesa) obj;
        return this.id == other.id;
    }
    
    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }
    
    public int[] getUltimosLanzamientos(){
    int[] ultimosLanzamientos = new int[6];
    int cantidadRondas = rondas.size();
    
    for (int i = 0; i < 6 && i < cantidadRondas; i++) {
        Ronda ronda = rondas.get(rondas.size() - 1 - i);
        
        // Verifica si la ronda tiene un casillero definido antes de acceder a su número sorteado
        if (ronda.getCasillero() != null) {
            ultimosLanzamientos[i] = ronda.getNumeroSorteado();
        } else {
            // Puedes asignar un valor predeterminado o lanzar una excepción si lo prefieres
            ultimosLanzamientos[i] = -1; // Por ejemplo, -1 para indicar que no se sorteó un número todavía.
        }
    }
    
    return ultimosLanzamientos;
}
    
    public void setApuesta(Jugador jugador, int monto, int universalCellCode){
        //encuentro la ronda;
        Ronda rondaActual = rondas.get(rondas.size() -1);
        rondaActual.setApuesta(jugador, monto, universalCellCode);
        
        this.balance += monto;
        avisar(Eventos.NUEVA_APUESTA);
        
    }
    private void pagarApuestas() {
        Ronda rondaActual = rondas.get(rondas.size() -1);
        //recorro las apuestas de la ronda
        for(Apuesta a: rondaActual.getApuestas()){
            if(a.getCasillero().getUniversalCellCode() == rondaActual.getNumeroSorteado()){
                int cantidadAPagar = a.getMonto() * a.getCasillero().getTipoDeApuesta().getFactorPago();
                a.getJugador().sumarSaldo(cantidadAPagar);
                balance -= cantidadAPagar;
            }
        }
    }
    private void crearEstadisticas(Ronda rondaActual) {
        //creo una estadistica por jugador en la mesa
        for(Jugador j: jugadores){
            EstadisticasRondaJugador nuevaEstadistica = new EstadisticasRondaJugador(rondaActual, j);
            //recorro las apuestas y actualizo su estadistica
            for(Apuesta a: rondaActual.getApuestas()){
                if(a.getJugador().equals(j)){
                    nuevaEstadistica.actualizar(a);
                }
            }
            rondaActual.getEstadisticasRondaJugador().add(nuevaEstadistica);
        }
    }
    
    public ArrayList<EstadisticasRondaJugador> getUltimasEstadisticas(Jugador jugador, int numRondas) {
        ArrayList<EstadisticasRondaJugador> arrayEstadisticasPlayer = new ArrayList<>();
        int rondasProcesadas = 0;

        for (int i = rondas.size() - 1; i >= 0 && rondasProcesadas < numRondas; i--) {
            Ronda r = rondas.get(i);
            for (EstadisticasRondaJugador e : r.getEstadisticasRondaJugador()) {
                if (e.getJugador().equals(jugador)) {
                    arrayEstadisticasPlayer.add(e);
                }
            }
            rondasProcesadas++;
        }

        return arrayEstadisticasPlayer;
    }
    

    

    
    
    
}
