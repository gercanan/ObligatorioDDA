/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author gcana
 */
public class Casillero {

    
    private int universalCellCode;
    private TipoApuesta tipoDeApuesta;

    public Casillero(int universalCellCode) {
        this.universalCellCode = universalCellCode;
    }
    public Casillero(int universalCellCode, TipoApuesta tipoApuesta){
        this.universalCellCode = universalCellCode;
        this.tipoDeApuesta = tipoApuesta;
        
    }
    
    public int getUniversalCellCode() {
        return universalCellCode;
    }

    public TipoApuesta getTipoDeApuesta() {
        return tipoDeApuesta;
    }
    
    
    
    
}
