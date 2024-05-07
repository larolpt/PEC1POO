package Main.ZonaMedica.Campus.Hospitalizacion;

import Main.ZonaMedica.Personas.Pacientes.Paciente;

import java.time.LocalDate;

public class Habitacion {

    //attribute
    private int numero;
    private boolean ocupada;
    private Paciente paciente;
    private String motivoAdmision;
    private LocalDate fechaIngreso;

    //Builder
    public Habitacion(int numero, boolean ocupada, Paciente paciente, String motivoAdmision, LocalDate fechaIngreso) {
        this.numero = numero;
        this.ocupada = ocupada;
        this.paciente = paciente;
        this.motivoAdmision = motivoAdmision;
        this.fechaIngreso = fechaIngreso;
    }

    public Habitacion(int numero){
        this.numero = numero;
        this.ocupada = false;
        this.paciente = null;
        this.motivoAdmision = "";
        this.fechaIngreso = null;
    }

    //getters and setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getMotivoAdmision() {
        return motivoAdmision;
    }

    public void setMotivoAdmision(String motivoAdmision) {
        this.motivoAdmision = motivoAdmision;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void vaciarHabitacion(){
        this.ocupada = false;
        this.paciente = null;
        this.motivoAdmision = "";
        this.fechaIngreso = null;
    }
    public void insertPacienteHabitacion(Paciente paciente, String motivoAdmision){
        this.ocupada = true;
        this.paciente = paciente;
        this.motivoAdmision = motivoAdmision;
        this.fechaIngreso = LocalDate.now();
    }



    @Override
    public String toString() {
        String ocupadaString = ocupada ? "Ocupada" : "Desocupada";
        String pacienteString = (paciente != null) ? paciente.getNombre() : "Sin paciente asignado";
        return "=============================================\n" +
                "| Número de habitación: " + numero + "\n" +
                "===========================================\n" +
                "| Estado: " + ocupadaString + "\n" +
                "| Paciente: " + pacienteString + "\n" +
                "| Motivo de admisión: " + motivoAdmision + "\n" +
                "| Fecha de ingreso: " + fechaIngreso + "\n" +
                "===========================================";
    }
}
