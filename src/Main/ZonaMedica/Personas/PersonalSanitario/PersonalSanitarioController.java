package Main.ZonaMedica.Personas.PersonalSanitario;

import Main.ZonaMedica.Personas.Pacientes.Citas.Cita;
import Main.ZonaMedica.Personas.Pacientes.Citas.CitaPaciente;
import Main.ZonaMedica.Personas.PersonaController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Main.ZonaMedica.Personas.PersonalSanitario.ConsultasExternas.*;
import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.*;
import static Main.ZonaMedica.Personas.PersonalSanitario.Turno.*;
public class PersonalSanitarioController extends PersonaController {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        inputSueldo();
    }
    public static void darAltaPersonal(){
        //Llamada a los metodos para crear un nuevo trabajador y guardarlo en la lista
        dataPersonalSanitario.add(new PersonalSanitario(
                        inputNombre(),
                        inputApellido1(),
                        inputApellido2(),
                        inputDNI(),
                        inputFechaNacimiento(),
                        inputCodigoPostal(),
                        inputResidencia(),
                        inputTelefono(),
                        inputConsultaExterna(),
                        inputTurno(),
                        inputSueldo())
        );
    }
    public static void modificarDatosPersonalSanitario(){
        int opcion, registro = 0;
        try{
            System.out.print("Indique el número del registro del personal que quiera modificar: ");
            registro = input.nextInt();
            input.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            modificarDatosPersonalSanitario();
        }
        // Menú para elegir qué atributo del usuario modificar
        PersonalSanitario personal = dataPersonalSanitario.get(registro);
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
                    personal.setEspecialidad(inputConsultaExterna());
                    break;
                case 10:
                    personal.setTurno(inputTurno());
                    break;
                case 11:
                    personal.setSueldo(inputSueldo());
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
        System.out.println(" | 9. Consulta Externa    | | 10. Turno          | ");
        System.out.println(" | 11. Sueldo             | | 12. Citas          | ");
        System.out.println(" | 0. Salir               | |                    | ");
        System.out.println("---------------------------------------------------");
        System.out.print(" Opción: ");
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
    public static int inputSueldo(){
        int sueldo = 0;

        try{
            System.out.print("Introduce el sueldo de la Persona: ");
            sueldo = input.nextInt();//Input para introducir el valor numerico
        }catch (InputMismatchException e){
            input.nextLine();//Se limpia el buffered
            System.out.println("ERROR. Introduzca un valor entero");
            inputSueldo();//Si salta que el valor introducido esta mal se vuelve a llamar al metodo
        }
        return sueldo;
    }
}
