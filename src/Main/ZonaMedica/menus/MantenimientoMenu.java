package Main.ZonaMedica.menus;

import Main.ZonaMedica.Campus.Mantenimiento.Incidencia;
import Main.ZonaMedica.Campus.Mantenimiento.MantenimientoController;

import java.util.Scanner;

import static Main.ZonaMedica.Campus.Mantenimiento.MantenimientoController.*;

public class MantenimientoMenu {
    public static void mantenimientoMenuTrabajadores() {
        Scanner input = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("=======================================");
            System.out.println("           MENU DE MANTENIMIENTO       ");
            System.out.println("=======================================");
            System.out.println("1. Ver próxima incidencia");
            System.out.println("2. Arreglar próxima incidencia");
            System.out.println("3. Mostrar incidencias arregladas");
            System.out.println("0. Salir");
            System.out.print("Eliga una opción: ");
            opcion = input.nextInt();
            input.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    Incidencia proxima = verProximaIncidencia();
                    if (proxima != null) {
                        System.out.println("Próxima incidencia: " + proxima.getProblema());
                    } else {
                        System.out.println("No hay incidencias pendientes.");
                    }
                    break;
                case 2:
                    Incidencia in = arreglarIncidencia();
                    if(in == null){
                        System.out.println("No hay mas incidencias por arreglar");
                    }else{
                        System.out.println("Incidencia arreglada.");
                    }
                    break;
                case 3:
                    mostrarIncidenciasArregladas();
                    break;
                case 0:
                    System.out.println("Volviendo del programa.");
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (opcion != 0);
    }
}
