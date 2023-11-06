/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dominio.Casillero;
import dominio.Mesa;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author gcana
 */
public class ServicioMesa {
    private ArrayList<Mesa> mesas;
    private ArrayList<Casillero> casilleros;
    
    public ServicioMesa(){
        this.casilleros = new ArrayList();
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    
    public void agregar(Mesa mesa){
        mesas.add(mesa);
    }

    public ArrayList<Casillero> getCasilleros() {
        return casilleros;
    }

    public void agregar(Casillero casillero) {
        casilleros.add(casillero);
    }

    public Casillero obtenerCasilleroAlAzar() {
        Random random = new Random();
    
        // Genera un índice al azar dentro del rango válido (0 a 41 para 42 elementos)
        int indiceAlAzar = random.nextInt(casilleros.size());
    
        //Casillero casilleroAlAzar = casilleros.get(indiceAlAzar);
        Casillero casilleroAlAzar = casilleros.get(30);
        
        return casilleroAlAzar;

    }

    public Casillero getCasillero(int universalCellCode) {
        for(Casillero c: casilleros){
            if(c.getUniversalCellCode() == universalCellCode){
                return c;
            }
        }
        return null;
    }
    
    
}
