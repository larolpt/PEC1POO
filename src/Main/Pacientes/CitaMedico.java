package Main.Pacientes;

import java.sql.Time;
import java.util.Date;
import Main.ZonaMedica.PersonalSanitario;
import Main.ZonaMedica.UnidadesEspecializadas;

public class CitaMedico extends Cita {
    //attribute
    /**
     Si el tipo == true cita presencial
     Si el tipo == false cita telefonica
     **/
    protected boolean tipo;
    protected PersonalSanitario medicoAsignado;
    protected UnidadesEspecializadas unidad;

    //builder
    public CitaMedico() {
        this.tipo = true;
        this.medicoAsignado = null;
        this.unidad = UnidadesEspecializadas.NO_NECESARIA;
    }

    public CitaMedico(Date dia, Time hora, boolean tipo, PersonalSanitario medicoAsignado, UnidadesEspecializadas unidad) {
        super(dia, hora);
        this.tipo = tipo;
        this.medicoAsignado = medicoAsignado;
        this.unidad = unidad;
    }

    //getters and setters
    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Main.Pacientes.CitaMedico{" +
                "tipo=" + tipo +
                ", medicoAsignado=" + medicoAsignado +
                ", unidad=" + unidad +
                ", dia=" + dia +
                ", hora=" + hora +
                '}';
    }
}
