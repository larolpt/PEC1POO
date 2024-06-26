package Main.ZonaMedica.Personas.Pacientes;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import Main.ZonaMedica.Personas.Pacientes.Citas.Cita;
import Main.ZonaMedica.Personas.Pacientes.Citas.CitaMedico;
import Main.ZonaMedica.Personas.Pacientes.Citas.CitaPaciente;
import Main.ZonaMedica.Personas.Pacientes.Citas.CitaPrueba;
import Main.ZonaMedica.Personas.Pacientes.ExpedienteMedico.ExpedienteMedico;
import Main.ZonaMedica.Personas.Persona;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;

import static Main.ZonaMedica.Personas.Pacientes.Citas.CitaController.*;

public class Paciente extends Persona {
    //attribute
    protected boolean estaIngresado;
    protected boolean tieneSeguro;

    protected ArrayList<Cita> citas;
    protected ArrayList<ExpedienteMedico> historialMedico;

    //builder
    public Paciente(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, int telefono, boolean estaIngresado, boolean tieneSeguro, ArrayList<Cita> citas, ArrayList<ExpedienteMedico> historialMedico) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia, telefono);
        this.estaIngresado = estaIngresado;
        this.tieneSeguro = tieneSeguro;
        this.citas = citas;
        this.historialMedico = historialMedico;
    }
    public Paciente(){
        super();
        this.citas =null;
        this.historialMedico = null;
        this.estaIngresado = false;
        this.tieneSeguro = false;
    }
    public Paciente(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, int telefono, boolean tieneSeguro) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia, telefono);
        this.estaIngresado = false;
        this.tieneSeguro = tieneSeguro;
        this.citas = new ArrayList<>();
        this.historialMedico = new ArrayList<>();
    }

    //getters and setters
    public boolean isEstaIngresado() {
        return estaIngresado;
    }

    public void setEstaIngresado(boolean estaIngresado) {
        this.estaIngresado = estaIngresado;
    }

    public boolean isTieneSeguro() {
        return tieneSeguro;
    }

    public void setTieneSeguro(boolean tieneSeguro) {
        this.tieneSeguro = tieneSeguro;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    public void setCitas(CitaMedico citas) {
        this.citas.add(citas);
    }

    public ArrayList<ExpedienteMedico> getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(ArrayList<ExpedienteMedico> historialMedico) {
        this.historialMedico = historialMedico;
    }

    public void setHistorialMedico(ExpedienteMedico historialMedico) {
        this.historialMedico.add(historialMedico);
    }
    public void mostrarCitas(){
        int j=1;
        if(citas.isEmpty()){
            System.out.println("No tienes citas registradas");
        }else{
            for(int i=0; this.citas.size() > i; i++){
                System.out.println(j);
                System.out.println(this.citas.get(i));
                j++;
            }
        }
    }
    public void crearCitaPrueba(){
        this.citas.add(new CitaPrueba(
                inputFechaCita(),
                inputHorario(),
                inputPrueba()
        ));
    }
    public void crearCitaMedico(){
        PersonalSanitario medico = inputAsignarSanitario();
        if(medico != null){
            UUID id = UUID.randomUUID();
            Date fechaCita = inputFechaCita();
            boolean tipoCita = inputTipoCita();

            medico.addCitas(new CitaPaciente(
                    fechaCita,
                    obtenerHorario(medico),
                    id,
                    tipoCita,
                    this
            ));
            this.citas.add(new CitaMedico(
                    fechaCita,
                    obtenerHorario(medico),
                    id,
                    tipoCita,
                    medico
            ));
        }else{
            System.out.println("No se puede crear ya que no hay ningun medico.");
        }
    }
    public void mostrarHistorialMedico(){
        int j=1;
        for(int i=0; this.historialMedico.size() > i; i++){
            System.out.println(j);
            System.out.println(this.historialMedico.get(i));
            j++;
        }
    }

    @Override
    public String toString() {
        return "╔════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                              PACIENTE                                      ║\n" +
                "╠════════════════════════════════════════════════════════════════════════════╣\n" +
                "║ Nombre: " + String.format("%1$-35s", getNombreCompleto()) + "║ DNI: " + String.format("%1$-25s", dni) + "║\n" +
                "║ Dirección: " + String.format("%1$-32s", lugarResidencia) + "║ Teléfono: " + String.format("%1$-20s", telefono) + "║\n" +
                "║ Fecha de Nacimiento: " + String.format("%1$-22s", formatearFecha(fNacimiento)) + "║ Código Postal: " + String.format("%1$-15s", codigoPostal) + "║\n" +
                "║ Seguro Médico: " + String.format("%1$-28s", (isTieneSeguro() ? "Sí" : "No")) + "║ Esta ingresado: " + String.format("%1$-14s", (isEstaIngresado() ? "Sí" : "No")) + "║\n" +
                "╚════════════════════════════════════════════════════════════════════════════╝\n";
    }

}
