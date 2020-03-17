/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udec.carrerarelevos;

/**
 *
 * @author santiago gómez
 * Creación de los corredores y pista de cada equipo, inicialización de los hilos
 */
public class Principal {
    /**
     * variable del primer equipo con su código de color
     */
    public static String rojo = "\u001B[31m";
    /**
     * variable del segundo equipo con su código de color
     */
    
    public static String azul = "\u001B[34m";
    /**
     * Variable del tercer equipo con su código de color
     */
    public static String verde = "\u001B[32m";

    public Principal() {

        Pista uno = new Pista();
        Pista dos = new Pista();
        Pista tres = new Pista();

        Corredor per = new Corredor(uno, 0, rojo);
        Corredor per2 = new Corredor(uno, 33, rojo);
        Corredor per3 = new Corredor(uno, 66, rojo);

        Corredor per4 = new Corredor(dos, 0, azul);
        Corredor per5 = new Corredor(dos, 33, azul);
        Corredor per6 = new Corredor(dos, 66, azul);

        Corredor per7 = new Corredor(tres, 0, verde);
        Corredor per8 = new Corredor(tres, 33, verde);
        Corredor per9 = new Corredor(tres, 66, verde);

        per.start();
        per2.start();
        per3.start();
        per4.start();
        per5.start();
        per6.start();
        per7.start();
        per8.start();
        per9.start();
    }

    public static void main(String[] args) {

        Principal p = new Principal();// TODO code application logic here
    }

}
