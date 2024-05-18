package Main.ZonaMedica.Personas.Pacientes.Citas;

import java.sql.Time;
import java.text.SimpleDateFormat;
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
    protected boolean estaPasada;

    //buider

    public Cita(Date dia, boolean horario, boolean estaPasada) {
        this.dia = dia;
        this.horario = horario;
        this.estaPasada = estaPasada;
    }

    public Cita(){
        this.dia = null;
        this.horario = false;
        this.estaPasada = false;
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

    public boolean isEstaPasada() {
        return estaPasada;
    }

    public void setEstaPasada(boolean estaPasada) {
        this.estaPasada = estaPasada;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "dia=" + dia +
                ", horario=" + horario +
                '}';
    }
    protected String formatearFecha(Date fecha) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(fecha);
    }

    public UUID getId() {
        return null;
    }
}
