/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Javir
 */
public class Fecha implements Serializable{
    
    private Calendar cal;

    public Fecha(int anio,int mes,int dia) {
        cal=new GregorianCalendar();
        cal.set(anio, mes, dia);
        
    }
    
    public int getDia(){
        return cal.get(Calendar.DATE);
    }
    public int getMes(){
        return cal.get(Calendar.MONTH);
    }
    public int getAnio(){
        return cal.get(Calendar.YEAR);
    }
    
    public Calendar getCalendario(){
        return cal;
    }

    @Override
    public String toString() {
        return ""+cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
