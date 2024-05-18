package Main.ZonaMedica.Personas.Estudiantes;

import Main.ZonaMedica.Personas.PersonalSanitario.Unidades.Unidades;
import Main.ZonaMedica.Personas.PersonaController;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Main.ZonaMedica.Personas.Estudiantes.EstudianteData.*;
import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.*;
/**
 * menuEstudiante:
 *     - Muestra un menú interactivo para gestionar estudiantes.
 *       Permite dar de alta nuevos estudiantes, modificar los datos de estudiantes existentes,
 *       eliminar estudiantes y mostrar una lista de estudiantes registrados.
 *       El menú se ejecuta en un bucle hasta que el usuario elige la opción de volver.
 * darAltaEstudiante:
 *     - Permite dar de alta a un nuevo estudiante.
 *       Solicita al usuario que ingrese los datos necesarios y crea una nueva instancia
 *       de la clase Estudiante con esos datos, que luego se agrega a la lista de estudiantes.
 * modificarDatosEstudiante:
 *     - Permite modificar los datos de un estudiante existente.
 *       Muestra una lista de estudiantes y solicita al usuario que seleccione el registro
 *       que desea modificar. Luego, muestra un menú de atributos disponibles para modificar
 *       y solicita al usuario que elija qué atributo modificar y proporcione el nuevo valor.
 *       Este proceso se repite hasta que el usuario elige salir o se completa la modificación.
 * eliminarEstudiante:
 *     - Permite eliminar un estudiante existente.
 *       Muestra una lista de estudiantes y solicita al usuario que seleccione el registro
 *       que desea eliminar. Luego, elimina ese registro de la lista de estudiantes.
 * mostrarEstudiantes:
 *     - Muestra una lista de estudiantes registrados.
 *       Si no hay estudiantes registrados, muestra un mensaje indicando que no hay registros.
 *       Si hay uno o más registros, muestra los registros en un formato legible.
 * inputUniversidad:
 *     - Solicita al usuario que ingrese el nombre de la universidad del estudiante.
 *       Muestra un mensaje solicitando al usuario que ingrese el nombre de la universidad
 *       y espera la entrada del usuario. Devuelve el nombre de la universidad ingresado.
 *       @return El nombre de la universidad ingresado por el usuario.
 * inputAsignarSanitario:
 *     - Permite al usuario asignar un sanitario al estudiante.
 *       Muestra una lista de personal sanitario disponible y solicita al usuario que seleccione
 *       el personal sanitario que se asignará al estudiante. Devuelve el personal sanitario seleccionado.
 *       @return El personal sanitario asignado al estudiante.
 * mostrarAtributos:
 *     - Muestra una lista de atributos disponibles para modificar.
 *       Presenta al usuario una lista de atributos que pueden modificarse
 *       durante el proceso de modificación de datos del estudiante.
 */

public class EstudianteController extends PersonaController {
    private static Scanner input = new Scanner(System.in);

