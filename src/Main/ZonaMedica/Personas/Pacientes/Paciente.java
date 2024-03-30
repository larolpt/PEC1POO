package Main.ZonaMedica.Personas.Pacientes;

import java.util.ArrayList;
import java.util.Date;

import Main.ZonaMedica.Personas.Persona;
public class Paciente extends Persona {
    //attribute
    protected boolean estaIngresado;
    protected boolean tieneSeguro;
    protected ArrayList<Cita> citas;
    protected ArrayList<ExpedienteMedico> historialMedico;

    //builder
    public Paciente(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, boolean estaIngresado, boolean tieneSeguro, ArrayList<Cita> citas, ArrayList<ExpedienteMedico> historialMedico) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia);
        this.estaIngresado = estaIngresado;
        this.tieneSeguro = tieneSeguro;
        this.citas = citas;
        this.historialMedico = historialMedico;
    }

    //getters and setters
    public boolean isEstaIngresado() {
        return estaIngresado;
    }

    public void setEstaIngresado(boolean estaIngresado) {
        this.estaIngresado = estaIngresado;
    }

    public boolean isTieneSeguro() {
        return tieneSeguro;
    }

    public void setTieneSeguro(boolean tieneSeguro) {
        this.tieneSeguro = tieneSeguro;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    public ArrayList<ExpedienteMedico> getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(ArrayList<ExpedienteMedico> historialMedico) {
        this.historialMedico = historialMedico;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "estaIngresado=" + estaIngresado +
                ", tieneSeguro=" + tieneSeguro +
                ", citas=" + citas +
                ", historialMedico=" + historialMedico +
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
