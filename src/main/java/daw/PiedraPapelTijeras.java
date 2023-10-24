/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

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
        int mostrarMenu = 0, numeroRandom, puntosJ1 = 0, puntosJ2 = 0;
        boolean menuRepetir = true;
        String menu = """
                    ----------------------------------------------  
                      1.- Juego de dos jugadores
                      2.- Juego de un jugador contra la máquina
                      3.- Salir
                    ----------------------------------------------
                      """;
        String jugador1, jugador2, elegirPPTJ1, elegirPPTJ2;
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

        switch (mostrarMenu) {
            case 1 -> {
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
                    case 1 -> {
                        JOptionPane.showMessageDialog(null,
                                "Elige primero " + jugador1 + ", y debes de "
                                + "introducir los datos por 'Scanner'");
                        for (int i = 0; i < 5; i++) {
                            System.out.println("Elige piedra, papel o tijeras "
                                    + "jugador 1º: ");
                            elegirPPTJ1 = teclado.nextLine();
                            System.out.println("Elige piedra, papel o tijeras "
                                    + "jugador 2º: ");
                            elegirPPTJ2 = teclado.nextLine();

                            if (elegirPPTJ1.equalsIgnoreCase("piedra")
                                    && elegirPPTJ2.equalsIgnoreCase("tijeras")) {
                                System.out.println("Gana " + jugador1);
                                puntosJ1 += 1;
                            } else if (elegirPPTJ2.equalsIgnoreCase("piedra")
                                    && elegirPPTJ1.equalsIgnoreCase("tijeras")) {
                                System.out.println("Gana " + jugador2);
                                puntosJ2 += 1;
                            }
                            if (elegirPPTJ1.equalsIgnoreCase("tijeras")
                                    && elegirPPTJ2.equalsIgnoreCase("papel")) {
                                System.out.println("Gana " + jugador1);
                                puntosJ1 += 1;
                            } else if (elegirPPTJ2.equalsIgnoreCase("tijeras")
                                    && elegirPPTJ1.equalsIgnoreCase("papel")) {
                                System.out.println("Gana " + jugador2);
                                puntosJ2 += 1;
                            }
                            if (elegirPPTJ1.equalsIgnoreCase("papel")
                                    && elegirPPTJ2.equalsIgnoreCase("piedra")) {
                                System.out.println("Gana " + jugador1);
                                puntosJ1 += 1;
                            } else if (elegirPPTJ2.equalsIgnoreCase("papel")
                                    && elegirPPTJ1.equalsIgnoreCase("piedra")) {
                                System.out.println("Gana " + jugador2);
                                puntosJ2 += 1;
                            } else if (elegirPPTJ1.equalsIgnoreCase("papel")
                                    && elegirPPTJ2.equalsIgnoreCase("papel")) {
                                System.out.println("Empate");
                            } else if (elegirPPTJ1.equalsIgnoreCase("tijeras")
                                    && elegirPPTJ2.equalsIgnoreCase("tijeras")) {
                                System.out.println("Empate");
                            } else if (elegirPPTJ1.equalsIgnoreCase("piedra")
                                    && elegirPPTJ2.equalsIgnoreCase("piedra")) {
                                System.out.println("Empate");
                            }
                        }
                        System.out.println("-------------------------------");
                        System.out.println(jugador1 + " tiene " + puntosJ1 + " puntos");
                        System.out.println(jugador2 + " tiene " + puntosJ2 + " puntos");

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
                            System.out.println("Elige piedra, papel o tijeras "
                                    + "jugador 1º: ");
                            elegirPPTJ1 = teclado.nextLine();
                            System.out.println("Elige piedra, papel o tijeras "
                                    + "jugador 2º: ");
                            elegirPPTJ2 = teclado.nextLine();

                            if (elegirPPTJ1.equalsIgnoreCase("piedra")
                                    && elegirPPTJ2.equalsIgnoreCase("tijeras")) {
                                System.out.println("Gana " + jugador1);
                                puntosJ1 += 1;
                            } else if (elegirPPTJ2.equalsIgnoreCase("piedra")
                                    && elegirPPTJ1.equalsIgnoreCase("tijeras")) {
                                System.out.println("Gana " + jugador2);
                                puntosJ2 += 1;
                            }
                            if (elegirPPTJ1.equalsIgnoreCase("tijeras")
                                    && elegirPPTJ2.equalsIgnoreCase("papel")) {
                                System.out.println("Gana " + jugador1);
                                puntosJ1 += 1;
                            } else if (elegirPPTJ2.equalsIgnoreCase("tijeras")
                                    && elegirPPTJ1.equalsIgnoreCase("papel")) {
                                System.out.println("Gana " + jugador2);
                                puntosJ2 += 1;
                            }
                            if (elegirPPTJ1.equalsIgnoreCase("papel")
                                    && elegirPPTJ2.equalsIgnoreCase("piedra")) {
                                System.out.println("Gana " + jugador1);
                                puntosJ1 += 1;
                            } else if (elegirPPTJ2.equalsIgnoreCase("papel")
                                    && elegirPPTJ1.equalsIgnoreCase("piedra")) {
                                System.out.println("Gana " + jugador2);
                                puntosJ2 += 1;
                            } else if (elegirPPTJ1.equalsIgnoreCase("papel")
                                    && elegirPPTJ2.equalsIgnoreCase("papel")) {
                                System.out.println("Empate");
                            } else if (elegirPPTJ1.equalsIgnoreCase("tijeras")
                                    && elegirPPTJ2.equalsIgnoreCase("tijeras")) {
                                System.out.println("Empate");
                            } else if (elegirPPTJ1.equalsIgnoreCase("piedra")
                                    && elegirPPTJ2.equalsIgnoreCase("piedra")) {
                                System.out.println("Empate");
                            }
                        }
                        System.out.println("-------------------------------");
                        System.out.println(jugador1 + " tiene " + puntosJ1 + " puntos");
                        System.out.println(jugador2 + " tiene " + puntosJ2 + " puntos");

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

            }

            case 3 -> {
                JOptionPane.showMessageDialog(null,
                        "Has elegido terminar el programa");
            }
        }
    }
}
