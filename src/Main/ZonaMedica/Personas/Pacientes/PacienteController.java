package Main.ZonaMedica.Personas.Pacientes;

import Main.ZonaMedica.Personas.Pacientes.Citas.Cita;
import Main.ZonaMedica.Personas.PersonaController;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Main.ZonaMedica.Personas.Pacientes.PacienteData.pacienteData;
import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.dataPersonalSanitario;

public class PacienteController extends PersonaController {
    public static Scanner input = new Scanner(System.in);

    public static void darAltaPersonal(){
        //Llamada a los metodos para crear un nuevo trabajador y guardarlo en la lista
        pacienteData.add(new Paciente(
                inputNombre(),
                inputApellido1(),
                inputApellido2(),
                inputDNI(),
                inputFechaNacimiento(),
                inputCodigoPostal(),
                inputResidencia(),
                inputTelefono(),
                inputEstaIngresado(),
                inputTieneSeguro()
                )
        );
    }
    public static void modificarDatosPacientes(){
        int opcion, registro = 0;
        try{
            System.out.print("Indique el número del registro del personal que quiera modificar: ");
            registro = input.nextInt();
            input.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            modificarDatosPacientes();
        }
        // Menú para elegir qué atributo del usuario modificar
        Paciente personal = pacienteData.get(registro);
        do {
            mostrarAtributos();
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    personal.setNombre(inputNombre());
                    break;
                case 2:
                    personal.setPrimerApellido(inputApellido1());
                    break;
                case 3:
                    personal.setSegundoApellido(inputApellido2());
                    break;
                case 4:
                    personal.setDni(inputDNI());
                    break;
                case 5:
                    personal.setfNacimiento(inputFechaNacimiento());
                    break;
                case 6:
                    personal.setCodigoPostal(inputCodigoPostal());
                    break;
                case 7:
                    personal.setLugarResidencia(inputResidencia());
                    break;
                case 8:
                    personal.setTelefono(inputTelefono());
                    break;
                case 9:
                    personal.setEstaIngresado(inputEstaIngresado());
                    break;
                case 10:
                    personal.setTieneSeguro(inputTieneSeguro());
                    break;
                case 11:

                    break;
                case 12:
                    //persona.setCitas(inputCitaPersonal);
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
    public static void eliminarPersonalSanitario(){
        int registro = 0;
        try{
            System.out.print("Indique el número del registro del personal que quiera borrar: ");
            registro = input.nextInt();
            input.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            eliminarPersonalSanitario();
        }
        dataPersonalSanitario.remove(registro);
    }
    public static void mostrarPersonal(){
        for(int i=0; i < dataPersonalSanitario.size(); i+=2) {
            System.out.print(dataPersonalSanitario.get(i));
            System.out.print(dataPersonalSanitario.get(i += 1));
            System.out.println(" ");
        }
    }
    public static void mostrarAtributos(){
        System.out.println("Seleccione el atributo a modificar:");
        System.out.println("---------------------------------------------------");
        System.out.println(" | 1. Nombre              | | 2. Primer apellido | ");
        System.out.println(" | 3. Segundo apellido    | | 4. DNI             | ");
        System.out.println(" | 5. Fecha de Nacimiento | | 6. Código Postal   | ");
        System.out.println(" | 7. Residencia          | | 8. Teléfono        | ");
        System.out.println(" | 9. Esta ingresado      | | 10. Tiene Seguro   | ");
        System.out.println(" | 11. Citas              | | 12. Historial      | ");
        System.out.println(" | 0. Salir               | |                    | ");
        System.out.println("---------------------------------------------------");
        System.out.print(" Opción: ");
    }
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
