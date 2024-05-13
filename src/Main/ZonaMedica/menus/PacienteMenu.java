package Main.ZonaMedica.menus;

import Main.ZonaMedica.Personas.Pacientes.Paciente;

import java.util.Scanner;

import static Main.Main.mainMenu;
import static Main.ZonaMedica.Campus.Urgencias.UrgenciasData.irUrgencias;
import static Main.ZonaMedica.Personas.Pacientes.PacienteController.darAltaPaciente;
import static Main.ZonaMedica.Personas.Pacientes.PacienteData.pacData;

public class PacienteMenu {

    public static Scanner input = new Scanner(System.in);
    public static void pacienteMenu(){
        Paciente paciente = identificarPaciente();
        int opcion;
        if(paciente != null){
            do {
                // Mostrar el menú
                System.out.println("=======================================");
                System.out.println("             MENU DE PACIENTES        ");
                System.out.println("=======================================");
                System.out.println("1. Consultar mis citas.");
                System.out.println("2. Ir urgercias.");
                System.out.println("0. Salir");
                System.out.print("Ingrese su opción: ");
                // Leer la opción del usuario
                opcion = input.nextInt();

                // Realizar acciones basadas en la opción seleccionada
                switch (opcion) {
                    case 1:
                        paciente.mostrarCitas();
                        break;
                    case 2:
                        irUrgencias(paciente);
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

    public static Paciente identificarPaciente(){
        String dni;
        Paciente paciente = null;
        System.out.print("Introduce tu dni para identificarte: ");
        dni = input.nextLine().toUpperCase().trim();
        if(!dni.matches("\\d{8}[A-HJ-NP-TV-Z]")){//Se comprueba con una expresion regular si el dni esta en el formato correcto español
            System.out.println("Formato del dni no aceptado formato debe ser(12345678X)");
            identificarPaciente();
        } else if (pacData.isEmpty()) {
            System.out.println("No hay pacientes en el sistema.");
        }
        for(Paciente p: pacData){
            if(p.getDni().equalsIgnoreCase(dni)){
                paciente = p;
                break;
            }
        }
        return paciente;
    }
}
