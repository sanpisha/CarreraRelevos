package main.java.edu.udec.carrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que establece las variables de las personas que compiten
 *
 * @author Santiago Gómez
 */
public class Persona extends Thread {

    Color color;
    private int posisionInicial;
    private int posicionFinal;
    private String cyan;
    private String azul;
    private String rojo;

    /**
     * Constructor de la clase que establece los siguientes parametros:
     *
     * @param posisionInicial captura la posicion inicial de la persona
     * @param posicionFinal captura la posicion final de la persona
     * @param color objeto de la clase Color que captura a que color pertenece
     * cada competidor
     */
    public Persona(int posisionInicial, int posicionFinal, Color color) {

        this.posisionInicial = posisionInicial;
        this.posicionFinal = posicionFinal;
        this.color = color;
    }

    @Override
    public void run() {
        if (posisionInicial == 0) {
            cicloPersonaUno();
        } else {
            sincronizadoEspera();
        }
        if (posisionInicial == 33) {
            cicloPersonaDos();
        } else {
            sincronizadoEspera();
        }
        if (posisionInicial == 66) {
            cicloPersonaTres();
        } else {
            sincronizadoEspera();
        }
    }

    /**
     * Metodo que realiza el ciclo del competidor 1 de cada color
     */
    public void cicloPersonaUno() {
        while (true) {
            int pasoActual = avanzar(1);
            if (pasoActual >= 33) {
                color.setPosicionActualP1(33);
                synchronized (color) {
                    color.notifyAll();
                }
                break;
            }
        }
    }

    /**
     * Metodo que realiza el ciclo del competidor 2 de cada color
     */
    public void cicloPersonaDos() {
        while (true) {
            int pasoActual = avanzar(2);
            if (pasoActual >= 66) {
                color.setPosicionActualP2(66);
                synchronized (color) {
                    color.notifyAll();
                }
                break;
            }
        }
    }

    /**
     * Metodo que realiza el ciclo del competidor 3 de cada color y da por
     * finalizada la carrera
     */
    public void cicloPersonaTres() {
        while (true) {
            int pasoActual = avanzar(3);
            if (pasoActual >= 100) {
                color.setPosicionActualP3(100);

                if (color.getNombre().equals("Cyan")) {
                    color.setNombre("Cyan");
                } else if (color.getNombre().equals("Azul")) {
                    color.setNombre("Azul");
                } else if (color.getNombre().equals("Rojo")) {
                    color.setNombre("Rojo");
                }

                Principal p = new Principal();
                p.mostrarGanador(color.getNombre());
                System.exit(0);

            }
        }
    }

    /**
     * Metodo que no recibe ningún parametro y se encarga de validar a que color
     * pertenece el jugador
     */
    public void colorPerteneciente() {
        if (color.mostrarPosicion().contains("Cyan")) {
            cyan = color.mostrarPosicion();
            System.out.println(cyan);

        } else if (color.mostrarPosicion().contains("Azul")) {
            azul = color.mostrarPosicion();
            System.out.println(azul);

        } else if (color.mostrarPosicion().contains("Rojo")) {
            rojo = color.mostrarPosicion();
            System.out.println(rojo);
            System.out.println();
            System.out.println();
            System.out.println();
        }

    }

    /**
     * Metodo avanzar para que la persona avance dependiendo del numero random y
     * como parametro el numero del persnaje
     *
     * @param numCompetidos variable entera del numero de la persona
     * @return int
     */
    public int avanzar(int numCompetidos) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        int avance = (int) (Math.random() * 3) + 1;

        if (numCompetidos == 1) {
            color.setPosicionActualP1(color.getPosicionActualP1() + avance);
            colorPerteneciente();
            return color.getPosicionActualP1();
        }
        if (numCompetidos == 2) {
            color.setPosicionActualP2(color.getPosicionActualP2() + avance);
            colorPerteneciente();
            return color.getPosicionActualP2();
        }
        if (numCompetidos == 3) {
            color.setPosicionActualP3(color.getPosicionActualP3() + avance);
            colorPerteneciente();
            return color.getPosicionActualP3();
        }
        return 0;

    }

    /**
     * Metodo para hacer esperar el hilo
     */
    public void sincronizadoEspera() {
        synchronized (color) {
            try {
                color.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
