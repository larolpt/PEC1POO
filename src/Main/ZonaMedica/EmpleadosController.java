package Main.ZonaMedica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class EmpleadosController {
    public void darAlta(){
        String nombre, apellido1, apellido2, dni, lugarResidencia, fecha;
        int codigoPostal;
        Date fechaNacimiento;
        Scanner input = new Scanner(System.in);

        System.out.print("Añade los datos de la persona: " + "\n" + "Introduce el nombre: ");
        nombre = input.nextLine();
        System.out.print("Introduce el primer apellido: ");
        apellido1 = input.nextLine();
        System.out.print("Introduce el segundo apellido: ");
        apellido2 = input.nextLine();
        System.out.print("Introduce el dni: ");
        dni = input.nextLine();
        System.out.print("Introduce el lugar de residencia: ");
        lugarResidencia = input.nextLine();
        System.out.print("Introduce el código postal: ");
        codigoPostal = input.nextInt();
        System.out.print("Introduce la fecha de nacimiento en formato dd/MM/yyyy: ");
        fecha = input.nextLine();

        try {
            fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
            System.out.print(fechaNacimiento);
        } catch (ParseException e) {
            // Manejar una excepción si la entrada no está en el formato esperado
            System.out.println("Error: La fecha ingresada no está en el formato dd/MM/yyyy.");
        }
    }
}
