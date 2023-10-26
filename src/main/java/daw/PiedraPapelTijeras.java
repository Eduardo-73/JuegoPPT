/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author edu
 */
public class PiedraPapelTijeras {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner teclado = new Scanner(System.in);
        int mostrarMenu = 0, numeroRandom, puntosJ1 = 0, puntosJ2 = 0,
                eligeMaquinaPPT = 0, puntosMaq = 0;
        boolean menuRepetir = true, repetirPPT = true, repetirPrograma = (mostrarMenu == 3);
        String menu = """
                    ----------------------------------------------  
                      1.- Juego de dos jugadores
                      2.- Juego de un jugador contra la máquina
                      3.- Salir
                    ----------------------------------------------
                      """;
        String jugador1, jugador2, elegirPPTJ1 = null, elegirPPTJ2 = null, maquinaPNJ = null;
        //Creo un menu y lo muestro y lo controlo con un do-while y un try-catch
        do {
            do {
                try {
                    mostrarMenu = Integer.parseInt(
                            JOptionPane.showInputDialog(menu));
                    menuRepetir = false;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null,
                            """
                    Debes de introducir uno de los datos del menu.
                    Prueba con poner 1, 2 o 3.
                    """);
                }
            } while (menuRepetir || (mostrarMenu < 1 || mostrarMenu > 3));
            //Creo un switch para mostrar los diferentes modos de juegos
            switch (mostrarMenu) {
                case 1 -> {//Modo 1VS1
                    JOptionPane.showMessageDialog(null,
                            "Has elegido el modo de dos jugadores ");
                    jugador1 = JOptionPane.showInputDialog("Introduce "
                            + "tu nombre 1º jugador: ");
                    jugador2 = JOptionPane.showInputDialog("Introduce "
                            + "tu nombre 2º jugador: ");
                    JOptionPane.showMessageDialog(null,
                            "Ahora se va a decidir aleatoriamente quien "
                            + "sacara primero");
                    numeroRandom = random.nextInt(1, 3);
                    switch (numeroRandom) {
                        case 1 -> {//Switch para ver quien elige primero si J1 o J2
                            JOptionPane.showMessageDialog(null,
                                    "Elige primero " + jugador1 + ", y debes de "
                                    + "introducir los datos por 'Scanner'");
                            for (int i = 0; i < 5; i++) {//Es al mejor de 5 rondas
                                System.out.println((i + 1) + "/5");
                                do {
                                    try {//Controlo lo que escribe el usuario con un do-while y un try-catch
                                        System.out.println(jugador1
                                                + " elige piedra, papel o tijeras: ");
                                        elegirPPTJ1 = teclado.nextLine();
                                        repetirPPT = false;
                                    } catch (InputMismatchException ime) {
                                        System.out.println("Tienes que elegir un dato "
                                                + "correcto (piedra, papel o tijeras)");
                                        teclado.nextLine();
                                    }
                                } while (repetirPPT
                                        || !(elegirPPTJ1.equalsIgnoreCase("piedra")
                                        || elegirPPTJ1.equalsIgnoreCase("papel")
                                        || elegirPPTJ1.equalsIgnoreCase("tijeras")));
                                do {
                                    try {//Controlo lo que escribe el usuario con un do-while y un try-catch
                                        System.out.println(jugador2
                                                + " elige piedra, papel o tijeras: ");
                                        elegirPPTJ2 = teclado.nextLine();
                                        repetirPPT = false;
                                    } catch (InputMismatchException ime) {
                                        System.out.println("Tienes que elegir un dato "
                                                + "correcto (piedra, papel o tijeras)");
                                        teclado.nextLine();
                                    }
                                } while (repetirPPT
                                        || !(elegirPPTJ2.equalsIgnoreCase("piedra")
                                        || elegirPPTJ2.equalsIgnoreCase("papel")
                                        || elegirPPTJ2.equalsIgnoreCase("tijeras")));
                                //Normas de quien se lleva los puntos
                                if ((elegirPPTJ1.equalsIgnoreCase("papel")//En el caso de que se quede empate
                                        && elegirPPTJ2.equalsIgnoreCase("papel"))
                                        || (elegirPPTJ1.equalsIgnoreCase("tijeras")
                                        && elegirPPTJ2.equalsIgnoreCase("tijeras"))
                                        || (elegirPPTJ1.equalsIgnoreCase("piedra")
                                        && elegirPPTJ2.equalsIgnoreCase("piedra"))) {
                                    System.out.println("Empate");
                                } else if ((elegirPPTJ1.equalsIgnoreCase("piedra")
                                        && elegirPPTJ2.equalsIgnoreCase("tijeras"))
                                        || (elegirPPTJ1.equalsIgnoreCase("tijeras")
                                        && elegirPPTJ2.equalsIgnoreCase("papel"))
                                        || (elegirPPTJ1.equalsIgnoreCase("papel")
                                        && elegirPPTJ2.equalsIgnoreCase("piedra"))) {
                                    System.out.println("Gana " + jugador1);
                                    puntosJ1 += 1;
                                } else {
                                    System.out.println("Gana " + jugador2);
                                    puntosJ2 += 1;
                                }
//                                if (puntosJ1 == 3) {
//                                    System.out.println(jugador1 + " ha llegado antes "
//                                            + "ha 3 puntos");
//                                } else {
//                                    System.out.println(jugador2 + " ha llegado antes "
//                                            + "ha 3 puntos");
//                                }
                                System.out.println("-------------------------------");
                                System.out.println(jugador1 + " tiene " + puntosJ1 + " puntos");
                                System.out.println(jugador2 + " tiene " + puntosJ2 + " puntos");
                            }
                            if (puntosJ1 > puntosJ2) {
                                JOptionPane.showMessageDialog(null,
                                        "Ha ganado " + jugador1);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Ha ganado " + jugador2);
                            }
                        }

                        case 2 -> {
                            JOptionPane.showMessageDialog(null,
                                    "Elige primero " + jugador2 + ", y debes de "
                                    + "introducir los datos por 'Scanner'");
                            for (int i = 0; i < 5; i++) {
                                System.out.println((i + 1) + "/5");
                                do {
                                    try {
                                        System.out.println(jugador2
                                                + " elige piedra, papel o tijeras: ");
                                        elegirPPTJ1 = teclado.nextLine();
                                        repetirPPT = false;
                                    } catch (InputMismatchException ime) {
                                        System.out.println("Tienes que elegir un dato "
                                                + "correcto (piedra, papel o tijeras)");
                                        teclado.nextLine();
                                    }
                                } while (repetirPPT
                                        || !(elegirPPTJ1.equalsIgnoreCase("piedra")
                                        || elegirPPTJ1.equalsIgnoreCase("papel")
                                        || elegirPPTJ1.equalsIgnoreCase("tijeras")));
                                do {
                                    try {
                                        System.out.println(jugador1
                                                + " elige piedra, papel o tijeras: ");
                                        elegirPPTJ2 = teclado.nextLine();
                                        repetirPPT = false;
                                    } catch (InputMismatchException ime) {
                                        System.out.println("Tienes que elegir un dato "
                                                + "correcto (piedra, papel o tijeras)");
                                        teclado.nextLine();
                                    }
                                } while (repetirPPT
                                        || !(elegirPPTJ2.equalsIgnoreCase("piedra")
                                        || elegirPPTJ2.equalsIgnoreCase("papel")
                                        || elegirPPTJ2.equalsIgnoreCase("tijeras")));

                                if ((elegirPPTJ1.equalsIgnoreCase("papel")//En el caso de que se quede empate
                                        && elegirPPTJ2.equalsIgnoreCase("papel"))
                                        || (elegirPPTJ1.equalsIgnoreCase("tijeras")
                                        && elegirPPTJ2.equalsIgnoreCase("tijeras"))
                                        || (elegirPPTJ1.equalsIgnoreCase("piedra")
                                        && elegirPPTJ2.equalsIgnoreCase("piedra"))) {
                                    System.out.println("Empate");
                                } else if ((elegirPPTJ2.equalsIgnoreCase("piedra")
                                        && elegirPPTJ1.equalsIgnoreCase("tijeras"))
                                        || (elegirPPTJ2.equalsIgnoreCase("tijeras")
                                        && elegirPPTJ1.equalsIgnoreCase("papel"))
                                        || (elegirPPTJ2.equalsIgnoreCase("papel")
                                        && elegirPPTJ1.equalsIgnoreCase("piedra"))) {
                                    System.out.println("Gana " + jugador1);
                                    puntosJ2 += 1;
                                } else {
                                    System.out.println("Gana " + jugador2);
                                    puntosJ1 += 1;
                                }
//                                if (puntosJ1 == 3) {
//                                    System.out.println(jugador1 + " ha llegado antes "
//                                            + "ha 3 puntos");
//                                } else {
//                                    System.out.println(jugador2 + " ha llegado antes "
//                                            + "ha 3 puntos");
//                                }
                                System.out.println("-------------------------------");
                                System.out.println(jugador2 + " tiene " + puntosJ2 + " puntos");
                                System.out.println(jugador1 + " tiene " + puntosJ1 + " puntos");
                            }
                            if (puntosJ1 > puntosJ2) {
                                JOptionPane.showMessageDialog(null,
                                        "Ha ganado " + jugador1);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Ha ganado " + jugador2);
                            }
                        }
                    }
                }

                case 2 -> {

                    jugador1 = JOptionPane.showInputDialog("Introduce tu nombre: ");
                    JOptionPane.showMessageDialog(null,
                            "Ahora se va a decidir aleatoriamente quien "
                            + "sacara primero");
                    numeroRandom = random.nextInt(1, 3);
                    switch (numeroRandom) {
                        case 1 -> {
                            JOptionPane.showMessageDialog(null,
                                    "Elige primero " + jugador1 + ", y debes de "
                                    + "introducir los datos por 'Scanner'");
                            for (int i = 0; i < 5; i++) {
                                System.out.println((i + 1) + "/5");
                                do {
                                    try {
                                        System.out.println(jugador1
                                                + " elige piedra, papel o tijeras");
                                        elegirPPTJ1 = teclado.nextLine();
                                        repetirPPT = false;
                                    } catch (InputMismatchException ime) {
                                        System.out.println("Tienes que elegir un dato "
                                                + "correcto (piedra, papel o tijeras)");
                                        teclado.nextLine();
                                    }
                                } while (repetirPPT
                                        || !(elegirPPTJ1.equalsIgnoreCase("piedra")
                                        || elegirPPTJ1.equalsIgnoreCase("papel")
                                        || elegirPPTJ1.equalsIgnoreCase("tijeras")));
                                eligeMaquinaPPT = random.nextInt(1, 3);
                                switch (eligeMaquinaPPT) {
                                    case 1 -> {
                                        maquinaPNJ = "piedra";
                                        System.out.println("La máquina ha "
                                                + "elegido " + maquinaPNJ);
                                    }
                                    case 2 -> {
                                        maquinaPNJ = "papel";
                                        System.out.println("La máquina ha "
                                                + "elegido " + maquinaPNJ);
                                    }
                                    case 3 -> {
                                        maquinaPNJ = "tijeras";
                                        System.out.println("La máquina ha "
                                                + "elegido " + maquinaPNJ);
                                    }
                                }

                                if ((elegirPPTJ1.equalsIgnoreCase("papel")
                                        && maquinaPNJ.equalsIgnoreCase("papel"))
                                        || (elegirPPTJ1.equalsIgnoreCase("tijeras")
                                        && maquinaPNJ.equalsIgnoreCase("tijeras"))
                                        || (elegirPPTJ1.equalsIgnoreCase("piedra")
                                        && maquinaPNJ.equalsIgnoreCase("piedra"))) {
                                    System.out.println("Empate");
                                } else if ((elegirPPTJ1.equalsIgnoreCase("piedra")
                                        && maquinaPNJ.equalsIgnoreCase("tijeras"))
                                        || (elegirPPTJ1.equalsIgnoreCase("tijeras")
                                        && maquinaPNJ.equalsIgnoreCase("papel"))
                                        || (elegirPPTJ1.equalsIgnoreCase("papel")
                                        && maquinaPNJ.equalsIgnoreCase("piedra"))) {
                                    System.out.println("Gana " + jugador1);
                                    puntosJ1 += 1;
                                } else {
                                    System.out.println("Gana la máquina");
                                    puntosMaq += 1;
                                }
//                                if (puntosJ1 == 3) {
//                                    System.out.println(jugador1 + " ha llegado antes "
//                                            + "ha 3 puntos");
//                                } else {
//                                    System.out.println("La máquina ha llegado antes "
//                                            + "ha 3 puntos");
//                                }
                                System.out.println("-------------------------------");
                                System.out.println(jugador1 + " tiene " + puntosJ1 + " puntos");
                                System.out.println("La máquina tiene " + puntosMaq + " puntos");
                            }
                            if (puntosJ1 > puntosMaq) {
                                JOptionPane.showMessageDialog(null,
                                        "Ha ganado " + jugador1);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Ha ganado la máquina");
                            }
                        }
                        case 2 -> {
                            JOptionPane.showMessageDialog(null,
                                    "Elige primero la máquina, y debes de "
                                    + "introducir los datos por 'Scanner'");
                            for (int i = 0; i < 5; i++) {
                                System.out.println((i + 1) + "/5");
                                eligeMaquinaPPT = random.nextInt(1, 3);
                                switch (eligeMaquinaPPT) {
                                    case 1 -> {
                                        maquinaPNJ = "piedra";
                                        System.out.println("La máquina ha "
                                                + "elegido " + maquinaPNJ);
                                    }
                                    case 2 -> {
                                        maquinaPNJ = "papel";
                                        System.out.println("La máquina ha "
                                                + "elegido " + maquinaPNJ);
                                    }
                                    case 3 -> {
                                        maquinaPNJ = "tijeras";
                                        System.out.println("La máquina ha "
                                                + "elegido " + maquinaPNJ);
                                    }
                                }
                                do {
                                    try {
                                        System.out.println(jugador1
                                                + " elige piedra, papel o tijeras");
                                        elegirPPTJ1 = teclado.nextLine();
                                        repetirPPT = false;
                                    } catch (InputMismatchException ime) {
                                        System.out.println("Tienes que elegir un dato "
                                                + "correcto (piedra, papel o tijeras)");
                                        teclado.nextLine();
                                    }
                                } while (repetirPPT
                                        || !(elegirPPTJ1.equalsIgnoreCase("piedra")
                                        || elegirPPTJ1.equalsIgnoreCase("papel")
                                        || elegirPPTJ1.equalsIgnoreCase("tijeras")));

                                if ((elegirPPTJ1.equalsIgnoreCase("papel")
                                        && maquinaPNJ.equalsIgnoreCase("papel"))
                                        || (elegirPPTJ1.equalsIgnoreCase("tijeras")
                                        && maquinaPNJ.equalsIgnoreCase("tijeras"))
                                        || (elegirPPTJ1.equalsIgnoreCase("piedra")
                                        && maquinaPNJ.equalsIgnoreCase("piedra"))) {
                                    System.out.println("Empate");
                                } else if ((elegirPPTJ1.equalsIgnoreCase("piedra")
                                        && maquinaPNJ.equalsIgnoreCase("tijeras"))
                                        || (elegirPPTJ1.equalsIgnoreCase("tijeras")
                                        && maquinaPNJ.equalsIgnoreCase("papel"))
                                        || (elegirPPTJ1.equalsIgnoreCase("papel")
                                        && maquinaPNJ.equalsIgnoreCase("piedra"))) {
                                    System.out.println("Gana " + jugador1);
                                    puntosMaq += 1;
                                } else {
                                    System.out.println("Gana la máquina");
                                    puntosJ1 += 1;
                                }
//                                if (puntosJ1 == 3) {
//                                    System.out.println(jugador1 + " ha llegado antes "
//                                            + "ha 3 puntos");
//                                } else {
//                                    System.out.println("La máquina ha llegado antes "
//                                            + "ha 3 puntos");
//                                }
                                System.out.println("-------------------------------");
                                System.out.println(jugador1 + " tiene " + puntosJ1 + " puntos");
                                System.out.println("La máquina tiene " + puntosMaq + " puntos");
                            }
                            if (puntosJ1 > puntosMaq) {
                                JOptionPane.showMessageDialog(null,
                                        "Ha ganado " + jugador1);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Ha ganado la máquina");
                            }
                        }
                    }
                }
                case 3 -> {
                    JOptionPane.showMessageDialog(null,
                            "Has elegido terminar el programa");
                }
            }
        } while (repetirPrograma);
    }
}
