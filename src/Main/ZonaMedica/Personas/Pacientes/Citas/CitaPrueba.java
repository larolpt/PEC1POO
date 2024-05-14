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

        return "╔════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                CITA DE PRUEBA                              ║\n" +
                "╠════════════════════════════════════════════════════════════════════════════╣\n" +
                "║ Fecha: " + String.format("%1$-36s", formatearFecha(dia)) + "║ Hora: " + String.format("%1$-34s", horario ? "Mañana" : "Tarde") + "║\n" +
                "║ Prueba: " + String.format("%1$-65s", prueba.toString()) + "║\n" +
                "╚═════════════════════════════════════════════════════════════════════════════╝";

    }
}