    public static void menuEstudiante(){
        int opcion;
        do {
            System.out.println("=======================================");
            System.out.println("         MENU ESTUDIANTES    ");
            System.out.println("=======================================");
            System.out.println("1. Dar de alta estudiante");
            System.out.println("2. Modificar datos de estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Mostrar estudiantes");
            System.out.println("0. Volver");
            System.out.print("Ingrese su opción: ");
            opcion = input.nextInt();
            input.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    darAltaEstudiante();
                    break;
                case 2:
                    modificarDatosEstudiante();
                    break;
                case 3:
                    eliminarEstudiante();
                    break;
                case 4:
                    mostrarEstudiantes();
                    break;
                case 0:
                    System.out.println("Volviendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 0);
    }
    public static void darAltaEstudiante(){
        //Creacion un objeto estudiante y se añade al ArrayList
        dataEstudiante.add(new Estudiante(//Llamada a los metodos para insertar cada atributo por consola
                        inputNombre(),
                        inputApellido1(),
                        inputApellido2(),
                        inputDNI(),
                        inputFechaNacimiento(),
                        inputCodigoPostal(),
                        inputResidencia(),
                        inputTelefono(),
                        inputAsignarSanitario(),
                        inputUniversidad()
                ));
    }
    public static void modificarDatosEstudiante(){
        int opcion, registro = 0;
        Estudiante estudiantes = null;
        mostrarEstudiantes();
        try{//Llamada al Scanner para que el usuario introduzca el dato. SI introduce texto salta una excepcion.
            System.out.print("Indique el número del registro del personal que quiera modificar: ");
            registro = input.nextInt();
            input.nextLine();//Se limpia el buffered del scanner
            estudiantes = dataEstudiante.get(registro-1);
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            modificarDatosEstudiante();//LLamada a este metodo para que se vuelva a pedir el numero de registro
        }catch (IndexOutOfBoundsException e){
            System.out.println("Error: No existe este registro. ");
            modificarDatosEstudiante();//LLamada a este metodo para que se vuelva a pedir el numero de registro
        }
        // Menú para elegir qué atributo del usuario modificar
        do {
            mostrarAtributos();
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    estudiantes.setNombre(inputNombre());
                    break;
                case 2:
                    estudiantes.setPrimerApellido(inputApellido1());
                    break;
                case 3:
                    estudiantes.setSegundoApellido(inputApellido2());
                    break;
                case 4:
                    estudiantes.setDni(inputDNI());
                    break;
                case 5:
                    estudiantes.setfNacimiento(inputFechaNacimiento());
                    break;
                case 6:
                    estudiantes.setCodigoPostal(inputCodigoPostal());
                    break;
                case 7:
                    estudiantes.setLugarResidencia(inputResidencia());
                    break;
                case 8:
                    estudiantes.setNombreUniversidad(inputUniversidad());
                    break;
                case 9:
                    estudiantes.setSanitarioAsignado(inputAsignarSanitario());
                    break;
                case 10:
                    estudiantes.setTelefono(inputTelefono());
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
    public static void eliminarEstudiante(){
        mostrarEstudiantes();
        int registro = 0;
        try{//Llamada al Scanner para que el usuario introduzca el dato. SI introduce texto salta una excepcion.
            System.out.print("Indique el número del registro del estudiante que quiera borrar: ");
            registro = input.nextInt();
            input.nextLine();//Limpia el buffered del scanner
            dataEstudiante.remove(registro);//Elimina el registro querido.
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            eliminarEstudiante();//Llamada al este metodo para que vuelva a pedir los datos otra vez.
        }catch (IndexOutOfBoundsException e){
            System.out.println("Error: No existe este registro. ");
            modificarDatosEstudiante();//LLamada a este metodo para que se vuelva a pedir el numero de registro
        }
    }
    public static void mostrarEstudiantes(){
        int cont = 1;
        System.out.println(String.format("%1$-114s", "-").replace(" ", "-"));
        for (Estudiante p: dataEstudiante){
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                    "║                       Numero del Estudiante: "+ cont +"                                         ║");
            System.out.println(p);
            cont++;
        }
    }
    public static String inputUniversidad(){//Input para introducir el nombre d ela universidad.
        System.out.print("Introduce el nombre de la Universidad: ");
        return input.nextLine().trim();
    }
    public static PersonalSanitario inputAsignarSanitario(){//Se le asigna el Medico con el que puede ver las consultas.
        mostrarPersonalEstudiantes();//Se muestran todos los medicos que hay para elegir.
        int registro = 0;
        PersonalSanitario persona = null;
        try{
            if(!dataPersonalSanitario.isEmpty()){
                System.out.print("Introduce el número del sanitario que tendra asignado: ");
                registro = input.nextInt();//Se introduce el numero del medico y se le resta uno porque en el ArrayList empieza a contar en el 0.
                input.nextLine();//Se limpia el buffed.
                if(registro == 0){
                    return null;//No se le asigna ninguno.
                }
                if(dataPersonalSanitario.size() < registro ||
                        dataPersonalSanitario.get(registro-1).equals(new Unidades("Unidad de formación",""))){;
                    throw new InputMismatchException();
                }
                persona = dataPersonalSanitario.get(registro-1);
            }else{
                System.out.println("No hay personal sanitario para poder asignar.");
            }

        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico o un número de registro que exista. ");
            input.nextLine();//Se limpia el buffed.
            inputAsignarSanitario();//Llamada al metodo otra vez si no ha introducido un numero correcto u otra cosa que no es un numero.
        }catch (IndexOutOfBoundsException e){
            System.out.println("Error: No existe este registro. ");
            input.nextLine();//Se limpia el buffed.
            modificarDatosEstudiante();//LLamada a este metodo para que se vuelva a pedir el numero de registro
        }
        return persona;
    }
    public static void mostrarAtributos(){//Se muestran los atributos de que tienen los estudiantes
        System.out.println("Seleccione el atributo a modificar:");
        System.out.println("-----------------------------------------------------");
        System.out.println(" | 1. Nombre              | | 2. Primer apellido   | ");
        System.out.println(" | 3. Segundo apellido    | | 4. DNI               | ");
        System.out.println(" | 5. Fecha de Nacimiento | | 6. Código Postal     | ");
        System.out.println(" | 7. Residencia          | | 8. Universidad       | ");
        System.out.println(" | 9. Personal Asignado   | | 10. Teléfono         | ");
        System.out.println(" | 0. Salir               | |                      | ");
        System.out.println("-----------------------------------------------------");
        System.out.print(" Opción: ");
    }
    public static void mostrarPersonalEstudiantes(){
        int x = 1;
        if(dataPersonalSanitario.isEmpty()){
            System.out.println("No hay personal medico");
        }else{
            for(PersonalSanitario p: dataPersonalSanitario){
                if(p.getUnidades().equals(new Unidades("Unidad de formación",""))){
                    System.out.println("╔════════════════════════════════════════════════════════════════════════════╗\n" +
                            "║                       Numero del Personal Sanitario: "+ x +"                    ║");
                    System.out.println(p);
                }
                x++;
            }
        }
    }


}
