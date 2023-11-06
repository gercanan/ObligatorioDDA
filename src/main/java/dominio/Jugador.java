/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author gcana
 */
public class Jugador extends Usuario{
    private int saldo;

    public Jugador(String cedula, String password, String nombre, int saldo) {
        super(cedula, password, nombre);
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public void sumarSaldo(int cantidad){
        this.saldo += cantidad;
    }
    
    
}
