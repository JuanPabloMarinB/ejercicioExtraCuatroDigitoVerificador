package Servicios;

import Entidades.Nif;

import java.util.Formatter;
import java.util.Scanner;

public class NifServicios {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    Formatter fmt = new Formatter();

    String[] vectorLetras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X",
            "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

    Nif n1 = new Nif();

    public Nif crearNif() {

        System.out.println(n1.getDNI());

        System.out.println("Ingresa tu DNI (Debe ser de 8 dígitos)");
        n1.setDNI(sc.nextLong());


        while (n1.getDNI() < 99999 || n1.getDNI() > 99999999) {
            System.out.println("DNI incorrecto");
            System.out.println("El DNI debe ser de 8 dígitos exactos");
            n1.setDNI(sc.nextLong());
        }

        n1.setLetra(vectorLetras[(int) (n1.getDNI() % 23)]);

        return n1;

    }

    public void mostrar() {

        String DNIString = String.valueOf(n1.getDNI());
        String NIF;

        if (n1.getLetra() == null) {
            System.out.println("No has ingresado los datos para crear el NIF");
        } else if (DNIString.length() < 8) {
            NIF = "00" + DNIString + "-" + n1.getLetra();
            System.out.println("Tu NIF es " + NIF);
        } else {
            NIF = DNIString + "-" + n1.getLetra();
            System.out.println("Tu NIF es " + NIF);
        }
    }

    public void menu() {

        boolean salir = false;

        do {

            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Crear NIF");
            System.out.println("2. Mostrar NIF");
            System.out.println("3. Salir");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> crearNif();
                case 2 -> mostrar();
                case 3 -> salir = true;
                default -> System.out.println("Opción incorrecta");
            }

        } while (!salir);

        System.out.println("Nos vemos pronto");

    }
}
