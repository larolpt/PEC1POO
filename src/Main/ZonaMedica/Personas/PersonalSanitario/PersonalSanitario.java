package Main.ZonaMedica.Personas.PersonalSanitario;

import Main.ZonaMedica.Personas.PersonalHospital;

import java.util.Date;
import java.util.Scanner;

import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioController.*;

public class PersonalSanitario extends PersonalHospital {
    //attribute
    protected ConsultasExternas especialidad;
    protected Turno turno;

    //builder
    public PersonalSanitario() {
        this.especialidad = ConsultasExternas.NO_ASIGNADO;
        this.turno = Turno.NO_ASIGNADO;
    }
    public PersonalSanitario(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, boolean isActivo, ConsultasExternas especialidad, Turno turno) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia, isActivo);
        this.especialidad = especialidad;
        this.turno = turno;
    }

    public PersonalSanitario(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, ConsultasExternas especialidad, Turno turno) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia);
        this.especialidad = especialidad;
        this.turno = turno;
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
    @Override
    public String toString() {
        return "Main.ZonaMedica.Persona.PersonalHospital.PersonalSanitario{" +
                "especialidad=" + especialidad + '\n' +
                ", turno=" + turno + '\n' +
                ", isActivo=" + isActivo + '\n' +
                ", nombre='" + nombre + '\n' +
                ", primerApellido='" + primerApellido + '\n' +
                ", segundoApellido='" + segundoApellido + '\n' +
                ", dni='" + dni + '\n' +
                '}';
    }
}
