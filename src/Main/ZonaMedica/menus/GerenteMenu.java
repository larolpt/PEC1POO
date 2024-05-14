package Main.ZonaMedica.menus;

import Main.ZonaMedica.Campus.Contabilidad.Contabilidad;
import Main.ZonaMedica.Campus.Hospitalizacion.PlantaHabitaciones;
import Main.ZonaMedica.Campus.Mantenimiento.MantenimientoController;
import Main.ZonaMedica.Personas.Estudiantes.EstudianteController;
import Main.ZonaMedica.Personas.Pacientes.Paciente;
import Main.ZonaMedica.Personas.Pacientes.PacienteController;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioController;

import java.util.Scanner;

public class GerenteMenu {

    public static void menuGerentes(){
        Scanner input = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar el menú
            System.out.println("=======================================");
            System.out.println("             MENU DE GENERENTES         ");
            System.out.println("=======================================");
            System.out.println("Menú:");
            System.out.println("1. Gestionar personal médico.");
            System.out.println("2. Gestion de estudiantes.");
            System.out.println("3. Gestion de pacientes.");
            System.out.println("4. Hospitalización de pacientes.");
            System.out.println("5. Contabilidad.");
            System.out.println("6. Gestión de servicios de mantenimiento.");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            // Leer la opción del usuario
            opcion = input.nextInt();

            // Realizar acciones basadas en la opción seleccionada
            switch (opcion) {
                case 1:
                    PersonalSanitarioController.menuPersonalSanitario();
                    break;
                case 2:
                    EstudianteController.menuEstudiante();
                    break;
                case 3:
                    PacienteController.menuPaciente();
                    break;
                case 4:
                    PlantaHabitaciones.menuHospitalizacion();
                    break;
                case 5:
                    Contabilidad.menuContabilidad();
                    break;
                case 6:
                    MantenimientoController.mantenimientoMenu();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 0);

    }
}
