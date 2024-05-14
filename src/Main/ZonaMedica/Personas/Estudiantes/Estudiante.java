package Main.ZonaMedica.Personas.Estudiantes;

import Main.ZonaMedica.Personas.Persona;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Estudiante extends Persona {
    //attribute
    protected PersonalSanitario sanitarioAsignado;
    protected String nombreUniversidad;
    //builder
    public Estudiante(PersonalSanitario sanitarioAsignado, String nombreUniversidad) {
        this.sanitarioAsignado = null;
        this.nombreUniversidad = "";
    }

    public Estudiante(String nombre, String primerApellido, String segundoApellido, String dni, Date fNacimiento, int codigoPostal, String lugarResidencia, int telefono, PersonalSanitario sanitarioAsignado, String nombreUniversidad) {
        super(nombre, primerApellido, segundoApellido, dni, fNacimiento, codigoPostal, lugarResidencia, telefono);
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
        return "╔═════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                              ESTUDIANTE                                                 ║\n" +
                "╠═════════════════════════════════════════════════════════════════════════════════════════╣\n" +
                "║ Nombre: " + String.format("%1$-41s", getNombreCompleto()) + "║ DNI: " + String.format("%1$-32s", dni) + "║\n" +
                "║ Dirección: " + String.format("%1$-38s", lugarResidencia) + "║ Teléfono: " + String.format("%1$-27s", telefono) + "║\n" +
                "║ Fecha de Nacimiento: " + String.format("%1$-28s", formatearFecha(fNacimiento)) + "║ Código Postal: " + String.format("%1$-22s", codigoPostal) + "║\n" +
                "║ Sanitario Asignado: " + String.format("%1$-29s", sanitarioAsignado.getNombreCompleto()) + "║ Universidad: " + String.format("%1$-24s", nombreUniversidad) + "║\n" +
                "╚═════════════════════════════════════════════════════════════════════════════════════════╝\n";

    }
}
