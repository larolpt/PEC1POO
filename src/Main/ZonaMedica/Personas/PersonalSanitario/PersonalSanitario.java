package Main.ZonaMedica.Personas.PersonalSanitario;

import Main.ZonaMedica.Campus.Unidades.Unidades;
import Main.ZonaMedica.Personas.Pacientes.Citas.CitaPaciente;
import Main.ZonaMedica.Personas.Persona;

import java.util.ArrayList;
import java.util.Date;


public class PersonalSanitario extends Persona {
    //attribute
    protected Unidades unidad;
    protected Turno turno;

    protected ArrayList<CitaPaciente> citas;
    protected int sueldo;

    //builder
    public PersonalSanitario(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, int telefono, Unidades unidad, Turno turno, CitaPaciente citas, int sueldo) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia, telefono);
        this.unidad = unidad;
        this.turno = turno;
        this.citas.add(citas);
        this.sueldo = sueldo;
    }
    public PersonalSanitario(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, int telefono, Unidades unidad, Turno turno, int sueldo) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia, telefono);
        this.unidad = unidad;
        this.turno = turno;
        this.citas = new ArrayList<>();
        this.sueldo = sueldo;
    }

    public PersonalSanitario() {
        super();
        this.unidad = new Unidades("NO ASIGNADO","");
        this.turno = Turno.NO_ASIGNADO;
        this.citas = new ArrayList<>();
        this.sueldo = 0;
    }

    //getters and setters
    public Unidades getUnidades() {
        return unidad;
    }

    public void setUnidades(Unidades unidad) {
        this.unidad = unidad;
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

    public void addCitas(CitaPaciente cita) {
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
                "especialidad=" + unidad +
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
