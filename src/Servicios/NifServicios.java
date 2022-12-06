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

        String NIF = fmt.format("%08d", n1.getDNI()) + "-" + n1.getLetra();
        System.out.println("Tu NIF es " + NIF);

    }
}
