package Main.ZonaMedica.menus;

import Main.ZonaMedica.Campus.Contabilidad.Contabilidad;
import Main.ZonaMedica.Campus.Hospitalizacion.PlantaHabitaciones;
import Main.ZonaMedica.Campus.Unidades.Unidades;
import Main.ZonaMedica.Personas.Estudiantes.EstudianteController;
import Main.ZonaMedica.Personas.Pacientes.PacienteController;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioController;

import java.util.Scanner;

import static Main.ZonaMedica.Campus.Urgencias.UrgenciasData.mostrarCola;
import static Main.ZonaMedica.Campus.Urgencias.UrgenciasData.pasarConsulta;
import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.dataPersonalSanitario;

public class ServicioMedicinaMenu {
    public static Scanner input = new Scanner(System.in);
    public static void menuPersonalSanitario() {
        PersonalSanitario medico = identificarMedico();
        if(medico == null){

        }else if (medico.getUnidades().equals(new Unidades("Urgencias",""))) {
            menuUrgencias();
        }else{
            menuMedico(medico);
        }
    }


    public static void menuMedico(PersonalSanitario medico){
        int opcion;
        do {
            // Mostrar el menú
            System.out.println("=======================================");
            System.out.println("             MENU DE MEDICOS         ");
            System.out.println("=======================================");
            System.out.println("1. Consultar mis citas.");
            System.out.println("2. Pasar consulta.");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            // Leer la opción del usuario
            opcion = input.nextInt();

            // Realizar acciones basadas en la opción seleccionada
            switch (opcion) {
                case 1:
                    medico.mostrarCitas();
                    break;
                case 2:
                    medico.pasarConsulta();
                    break;
                case 0:
                    System.out.println("Volviendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 0);
    }
    public static void menuUrgencias(){
        int opcion;
        do {
            // Mostrar el menú
            System.out.println("=======================================");
            System.out.println("        MENU DE MEDICOS URGENCIAS ");
            System.out.println("=======================================");
            System.out.println("1. Consultar cola urgencias.");
            System.out.println("2. Pasar consulta.");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            // Leer la opción del usuario
            opcion = input.nextInt();

            // Realizar acciones basadas en la opción seleccionada
            switch (opcion) {
                case 1:
                    mostrarCola();
                    break;
                case 2:
                    pasarConsulta();
                    break;
                case 0:
                    System.out.println("Volviendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 0);
    }
    public static PersonalSanitario identificarMedico(){
        Scanner input = new Scanner(System.in);
        String dni;
        PersonalSanitario medico = null;
        System.out.print("Introduce tu dni para identificarte: ");
        dni = input.nextLine().trim().toUpperCase();
        if(!dni.matches("\\d{8}[A-HJ-NP-TV-Z]")){//Se comprueba con una expresion regular si el dni esta en el formato correcto español
            System.out.println("Formato del dni no aceptado formato debe ser(12345678X)");
            identificarMedico();
        }
        for(PersonalSanitario p:  dataPersonalSanitario){
            if(p.getDni().equalsIgnoreCase(dni)){
                medico = p;
                break;
            }else{
                System.out.println("No estas en el sistema");
                input.nextLine();
            }
        }
        return medico;
    }
}
