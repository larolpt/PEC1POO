package Main.ZonaMedica.Personas.Pacientes.Citas;

import Main.ZonaMedica.Personas.Pacientes.Paciente;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;

import java.sql.Time;
import java.util.Date;

public class CitaPaciente extends Cita {

    //attribute
    /**
     Si el tipo == true cita presencial
     Si el tipo == false cita telefonica
     **/
    protected boolean tipo;
    protected Paciente pacienteAsignado;

    //builder

    public CitaPaciente(Date dia, boolean hora, boolean tipo, Paciente pacienteAsignado) {
        super(dia, hora);
        this.tipo = tipo;
        this.pacienteAsignado = pacienteAsignado;
    }

    public CitaPaciente() {
        super();
        this.tipo = false;
        this.pacienteAsignado = null;
    }

    //getters and setters

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
        return "CitaPaciente{" +
                "tipo=" + tipo +
                ", pacienteAsignado=" + pacienteAsignado +
                ", hora=" + horario +
                ", dia=" + dia +
                '}';
    }
}
