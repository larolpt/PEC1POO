package Main.ZonaMedica.Campus.Mantenimiento;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MantenimientoController {
    private static final Queue<Incidencia> colaIncidencias = new LinkedList<>();
    private static final LinkedList<Incidencia> incidenciasArregladas = new LinkedList<>();


    public static void mantenimientoMenu() {
        Scanner input = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("=======================================");
            System.out.println("           MENU DE MANTENIMIENTO       ");
            System.out.println("=======================================");
            System.out.println("1. Reportar incidencia");
            System.out.println("2. Ver próxima incidencia");
            System.out.println("3. Arreglar próxima incidencia");
            System.out.println("4. Mostrar incidencias arregladas");
            System.out.println("0. Salir");

            opcion = input.nextInt();
            input.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el problema de la incidencia:");
                    String problema = input.nextLine();
                    agregarIncidencia(problema);
                    System.out.println("Incidencia reportada.");
                    break;
                case 2:
                    Incidencia proxima = verProximaIncidencia();
                    if (proxima != null) {
                        System.out.println(proxima);
                    } else {
                        System.out.println("No hay incidencias pendientes.");
                    }
                    break;
                case 3:
                    Incidencia in = arreglarIncidencia();
                    if(in == null){
                        System.out.println("No hay mas incidencias por arreglar");
                    }else{
                        System.out.println("Incidencia arreglada.");
                    }
                    break;
                case 4:
                    mostrarIncidenciasArregladas();
                    break;
                case 0:
                    System.out.println("Volviendo del programa.");
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        }while(opcion != 0);
    }

    public static void agregarIncidencia(String problema) {
        Incidencia incidencia = new Incidencia(problema);
        colaIncidencias.add(incidencia);
    }

    public static Incidencia verProximaIncidencia() {
        return colaIncidencias.peek();
    }

    public static Incidencia arreglarIncidencia() {
        Incidencia incidencia = colaIncidencias.poll();
        if (incidencia != null) {
            incidencia.setArreglada(true);
            incidenciasArregladas.add(incidencia);
        }
        return incidencia;
    }

    public static void mostrarIncidenciasArregladas() {
        System.out.println("Incidencias Arregladas:");
        for (Incidencia incidencia : incidenciasArregladas) {
            System.out.println(incidencia);
        }
    }
}
