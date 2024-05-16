package Main.ZonaMedica.Campus.Hospitalizacion;

import Main.Main;
import Main.ZonaMedica.Campus.Contabilidad.Contabilidad;
import Main.ZonaMedica.Personas.Pacientes.Paciente;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Main.ZonaMedica.Personas.Pacientes.PacienteController.*;
import static Main.ZonaMedica.Personas.Pacientes.PacienteData.pacData;
//import static Main.ZonaMedica.Personas.Pacientes.PacienteData.pacienteData;

public class PlantaHabitaciones {
    public static Habitacion[] habitaciones = new Habitacion[90];

    public static void menuHospitalizacion() {
        int opcion;
        do {
            System.out.println("=======================================");
            System.out.println("         MENU HOSPITALIZACION     ");
            System.out.println("=======================================");
            System.out.println("Menú:");
            System.out.println("1. Ingresar paciente");
            System.out.println("2. Dar alta a paciente");
            System.out.println("3. Mostrar habitaciones");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = input.nextInt();
            input.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    ingresarPaciente();
                    break;
                case 2:
                    darAltaPaciente();
                    break;
                case 3:
                    mostrarEstadoHabitaciones();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarEstadoHabitaciones() {

        // Mostrar el estado de las habitaciones en líneas de 10 habitaciones
        for (int i = 0; i < habitaciones.length; i++) {
            // Imprimir el número de la habitación
            System.out.print((i + 1) + "-");

            // Imprimir el estado de la habitación
            System.out.print("[" + (habitaciones[i].isOcupada() ? "X" : " ") + "] ");

            // Salto de línea después de mostrar 10 habitaciones
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        mostrarDatosHabitacion();

    }
    public static void mostrarDatosHabitacion(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de la habitación para ver su información (si no quiere introduzca 0): ");

        int numeroHabitacion = 0;
        try {
            numeroHabitacion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            if(numeroHabitacion == 0){
                System.out.println("Ninguna habitación elegida");
            }else{
                // Verificar si el número de habitación está dentro del rango válido
                if (numeroHabitacion < 1 || numeroHabitacion > habitaciones.length) {
                    throw new IllegalArgumentException("El número de habitación debe estar entre 1 y " + habitaciones.length);
                }

                // Mostrar la información de la habitación seleccionada si está ocupada
                if (habitaciones[numeroHabitacion - 1].isOcupada()) {
                    System.out.println(habitaciones[numeroHabitacion -1]);
                } else {
                    System.out.println("La habitación " + numeroHabitacion + " está libre.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void generarHabitaciones(){
        for(int i = 0; habitaciones.length > i; i++){
            habitaciones[i] = new Habitacion(i+1);
        }
    }
    public static void darAltaPaciente(){
        int numAlta = -1;
        mostrarPacienteIngresados();
        int dias, coste;
        try{
            System.out.println("Eliga la habitacion de a la que quieras dar de alta: ");
            numAlta = input.nextInt()-1;
            input.nextLine();
            if(!habitaciones[numAlta].isOcupada()){//Comprbamos de que la habitacion este ocupada
                throw new InputMismatchException();
            }
            dias = habitaciones[numAlta].getFechaIngreso().until(LocalDate.now()).getDays();
            coste = 200 + dias*150;//El coste por dia son 150 por lo que para saber lo que le cuesta se multiplica el dia por el coste y tiene un coste el simple ingreso de 200
            Contabilidad.ingresosHospital = coste;
            if (!habitaciones[numAlta].getPaciente().isTieneSeguro()){ generarFactura(dias, coste); } //Sino tiene segurp le generamos una factura para que la pague
            habitaciones[numAlta].getPaciente().setEstaIngresado(false);//El paciente deja de estar ingresado en su historial
            habitaciones[numAlta].vaciarHabitacion();//Vaciamos la habitacion dejando con valores vacios o nulos.
        }catch (InputMismatchException | IndexOutOfBoundsException e){
            System.out.println("Error: La habitacion esta vacia o no existe.");
            input.nextLine();
            darAltaPaciente();
        }
    }
    public static void ingresarPaciente(){
        Paciente paciente = inputPaciente();
        paciente.setEstaIngresado(true);
        System.out.println("Introduce a que se debe el ingreso del paciente: ");
        String motivo = input.nextLine();//Se introduce el motivo del ingreso
        for(int i=0; habitaciones.length > i; i++){
            if(!habitaciones[i].isOcupada()){//Si esta vacia se le asigna la primera habitación vacia que encuentre.
                habitaciones[i].insertPacienteHabitacion(paciente, motivo);// se inserta el paciente y erl motivo del ingreso
                break;
            }
        }
    }

    public static void ingresarPaciente(Paciente paciente){
        paciente.setEstaIngresado(true);
        System.out.println("Introduce a que se debe el ingreso del paciente: ");
        String motivo = input.nextLine();//Se introduce el motivo del ingreso
        for(int i=0; habitaciones.length > i; i++){
            if(!habitaciones[i].isOcupada()){//Si esta vacia se le asigna la primera habitación vacia que encuentre.
                habitaciones[i].insertPacienteHabitacion(paciente, motivo);// se inserta el paciente y erl motivo del ingreso
                break;
            }
        }
    }
    public static Paciente inputPaciente(){
        int numPaciente = -1;
        Paciente pacienteElegido = null;
        mostrarPacientesNoIngresados();

        try{
            System.out.print("Introduce el numero del paciente que quieras ingresar: ");
            numPaciente = input.nextInt()-1;
            input.nextLine();
            if(pacData.get(numPaciente).isEstaIngresado()){//Comprobamos que el paciente elegido no este ingresado
                throw new InputMismatchException();//lanzamos una excepcion si esta ingresado ya
            }
            pacienteElegido = pacData.get(numPaciente);
        }catch (InputMismatchException | IndexOutOfBoundsException e){
            System.out.println("Error: Este paciente no existe o esta ya ingresado.");
            input.nextLine();
            inputPaciente();//Llamada al metodo para que vuelva a pedir un paciente
        }
        return pacienteElegido;
    }
    public static void mostrarPacientesNoIngresados(){
        for(int i=0; i < pacData.size(); i++) {
            if(!pacData.get(i).isEstaIngresado()){//Se filtran los pacientes que no estan ingresados
                System.out.println("╔════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                              Número del paciente: "+ i +"                        ║");
                System.out.println(pacData.get(i));
            }
        }
    }
    public static void mostrarPacienteIngresados(){
        for(int i=0; habitaciones.length > i; i++){
            if(habitaciones[i].isOcupada()){
                System.out.println(habitaciones[i]);
            }
        }
    }
    public static void generarFactura(int dias, int coste){
        System.out.println("=======================================");
        System.out.println("           Ticket de Factura            ");
        System.out.println("=======================================");
        System.out.println("Días de estancia: " + dias);
        System.out.println("Costo por día: " + 150);
        System.out.println("Costo de ingreso: " + 200);
        System.out.println("---------------------------------------");
        System.out.println("Costo total: " + coste);
        System.out.println("=======================================");
    }
}
