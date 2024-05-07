package Main.ZonaMedica.Personas.PersonalSanitario;

import Main.ZonaMedica.Personas.Pacientes.Citas.Cita;
import Main.ZonaMedica.Personas.Pacientes.Citas.CitaPaciente;
import Main.ZonaMedica.Personas.Pacientes.Paciente;
import Main.ZonaMedica.Personas.PersonaController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Main.ZonaMedica.Personas.Pacientes.PacienteData.pacienteData;
import static Main.ZonaMedica.Personas.PersonalSanitario.ConsultasExternas.*;
import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.*;
import static Main.ZonaMedica.Personas.PersonalSanitario.Turno.*;
/**
 *  menuPersonalSanitario:
 *     -Muestra un menú interactivo para gestionar personal sanitario.
 *      Permite dar de alta nuevo personal sanitario, modificar los datos de personal existente,
 *      eliminar personal sanitario y mostrar una lista de personal sanitario registrado.
 *      El menú se ejecuta en un bucle hasta que el usuario elige la opción de salir.
 *  darAltaPersonal:
 *     -Permite dar de alta a un nuevo personal sanitario.
 *      Solicita al usuario que ingrese los datos necesarios y crea una nueva instancia
 *      de la clase PersonalSanitario con esos datos, que luego se agrega a la lista de personal sanitario.
 *  modificarDatosPersonalSanitario:
 *      -Permite modificar los datos de un personal sanitario existente.
 *       Muestra una lista de personal sanitario y solicita al usuario que seleccione el registro
 *       que desea modificar. Luego, muestra un menú de atributos disponibles para modificar
 *       y solicita al usuario que elija qué atributo modificar y proporcione el nuevo valor.
 *       Este proceso se repite hasta que el usuario elige salir.
 *  eliminarPersonalSanitario:
 *      -Permite eliminar un personal sanitario existente.
 *      Muestra una lista de personal sanitario y solicita al usuario que seleccione el registro
 *      que desea eliminar. Luego, elimina ese registro de la lista de personal sanitario.
 *  mostrarPersonal:
 *      -Muestra una lista de personal sanitario registrado.
 *      Si no hay personal sanitario registrado, muestra un mensaje indicando que no hay registros.
 *      Si hay uno o más registros, muestra los registros en un formato legible.
 *  mostrarAtributos:
 *      -Muestra una lista de atributos disponibles para modificar.
 *       Presenta al usuario una lista de atributos que pueden modificarse
 *       durante el proceso de modificación de datos del personal sanitario.
 *  inputConsultaExterna:
 *      -Solicita al usuario que seleccione una consulta externa.
 *       Muestra una lista de consultas externas disponibles y solicita al usuario
 *       que ingrese el número correspondiente a la consulta que desea asignar.
 *       Devuelve la consulta externa seleccionada por el usuario.
 *       @return La consulta externa seleccionada por el usuario.
 *  inputTurno:
 *      -Solicita al usuario que seleccione un turno.
 *       Muestra una lista de turnos disponibles y solicita al usuario
 *       que ingrese el número correspondiente al turno que desea asignar.
 *       Devuelve el turno seleccionado por el usuario.
 *       @return El turno seleccionado por el usuario.
 *  inputSueldo:
 *      -Solicita al usuario que ingrese un sueldo para el personal sanitario.
 *       Muestra un mensaje solicitando al usuario que ingrese el sueldo
 *       y espera la entrada del usuario. Si el usuario ingresa un valor no numérico,
 *       muestra un mensaje de error y solicita nuevamente el ingreso del sueldo.
 *       @return El sueldo ingresado por el usuario.
 *
 */
public class PersonalSanitarioController extends PersonaController {
    private static Scanner input = new Scanner(System.in);

