package Main.ZonaMedica.Personas.Pacientes;

import Main.ZonaMedica.Personas.Pacientes.Citas.Cita;
import Main.ZonaMedica.Personas.PersonaController;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Main.ZonaMedica.Personas.Pacientes.Citas.CitaController.*;
import static Main.ZonaMedica.Personas.Pacientes.ExpedienteMedico.ExpedienteMedicoController.menuExpediente;
import static Main.ZonaMedica.Personas.Pacientes.PacienteData.pacData;
import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.dataPersonalSanitario;

public class PacienteController extends PersonaController {
    public static Scanner input = new Scanner(System.in);

    /**
     * Muestra el menú de gestión de pacientes y maneja las opciones seleccionadas por el usuario.
     */
    public static void menuPaciente(){
        int opcion;
        do {
            System.out.println("=======================================");
            System.out.println("         MENU PACIENTES    ");
            System.out.println("=======================================");
            System.out.println("1. Dar de alta paciente");
            System.out.println("2. Modificar datos de paciente");
            System.out.println("3. Eliminar paciente");
            System.out.println("4. Mostrar pacientes");
            System.out.println("5. Citas");
            System.out.println("6. Historial Medico");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = input.nextInt();
            input.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    darAltaPaciente();
                    break;
                case 2:
                    modificarDatosPacientes();
                    break;
                case 3:
                    eliminarPaciente();
                    break;
                case 4:
                    mostrarPacientes();
                    break;
                case 5:
                    menuGestionCitasMedicasPacientes();
                    break;
                case 6:
                    menuExpediente();
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
     * Da de alta a un nuevo paciente pidiendo los datos necesarios y guardándolo en la lista de pacientes.
     */
    public static void darAltaPaciente(){
        //Llamada a los metodos para crear un nuevo trabajador y guardarlo en la lista
        Paciente pac = new Paciente(
                inputNombre(),
                inputApellido1(),
                inputApellido2(),
                inputDNI(),
                inputFechaNacimiento(),
                inputCodigoPostal(),
                inputResidencia(),
                inputTelefono(),
                inputTieneSeguro()
        );
    }

    /**
     * Modifica los datos de un paciente seleccionado por el usuario.
     */
    public static void modificarDatosPacientes(){
        int opcion, registro = 0;
        Paciente personal = getPaciente();
        do {
            mostrarAtributos();
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    personal.setNombre(inputNombre());
                    break;
                case 2:
                    personal.setPrimerApellido(inputApellido1());
                    break;
                case 3:
                    personal.setSegundoApellido(inputApellido2());
                    break;
                case 4:
                    personal.setDni(inputDNI());
                    break;
                case 5:
                    personal.setfNacimiento(inputFechaNacimiento());
                    break;
                case 6:
                    personal.setCodigoPostal(inputCodigoPostal());
                    break;
                case 7:
                    personal.setLugarResidencia(inputResidencia());
                    break;
                case 8:
                    personal.setTelefono(inputTelefono());
                    break;
                case 9:
                    personal.setEstaIngresado(inputEstaIngresado());
                    break;
                case 10:
                    personal.setTieneSeguro(inputTieneSeguro());
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

    /**
     * Elimina un paciente seleccionado por el usuario.
     */
    public static void eliminarPaciente(){
        pacData.remove(getPaciente());
    }

    /**
     * Muestra la lista de pacientes con su información.
     */
    public static void mostrarPacientes(){
        for(int i=0; i < pacData.size(); i++) {
            System.out.println("╔════════════════════════════════════════════════════════════════════════════╗\n" +
                    "║                              Número del paciente: "+ i +"                        ║");
            System.out.print(pacData.get(i));
        }
    }

    /**
     * Muestra un menú de selección de atributos de un paciente para su modificación.
     */
    public static void mostrarAtributos(){
        System.out.println("Seleccione el atributo a modificar:");
        System.out.println("---------------------------------------------------");
        System.out.println(" | 1. Nombre              | | 2. Primer apellido | ");
        System.out.println(" | 3. Segundo apellido    | | 4. DNI             | ");
        System.out.println(" | 5. Fecha de Nacimiento | | 6. Código Postal   | ");
        System.out.println(" | 7. Residencia          | | 8. Teléfono        | ");
        System.out.println(" | 9. Esta ingresado      | | 10. Tiene Seguro   | ");
        System.out.println(" | 0. Salir               | |                    | ");
        System.out.println("---------------------------------------------------");
        System.out.print(" Opción: ");
    }

    /**
     * Solicita al usuario si el paciente tiene seguro médico.
     *
     * @return true si el paciente tiene seguro médico, false en caso contrario.
     */
    public static boolean inputTieneSeguro(){
        System.out.print("¿Tiéne seguro medico? (S/N): ");
        return respuestaSiNO();
    }

    /**
     * Solicita al usuario si el paciente está ingresado.
     *
     * @return true si el paciente está ingresado, false en caso contrario.
     */
    public static boolean inputEstaIngresado(){
        System.out.print("¿Esta ingresado? (S/N): ");
        return respuestaSiNO();
    }

    /**
     * Solicita una respuesta de sí o no al usuario.
     *
     * @return true si la respuesta es sí, false si la respuesta es no.
     */
    public static boolean respuestaSiNO(){
        boolean isActive = false;
        boolean isValidInput;

        do {
            String respuesta = input.nextLine().trim().toLowerCase();
            isValidInput = true;

            if (respuesta.equals("si") || respuesta.equals("s") || respuesta.equals("sí")) { isActive = true; }
            else if (respuesta.equals("no") || respuesta.equals("n")) { isActive = false; }
            else {
                System.out.println("Respuesta no válida. Por favor, ingrese 'S' o 'N'.");
                isValidInput = false;
            }
        } while (!isValidInput);
        return isActive;
    }

    /**
     * Solicita al usuario que seleccione un paciente de la lista.
     *
     * @return el paciente seleccionado.
     */
    public static Paciente getPaciente(){
        Paciente paciente = null;
        int registro = -1;
        try{
            mostrarPacientes();
            System.out.print("Indique el número del registro del paciente que quiera elegir: ");
            registro = input.nextInt();
            paciente = pacData.get(registro);
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            input.nextLine();
            getPaciente();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Error: No existe este registro. ");
            getPaciente();//LLamada a este metodo para que se vuelva a pedir el numero de registro
        }
        return paciente;
    }
}
