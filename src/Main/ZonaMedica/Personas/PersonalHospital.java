package Main.ZonaMedica.Personas;

import java.util.Date;

public class PersonalHospital extends Persona {
    //attribute
    protected boolean isActivo;

    //builder
    public PersonalHospital() {
        super();
        this.isActivo = false;
    }

    public PersonalHospital(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, boolean isActivo) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia);
        this.isActivo = isActivo;
    }
    public PersonalHospital(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia);
        this.isActivo = true;
    }

    //getters and setter
    public boolean getIsActivo() {
        return isActivo;
    }

    public void setIsActivo(boolean activo) {
        isActivo = activo;
    }

    @Override
    public String toString() {
        return "Main.ZonaMedica.Persona.PersonalHospital.PersonalHospital{" +
                "isActivo=" + isActivo +
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
