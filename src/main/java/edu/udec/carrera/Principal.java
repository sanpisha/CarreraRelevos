package main.java.edu.udec.carrera;

import main.java.edu.udec.carrera.Color;
import main.java.edu.udec.carrera.Persona;

/**
 * Clase Principal inicializa hilo y muestra el ganador
 *
 * @author Santiago Gómez
 */
public class Principal {

    Color color;
    Color e1 = new Color("Cyan");
    Color e2 = new Color("Azul");
    Color e3 = new Color("Rojo");

    Persona p1 = new Persona(0, 33, e1);
    Persona p2 = new Persona(33, 66, e1);
    Persona p3 = new Persona(66, 100, e1);
    Persona p4 = new Persona(0, 33, e2);
    Persona p5 = new Persona(33, 66, e2);
    Persona p6 = new Persona(66, 100, e2);
    Persona p7 = new Persona(0, 33, e3);
    Persona p8 = new Persona(33, 66, e3);
    Persona p9 = new Persona(66, 100, e3);

    /**
     * Metodo inicializa los hilos
     */
    public void iniciaCarrera() {
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        p8.start();
        p9.start();

    }
    /**
     * Metodo que muestra el ganador y el color de ese ganador
     *
     * @param color variable del color del ganador
     */
    public void mostrarGanador(String color) {

        System.out.println(" **************************************");
        System.out.println(" El ganador es el equipo: " + color);
        System.out.println(" **************************************");

    }

}
