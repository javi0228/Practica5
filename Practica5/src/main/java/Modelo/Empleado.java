/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.*;

/**
 *
 * @author Javir
 */
public class Empleado {
    
    private int numero;
    private String nombre;
    private String apellido;
    private String foto;
    private float sueldo;
    private float sueldoMaximo;
    private Fecha fechaAlta;

    public Empleado(int numero, String nombre, String apellido,String foto,
            float sueldo, float sueldoMaximo,int anio,int mes,int dia) {
        
        this.numero=numero;        
        this.nombre=nombre;        
        this.apellido=apellido;        
        this.foto=foto;        
        this.sueldo=sueldo;        
        this.sueldoMaximo=sueldoMaximo;        
        fechaAlta=new Fecha(anio, mes, dia);
        
    }
    
    public void setNumero(int numero){
        this.numero=numero;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    
    public void setFoto(String foto){
        this.foto=foto;
    }
    
    public void setSueldo(float sueldo){
        this.sueldo=sueldo;
    }
    
    public void setSueldoMaximo(float sueldoMaximo){
        this.sueldoMaximo=sueldoMaximo;
    }
    
    public void setFechaAlta(int anio,int mes,int dia){
        this.fechaAlta=new Fecha(anio, mes, dia);
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public String getFoto(){
        return this.foto;
    }
    
    public float getSueldo(){
        return this.sueldo;
    }
    
    public float getSueldoMaximo(){
        return this.sueldoMaximo;
    }
    
    public Fecha getFechaAlta(){
        return fechaAlta;
    }

    @Override
    public String toString() {
        return "\n "+numero+"\n  "+nombre+"\n  "+apellido+"\n  "+foto+
                "\n  "+sueldo+"\n  "+sueldoMaximo+"\n  "+fechaAlta;
    }
    
    
    
}
