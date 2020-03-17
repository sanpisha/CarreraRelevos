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
 * Crea la pista e imprime la posición de los corredores
 * 
 */
public class Pista {
    
    /**
     * define la posición inicial de los 3 corredores
     */
    private int posCorredor1=0;
    /**
     * define la segunda posición de los 3 corredores
     */
    private int posCorredor2=33;
    /**
     * define la tercera posición de los 3 corredores
     */
    private int posCorredor3=66;
    /**
     * Variable que imprimirá la pista
     */
    private String pista = "";
    /**
     * obtiene la posición del corredor1
     * @return 
     */
    public int getPosCorredor1() {
        return posCorredor1;
    }
    /**
     * setea la posición del corredor 1
     * @param posCorredor1 
     */
    public void setPosCorredor1(int posCorredor1) {
        this.posCorredor1 = posCorredor1;
    }
    /**
     * obitne la posición del corredor 2
     * @return 
     */
    public int getPosCorredor2() {
        return posCorredor2;
    }
    /**
     * setea la posición del corredor 2
     * @param posCorredor2 
     */
    public void setPosCorredor2(int posCorredor2) {
        this.posCorredor2 = posCorredor2;
    }
    /**
     * obtiene la posición del corredor 3
     * @return 
     */
    public int getPosCorredor3() {
        return posCorredor3;
    }
    /**
     * setea la posición del corredor 3
     * @param posCorredor3 
     */
    public void setPosCorredor3(int posCorredor3) {
        this.posCorredor3 = posCorredor3;
    }
    /**
     * obtiene la pista
     * @return 
     */
    public String getPista() {
        return pista;
    }
    /**
     * setea la pista
     * @param pista 
     */
    public void setPista(String pista) {
        this.pista = pista;
    }
    /**
     * imprime la pista con los 9 corredores
     * @param color 
     */
    public void imprimirPista(String color){
   
        for (int i = 0; i < 100; i++) {
            if(i == posCorredor1){
                pista += "|";
            }
            if(i == posCorredor2){
                pista += "&";
            }
            if(i == posCorredor3){
                pista += "$";
            } pista += "-";            
        }  
        System.out.println(color+ pista);
        pista="";
        System.out.println("\n");
        
        
        try {
            if("\u001B[31m".equals(color)){
            Thread.sleep(1000);
            }
            else if ("\u001B[34m".equals(color)){
                Thread.sleep(1000);
            }else{
            Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    }
    
    
    

