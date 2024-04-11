package Main.ZonaMedica.Personas.Pacientes;

import Main.ZonaMedica.Personas.Pacientes.Citas.Cita;
import Main.ZonaMedica.Personas.PersonaController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PacienteController extends PersonaController {
    public static Scanner input = new Scanner(System.in);
    public static Cita inputCita(){
        int opcion;
        System.out.println("¿Qué tipo de prueba quiere dar de alta? Introduzca el número correspondiente: ");
        System.out.println("---------------------------------------------------------");
        System.out.println("| 1.-Cita con Personal Medico. | 2.-Cita prueba medica. |");
        System.out.println("---------------------------------------------------------");
        System.out.print("Opcion: ");
        try{
            opcion = input.nextInt();
            if(opcion == 1){}
            else if (opcion == 2) {}
            else{}
        }catch (InputMismatchException e){

        }
        return new Cita();
    }
    public static boolean inputTieneSeguro(){
        System.out.print("¿Tiéne seguro medico? (S/N): ");
        return respuestaSiNO();
    }
    public static boolean inputEstaIngresado(){
        System.out.print("¿Esta ingresado? (S/N): ");
        return respuestaSiNO();
    }
    public static boolean respuestaSiNO(){
        boolean isActive = false;
        boolean isValidInput;

        do {
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
}
