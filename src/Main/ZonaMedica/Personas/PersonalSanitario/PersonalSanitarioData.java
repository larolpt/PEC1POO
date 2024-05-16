package Main.ZonaMedica.Personas.PersonalSanitario;

import Main.ZonaMedica.Personas.PersonalSanitario.Unidades.Unidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PersonalSanitarioData {
    // Crear una dataPersonalSanitario de objetos PersonalSanitario global para poder acceder desde distintas clases.
    public static ArrayList<PersonalSanitario> dataPersonalSanitario = new ArrayList<>();

    public static void generarDatosPersonalSanitario() {

        // Generar personal sanitario para Consultas externas y sus subunidades
        dataPersonalSanitario.add(new PersonalSanitario("Pablo", "García", "Martínez", "22345678A", new Date(1978 - 1900, Calendar.JANUARY, 14), 28015, "Calle Mayor 111", 600112233, new Unidades("Consultas externas", "Aparato Digestivo"), Turno.MAÑANA, 6000));
        dataPersonalSanitario.add(new PersonalSanitario("Luisa", "Martínez", "Gómez", "23456789B", new Date(1985 - 1900, Calendar.FEBRUARY, 25), 28016, "Avenida del Río 222", 611223344, new Unidades("Consultas externas", "Cardiología"), Turno.TARDE, 5500));
        dataPersonalSanitario.add(new PersonalSanitario("Eva", "López", "Fernández", "34567890C", new Date(1990 - 1900, Calendar.MARCH, 5), 28017, "Plaza España 333", 633445566, new Unidades("Consultas externas", "Cirugía General"), Turno.TARDE, 6000));
        dataPersonalSanitario.add(new PersonalSanitario("Marcos", "Sánchez", "Pérez", "45678901D", new Date(1972 - 1900, Calendar.APRIL, 16), 28018, "Calle Nueva 444", 677889900, new Unidades("Consultas externas", "Dermatología"), Turno.MAÑANA, 5500));
        dataPersonalSanitario.add(new PersonalSanitario("Carmen", "Gómez", "Martín", "56789012E", new Date(1988 - 1900, Calendar.MAY, 27), 28019, "Avenida del Sol 555", 688990011, new Unidades("Consultas externas", "Medicina Interna"), Turno.TARDE, 6000));
        dataPersonalSanitario.add(new PersonalSanitario("Javier", "Martínez", "López", "67890123F", new Date(1995 - 1900, Calendar.JUNE, 8), 28020, "Calle Real 666", 699001122, new Unidades("Consultas externas", "Oncología"), Turno.TARDE, 5500));
        dataPersonalSanitario.add(new PersonalSanitario("Ana", "Fernández", "Sánchez", "78901234G", new Date(1976 - 1900, Calendar.JULY, 19), 28021, "Avenida de la Paz 777", 600112233, new Unidades("Consultas externas", "Oftalmología"), Turno.MAÑANA, 6000));
        dataPersonalSanitario.add(new PersonalSanitario("Pedro", "López", "Martínez", "89012345H", new Date(1983 - 1900, Calendar.AUGUST, 30), 28022, "Plaza Mayor 888", 611223344, new Unidades("Consultas externas", "Psiquiatría"), Turno.TARDE, 5500));
        dataPersonalSanitario.add(new PersonalSanitario("Laura", "Sánchez", "Gómez", "90123456I", new Date(1979 - 1900, Calendar.SEPTEMBER, 10), 28023, "Paseo del Parque 999", 633445566, new Unidades("Consultas externas", "Traumatología"), Turno.MAÑANA, 6000));
        dataPersonalSanitario.add(new PersonalSanitario("Juan", "López", "García", "12345678A", new Date(1960 - 1900, Calendar.DECEMBER, 11), 28001, "Calle Principal 123", 666777888, new Unidades("UCI", ""), Turno.MAÑANA, 5000));
        dataPersonalSanitario.add(new PersonalSanitario("María", "González", "Martínez", "87654321B", new Date(1975 - 1900, Calendar.JULY, 20), 28002, "Avenida Central 456", 611223344, new Unidades("Enfermeria", ""), Turno.TARDE, 5500));
        dataPersonalSanitario.add(new PersonalSanitario("Carlos", "Sánchez", "Fernández", "98765432C", new Date(1988 - 1900, Calendar.MARCH, 5), 28003, "Plaza Mayor 789", 600112233, new Unidades("Unidades especializadas", "Enfermedades Cardiovasculares"), Turno.MAÑANA, 6000));
        dataPersonalSanitario.add(new PersonalSanitario("Ana", "Rodríguez", "López", "54321678D", new Date(1972 - 1900, Calendar.NOVEMBER, 15), 28004, "Paseo de la Alameda 101", 633445566, new Unidades("Urgencias", ""), Turno.MAÑANA, 5500));
        dataPersonalSanitario.add(new PersonalSanitario("Sofía", "Martín", "Pérez", "23456789E", new Date(1990 - 1900, Calendar.APRIL, 25), 28005, "Calle de la Luna 999", 677889900, new Unidades("Unidad de formación", ""), Turno.TARDE, 6000));
        dataPersonalSanitario.add(new PersonalSanitario("Pedro", "Díaz", "Gómez", "34567890F", new Date(1985 - 1900, Calendar.AUGUST, 10), 28006, "Avenida del Sol 333", 688990011, new Unidades("Unidades especializadas", "Enfermedades Cardiovasculares"), Turno.TARDE, 5500));
        dataPersonalSanitario.add(new PersonalSanitario("Laura", "Ruiz", "Sánchez", "45678901G", new Date(1982 - 1900, Calendar.FEBRUARY, 8), 28007, "Calle Mayor 777", 699001122, new Unidades("Unidades especializadas", "Diabetes"), Turno.MAÑANA, 6000));



    }
}