package Main.ZonaMedica.Personas.Pacientes.ExpedienteMedico;

import Main.ZonaMedica.Personas.Pacientes.Paciente;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Main.ZonaMedica.Personas.Pacientes.Citas.CitaController.menuGestionCitasMedicasPacientes;
import static Main.ZonaMedica.Personas.Pacientes.PacienteController.getPaciente;
import static Main.ZonaMedica.Personas.Pacientes.PacienteController.mostrarAtributos;
import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.dataPersonalSanitario;

public class ExpedienteMedicoController {
    public static Scanner input = new Scanner(System.in);


    /**
     * Muestra el menú de gestión de expedientes médicos y maneja las opciones seleccionadas por el usuario.
     */
    public static void menuExpediente(){
        int opcion;
        Paciente paciente = getPaciente();

        do {
            System.out.println("=======================================");
            System.out.println("         MENU EXPEDIENTE     ");
            System.out.println("=======================================");
            System.out.println("1. Crear Expediente");
            System.out.println("2. Modificar expediente");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = input.nextInt();
            input.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    paciente.setHistorialMedico(crearExpediente());
                    break;
                case 2:
                    paciente.mostrarHistorialMedico();
                    ExpedienteMedico historial = getExpedienteMedico(paciente);
                    if(historial != null){
                        paciente.setHistorialMedico(modificarExpediente(historial));
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 0);
    }

    /**
     * Crea un nuevo expediente médico para un paciente.
     *
     * @return el nuevo expediente médico creado.
     */
    public static ExpedienteMedico crearExpediente(){
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

    /**
     * Modifica un expediente médico existente.
     *
     * @param expediente el expediente médico a modificar.
     * @return el expediente médico modificado.
     */
    public static ExpedienteMedico modificarExpediente(ExpedienteMedico expediente) {
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
        return expediente;
    }


    /**
     * Obtiene un expediente médico específico de un paciente.
     *
     * @param paciente el paciente del que se va a obtener el expediente médico.
     * @return el expediente médico seleccionado.
     */
    public static ExpedienteMedico getExpedienteMedico(Paciente paciente){
        int registro = 0;
        ExpedienteMedico expediente = null;
        try{
            if(!paciente.getHistorialMedico().isEmpty()){
                System.out.print("Introduce el número del expediente que quieres obtener: ");
                registro = input.nextInt();//Se introduce el numero del medico y se le resta uno porque en el ArrayList empieza a contar en el 0.
                input.nextLine();//Se limpia el buffed.
                if(paciente.getHistorialMedico().size()-1 <= registro-1){
                    throw new InputMismatchException();
                }
                expediente = paciente.getHistorialMedico().get(registro-1);
            }else{
                System.out.println("No hay expedientes poder observar.");
            }

        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico o un número de registro que exista. ");
            getExpedienteMedico(paciente);//Llamada al metodo otra vez si no ha introducido un numero correcto u otra cosa que no es un numero.
        }catch (IndexOutOfBoundsException e){
            System.out.println("Error: No existe este registro. ");
            getExpedienteMedico(paciente);//LLamada a este metodo para que se vuelva a pedir el numero de registro
        }
        return expediente;
    }
}
