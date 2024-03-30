package Main.ZonaMedica.PersonalSanitario;

import Main.ZonaMedica.PersonalHospital;

import java.util.Date;
import java.util.Scanner;

import static Main.ZonaMedica.PersonalSanitario.PersonalSanitarioController.*;

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

    public void modificarDatos(){
        int opcion;
        Scanner input = new Scanner(System.in);
        // Menú para elegir qué atributo del usuario modificar
        do {
            mostrarAtributos();
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    this.setNombre(inputNombre());
                    break;
                case 2:
                    this.setPrimerApellido(inputApellido1());
                    break;
                case 3:
                    this.setSegundoApellido(inputApellido2());
                    break;
                case 4:
                    this.setDni(inputDNI());
                    break;
                case 5:
                    this.setfNacimiento(inputFechaNacimiento());
                    break;
                case 6:
                    this.setCodigoPostal(inputCodigoPostal());
                    break;
                case 7:
                    this.setLugarResidencia(inputResidencia());
                    break;
                case 8:
                    this.setActivo(inputActivo());
                    break;
                case 9:
                    this.setEspecialidad(inputConsultaExterna());
                    break;
                case 10:
                    this.setTurno(inputTurno());
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 0);
    }

    @Override
    public String toString() {
        return "Main.ZonaMedica.PersonalHospital.PersonalSanitario{" +
                "especialidad=" + especialidad +
                ", turno=" + turno +
                ", isActivo=" + isActivo +
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
