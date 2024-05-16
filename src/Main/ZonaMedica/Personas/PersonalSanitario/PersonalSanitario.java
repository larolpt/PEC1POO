package Main.ZonaMedica.Personas.PersonalSanitario;

import Main.ZonaMedica.Personas.PersonalSanitario.Unidades.Unidades;
import Main.ZonaMedica.Personas.Pacientes.Citas.CitaPaciente;
import Main.ZonaMedica.Personas.Persona;

import java.util.*;

import static Main.ZonaMedica.Campus.Hospitalizacion.PlantaHabitaciones.ingresarPaciente;
import static Main.ZonaMedica.Personas.Pacientes.ExpedienteMedico.ExpedienteMedicoController.*;


public class PersonalSanitario extends Persona {
    //attribute
    protected Unidades unidad;
    protected Turno turno;

    protected ArrayList<CitaPaciente> citas;
    protected int sueldo;

    //builder
    public PersonalSanitario(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, int telefono, Unidades unidad, Turno turno, CitaPaciente citas, int sueldo) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia, telefono);
        this.unidad = unidad;
        this.turno = turno;
        this.citas.add(citas);
        this.sueldo = sueldo;
    }
    public PersonalSanitario(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, int telefono, Unidades unidad, Turno turno, int sueldo) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia, telefono);
        this.unidad = unidad;
        this.turno = turno;
        this.citas = new ArrayList<>();
        this.sueldo = sueldo;
    }

    public PersonalSanitario() {
        super();
        this.unidad = new Unidades("NO ASIGNADO","");
        this.turno = Turno.NO_ASIGNADO;
        this.citas = new ArrayList<>();
        this.sueldo = 0;
    }

    //getters and setters
    public Unidades getUnidades() {
        return unidad;
    }

    public void setUnidades(Unidades unidad) {
        this.unidad = unidad;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public ArrayList<CitaPaciente> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<CitaPaciente> citas) {
        this.citas = citas;
    }

    public void addCitas(CitaPaciente cita) {
        this.citas.add(cita);
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public void mostrarCitas(){
        for(CitaPaciente c: this.citas){
            if (c.getDia().equals(new Date()) || c.getDia().before(new Date())){
                System.out.println(c);
            }
        }
    }
    public void pasarConsultaMedico(){
        Scanner input = new Scanner(System.in);

        Queue<CitaPaciente> consultasHoy = new LinkedList<>();
        if(!this.citas.isEmpty()){
            for(CitaPaciente c: this.citas){
                if (c.getDia().getDay() == new Date().getDay() && !c.isEstaPasada()){
                    consultasHoy.add(c);
                }
            }
            if (!consultasHoy.isEmpty()) {
                CitaPaciente consulta = consultasHoy.poll();
                System.out.println("Paciente: " + consulta.getPacienteAsignado().getNombreCompleto());
                System.out.println("Elige una opción:");
                System.out.println("1. Hospitalizar al paciente");
                System.out.println("2. Realizar pruebas");
                System.out.println("3. No hacer nada");
                System.out.print("Opción: ");
                int opcion = input.nextInt();
                switch (opcion) {
                    case 1:
                        ingresarPaciente(consulta.getPacienteAsignado());
                        break;
                    case 2:
                        consulta.getPacienteAsignado().crearCitaPrueba();
                        break;
                    case 3:
                        System.out.println("No se realiza ninguna acción.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                consulta.getPacienteAsignado().setHistorialMedico(crearExpediente());//Despues de pasar la consulta modificara su expediente medico
                consulta.setEstaPasada(true);
            } else {
                System.out.println("Ya no hay mas citas.");
            }
        }else{
            System.out.println("No tienes citas para pasar");
        }
    }
    public void pasarConsultaEnfermeria(){
        Scanner input = new Scanner(System.in);

        Queue<CitaPaciente> consultasHoy = new LinkedList<>();
        if(!this.citas.isEmpty()){
            for(CitaPaciente c: this.citas){
                if (c.getDia().getDay() == new Date().getDay() && !c.isEstaPasada()){
                    consultasHoy.add(c);
                }
            }
            if (!consultasHoy.isEmpty()) {
                CitaPaciente consulta = consultasHoy.poll();
                System.out.println("Paciente: " + consulta.getPacienteAsignado().getNombreCompleto());
                System.out.println("Elige una opción:");
                System.out.println("1. Ver tratamientos");
                System.out.println("2. Realizar tratamientos");
                System.out.println("3. No hacer nada");
                System.out.print("Opción: ");
                int opcion = input.nextInt();
                switch (opcion) {
                    case 1:
                        consulta.getPacienteAsignado().mostrarHistorialMedico();
                        break;
                    case 2:
                        consulta.getPacienteAsignado().setHistorialMedico(modificarExpediente(getExpedienteMedico(consulta.getPacienteAsignado())));
                        break;
                    case 3:
                        System.out.println("No se realiza ninguna acción.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                consulta.setEstaPasada(true);
            } else {
                System.out.println("Ya no hay mas citas.");
            }
        }else{
            System.out.println("No tienes citas para pasar");
        }
    }
    public void pasarConsulta(){
        if(this.unidad.equals(new Unidades("Enfermeria",""))){
            this.pasarConsultaEnfermeria();
        }else{
            this.pasarConsultaMedico();
        }

    }


    @Override
    public String toString() {
        return "╔════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                              PERSONAL SANITARIO                            ║\n" +
                "╠════════════════════════════════════════════════════════════════════════════╣\n" +
                "║ Nombre: " + String.format("%1$-35s", getNombreCompleto()) + "║ DNI: " + String.format("%1$-25s", dni) + "║\n" +
                "║ Dirección: " + String.format("%1$-32s", lugarResidencia) + "║ Teléfono: " + String.format("%1$-20s", telefono) + "║\n" +
                "║ Fecha de Nacimiento: " + String.format("%1$-22s", formatearFecha(fNacimiento)) + "║ Código Postal: " + String.format("%1$-15s", codigoPostal) + "║\n" +
                "║ Unidad: " + String.format("%1$-35s", getUnidades().getNombreUnidad()) + "║ Turno: " + String.format("%1$-23s", turno) + "║\n" +
                "║ Subunidad: " + String.format("%1$-32s", getUnidades().getSubunidad().isEmpty() ? "No tiene subunidad":getUnidades().getSubunidad()) + "║ Sueldo: " + String.format("%1$-22s", sueldo + "€") + "║\n" +
                "╚════════════════════════════════════════════════════════════════════════════╝\n";
    }
}
