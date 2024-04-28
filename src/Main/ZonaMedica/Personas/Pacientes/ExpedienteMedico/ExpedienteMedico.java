package Main.ZonaMedica.Personas.Pacientes.ExpedienteMedico;

import java.time.LocalDate;
import java.util.Date;

public class ExpedienteMedico {
    //attribute
    protected LocalDate fecha;
    protected String tratamiento;

    protected boolean isActivo;

    //builder
    public ExpedienteMedico(LocalDate fecha, String tratamiento, boolean isActivo) {
        this.fecha = fecha;
        this.tratamiento = tratamiento;
        this.isActivo = isActivo;
    }

    //getters and setters

    public boolean isActivo() {
        return isActivo;
    }

    public void setActivo(boolean activo) {
        isActivo = activo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "ExpedienteMedico{" +
                "fecha=" + fecha +
                ", tratamiento='" + tratamiento + '\'' +
                ", isActivo=" + isActivo +
                '}';
    }
}
