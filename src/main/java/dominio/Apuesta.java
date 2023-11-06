/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author gcana
 */
public class Apuesta {
    private int monto;
    private Jugador jugador;
    private Casillero casillero;
    
    

    public Apuesta(Jugador jugador, int monto, Casillero casillero) {
        this.monto = monto;
        this.jugador = jugador;
        this.casillero = casillero;
        this.jugador.setSaldo(jugador.getSaldo() - monto);
    }

    public int getUniversalCellCode() {
        return casillero.getUniversalCellCode();
    }
    
    public Casillero getCasillero(){
        return casillero;
    }

    
    public int getMonto() {
        return monto;
    }

    public Jugador getJugador() {
        return jugador;
    }
    
    
    
    
}
