package Main.ZonaMedica.Personas.Pacientes.Citas;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;
import Main.ZonaMedica.Personas.PersonalSanitario.Turno;
import Main.ZonaMedica.Personas.PersonalSanitario.UnidadesEspecializadas;

public class CitaMedico extends Cita {
    //attribute
    protected UUID id;//Lo uso para poder comprarlo mas tarde con la cita Paciente
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

    public CitaMedico(Date dia, boolean hora, UUID id, boolean tipo, PersonalSanitario medicoAsignado, UnidadesEspecializadas unidad) {
        super(dia, hora);
        this.id = id;
        this.tipo = tipo;
        this.medicoAsignado = medicoAsignado;
        this.unidad = unidad;
    }

    //getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PersonalSanitario getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(PersonalSanitario medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }

    public UnidadesEspecializadas getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadesEspecializadas unidad) {
        this.unidad = unidad;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        String citaType = tipo ? "Presencial" : "Telefónica";
        String medicoInfo = (medicoAsignado != null) ? medicoAsignado.toString() : "No asignado";

        StringBuilder sb = new StringBuilder();
        sb.append("Main.ZonaMedica.Persona.Pacientes.CitaMedico {");
        sb.append(System.lineSeparator());
        sb.append("\tTipo: ").append(citaType);
        sb.append(System.lineSeparator());
        sb.append("\tMédico asignado: ").append(medicoInfo);
        sb.append(System.lineSeparator());
        sb.append("\tUnidad: ").append(unidad);
        sb.append(System.lineSeparator());
        sb.append("\tDía: ").append(dia);
        sb.append(System.lineSeparator());
        sb.append("\tHora: ").append(horario);
        sb.append(System.lineSeparator());
        sb.append("}");

        return sb.toString();
    }
}
