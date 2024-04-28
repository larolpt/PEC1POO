package Main.ZonaMedica.Personas.Pacientes.Citas;

import Main.ZonaMedica.Personas.Pacientes.Paciente;
import Main.ZonaMedica.Personas.Persona;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;
import Main.ZonaMedica.Personas.PersonalSanitario.Turno;
import Main.ZonaMedica.Personas.PersonalSanitario.UnidadesEspecializadas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

import static Main.ZonaMedica.Personas.Pacientes.Citas.TipoPruebas.*;
import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.dataPersonalSanitario;
import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.mostrarPersonal;
import static Main.ZonaMedica.Personas.PersonalSanitario.UnidadesEspecializadas.asignarUnidad;
import static Main.ZonaMedica.Personas.PersonalSanitario.UnidadesEspecializadas.mostrarUnidades;

public class CitaController {

    public static Scanner input = new Scanner(System.in);
    public static CitaMedico inputCitaMedico(Paciente paciente){
        UUID id = UUID.randomUUID();
        Date fechaCita = inputFechaCita();
        boolean tipoCita = inputTipoCita();
        PersonalSanitario medico = inputAsignarSanitario();

        medico.addCitas(new CitaPaciente(
                fechaCita,
                obtenerHorario(medico),
                id,
                tipoCita,
                paciente
        ));
        return new CitaMedico(
                fechaCita,
                obtenerHorario(medico),
                id,
                tipoCita,
                medico,
                inputUnidadEspecializada()
        );
    }
    public static void eliminarCitasPacientes(Paciente paciente){
        int numCita = -1;
        Cita cita = null;
        try{
            System.out.println("Elija la cita que quiere eliminar: ");
            numCita =  input.nextInt()-1;
            cita = paciente.getCitas().get(numCita); //Cita que quiere borrar el usuario

            if(cita instanceof CitaMedico){//Comprobamos si es una cita para el medico para borrar tambien la lista del medico
                for (int i=0 ; ((CitaMedico) cita).getMedicoAsignado().getCitas().size()-1 > i ; i++){
                    if(((CitaMedico) cita).getMedicoAsignado().getCitas().get(i).getId().equals(((CitaMedico) cita).getId())){//Se compara el id de las dos citas y si es igual se borra de la lista del medico
                        ((CitaMedico) cita).getMedicoAsignado().getCitas().remove(i);
                        break;
                    }
                }
            }
            paciente.getCitas().remove(numCita);
            System.out.println("Borrado correctamente la cita");
        }catch(Exception e){
            System.out.println("Error: Introduce un numero o un numero asignado a la lista: ");
        }
    }
    public static void modificarCitaMedico(PersonalSanitario medico){
        int numCita = -1;
        CitaPaciente cita = null;
        Paciente paciente = null;
        try{
            System.out.println("Elija la cita que quiere eliminar: ");
            numCita =  input.nextInt()-1;
            cita = medico.getCitas().get(numCita); //Cita que quiere borrar el usuario
            paciente = medico.getCitas().get(numCita).getPacienteAsignado();//Guardamos el paciente para poder crear luego la cita con el mismo paciente
            for (int i=0 ; ((CitaPaciente) cita).getPacienteAsignado().getCitas().size()-1 > i ; i++){
                if(cita.getPacienteAsignado().getCitas().get(i).getId().equals(cita.getId())){//Se compara el id de las dos citas y si es igual se borra de la lista del medico
                    cita.getPacienteAsignado().getCitas().remove(i);
                    break;
                }
            }
            medico.getCitas().remove(numCita);
            System.out.println("Borrado correctamente la cita");
        }catch(Exception e){
            System.out.println("Error: Introduce un numero o un numero asignado a la lista: ");
        }
        inputCitaMedico(paciente);
    }
    public static CitaPrueba inputCitaPrueba(){
        return new CitaPrueba(
                inputFechaCita(),
                inputHorario(),
                inputPrueba()
        );
    }
    public static UnidadesEspecializadas inputUnidadEspecializada(){
        int unidad = 0;
        UnidadesEspecializadas unidadesEspecializadas = null;
        mostrarUnidades();//llamada al metodo del enum para mostrar las pruebas
        try{
            System.out.print("Introduce el número asignado de cada prueba para elegir:");
            unidad = input.nextInt();
            unidadesEspecializadas = asignarUnidad(unidad);
        }catch(IllegalArgumentException | InputMismatchException e){
            input.nextLine();//limpiar buffered
            System.out.println("Error: el número elegido no esta asignado a ninguna prueba");
            inputUnidadEspecializada();//llamada al metoddo si ha habido un fallo al introducir el número
        }
        return unidadesEspecializadas;
    }
    public static TipoPruebas inputPrueba(){
        int prueba = 0;
        TipoPruebas pruebaElegida = null;
        mostrarPruebas();//llamada al metodo del enum para mostrar las pruebas
        try{
            System.out.print("Introduce el número asignado de cada prueba para elegir:");
            prueba = input.nextInt();
            pruebaElegida = asignarPrueba(prueba);
        }catch(IllegalArgumentException | InputMismatchException e){
            input.nextLine();//limpiar buffered
            System.out.println("Error: el número elegido no esta asignado a ninguna prueba");
            inputPrueba();//llamada al metoddo si ha habido un fallo al introducir el número
        }
        return pruebaElegida;
    }
    public static boolean inputHorario(){
        boolean isActive = false;
        boolean isValidInput;

        do {
            System.out.println("Decide cuando quieres ir a la prueba mañana(M) o tarde(T):");
            String respuesta = input.nextLine().trim().toUpperCase();
            isValidInput = true;

            if (respuesta.equals("M") || respuesta.equals("MAÑANA")){ isActive = true; }
            else if (respuesta.equals("T") || respuesta.equals("TARDE")) { isActive = false; }
            else {
                System.out.println("Respuesta no válida. Por favor, ingrese 'M' o 'T'.");
                isValidInput = false;
            }
        } while (!isValidInput);
        return isActive;
    }
    public static Date inputFechaCita(){
        String fecha;
        Date fechaCita = null;
        System.out.print("Introduce la fecha para la cita en formato dd/MM/yyyy: ");
        fecha = input.nextLine().trim();

        try {
            fechaCita = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
            String[] partes = fecha.split("/");
            LocalDate.of(Integer.parseInt(partes[2]), Integer.parseInt(partes[1]), Integer.parseInt(partes[0]));

        } catch (ParseException e) {
            // Manejar una excepción si la entrada no está en el formato esperado
            System.out.println("Error: La fecha ingresada no está en el formato dd/MM/yyyy.");
            inputFechaCita();
        }catch (DateTimeException e ){
            // Manejar si la fecha introducida es correcta
            System.out.println("Error: La fecha ingresada no es correcta.");
            inputFechaCita();
        }
        return fechaCita;
    }
    public static boolean inputTipoCita(){
        boolean isActive = false;
        boolean isValidInput;

        do {
            System.out.print("Decide si la cita es presencial(P) o telefonica(T):");
            String respuesta = input.nextLine().trim().toUpperCase();
            isValidInput = true;

            if (respuesta.equals("P") || respuesta.equals("PRESENCIAL")){ isActive = true; }
            else if (respuesta.equals("T") || respuesta.equals("TELEFONICA") || respuesta.equals("TELEFÓNICA")) { isActive = false; }
            else {
                System.out.println("Respuesta no válida. Por favor, ingrese 'P' o 'T'.");
                isValidInput = false;
            }
        } while (!isValidInput);
        return isActive;
    }
    public static PersonalSanitario inputAsignarSanitario(){//Se le asigna el Medico con el que puede ver las consultas.
        mostrarPersonal();//Se muestran todos los medicos que hay para elegir.
        int registro = 0;
        try{
            System.out.print("Introduce el número del sanitario que tendra asignado: ");
            registro = input.nextInt()-1;//Se introduce el numero del medico y se le resta uno porque en el ArrayList empieza a contar en el 0.
            input.nextLine();//Se limpia el buffed.
            if(registro == 0){
                return null;//No se le asigna ninguno.
            }
            if(dataPersonalSanitario.size()-1 <= registro-1){
                throw new InputMismatchException();
            }
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico o un número de registro que exista. ");
            inputAsignarSanitario();//Llamada al metodo otra vez si no ha introducido un numero correcto u otra cosa que no es un numero.
        }
        return dataPersonalSanitario.get(registro-1);
    }
    private static boolean obtenerHorario(PersonalSanitario medicoAsignado) {
        if (medicoAsignado.getTurno() == Turno.MAÑANA) {
            return true;
        } else if (medicoAsignado.getTurno() == Turno.TARDE) {
            return false;
        }
        return false;  // o manejo de error si es necesario
    }
}