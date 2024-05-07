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

}
