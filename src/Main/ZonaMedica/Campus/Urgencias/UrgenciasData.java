package Main.ZonaMedica.Campus.Urgencias;

import Main.ZonaMedica.Personas.Pacientes.Citas.CitaPaciente;
import Main.ZonaMedica.Personas.Pacientes.Paciente;
import Main.ZonaMedica.Personas.Pacientes.PacienteData;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static Main.ZonaMedica.Campus.Hospitalizacion.PlantaHabitaciones.ingresarPaciente;
import static Main.ZonaMedica.Personas.Pacientes.ExpedienteMedico.ExpedienteMedicoController.*;


public class UrgenciasData {
    public static Queue<Urgencias> urgenciasData = new LinkedList<>();
    public static Scanner input = new Scanner(System.in);

    public static void irUrgencias(Paciente paciente){
        urgenciasData.add(new Urgencias(paciente,inputProblema()));
    }
    public static String inputProblema() {
        System.out.println("Describe el problema que tienes: ");
        return input.nextLine();
    }
    public static void pasarConsulta(){
        if(!urgenciasData.isEmpty()){
            Urgencias paciente = urgenciasData.poll();
            System.out.println("Paciente: " + paciente.getPaciente().getNombreCompleto());
            System.out.println("Elige una opción:");
            System.out.println("1. Hospitalizar paciente");
            System.out.println("2. Poner tratamiento");
            System.out.println("3. Poner cita prueba");
            System.out.println("3. Poner cita medico");
            System.out.println("4. No hacer nada");
            System.out.print("Opción: ");
            int opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    ingresarPaciente(paciente.getPaciente());
                    break;
                case 2:
                    paciente.getPaciente().setHistorialMedico(crearExpediente());
                    break;
                case 3:
                    paciente.getPaciente().crearCitaPrueba();
                    break;
                case 4:
                    paciente.getPaciente().crearCitaMedico();
                    break;
                case 5:
                    System.out.println("No se realiza ninguna acción.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }else{
            System.out.println("No tienes citas para pasar");
        }
    }
    public static void mostrarCola(){
        for(Urgencias u: urgenciasData){
            System.out.println(u);
        }
    }
}
