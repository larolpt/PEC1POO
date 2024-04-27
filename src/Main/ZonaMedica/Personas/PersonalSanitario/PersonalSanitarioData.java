package Main.ZonaMedica.Personas.PersonalSanitario;

import java.util.ArrayList;
import java.util.Date;

import static Main.ZonaMedica.Personas.Estudiantes.EstudianteController.inputAsignarSanitario;

public class PersonalSanitarioData {
    // Crear una dataPersonalSanitario de objetos PersonalSanitario global para poder acceder desde distintas clases.
    public static ArrayList<PersonalSanitario> dataPersonalSanitario = new ArrayList<>();

    public static void main(String args[]) {
        generarDatosPersonalSanitario();
        mostrarPersonal();
        inputAsignarSanitario();
    }

    public static void mostrarPersonal() {
        int cont, cont2;
        System.out.println(String.format("%1$-79s", "-").replace(" ", "-"));
        for (int i = 0; i < dataPersonalSanitario.size() - 1; i += 2) {
            cont = i + 1;
            cont2 = i + 2;
            System.out.println(
                    "| " + String.format("%1$-36s", cont + ".-") +
                            "| " + String.format("%1$-36s", cont2 + ".-") + " |\n" +
                            "| Nombre: " + String.format("%1$-28s", dataPersonalSanitario.get(i).getNombreCompleto()) +
                            "| Nombre: " + String.format("%1$-28s", dataPersonalSanitario.get(cont).getNombreCompleto()) + " |\n" +
                            "| Especialidad: " + String.format("%1$-22s", dataPersonalSanitario.get(i).getEspecialidad()) +
                            "| Especialidad: " + String.format("%1$-22s", dataPersonalSanitario.get(cont).getEspecialidad()) + " |"
            );
            System.out.println(String.format("%1$-79s", "-").replace(" ", "-"));
        }
    }

    public static void generarDatosPersonalSanitario() {

        // Agregar los objetos PersonalSanitario a la dataPersonalSanitario
        

    }
}