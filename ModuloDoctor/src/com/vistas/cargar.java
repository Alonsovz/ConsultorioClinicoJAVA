package com.vistas;

import com.modelo.*;
import javax.swing.JProgressBar;

/**
 * Nombre de la clase: Cargar
 * Fecha: 3-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
 */

public class cargar extends Thread{
    JProgressBar progreso;

    public cargar( JProgressBar progreso) {
        super();
        this.progreso = progreso;
    }
    
   
     @Override
    public void run ()
    {
        for(int a=1; a<=100; a++)
        {
            
            progreso.setValue(a);
            pausa(13);
        
        }
    }
    
     public void pausa(int miseg)
    {
        try {
            Thread.sleep(miseg);
        } catch (Exception e) {
        }
    }

   

    
    
    
}
