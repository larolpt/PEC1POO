package Main.ZonaMedica.Personas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {
    //attribute
    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected String dni;
    protected Date fNacimiento;
    protected int codigoPostal;
    protected String lugarResidencia;
    protected int telefono;

    public Persona(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, int telefono) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.dni = dni;
        this.fNacimiento = fNacimiento;
        this.codigoPostal = codigoPostal;
        this.lugarResidencia = lugarResidencia;
        this.telefono = telefono;
    }

    //builder
    public Persona() {
        this.nombre = "";
        this.primerApellido = "";
        this.segundoApellido = "";
        this.dni = "";
        this.fNacimiento =  new Date(0000,00,00);
        this.codigoPostal = 0;
        this.lugarResidencia = "";
        this.telefono = 123456789;
    }
    //getters and setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public void setTelefono(int telefono) { this.telefono = telefono; }
    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getDni() {
        return dni;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public int getTelefono() { return telefono; }

    public String getNombreCompleto(){
        return this.getNombre() + " " + this.getPrimerApellido() + " " + this.getSegundoApellido();
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fNacimiento=" + fNacimiento +
                ", codigoPostal=" + codigoPostal +
                ", lugarResidencia='" + lugarResidencia + '\'' +
                ", telefono=" + telefono +
                '}';
    }

    protected String formatearFecha(Date fecha) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(fecha);
    }
}
