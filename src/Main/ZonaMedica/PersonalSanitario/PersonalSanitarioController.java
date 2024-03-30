package Main.ZonaMedica.PersonalSanitario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Main.ZonaMedica.PersonalSanitario.ConsultasExternas.*;
import static Main.ZonaMedica.PersonalSanitario.Turno.*;

public class PersonalSanitarioController {
    private static Scanner input = new Scanner(System.in);
    public static void darAlta(){
        //Llamada a los metodos para crear un nuevo trabajador
        PersonalSanitario medico = new PersonalSanitario(
                inputNombre(),
                inputApellido1(),
                inputApellido2(),
                inputDNI(),
                inputFechaNacimiento(),
                inputCodigoPostal(),
                inputResidencia(),
                inputActivo(),
                inputConsultaExterna(),
                inputTurno());
    }
    public static void mostrarAtributos(){
        System.out.println("Seleccione el atributo a modificar:");
        System.out.println("----------------------------------------------- ");
        System.out.println("| 1. Nombre              | | 2. Apellido1     | ");
        System.out.println("| 3. Apellido2           | | 4. DNI           | ");
        System.out.println("| 5. Fecha de Nacimiento | | 6. Código Postal | ");
        System.out.println("| 7. Residencia          | | 8. Activo        | ");
        System.out.println("| 9. Consulta Externa    | | 10. Turno        | ");
        System.out.println("| 0. Salir               | |                  | ");
        System.out.println("----------------------------------------------- ");
        System.out.print("Opción: ");
    }
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
    public static ConsultasExternas inputConsultaExterna() {
        ConsultasExternas especialidad = null;
        boolean isValid = false;

        do {
            try {
                System.out.println("Introduzca el número correspondiente para asignar la consulta:");
                mostrarConsultasExternas();
                System.out.print("Número Consulta: ");
                int numeroConsulta = input.nextInt();
                input.nextLine(); // Limpiar el buffer del scanner

                especialidad = asignarConsultaExterna(numeroConsulta);
                isValid = true; // Si no se lanza una excepción, el número de consulta es válido
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                input.nextLine(); // Limpiar el buffer del scanner
            }
        } while (!isValid);

        return especialidad;
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

            if (respuesta.equals("si") || respuesta.equals("s")) { isActive = true; }
            else if (respuesta.equals("no") || respuesta.equals("n")) { isActive = false; }
            else {
                System.out.println("Respuesta no válida. Por favor, ingrese 'S' o 'N'.");
                isValidInput = false;
            }
        } while (!isValidInput);

        return isActive;
    }
    public static Turno inputTurno(){
        Turno turno = null;
        boolean isValid = false;

        do {
            try {
                System.out.println("Introduzca el número correspondiente para asignar el turno:");
                mostrarTurnos();
                System.out.print("Número turno: ");
                int numTurno = input.nextInt();
                input.nextLine(); // Limpiar el buffer del scanner

                turno = asignarTurno(numTurno);
                isValid = true; // Si no se lanza una excepción, el número de consulta es válido
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                input.nextLine(); // Limpiar el buffer del scanner
            }
        } while (!isValid);

        return turno;
    }
    public static void main(String[] args) {
        inputFechaNacimiento();
    }
}
