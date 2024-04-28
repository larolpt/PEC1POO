package Main.ZonaMedica.Personas.Pacientes.ExpedienteMedico;

import java.time.LocalDate;
import java.util.Scanner;

public class ExpedienteMedicoController {
    public static ExpedienteMedico crearExpediente(){
        Scanner input = new Scanner(System.in);
        String tratamiento = "";
        boolean isActivo = true;

        LocalDate diaCreado = LocalDate.now();
        System.out.println("Introduce el tratamiento que debe recibir el paciente: ");
        tratamiento = input.nextLine();

        return new ExpedienteMedico(
                diaCreado,
                tratamiento,
                isActivo
        );
    }
    public static void modificarExpediente(ExpedienteMedico expediente) {
        Scanner input = new Scanner(System.in);
        System.out.println("¿Qué atributo deseas modificar?");
        System.out.println("1. Tratamiento");
        System.out.println("2. Activo");
        int opcion = input.nextInt();
        input.nextLine(); // Limpiar el buffer de entrada

        switch (opcion) {
            case 1:
                System.out.println("Introduce el nuevo tratamiento: ");
                String nuevoTratamiento = input.nextLine();
                expediente.setTratamiento(nuevoTratamiento);
                break;
            case 2:
                System.out.println("¿El tratamiento está activo? (si/no): ");
                String respuesta = input.nextLine();
                boolean nuevoEstado = respuesta.equalsIgnoreCase("si");
                expediente.setActivo(nuevoEstado);
                break;
            default:
                System.out.println("Opción inválida.");
        }
        System.out.println("Expediente modificado: ");
        System.out.println(expediente);
    }
}
