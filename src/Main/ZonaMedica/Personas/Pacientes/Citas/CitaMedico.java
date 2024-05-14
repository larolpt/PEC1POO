package Main.ZonaMedica.Personas.Pacientes.Citas;

import java.util.Date;
import java.util.UUID;

import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;

public class CitaMedico extends Cita {
    //attribute
    protected UUID id;//Lo uso para poder comprarlo mas tarde con la cita Paciente
    /**
     * Si el tipo == true cita presencial
     * Si el tipo == false cita telefonica
     **/
    protected boolean tipo;
    protected PersonalSanitario medicoAsignado;

    //builder
    public CitaMedico() {
        this.tipo = true;
        this.medicoAsignado = null;

    }

    public CitaMedico(Date dia, boolean hora, UUID id, boolean tipo, PersonalSanitario medicoAsignado) {
        super(dia, hora, false);
        this.id = id;
        this.tipo = tipo;
        this.medicoAsignado = medicoAsignado;
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

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "╔════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                  CITA MÉDICA                                 ║\n" +
                "╠════════════════════════════════════════════════════════════════════════════╣\n" +
                "║ ID: " + String.format("%1$-38s", id) + "║ Tipo: " + String.format("%1$-27s", tipo ? "Presencial" : "Telefónica") + "║\n" +
                "║ Fecha: " + String.format("%1$-35s", formatearFecha(dia)) + "║ Hora: " + String.format("%1$-27s", horario ? "Mañana" : "Tarde") + "║\n" +
                "║ Médico Asignado: " + String.format("%1$-32s", medicoAsignado.getNombreCompleto()) + "║\n" +
                "╚════════════════════════════════════════════════════════════════════════════╝";
    }

}


