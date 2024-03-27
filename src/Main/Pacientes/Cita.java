package Main.Pacientes;

import java.sql.Time;
import java.util.Date;

public class Cita{
    //attributes
    protected Date dia;
    protected Time hora;

    //builder

    public Cita() {
        this.dia = new Date(0,0,0);
        this.hora = new Time(0);
    }

    public Cita(Date dia, Time hora) {
        this.dia = dia;
        this.hora = hora;
    }

    //getters and setters

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Main.Pacientes.Cita{" +
                "dia=" + dia +
                ", hora=" + hora +
                '}';
    }
}
