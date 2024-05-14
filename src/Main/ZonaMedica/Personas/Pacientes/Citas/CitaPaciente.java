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
        super(dia, hora, false);
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


    @Override
    public String toString() {
        return "╔════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                  CITA MÉDICA                                 ║\n" +
                "╠════════════════════════════════════════════════════════════════════════════╣\n" +
                "║ ID: " + String.format("%1$-38s", id) + "║ Tipo: " + String.format("%1$-33s", tipo ? "Presencial" : "Telefónica") + "║\n" +
                "║ Fecha: " + String.format("%1$-36s", formatearFecha(dia)) + "║ Hora: " + String.format("%1$-34s", horario ? "Mañana" : "Tarde") + "║\n" +
                "║ Paciente: " + String.format("%1$-29s", pacienteAsignado.getNombreCompleto()) + "║\n" +
                "╚════════════════════════════════════════════════════════════════════════════╝";
    }

}
