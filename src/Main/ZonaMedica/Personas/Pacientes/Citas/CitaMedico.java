package Main.ZonaMedica.Personas.Pacientes.Citas;

import java.sql.Time;
import java.util.Date;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;
import Main.ZonaMedica.Personas.PersonalSanitario.Turno;
import Main.ZonaMedica.Personas.PersonalSanitario.UnidadesEspecializadas;

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
    public CitaMedico(Date dia, boolean tipo, PersonalSanitario medicoAsignado, UnidadesEspecializadas unidad) {
        // Llamar al constructor de la superclase con dia y aux
        super(dia, obtenerAuxiliar(medicoAsignado));

        this.tipo = tipo;
        this.medicoAsignado = medicoAsignado;
        this.unidad = unidad;
    }

    public CitaMedico(Date dia, boolean hora, boolean tipo, PersonalSanitario medicoAsignado, UnidadesEspecializadas unidad) {
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
        return "Main.ZonaMedica.Persona.Pacientes.CitaMedico{" +
                "tipo=" + tipo +
                ", medicoAsignado=" + medicoAsignado +
                ", unidad=" + unidad +
                ", dia=" + dia +
                ", hora=" + horario +
                '}';
    }
    //Se obitiene del turno del personal sanitario un boolean para crear las citas
    private static boolean obtenerAuxiliar(PersonalSanitario medicoAsignado) {
        if (medicoAsignado.getTurno() == Turno.MAÑANA) {
            return true;
        } else if (medicoAsignado.getTurno() == Turno.TARDE) {
            return false;
        }
        return false;  // o manejo de error si es necesario
    }
}
