package Main.ZonaMedica.Pacientes;

import java.util.Date;

public class ExpedienteMedico {
    //attribute
    protected Date fecha;
    protected String tratamiento;

    //builder
    public ExpedienteMedico(Date fecha, String tratamiento) {
        this.fecha = fecha;
        this.tratamiento = tratamiento;
    }

    //getters and setters

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
                '}';
    }
}
