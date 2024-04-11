package Main.ZonaMedica.Personas.Estudiantes;

import Main.ZonaMedica.Personas.Persona;
import Main.ZonaMedica.Personas.PersonaController;
import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Main.ZonaMedica.Personas.Estudiantes.EstudianteData.*;
import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.*;

public class EstudianteController extends PersonaController {
    private static Scanner input = new Scanner(System.in);
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
    public static void modificiarDatosEstudiante(){
        int opcion, registro = 0;
        try{//Llamada al Scanner para que el usuario introduzca el dato. SI introduce texto salta una excepcion.
            System.out.print("Indique el número del registro del personal que quiera modificar: ");
            registro = input.nextInt();
            input.nextLine();//Se limpia el buffered del scanner
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            modificiarDatosEstudiante();//LLamada a este metodo para que se vuelva a pedir el numero de registro
        }
        // Menú para elegir qué atributo del usuario modificar
        Estudiante estudiantes = dataEstudiante.get(registro-1);
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
        int registro = 0;
        try{//Llamada al Scanner para que el usuario introduzca el dato. SI introduce texto salta una excepcion.
            System.out.print("Indique el número del registro del estudiante que quiera borrar: ");
            registro = input.nextInt();
            input.nextLine();//Limpia el buffered del scanner
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico solo. ");
            eliminarEstudiante();//Llamada al este metodo para que vuelva a pedir los datos otra vez.
        }
        dataEstudiante.remove(registro);//Elimina el registro querido.
    }
    public static String inputUniversidad(){//Input para introducir el nombre d ela universidad.
        System.out.print("Introduce el nombre de la Universidad: ");
        return input.nextLine().trim();
    }
    public static PersonalSanitario inputAsignarSanitario(){//Se le asigna el Medico con el que puede ver las consultas.
        mostrarPersonal();//Se muestran todos los medicos que hay para elegir.
        int registro = 0;
        try{
            System.out.print("Introduce el número del sanitario que tendra asignado: ");
            registro = input.nextInt()-1;//Se introduce el numero del medico y se le resta uno porque en el ArrayList empieza a contar en el 0.
            input.nextLine();//Se limpia el buffed.
            if(registro == 0){
                return null;//No se le asigna ninguno.
            }
            if(dataPersonalSanitario.size()-1 <= registro-1){
                throw new InputMismatchException();
            }
        }catch (InputMismatchException e){
            System.out.println("Error: Introduzca un valor numerico o un número de registro que exista. ");
            inputAsignarSanitario();//Llamada al metodo otra vez si no ha introducido un numero correcto u otra cosa que no es un numero.
        }
        return dataPersonalSanitario.get(registro-1);
    }
    public static void mostrarAtributos(){//Se muestran los atributos de que tienen los estudiantes
        System.out.println("Seleccione el atributo a modificar:");
        System.out.println("-----------------------------------------------------");
        System.out.println(" | 1. Nombre              | | 2. Primer apellido   | ");
        System.out.println(" | 3. Segundo apellido    | | 4. DNI               | ");
        System.out.println(" | 5. Fecha de Nacimiento | | 6. Código Postal     | ");
        System.out.println(" | 7. Residencia          | | 8. Personal Asignado | ");
        System.out.println(" | 9. Universidad         | | 10. Teléfono         | ");
        System.out.println(" | 0. Salir               | |                      | ");
        System.out.println("-----------------------------------------------------");
        System.out.print(" Opción: ");
    }

}
