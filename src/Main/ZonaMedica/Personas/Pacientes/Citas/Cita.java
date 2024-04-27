package Main.ZonaMedica.Personas.Pacientes.Citas;

import java.sql.Time;
import java.util.Date;

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
        return "Main.ZonaMedica.Persona.Pacientes.Cita{" +
                "dia=" + dia +
                ", hora=" + horario +
                '}';
    }
}
