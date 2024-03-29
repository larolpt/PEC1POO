package Main.ZonaMedica.PersonalHospital;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Main.ZonaMedica.PersonalHospital.ConsultasExternas.*;
import static Main.ZonaMedica.PersonalHospital.Turno.*;

public class EmpleadosController {
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
    public static void modificarDatos(PersonalSanitario medico){
        int opcion;
        // Menú para elegir qué atributo del usuario modificar
        do {
            System.out.println("Seleccione el atributo a modificar:");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido1");
            System.out.println("3. Apellido2");
            System.out.println("4. DNI");
            System.out.println("5. Fecha de Nacimiento");
            System.out.println("6. Código Postal");
            System.out.println("7. Residencia");
            System.out.println("8. Activo");
            System.out.println("9. Consulta Externa");
            System.out.println("10. Turno");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    medico.setNombre(inputNombre());
                    break;
                case 2:
                    medico.setPrimerApellido(inputApellido1());
                    break;
                case 3:
                    medico.setSegundoApellido(inputApellido2());
                    break;
                case 4:
                    medico.setDni(inputDNI());
                    break;
                case 5:
                    medico.setfNacimiento(inputFechaNacimiento());
                    break;
                case 6:
                    medico.setCodigoPostal(inputCodigoPostal());
                    break;
                case 7:
                    medico.setLugarResidencia(inputResidencia());
                    break;
                case 8:
                    medico.setActivo(inputActivo());
                    break;
                case 9:
                    medico.setEspecialidad(inputConsultaExterna());
                    break;
                case 10:
                    medico.setTurno(inputTurno());
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 0);
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
        Date fechaNacimiento = null;
        System.out.print("Introduce la fecha de nacimiento en formato dd/MM/yyyy: ");
        fecha = input.next().trim();

        try {
            fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
        } catch (ParseException e) {
            // Manejar una excepción si la entrada no está en el formato esperado
            System.out.println("Error: La fecha ingresada no está en el formato dd/MM/yyyy.");
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

    }
}
