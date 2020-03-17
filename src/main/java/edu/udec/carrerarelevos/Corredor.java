/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udec.carrerarelevos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santiago gómez
 * Clase que hereda del thread donde se ubica el método run
 * notifica a los demás hilos para que dejen el estado wait y empiecen con su ejecución
 */

public class Corredor extends Thread{
    private Pista carril;
    /**
     * Atributo que recibe la posicion inicial de cada corredor*/
    private int posicionInicial;
    /*
    *atributo que recibe el color de cada corredor */
    private String color;

    Corredor(Pista carril, int posicionInicial, String color) {
        this.carril = carril;
        this.posicionInicial = posicionInicial;
        this.color  = color;
    }
    /**
     * Obtiene el carril del corredor
     * @return carril
     */
    public Pista getCarril() {
        return carril;
    }
    /**
     * Setea el carril
     * @param carril 
     */
    public void setCarril(Pista carril) {
        this.carril = carril;
    }
    /**
     * Obtiene la posición inicial del corredor
     * @return posición inicial
     */
    public int getPosicionInicial() {
        return posicionInicial;
    }
    /**
     * Setea la posición inicial
     * @param posicionInicial 
     */
    public void setPosicionInicial(int posicionInicial) {
        this.posicionInicial = posicionInicial;
    }
    /**
     * Obtiene el color del equipo
     * @return color
     */
    public String getColor() {
        return color;
    }
    /**
     * Setea el color del equipo
     * @param color 
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * Crea la variable pasos para que los corredores avancen aleatoriamente
     * @return pasos
     */
    public int Correr(){
        int pasos=(int)(Math.random()*3)+1;
        return pasos;
    
    }
    /**
     * método run donde se notifica a los demás hilos cuando deben arrancar
     */
    @Override
    public void run(){
        if(posicionInicial==0){
            arrancaCorredor1();
            synchronized(carril){
                carril.notifyAll();
            }   
        }else {
            synchronized(carril){
                try {
                        carril.wait();
                }catch (InterruptedException ex) {
                        Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
                 if(posicionInicial==33){
                 arrancaCorredor2();
                  synchronized(carril){
                      carril.notifyAll();
                    }   
                 }else{
                   synchronized(carril){
                try {
                    carril.wait();
                }catch (InterruptedException ex) {
                        Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
                   if(posicionInicial==66){
                   arrancaCorredor3();
                   }
                 }
            }
        }
}
}
     /**
     * Metodo que incrementa la posicion del corredor uno
     */
    public void arrancaCorredor1(){
    int numPasos;
    do{
                carril.imprimirPista(getColor());
                numPasos = Correr();
                carril.setPosCorredor1(carril.getPosCorredor1()+numPasos); 
                if(carril.getPosCorredor1()> 33){
                     carril.setPosCorredor1(33);
                }
            }while(carril.getPosCorredor1()< 33);
    }
   /**
     * Metodo que incrementa la posicion del corredor dos
     */
     public void arrancaCorredor2(){
    int numPasos;
    do{
                carril.imprimirPista(getColor());
                numPasos = Correr();
                carril.setPosCorredor2(carril.getPosCorredor2()+numPasos); 
                if(carril.getPosCorredor2()> 66){
                     carril.setPosCorredor2(66);
                }
            }while(carril.getPosCorredor2()< 66);
    }
    /**
     * Metodo que incrementa la posicion del corredor tres
     */
     public void arrancaCorredor3(){
    int numPasos;
    do{
                carril.imprimirPista(getColor());
                numPasos = Correr();
                carril.setPosCorredor3(carril.getPosCorredor3()+numPasos); 
                if(carril.getPosCorredor3()> 100){
                     carril.setPosCorredor3(100);
                }
            }while(carril.getPosCorredor3()< 100);
    ganador();
    }
     /**
      * Método que según el color imprime el ganador
      */
     public void ganador(){
         
                       if("\u001B[31m".equals(color)){
                       System.out.println("EL GANADOR ES: "+ "Rojo"); 
                       }
                       else if ("\u001B[34m".equals(color)){
                       System.out.println("EL GANADOR ES: "+ "Azul");
                       }else{
                       System.out.println("EL GANADOR ES: "+ "Verde");
                       }
                    
                        System.exit(0);
    } 
    
    
}
