package Main.ZonaMedica.Personas.Estudiantes;

import Main.ZonaMedica.Personas.Persona;
import Main.ZonaMedica.Personas.PersonaController;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Main.ZonaMedica.Personas.Estudiantes.EstudianteData.*;
import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.*;

public class EstudianteController extends PersonaController {
    private static Scanner input = new Scanner(System.in);
    public static void darAltaEstudiante(){
        dataEstudiante.add(new Estudiante(
                        inputNombre(),
                        inputApellido1(),
                        inputApellido2(),
                        inputDNI(),
                        inputFechaNacimiento(),
                        inputCodigoPostal(),
                        inputResidencia(),
                        inputAsignarSanitario(),
                        inputUniversidad()
                ));
    }
    public static void modificiarDatosEstudiante(){
        int opcion, registro = 0;
        try{
            System.out.print("Indique el número del registro del personal que quiera borrar: ");
            registro = input.nextInt();
            input.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            modificiarDatosEstudiante();
        }
        // Menú para elegir qué atributo del usuario modificar
        Estudiante estudiantes = dataEstudiante.get(registro);
        do {
            mostrarAtributos();
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    estudiantes.setNombre(inputNombre());
                    break;
                case 2:
                    estudiantes.setPrimerApellido(inputApellido1());
                    break;
                case 3:
                    estudiantes.setSegundoApellido(inputApellido2());
                    break;
                case 4:
                    estudiantes.setDni(inputDNI());
                    break;
                case 5:
                    estudiantes.setfNacimiento(inputFechaNacimiento());
                    break;
                case 6:
                    estudiantes.setCodigoPostal(inputCodigoPostal());
                    break;
                case 7:
                    estudiantes.setLugarResidencia(inputResidencia());
                    break;
                case 8:
                    estudiantes.setNombreUniversidad(inputUniversidad());
                    break;
                case 9:
                    estudiantes.setSanitarioAsignado(inputAsignarSanitario());
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
    public static void eliminarEstudiante(){
        int registro = 0;
        try{
            System.out.print("Indique el número del registro del estudiante que quiera borrar: ");
            registro = input.nextInt();
            input.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            eliminarEstudiante();
        }
        dataEstudiante.remove(registro);
    }
    public static String inputUniversidad(){
        System.out.print("Introduce el nombre de la Universidad: ");
        return input.nextLine().trim();
    }
    public static PersonalSanitario inputAsignarSanitario(){
        Scanner input = new Scanner(System.in);
        mostrarPersonal();
        int registro = 0;
        try{
            System.out.print("Introduce el número del sanitario que tendra asignado: ");
            registro = input.nextInt()-1;
            input.nextLine();
            if(registro == 0){
                return null;
            }
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            inputAsignarSanitario();
        }
        return dataPersonalSanitario.get(registro-1);
    }
    public static void mostrarAtributos(){
        System.out.println("Seleccione el atributo a modificar:");
        System.out.println("-----------------------------------------------------");
        System.out.println(" | 1. Nombre              | | 2. Primer apellido   | ");
        System.out.println(" | 3. Segundo apellido    | | 4. DNI               | ");
        System.out.println(" | 5. Fecha de Nacimiento | | 6. Código Postal     | ");
        System.out.println(" | 7. Residencia          | | 8. Personal Asignado | ");
        System.out.println(" | 9. Universidad         | | 0.                   | ");
        System.out.println("-----------------------------------------------------");
        System.out.print(" Opción: ");
    }

}
