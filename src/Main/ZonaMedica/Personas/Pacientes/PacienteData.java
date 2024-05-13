package Main.ZonaMedica.Personas.Pacientes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PacienteData {
    public static ArrayList<Paciente> pacData = new ArrayList<>();

    public static void genDatosPaciente() {
        pacData.add(new Paciente("Juan", "López", "García", "12345678A", new Date(2002 - 1900, Calendar.DECEMBER, 11), 28001, "Calle Principal 123", 666777888, true));
        pacData.add(new Paciente("María", "González", "Martínez", "87654321B", new Date(1975 - 1900, Calendar.JULY, 20), 28002, "Avenida Central 456", 611223344, false));
        pacData.add(new Paciente("Carlos", "Sánchez", "Fernández", "98765432C", new Date(1988 - 1900, Calendar.MARCH, 5), 28003, "Plaza Mayor 789", 600112233, true));
        pacData.add(new Paciente("Ana", "Rodríguez", "López", "54321678D", new Date(1972 - 1900, Calendar.NOVEMBER, 15), 28004, "Paseo de la Alameda 101", 633445566, false));
        pacData.add(new Paciente("Sofía", "Martín", "Pérez", "23456789E", new Date(1990 - 1900, Calendar.APRIL, 25), 28005, "Calle de la Luna 999", 677889900, true));



    }
}
