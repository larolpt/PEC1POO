package Main.ZonaMedica.menus;

import java.util.ArrayList;
import java.util.Scanner;

public class AparcamientoMenu {
    private static ArrayList<String> vehiculos = new ArrayList<>();
    private static final int CAPACIDAD_MAXIMA = 90;

    public static void aparcamientoMenu() {
        Scanner input = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("=======================================");
            System.out.println("             APARCAMIENTO        ");
            System.out.println("=======================================");
            System.out.println("1. Ingresar vehículo");
            System.out.println("2. Sacar vehículo");
            System.out.println("3. Mostrar cantidad de vehículos estacionados");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción:");

            opcion = input.nextInt();
            input.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    ingresarVehiculo();
                    break;
                case 2:
                    sacarVehiculo();
                    break;
                case 3:
                    System.out.println("Cantidad de vehículos estacionados: " + vehiculos.size());
                    break;
                case 0:
                    System.out.println("Volviendo...");
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        }while(opcion != 0);
    }

    private static void ingresarVehiculo() {
        Scanner input = new Scanner(System.in);
        if (vehiculos.size() >= CAPACIDAD_MAXIMA) {
            System.out.println("El parking está lleno. No se pueden ingresar más vehículos.");
            return;
        }

        System.out.println("Ingrese la matrícula de su vehículo:");
        String matricula = input.nextLine();

        vehiculos.add(matricula);
        System.out.println("Vehículo con matrícula " + matricula + " ingresado al parking.");
    }

    private static void sacarVehiculo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese la matrícula de su vehículo a sacar:");
        String matricula = input.nextLine();

        if (vehiculos.remove(matricula)) {
            System.out.println("Vehículo con matrícula " + matricula + " sacado del parking.");
        } else {
            System.out.println("No se encontró ningún vehículo con esa matrícula en el parking.");
        }
    }
}

