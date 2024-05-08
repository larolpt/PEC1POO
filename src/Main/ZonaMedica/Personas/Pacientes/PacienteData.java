package Main.ZonaMedica.Personas.Pacientes;

import java.util.ArrayList;
import java.util.Date;

public class PacienteData {
    public static ArrayList<Paciente> pacienteData = new ArrayList<>();

    public static void generarDatosPaciente() {

        pacienteData.add(new Paciente("sdadadad","dasdadadad",
                "sadadada","12345678a",new Date(1903,11,11),12345,"sdadada"
                ,123456789,false));


    }
}
