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
    public void asignarSanitario(ArrayList<PersonalSanitario> data){
        Scanner input = new Scanner(System.in);
        int registro = 0;
        try{
            System.out.print("Introduce el número del sanitario que tendra" + nombre + primerApellido + "asignado: ");
            registro = input.nextInt();
            input.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            asignarSanitario(data);
        }
        this.setSanitarioAsignado(data.get(registro));
    }
    @Override
    public String toString() {
        return "Main.ZonaMedica.Persona.Estudiantes.Estudiante{" +
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
