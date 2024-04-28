package Main.ZonaMedica.Personas.Pacientes.Citas;

import Main.ZonaMedica.Personas.Pacientes.Paciente;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

public class CitaPaciente extends Cita {

    //attribute
    protected UUID id;
    /**
     Si el tipo == true cita presencial
     Si el tipo == false cita telefonica
     **/
    protected boolean tipo;
    protected Paciente pacienteAsignado;

    //builder

    public CitaPaciente(Date dia, boolean hora,UUID id, boolean tipo, Paciente pacienteAsignado) {
        super(dia, hora);
        this.id = id;
        this.tipo = tipo;
        this.pacienteAsignado = pacienteAsignado;
    }

    public CitaPaciente() {
        super();
        this.tipo = false;
        this.pacienteAsignado = null;
    }

    //getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public Paciente getPacienteAsignado() {
        return pacienteAsignado;
    }

    public void setPacienteAsignado(Paciente pacienteAsignado) {
        this.pacienteAsignado = pacienteAsignado;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Main.ZonaMedica.Persona.Pacientes.CitaPaciente {").append(System.lineSeparator());
        sb.append("\tID: ").append(id).append(System.lineSeparator());
        sb.append("\tTipo: ").append(tipo ? "Presencial" : "Telefónica").append(System.lineSeparator());
        sb.append("\tPaciente asignado: ").append(pacienteAsignado).append(System.lineSeparator());
        sb.append("\tDía: ").append(dia).append(System.lineSeparator());
        sb.append("\tHorario: ").append(horario ? "Mañana" : "Tarde").append(System.lineSeparator());
        sb.append("}");
        return sb.toString();
    }
}
