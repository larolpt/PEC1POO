package Main.ZonaMedica.Campus.Hospitalizacion;

import Main.ZonaMedica.Personas.Pacientes.Paciente;

import java.time.LocalDate;
import java.util.InputMismatchException;

import static Main.ZonaMedica.Personas.Pacientes.PacienteController.input;
import static Main.ZonaMedica.Personas.Pacientes.PacienteController.mostrarPacientes;
import static Main.ZonaMedica.Personas.Pacientes.PacienteData.pacienteData;

public class PlantaHabitaciones {
    public static Habitacion[] habitaciones = new Habitacion[90];
    public static void main(String[] args) {
        generarHabitaciones();
        ingresarPaciente();
    }
    public static void generarHabitaciones(){

        for(int i = 0; habitaciones.length > i; i++){
            habitaciones[i] = new Habitacion(i+1);
            System.out.println(habitaciones[i]);
        }
    }
    public static void darAltaPaciente(){
        int numAlta = -1;
        mostrarPacienteIngresados();
        try{
            System.out.println("Eliga la habitacion de a la que quieras dar de alta: ");
            numAlta = input.nextInt();
            if(!habitaciones[numAlta].isOcupada()){//Comprbamos de que la habitacion este ocupada
                throw new InputMismatchException();
            }
            if (!habitaciones[numAlta].getPaciente().isTieneSeguro()){} //Sino tiene segurp le generamos una factura para que la pague
            habitaciones[numAlta].getPaciente().setEstaIngresado(false);//El paciente deja de estar ingresado en su historial
            habitaciones[numAlta].vaciarHabitacion();//Vaciamos la habitacion dejando con valores vacios o nulos.
        }catch (InputMismatchException | IndexOutOfBoundsException e){
            System.out.println("Error: La habitacion esta vacia o no existe.");
            darAltaPaciente();
        }
    }
    public static void ingresarPaciente(){
        Paciente paciente = inputPaciente();
        paciente.setEstaIngresado(true);
        System.out.println("Introduce a que se debe el ingreso del paciente: ");
        String motivo = input.nextLine();
        for(int i=0; habitaciones.length > i; i++){
            if(!habitaciones[i].isOcupada()){//Si esta vacia se le asigna la primera habitación vacia que encuentre.
                habitaciones[i].insertPacienteHabitacion(paciente, motivo);
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
            numPaciente = input.nextInt();
            if(pacienteData.get(numPaciente).isEstaIngresado()){//Comprobamos que el paciente elegido no este ingresado
                throw new InputMismatchException();//lanzamos una excepcion si esta ingresado ya
            }
            pacienteElegido = pacienteData.get(numPaciente);
        }catch (InputMismatchException | IndexOutOfBoundsException e){
            System.out.println("Error: Este paciente no existe o esta ya ingresado.");
            inputPaciente();//Llamada al metodo para que vuelva a pedir un paciente
        }
        return pacienteElegido;
    }
    public static void mostrarPacientesNoIngresados(){
        for(int i=0; i < pacienteData.size(); i++) {
            if(!pacienteData.get(i).isEstaIngresado()){//Se filtran los pacientes que no estan ingresados
                System.out.println(i+1 + " " + pacienteData.get(i));
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
}
