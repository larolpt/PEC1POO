package Main;

import java.util.Date;

public class PersonalHospital extends Persona{
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

    //getters and setter
    public boolean isActivo() {
        return isActivo;
    }

    public void setActivo(boolean activo) {
        isActivo = activo;
    }

    @Override
    public String toString() {
        return "Main.PersonalHospital{" +
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
