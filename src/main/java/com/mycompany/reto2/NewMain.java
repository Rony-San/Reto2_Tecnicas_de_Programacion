package com.mycompany.reto2;

import java.util.Scanner;
import java.text.*;

public class NewMain {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        
        // bandera para entrar al ciclo de elección del ejercicio 
        boolean respuesta = false;
        
        while (!respuesta) {

            System.out.println("""
                            EJERCICIOS 
                           1:  ejercicio 1 
                           2:  ejercicio 2
                           3:  ejercicio 3
                           4:  Salir de la aplicación. 
                           """);
            System.out.println(" \n Ingrese el numero del ejercicio");
            String opcion = entrada.nextLine();  // opción del ejercicio de 1 a 4 
            
            switch (opcion) {
                case "1":
                    System.out.println("Ejercicio 1 ");
                    respuesta = true;
                    punto1();
                    break;
                case "2":
                    System.out.println("Ejercicio 2 ");
                    respuesta = true;
                    punto2();
                    break;
                case "3":
                    System.out.println("Ejercicio 3 ");
                    respuesta = true;
                    punto3();
                    break;
                case "4":
                    System.out.println("Finalización del algoritmo ");
                    respuesta = true;
                    break;
            }

        }
    }
    // ********************* Punto 1 **********************************
    static void punto1() {
        System.out.println("Construir un procedimiento que calcule "
                + "el cuadrado de los N primeros enteros, haciéndolo\n"
                + "mediante sumas de números impares, "
                + "como se observa a continuación:");

        System.out.println(" ");
        System.out.println("Ingrese el numero n: ");
        int numero = entrada.nextInt();  // Numero n hasta el cual se mostrará los n cuadrados
        int sumaImpar;                  // Suma la cual se va a comparar con el cuadado del n-i termino
        String salida;
        
        
        
        for (int i = 1; i <= numero; i++) {

            sumaImpar = 0;
            salida = "";               // cadena del resultado de la suma de numeros impares
            for (int j = 1;; j++) {    // ciclo de 1 a n 

                if (j % 2 != 0) {
                    sumaImpar += j;
                    salida += sumaImpar == (i * i) ? j : j + " + ";
                }
                if (sumaImpar == (i * i)) {
                    break;
                }
            }
            System.out.println(i + "^(2)" + " = " + salida + " = " + i * i);
        }

    }
    
    // ********************* Punto 2 **********************************
    static void punto2() {
        System.out.println("Escriba un programa que, en primer lugar,"
                + " pida un número entero N, y luego, muestre en\n"
                + "pantalla los primeros N números primos para, finalmente, "
                + "mostrar la suma de estos.");

        System.out.println(" ");
        System.out.println("Ingrese el numero n: ");
        int numero = entrada.nextInt();

        
        boolean esPrimo;
        int sumatoria = 0;
        String salida = "";

        for (int i = 2; i <= numero; i++) {
            esPrimo = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    esPrimo = false;
                }
            }
            if (esPrimo) {
                sumatoria += i;
                salida = salida + i + " ";
            }

        }

        System.out.println(" Los numeros primos hasta el numero " + numero + " son " + salida);
        System.out.println(" La sumatoria de estos numeros es: " + sumatoria);

    }

    // ********************* Punto 3 **********************************
    static void punto3() {
        System.out.println("Como desarrollador de software de una "
                + "empresa de ingeniería mecánica"
                + ", se le pide construir un\n"
                + "programa que permita calcular los desarrollos posibles"
                + " de una bicicleta de montaña (MTB)");
        System.out.println(" ");

        boolean respuesta = false;
        int numeroPlatos = 0;
        while (!respuesta) {
            System.out.println("Ingrese el numero de platos ");
            numeroPlatos = entrada.nextInt();
            if (numeroPlatos <= 2) {
                respuesta = true;
            }
        }
        double[] platos = {0, 0};
        double[] piñones = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.err.println("\n PLATOS");
        for (int i = 0; i < numeroPlatos; i++) {
            System.out.println("Ingrese el numero de dientes del plato:  " + (i + 1));
            platos[i] = entrada.nextInt();
        }
        int dientes;
        System.err.println("\n PIÑONES");
        for (int i = 0; i < 12; i++) {
            boolean mayorCero = false;
            while (!mayorCero) {
                System.out.println("Ingrese el numero de dientes del piñon:  " + (i + 1));
                dientes = entrada.nextInt();
                if (dientes > 0) {
                    piñones[i] = dientes;
                    mayorCero = true;
                } else {
                    System.out.println("Ingrese un numero de dientes mayor a cero");
                }
            }

        }

        System.out.println(" ");
        System.out.println("""
                            DIMENSIONES 
                           1:  29X2.1 
                           2:  29X2.2 
                           3:  29X2.3 
                           """);
        String dimension;
        System.out.println("Ingrese la opción a elerigr para la llanta :  ");
        dimension = entrada.next();
        double llanta = 0;

        switch (dimension) {
            case "1":
                System.out.println("La dimensión escogida es de 2288mm");
                llanta = 2288;
                break;

            case "2":
                System.out.println("La dimensión escogida es de 2298mm");
                llanta = 2298;
                break;

            case "3":
                System.out.println("La dimensión escogida es de 2326mm");
                llanta = 2326;
                break;
        }

        System.out.println(llanta);
        DecimalFormat df = new DecimalFormat("#.#");
        String salida = " -         " + "Plato1: " + platos[0] + " Plato2: " + platos[1];
        System.out.println(salida);

        for (int i = 0; i < piñones.length; i++) {
            double desarrollo = 0;
            salida = "";
            salida += "piñon" + (i + 1) + ":  " + piñones[i];
            for (int j = 0; j < platos.length; j++) {
                desarrollo = platos[j] / piñones[i];
                desarrollo = desarrollo * llanta;
                salida += "    " + df.format(desarrollo);

            }
            System.out.println(salida);
        }

    }
}
