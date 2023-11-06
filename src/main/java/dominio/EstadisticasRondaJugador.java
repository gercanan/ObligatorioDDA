/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author gcana
 */
public class EstadisticasRondaJugador {

    
    private Jugador jugador;
    private Ronda ronda;
    //private int numeroApostado;
    private int totalApostado;
    private int ganado;
    private int ganadoParcial;
    private int perdido;
    private int perdidoParcial;
    private int balance;
    private int factorPago;
    
    public EstadisticasRondaJugador(Ronda ronda, Jugador jugador){
        this.ronda = ronda;
        this.jugador = jugador;
    }
    
    public void actualizar(Apuesta apuesta) {
        //con los datos de la apuesta, actualizo los atributos
        ganadoParcial = 0;
        perdidoParcial = 0;
        this.totalApostado += apuesta.getMonto();
        if(ronda.getNumeroSorteado() == apuesta.getUniversalCellCode()){
            ganadoParcial = apuesta.getMonto() * apuesta.getCasillero().getTipoDeApuesta().getFactorPago();
            ganado += ganadoParcial;
        }else{
            perdidoParcial = apuesta.getMonto();
            perdido -= perdidoParcial;
        }
        balance = balance + ganadoParcial - perdidoParcial;
        
    }

    public void setGanado(int ganado) {
        this.ganado = ganado;
    }

    public void setPerdido(int perdido) {
        this.perdido = perdido;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public int getTotalApostado() {
        return totalApostado;
    }

    public int getGanado() {
        return ganado;
    }

    public int getPerdido() {
        return perdido;
    }

    public int getBalance() {
        return balance;
    }
    
    

    
    
    
    
    
}
