package Main.ZonaMedica.menus;

import Main.ZonaMedica.Personas.Estudiantes.Estudiante;
import Main.ZonaMedica.Personas.Pacientes.Paciente;

import java.util.Scanner;

import static Main.ZonaMedica.Campus.Urgencias.UrgenciasData.irUrgencias;
import static Main.ZonaMedica.Personas.Estudiantes.EstudianteData.dataEstudiante;
import static Main.ZonaMedica.Personas.Pacientes.PacienteData.pacData;

public class EstudianteMenu {

    public static void estudianteMenu(){
        Scanner input = new Scanner(System.in);
        Estudiante estudiante = identificarEstudiante();
        int opcion;
        if(estudiante != null){
            do {
                // Mostrar el menú
                System.out.println("=======================================");
                System.out.println("           MENU DE ESTUDIANTES       ");
                System.out.println("=======================================");
                System.out.println("1. Consltar citas a las que asistir.");
                System.out.println("0. Salir");
                System.out.print("Ingrese su opción: ");
                // Leer la opción del usuario
                opcion = input.nextInt();

                // Realizar acciones basadas en la opción seleccionada
                switch (opcion) {
                    case 1:
                        estudiante.getSanitarioAsignado().mostrarCitas();
                        break;
                    case 0:
                        System.out.println("Volviendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                }
            } while (opcion != 0);
        }else{
            System.out.println("ERROR: No estas en el sistema vuelve a registrarte o indentificate en el sistema.");
        }
    }

    public static Estudiante identificarEstudiante(){
        Scanner input = new Scanner(System.in);
        String dni;
        Estudiante estudiante = null;
        System.out.print("Introduce tu dni para identificarte: ");
        dni = input.nextLine().toUpperCase().trim();
        if(!dni.matches("\\d{8}[A-HJ-NP-TV-Z]")){//Se comprueba con una expresion regular si el dni esta en el formato correcto español
            System.out.println("Formato del dni no aceptado formato debe ser(12345678X)");
            identificarEstudiante();
        } else if (pacData.isEmpty()) {
            System.out.println("No hay pacientes en el sistema.");
        }
        for(Estudiante e: dataEstudiante){
            if(e.getDni().equalsIgnoreCase(dni)){
                estudiante = e;
                break;
            }
        }
        return estudiante;
    }
}
