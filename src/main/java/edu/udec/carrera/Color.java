package main.java.edu.udec.carrera;

import java.util.Date;

/**
 * Clase que establece las variables del color y donde se muestra en pantalla la posición de los competidores
 *
 * @author Santiago Gómez
 * 
 */
public class Color {
    private String nombre;
    private Date termino;
    private int posicion;
    private int posicionActualP1;
    private int posicionActualP2;
    private int posicionActualP3;
    
    /**
     * Constructor  con la posiscion actual de  los 3 jugadores 
     * @param nombre nombre del Color
     */
    public Color(String nombre) {
        this.nombre = nombre;
        this.posicionActualP1=0;
        this.posicionActualP2=33;
        this.posicionActualP3=66;
        termino = null;
    }
    /**
     * La clase mostrar posicion es el encargado de mostrar que figura  y en mostrar la posicion
     * 
     */
    public synchronized String mostrarPosicion(){
        String posicion="";
        String colorcito = null;
        if (nombre=="Cyan"){
            colorcito="\u001B[36m";
        }else if (nombre=="Azul"){
            colorcito="\u001B[34m";
        }else if (nombre=="Rojo"){
            colorcito="\u001B[31m";
        }
        posicion = colorcito+"Color: "+nombre+" ";
        for (int i = 0; i <= 100; i++) {
            if (i == posicionActualP1) {
                posicion += "®";
            } else if (i == posicionActualP2) {
                posicion += "|";
            } else if (i == posicionActualP3) {
                posicion += "$";
            } else {
                posicion += "_";
            }
            
        }
 
        return posicion;
    }
    /**
    * metodo de  nombre
    * @return nombre
    */

    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para asignar nombre
     * @param nombre 
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
    * metodo de  posicionActualP1
    * @return posicionActualP1
    */

    public int getPosicionActualP1() {
        return posicionActualP1;
    }
    /**
     * Metodo para asignar posicionActualP1
     * @param posicionActualP1 
     */

    public void setPosicionActualP1(int posicionActualP1) {
        this.posicionActualP1 = posicionActualP1;
    }
    /**
    * metodo de  posicionActualP2
    * @return posicionActualP2
    */

    public int getPosicionActualP2() {
        return posicionActualP2;
    }
    /**
     * Metodo para asignar posicionActualP2
     * @param posicionActualP2 
     */

    public void setPosicionActualP2(int posicionActualP2) {
        this.posicionActualP2 = posicionActualP2;
    }
    /**
    * metodo de  posicionActualP3
    * @return posicionActualP3
    */
   

    public int getPosicionActualP3() {
        return posicionActualP3;
    }
    /**
     * Metodo para asignar posicionActualP3
     * @param posicionActualP3 
     */

    public void setPosicionActualP3(int posicionActualP3) {
        this.posicionActualP3 = posicionActualP3;
    }
    /**
    * metodo de  posicion
    * @return posicion
    */

    public int getPosicion() {
        return posicion;
    }
    /**
     * Metodo para asignar posicion
     * @param posicion 
     */

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    /**
    * metodo de  termino
    * @return termino
    */

    public Date getTermino() {
        return termino;
    }
    /**
     * Metodo para asignar termino
     * @param termino 
     */

    public void setTermino(Date termino) {
        this.termino = termino;
    }
    
}
