package Main.ZonaMedica.Personas.PersonalSanitario;

import Main.ZonaMedica.Campus.Unidades.Unidades;

import java.util.ArrayList;
import java.util.Date;

import static Main.ZonaMedica.Personas.Estudiantes.EstudianteController.inputAsignarSanitario;

public class PersonalSanitarioData {
    // Crear una dataPersonalSanitario de objetos PersonalSanitario global para poder acceder desde distintas clases.
    public static ArrayList<PersonalSanitario> dataPersonalSanitario = new ArrayList<>();

    public static void generarDatosPersonalSanitario() {

        dataPersonalSanitario.add(new PersonalSanitario("sdadadad","dasdadadad",
                "sadadada","12345678A",new Date(1903,11,11),12345,"sdadada"
        ,123456789,new Unidades("Urgencias",""),Turno.MAÑANA,1111));
        

    }
}