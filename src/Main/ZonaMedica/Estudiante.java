package Main.ZonaMedica;

import java.util.Date;

public class Estudiante extends Persona{
    //attribute
    protected PersonalSanitario sanitarioAsignado;
    protected String nombreUniversidad;

    //builder
    public Estudiante(PersonalSanitario sanitarioAsignado, String nombreUniversidad) {
        this.sanitarioAsignado = null;
        this.nombreUniversidad = "";
    }

    public Estudiante(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, PersonalSanitario sanitarioAsignado, String nombreUniversidad) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia);
        this.sanitarioAsignado = sanitarioAsignado;
        this.nombreUniversidad = nombreUniversidad;
    }

    //getters and setters
    public PersonalSanitario getSanitarioAsignado() {
        return sanitarioAsignado;
    }

    public void setSanitarioAsignado(PersonalSanitario sanitarioAsignado) {
        this.sanitarioAsignado = sanitarioAsignado;
    }

    public String getNombreUniversidad() {
        return nombreUniversidad;
    }

    public void setNombreUniversidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }

    @Override
    public String toString() {
        return "Main.ZonaMedica.Estudiante{" +
                "sanitarioAsignado=" + sanitarioAsignado +
                ", nombreUniversidad='" + nombreUniversidad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fNacimiento=" + fNacimiento +
                ", codigoPostal=" + codigoPostal +
                ", lugarResidencia='" + lugarResidencia + '\'' +
                '}';
    }
}
