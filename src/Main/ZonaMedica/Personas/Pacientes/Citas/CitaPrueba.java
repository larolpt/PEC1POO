package Main.ZonaMedica.Personas.Pacientes.Citas;

import Main.ZonaMedica.Personas.PersonalSanitario.Turno;

import java.sql.Time;
import java.util.Date;

public class CitaPrueba extends Cita {
    //attribute
    protected TipoPruebas prueba;

    //builder

    public CitaPrueba() {
        super();
        this.prueba = null;
    }

    public CitaPrueba(Date dia, boolean hora, TipoPruebas prueba) {
        super(dia, hora, false);
        this.prueba = prueba;
    }

    //getters and setters
    public TipoPruebas getPrueba() {
        return prueba;
    }

    public void setPrueba(TipoPruebas prueba) {
        this.prueba = prueba;
    }

    @Override
    public String toString() {
        return "Main.ZonaMedica.Persona.Pacientes.CitaPrueba{" +
                "prueba=" + prueba +
                ", dia=" + dia +
                ", hora=" + horario +
                '}';
    }
}