    public static void menuPersonalSanitario(){
        int opcion;
        do {
            System.out.println("=======================================");
            System.out.println("         MENU PERSONAL SANITARIO     ");
            System.out.println("=======================================");
            System.out.println("1. Dar de alta personal");
            System.out.println("2. Modificar datos de personal sanitario");
            System.out.println("3. Eliminar personal sanitario");
            System.out.println("4. Mostrar personal");
            System.out.println("0. Volver");
            System.out.print("Ingrese su opción: ");
            opcion = input.nextInt();
            input.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    darAltaPersonal();
                    break;
                case 2:
                    modificarDatosPersonalSanitario();
                    break;
                case 3:
                    eliminarPersonalSanitario();
                    break;
                case 4:
                    mostrarPersonal();
                    break;
                case 0:
                    System.out.println("Volviendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 0);
    }
    public static void darAltaPersonal(){
        //Llamada a los metodos para crear un nuevo trabajador y guardarlo en la lista
        dataPersonalSanitario.add(new PersonalSanitario(
                inputNombre(),
                inputApellido1(),
                inputApellido2(),
                inputDNI(),
                inputFechaNacimiento(),
                inputCodigoPostal(),
                inputResidencia(),
                inputTelefono(),
                inputConsultaExterna(),
                inputTurno(),
                inputSueldo())
        );
    }
    public static void modificarDatosPersonalSanitario(){
        int opcion, registro = 0;
        PersonalSanitario personal = null;
        mostrarPersonal();
        try{
            System.out.print("Indique el número del registro del personal que quiera modificar: ");
            registro = input.nextInt()-1;
            input.nextLine();
            personal = dataPersonalSanitario.get(registro);
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            modificarDatosPersonalSanitario();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Error: No existe este registro. ");
            modificarDatosPersonalSanitario();//LLamada a este metodo para que se vuelva a pedir el numero de registro
        }
        // Menú para elegir qué atributo del usuario modificar
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
                    personal.setEspecialidad(inputConsultaExterna());
                    break;
                case 10:
                    personal.setTurno(inputTurno());
                    break;
                case 11:
                    personal.setSueldo(inputSueldo());
                    break;
                case 12:
                    //persona.setCitas(inputCitaPersonal);
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
    public static void eliminarPersonalSanitario(){
        int registro = 0;
        mostrarPersonal();
        try{
            System.out.print("Indique el número del registro del personal que quiera borrar: ");
            registro = input.nextInt()-1;
            input.nextLine();
            dataPersonalSanitario.remove(registro);
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            eliminarPersonalSanitario();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Error: No existe este registro. ");
            eliminarPersonalSanitario();//LLamada a este metodo para que se vuelva a pedir el numero de registro
        }
    }
    public static void mostrarPersonal(){
        if(dataPersonalSanitario.isEmpty()){
            System.out.println("No hay personal Sanitario");
        }else if(dataPersonalSanitario.size() == 1){//Comprobamos que si solo hay un registro se muestre solo para que no de error
            System.out.println(String.format("%1$-79s", "-").replace(" ", "-"));
            System.out.println(
                    "| " + String.format("%1$-36s", 1 + ".-") + " |\n" +
                            "| Nombre: " + String.format("%1$-28s", dataPersonalSanitario.getFirst().getNombreCompleto()) + " |\n" +
                            "| Especialidad: " + String.format("%1$-22s", dataPersonalSanitario.getFirst().getEspecialidad())
            );
            System.out.println(String.format("%1$-79s", "-").replace(" ", "-"));
        }else{
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
    }
    public static void mostrarAtributos(){
        System.out.println("Seleccione el atributo a modificar:");
        System.out.println("---------------------------------------------------");
        System.out.println(" | 1. Nombre              | | 2. Primer apellido | ");
        System.out.println(" | 3. Segundo apellido    | | 4. DNI             | ");
        System.out.println(" | 5. Fecha de Nacimiento | | 6. Código Postal   | ");
        System.out.println(" | 7. Residencia          | | 8. Teléfono        | ");
        System.out.println(" | 9. Consulta Externa    | | 10. Turno          | ");
        System.out.println(" | 11. Sueldo             | | 12. Citas          | ");
        System.out.println(" | 0. Salir               | |                    | ");
        System.out.println("---------------------------------------------------");
        System.out.print(" Opción: ");
    }
    public static ConsultasExternas inputConsultaExterna() {
        ConsultasExternas especialidad = null;
        boolean isValid = false;

        do {
            try {
                System.out.println("Introduzca el número correspondiente para asignar la consulta:");
                mostrarConsultasExternas();
                System.out.print("Número Consulta: ");
                int numeroConsulta = input.nextInt();
                input.nextLine(); // Limpiar el buffer del scanner

                especialidad = asignarConsultaExterna(numeroConsulta);
                isValid = true; // Si no se lanza una excepción, el número de consulta es válido
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                input.nextLine(); // Limpiar el buffer del scanner
            }
        } while (!isValid);

        return especialidad;
    }
    public static Turno inputTurno(){
        Turno turno = null;
        boolean isValid = false;

        do {
            try {
                System.out.println("Introduzca el número correspondiente para asignar el turno:");
                mostrarTurnos();
                System.out.print("Número turno: ");
                int numTurno = input.nextInt();
                input.nextLine(); // Limpiar el buffer del scanner

                turno = asignarTurno(numTurno);
                isValid = true; // Si no se lanza una excepción, el número de consulta es válido
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                input.nextLine(); // Limpiar el buffer del scanner
            }
        } while (!isValid);
        return turno;
    }
    public static int inputSueldo(){
        int sueldo = 0;

        try{
            System.out.print("Introduce el sueldo de la Persona: ");
            sueldo = input.nextInt();//Input para introducir el valor numerico
        }catch (InputMismatchException e){
            input.nextLine();//Se limpia el buffered
            System.out.println("ERROR. Introduzca un valor entero");
            inputSueldo();//Si salta que el valor introducido esta mal se vuelve a llamar al metodo
        }
        return sueldo;
    }
    public static PersonalSanitario getPersonalSanitario(){
        PersonalSanitario medico = null;
        int registro = -1;
        try{
            mostrarPersonal();
            System.out.print("Indique el número del registro del personal sanitario que quiera elegir: ");
            registro = input.nextInt()-1;
            input.nextLine();
            medico = dataPersonalSanitario.get(registro);
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            getPersonalSanitario();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Error: No existe este registro. ");
            getPersonalSanitario();//LLamada a este metodo para que se vuelva a pedir el numero de registro
        }
        return medico;
    }
}
