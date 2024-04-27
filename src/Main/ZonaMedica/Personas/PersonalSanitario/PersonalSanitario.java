package Main.ZonaMedica.Personas.PersonalSanitario;

import Main.ZonaMedica.Personas.Pacientes.Citas.Cita;
import Main.ZonaMedica.Personas.Pacientes.Citas.CitaPaciente;
import Main.ZonaMedica.Personas.Persona;

import java.util.ArrayList;
import java.util.Date;

public class PersonalSanitario extends Persona {
    //attribute
    protected ConsultasExternas especialidad;
    protected Turno turno;
    protected ArrayList<CitaPaciente> citas;
    protected int sueldo;

    //builder
    public PersonalSanitario(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, int telefono, ConsultasExternas especialidad, Turno turno, CitaPaciente citas, int sueldo) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia, telefono);
        this.especialidad = especialidad;
        this.turno = turno;
        this.citas.add(citas);
        this.sueldo = sueldo;
    }
    public PersonalSanitario(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, int telefono, ConsultasExternas especialidad, Turno turno, int sueldo) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia, telefono);
        this.especialidad = especialidad;
        this.turno = turno;
        this.citas = null;
        this.sueldo = sueldo;
    }

    public PersonalSanitario() {
        super();
        this.especialidad = ConsultasExternas.NO_ASIGNADO;
        this.turno = Turno.NO_ASIGNADO;
        this.citas = null;
        this.sueldo = 0;
    }

    //getters and setters
    public ConsultasExternas getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(ConsultasExternas especialidad) {
        this.especialidad = especialidad;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public ArrayList<CitaPaciente> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<CitaPaciente> citas) {
        this.citas = citas;
    }

    public void setCitas(CitaPaciente cita) {
        this.citas.add(cita);
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }


    @Override
    public String toString() {
        return "PersonalSanitario{" +
                "especialidad=" + especialidad +
                ", turno=" + turno +
                ", citas=" + citas +
                ", sueldo=" + sueldo +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fNacimiento=" + fNacimiento +
                ", codigoPostal=" + codigoPostal +
                ", lugarResidencia='" + lugarResidencia + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
