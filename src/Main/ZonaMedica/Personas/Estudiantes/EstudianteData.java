package Main.ZonaMedica.Personas.Estudiantes;

import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;

import java.util.ArrayList;
import java.util.Date;


public class EstudianteData {
    public static ArrayList<Estudiante> dataEstudiante = new ArrayList<>();

    public static void generarEstudiantes(){
        dataEstudiante.add(new Estudiante("Manolo", "Garcia","Garcia","12345678A", new Date(10 / 6 / 2000), 39012, "Calle floranes nº2", 123456789, new PersonalSanitario(), "Universidad de Cantabria"));
        dataEstudiante.add(new Estudiante("Luis", "López", "Martínez", "98765432B", new Date(15 / 3 / 1999), 28001, "Calle Mayor nº5", 987654321, new PersonalSanitario(), "Universidad Complutense de Madrid"));
        dataEstudiante.add(new Estudiante("María", "Sánchez", "García", "13579246C", new Date(20 / 11 / 2001), 46002, "Avenida Libertad nº15", 987654321, new PersonalSanitario(), "Universidad de Valencia"));
        dataEstudiante.add(new Estudiante("Carlos", "Martín", "López", "24681357D", new Date(5 / 9 / 1998), 29010, "Calle Granada nº8", 123456789, new PersonalSanitario(), "Universidad de Málaga"));
        dataEstudiante.add(new Estudiante("Laura", "González", "Fernández", "78945612E", new Date(12 / 07 / 2000), 00001, "Plaza Cataluña nº20", 987654321, new PersonalSanitario(), "Universidad de Barcelona"));
        dataEstudiante.add(new Estudiante("Juan", "Hernández", "Sánchez", "36985214F", new Date(25 / 05 / 2002), 41001, "Calle Sevilla nº30", 123456789, new PersonalSanitario(), "Universidad de Sevilla"));
        dataEstudiante.add(new Estudiante("Ana", "Pérez", "Martínez", "25874136G", new Date(30 / 8 / 1997), 15001, "Calle Real nº10", 987654321, new PersonalSanitario(), "Universidad de Santiago de Compostela"));
        dataEstudiante.add(new Estudiante("Pedro", "Rodríguez", "Gómez", "14725836H", new Date(18 / 04 / 1996), 48013, "Avenida Bilbao nº25", 123456789, new PersonalSanitario(), "Universidad del País Vasco"));
        dataEstudiante.add(new Estudiante("Elena", "Fernández", "Álvarez", "36914725I", new Date(03 / 10 / 2003), 46021, "Calle Sagunto nº6", 987654321, new PersonalSanitario(), "Universidad de Valencia"));
        dataEstudiante.add(new Estudiante("Javier", "García", "Sánchez", "98765432J", new Date(14 / 02 / 1995), 29001, "Calle Alameda nº12", 123456789, new PersonalSanitario(), "Universidad de Málaga"));

    }


}
