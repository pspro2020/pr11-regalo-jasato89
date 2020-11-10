package com.jasato;

public class Main {

    public static void main(String[] args) {
        HermanoMayor hermanoMayor = new HermanoMayor(10);
        Thread hermanoMayorThread = new Thread(hermanoMayor, "Hermano mayor");
        Thread[] compañeros = new Thread[5];

        hermanoMayorThread.start();

        for (int i = 0; i < compañeros.length; i++) {
            compañeros[i] = new Thread(new Alumno(hermanoMayor), "Alumno" + (i+1));
            compañeros[i].start();

        }
    }
}
