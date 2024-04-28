package Main.ZonaMedica.Personas.Pacientes.Citas;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

public class Cita{
    //attributes
    protected Date dia;

    /**
     Si el tipo == true cita por la mañana
     Si el tipo == false cita por la tarde
     **/
    protected boolean horario;

    //builder

    public Cita(Date dia, boolean horario) {
        this.dia = dia;
        this.horario = horario;
    }

    public Cita(){
        dia = null;
        horario = false;
    }


    //getters and setters

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public boolean isHorario() {
        return horario;
    }

    public void setHorario(boolean horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Main.ZonaMedica.Persona.Pacientes.Cita {").append(System.lineSeparator());
        sb.append("\tDía: ").append(dia).append(System.lineSeparator());
        sb.append("\tHorario: ").append(horario ? "Mañana" : "Tarde").append(System.lineSeparator());
        sb.append("}");
        return sb.toString();
    }

    public UUID getId() {
        return null;
    }
}
