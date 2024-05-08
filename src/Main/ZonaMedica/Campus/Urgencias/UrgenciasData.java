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
import static Main.ZonaMedica.Personas.Pacientes.PacienteController.darAltaPaciente;
import static Main.ZonaMedica.Personas.Pacientes.PacienteData.pacienteData;


public class UrgenciasData {
    public static Queue<Urgencias> urgenciasData = new LinkedList<>();
    public static Scanner input = new Scanner(System.in);

    public static void irUrgencias(){
        urgenciasData.add(new Urgencias(indentificarPaciente(),inputProblema()));
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
    public static Paciente indentificarPaciente(){
        String dni;
        Paciente paciente = null;
        System.out.print("Introduce tu dni para identificarte: ");
        dni = input.nextLine().trim().toUpperCase();
        if(!dni.matches("\\d{8}[A-HJ-NP-TV-Z]")){//Se comprueba con una expresion regular si el dni esta en el formato correcto español
            System.out.println("Formato del dni no aceptado formato debe ser(12345678X)");
            indentificarPaciente();
        }
        for(Paciente p: pacienteData){
            if(p.getDni().equals(dni)){
                paciente = p;
                break;
            }else{
                System.out.println("No estas en el sistema indentificate con tus datos");
                darAltaPaciente();
            }
        }
        return paciente;
    }


}
