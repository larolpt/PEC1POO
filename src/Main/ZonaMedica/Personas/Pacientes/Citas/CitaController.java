package Main.ZonaMedica.Personas.Pacientes.Citas;

import Main.ZonaMedica.Campus.Contabilidad.Contabilidad;
import Main.ZonaMedica.Campus.Unidades.Unidades;
import Main.ZonaMedica.Personas.Pacientes.Paciente;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;
import Main.ZonaMedica.Personas.PersonalSanitario.Turno;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

import static Main.ZonaMedica.Campus.Unidades.UnidadesData.*;
import static Main.ZonaMedica.Personas.Pacientes.Citas.TipoPruebas.*;
import static Main.ZonaMedica.Personas.Pacientes.PacienteController.getPaciente;
import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.*;
public class CitaController {

    public static Scanner input = new Scanner(System.in);

    public static void menuGestionCitasMedicasPacientes() {
        int opcion;
        Paciente paciente = getPaciente();
        do {
            System.out.println("=======================================");
            System.out.println("         MENU CITAS    ");
            System.out.println("=======================================");
            System.out.println("1. Añadir nueva cita");
            System.out.println("2. Eliminar cita");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = input.nextInt();
            input.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    paciente.crearCitaMedico();
                    break;
                case 2:
                    eliminarCitasPacientes(paciente);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 0);
    }
    public static void eliminarCitasPacientes(Paciente paciente){
        int numCita = -1;
        Cita cita = null;
        paciente.mostrarCitas();
        try{
            System.out.println("Elija la cita que quiere eliminar: ");
            numCita =  input.nextInt()-1;
            cita = paciente.getCitas().get(numCita); //Cita que quiere borrar el usuario
            if(cita instanceof CitaPrueba){//Si la cita que se tiene es eliminada el coste de esta se restara a las ganancias ya que no esta hecha.
                Contabilidad.ingresosHospital -=((CitaPrueba) cita).getPrueba().getCoste();

            }
            if(cita instanceof CitaMedico){//Comprobamos si es una cita para el medico para borrar tambien la lista del medico
                for (int i=0 ; ((CitaMedico) cita).getMedicoAsignado().getCitas().size()-1 > i ; i++){
                    if(((CitaMedico) cita).getMedicoAsignado().getCitas().get(i).getId().equals((cita).getId())){//Se compara el id de las dos citas y si es igual se borra de la lista del medico
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
    private static void mostrarCitaPaciente(Paciente paciente) {
        if(paciente.getCitas().isEmpty()){
            System.out.println("No hay citas en el paciente");
        }else{
            for(int i=1; paciente.getCitas().size() > i; i++){
                System.out.println(i);
                System.out.println(paciente.getCitas().get(i));
            }
        }
    }
    public static TipoPruebas inputPrueba(){
        int prueba = 0;
        TipoPruebas pruebaElegida = null;
        mostrarPruebas();//llamada al metodo del enum para mostrar las pruebas
        try{
            System.out.print("Introduce el número asignado de cada prueba para elegir:");
            prueba = input.nextInt();
            pruebaElegida = asignarPrueba(prueba);
            Contabilidad.ingresosHospital += pruebaElegida.getCoste();
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
            if(fechaCita.before(new Date())){
                System.out.println("No puedes asignar fechas pasadas a las citas ni en el dia de hoy.");
                inputFechaCita();
            }
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
    public static PersonalSanitario inputAsignarSanitario(){//Se le asigna el Medico con el que puede ver las consultas.//Se muestran todos los medicos que hay para elegir.
        return  inputPersonalUnidad(elegirUnidadCita());
    }
    private static PersonalSanitario inputPersonalUnidad(Unidades unidad) {
        int x = 1;
        int aux = 0;
        PersonalSanitario medico = null;
        if(dataPersonalSanitario.isEmpty()){
            System.out.println("No hay personal medico");
        }else{
            for(PersonalSanitario p: dataPersonalSanitario){
                if(p.getUnidades().equals(unidad)){
                    System.out.println(x);
                    System.out.println(p.getNombreCompleto());
                    System.out.println(p.getTurno());
                    System.out.println(p.getUnidades());
                    aux++;


                }
                x++;
            }
            if (aux == 0){//Si no se ha sumado ningun personal de la unidad se muestra este mensaje
                System.out.println("No hay medicos en esta unidad.");
            }else{
                System.out.print("Elige el registro del medico de la unidad:");
                medico = dataPersonalSanitario.get(input.nextInt()-1);
            }
        }
        return medico;
    }
    public static Unidades elegirUnidadCita(){
        String unidad = "";
        String subUnidad = "";
        int opcion = 0;
        System.out.println("1. Unidades especializadas");
        System.out.println("2. Consultas externas");
        System.out.println("3. Unidad de formación");
        System.out.println("4. Enfermeria");
        //Primero obtenemos una de las unidades mas generales
        System.out.println("Eliga una unidad para la cita: ");
        opcion = input.nextInt();
        switch (opcion) {//Si la unidad tiene subunidades te hara elegir con las opciones correspondiente en cada caso.
            case 1:
                subUnidad = inputEnfermedadesComunes();
                unidad = "Unidades especializadas";
                break;
            case 2:
                subUnidad = inputConsultasExternas();
                unidad = "Consultas externas";
                break;
            case 3:
                subUnidad = "";
                unidad = "Unidad de formación";
            case 4:
                subUnidad = "";
                unidad = "Enfermeria";
            default:
                System.out.println("No existe esta opcion");
                elegirUnidadCita();
        }
        return new Unidades(unidad,subUnidad);
    }
    public static boolean obtenerHorario(PersonalSanitario medicoAsignado) {
        if (medicoAsignado.getTurno() == Turno.MAÑANA) {
            return true;
        } else if (medicoAsignado.getTurno() == Turno.TARDE) {
            return false;
        }
        return false;  // o manejo de error si es necesario
    }
}