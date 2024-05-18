package Main.ZonaMedica.Campus.Contabilidad;

import Main.ZonaMedica.Campus.Hospitalizacion.PlantaHabitaciones;
import Main.ZonaMedica.Personas.Estudiantes.EstudianteController;
import Main.ZonaMedica.Personas.Pacientes.PacienteController;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioController;

import java.util.Scanner;

import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.dataPersonalSanitario;

public class Contabilidad {

    public static int ingresosHospital = 0;

    /**
     * Muestra el menú de opciones para la gestión de contabilidad del hospital.
     * Permite al usuario seleccionar entre pagar las nóminas del personal sanitario,
     * revisar las ganancias del hospital o volver al menú principal.
     */
    public static void menuContabilidad(){
        Scanner input = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar el menú
            System.out.println("=======================================");
            System.out.println("         MENU CONTABILIDAD     ");
            System.out.println("=======================================");
            System.out.println("Menú:");
            System.out.println("1. Pagar Nominas Personal Sanitario.");
            System.out.println("2. Gestion de estudiantes.");
            System.out.println("0. Volver");
            System.out.print("Ingrese su opción: ");

            // Leer la opción del usuario
            opcion = input.nextInt();

            // Realizar acciones basadas en la opción seleccionada
            switch (opcion) {
                case 1:
                    pagarNominasPersonalSanitario();
                    break;
                case 2:
                    gananciasHospital();
                    break;
                case 0:
                    System.out.println("Volviendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 0);
    }

    /**
     * Muestra las ganancias actuales del hospital.
     */
    private static void gananciasHospital() {
        System.out.println("El hospital tiene actualmente unas ganancias de: " + ingresosHospital + "€");
    }

    /**
     * Calcula y muestra el detalle de las nóminas del personal sanitario y el costo total.
     */
    public static void pagarNominasPersonalSanitario(){
        int costoTotal = 0;
        System.out.println("=======================================");
        System.out.println("         Ticket de Pago de Nóminas      ");
        System.out.println("=======================================");
        System.out.println("Detalle de nóminas:");
        for (PersonalSanitario p: dataPersonalSanitario) {
            System.out.println("Nómina de: " + p.getNombreCompleto() + " | Sueldo de: " + p.getSueldo());
            costoTotal += p.getSueldo();
        }

        System.out.println("---------------------------------------");
        System.out.println("Costo total de nóminas: $" + costoTotal);
        System.out.println("=======================================");

    }

}
