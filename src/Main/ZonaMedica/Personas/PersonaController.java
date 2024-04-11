package Main.ZonaMedica.Personas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PersonaController {
    private static Scanner input = new Scanner(System.in);
    public static String inputNombre(){
        System.out.print("Introduce el nombre: ");
        return input.nextLine().trim();
    }
    public static String inputApellido1(){
        System.out.print("Introduce el primer apellido: ");
        return input.nextLine().trim();
    }
    public static String inputApellido2(){
        System.out.print("Introduce el segundo apellido: ");
        return input.nextLine().trim();
    }
    public static String inputDNI(){
        String dni;
        System.out.print("Introduce el dni: ");
        dni = input.nextLine().trim().toUpperCase();
        if(!dni.matches("\\d{8}[A-HJ-NP-TV-Z]")){//Se comprueba con una expresion regular si el dni esta en el formato correcto español
            System.out.println("Formato del dni no aceptado formato debe ser(12345678X)");
            inputDNI();
        }
        return dni;
    }
    public static String inputResidencia(){
        System.out.print("Introduce el lugar de residencia: ");
        return input.nextLine().trim();
    }
    public static int inputCodigoPostal() {
        String cp = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Introduce el código postal: ");
            cp = input.nextLine().trim();
            // Se comprueba con una expresión regular si el cp está en el formato correcto
            if (cp.matches("\\b\\d{5}\\b")) {
                isValid = true;
            } else {
                System.out.println("Formato del código postal no aceptado. El formato debe ser 5 cifras.");
            }
        }
        return Integer.parseInt(cp);
    }
    public static Date inputFechaNacimiento(){
        String fecha;
        int mes, dia;
        Date fechaNacimiento = null;
        System.out.print("Introduce la fecha de nacimiento en formato dd/MM/yyyy: ");
        fecha = input.nextLine().trim();

        try {
            fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
            String[] partes = fecha.split("/");
            dia = Integer.parseInt(partes[0]);
            mes = Integer.parseInt(partes[1]);

            if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {
                throw new IllegalArgumentException("Fecha inválida");
            }
        } catch (ParseException e) {
            // Manejar una excepción si la entrada no está en el formato esperado
            System.out.println("Error: La fecha ingresada no está en el formato dd/MM/yyyy.");
            inputFechaNacimiento();
        }catch (IllegalArgumentException e ){
            // Manejar si la fecha introducida es correcta
            System.out.println("Error: La fecha ingresada no es correcta.");
            inputFechaNacimiento();
        }
        return fechaNacimiento;
    }
    public static boolean inputActivo() {
        boolean isActive = false;
        boolean isValidInput;

        do {
            System.out.print("¿Va a estar activo en el hospital? (S/N): ");
            String respuesta = input.nextLine().trim().toLowerCase();
            isValidInput = true;

            if (respuesta.equals("si") || respuesta.equals("s") || respuesta.equals("sí")) { isActive = true; }
            else if (respuesta.equals("no") || respuesta.equals("n")) { isActive = false; }
            else {
                System.out.println("Respuesta no válida. Por favor, ingrese 'S' o 'N'.");
                isValidInput = false;
            }
        } while (!isValidInput);
        return isActive;
    }

    public static int inputTelefono() {
        String tel = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Introduce el número de teléfono: ");
            tel = input.nextLine().trim();
            // Se comprueba con una expresión regular si el cp está en el formato correcto
            if (tel.matches("\\b\\d{9}\\b")) {
                isValid = true;
            } else {
                System.out.println("Formato del teléfono erroneo. El formato debe ser 9 cifras.");
            }
        }
        return Integer.parseInt(tel);
    }
}