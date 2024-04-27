package Main.ZonaMedica.Personas.Pacientes.Citas;

import Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitario;
import Main.ZonaMedica.Personas.PersonalSanitario.UnidadesEspecializadas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Main.ZonaMedica.Personas.Pacientes.Citas.TipoPruebas.*;
import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.dataPersonalSanitario;
import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.mostrarPersonal;

public class CitaController {

    public static Scanner input = new Scanner(System.in);

    public static Cita inputCitaMedico(){
        return new CitaMedico(
                inputFechaCita(),
                inputTipoCita(),
                inputAsignarSanitario(),
                inputUnidadEspecializada()
        );
    }

    public static Cita inputCitaPrueba(){
        return new CitaPrueba(
                inputFechaCita(),
                inputHorario(),
                inputPrueba()
        );
    }

    public static UnidadesEspecializadas inputUnidadEspecializada(){
        return null;
    }

    public static TipoPruebas inputPrueba(){
        int prueba = 0;
        TipoPruebas pruebaElegida = null;
        mostrarPruebas();//llamada al metodo del enum para mostrar las pruebas
        try{
            System.out.print("Introduce el número asignado de cada prueba para elegir:");
            prueba = input.nextInt();
            pruebaElegida = asignarPrueba(prueba);
        }catch(IllegalArgumentException | InputMismatchException e){
            input.nextLine();//limpiar buffered
            System.out.println("Error: el número elegido no esta asignado a ninguna prueba");
            inputPrueba();//llamada al metoddo si ha habido un fallo al introducir el número
        }
        return pruebaElegida;
    }
    public static boolean inputHorario(){
        boolean isActive = false;
        boolean isValidInput;

        do {
            System.out.println("Decide cuando quieres ir a la prueba mañana(M) o tarde(T):");
            String respuesta = input.nextLine().trim().toUpperCase();
            isValidInput = true;

            if (respuesta.equals("M") || respuesta.equals("MAÑANA")){ isActive = true; }
            else if (respuesta.equals("T") || respuesta.equals("TARDE")) { isActive = false; }
            else {
                System.out.println("Respuesta no válida. Por favor, ingrese 'M' o 'T'.");
                isValidInput = false;
            }
        } while (!isValidInput);
        return isActive;
    }
    public static Date inputFechaCita(){
        String fecha;
        Date fechaCita = null;
        System.out.print("Introduce la fecha para la cita en formato dd/MM/yyyy: ");
        fecha = input.nextLine().trim();

        try {
            fechaCita = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
            String[] partes = fecha.split("/");
            LocalDate.of(Integer.parseInt(partes[2]), Integer.parseInt(partes[1]), Integer.parseInt(partes[0]));

        } catch (ParseException e) {
            // Manejar una excepción si la entrada no está en el formato esperado
            System.out.println("Error: La fecha ingresada no está en el formato dd/MM/yyyy.");
            inputFechaCita();
        }catch (DateTimeException e ){
            // Manejar si la fecha introducida es correcta
            System.out.println("Error: La fecha ingresada no es correcta.");
            inputFechaCita();
        }
        return fechaCita;
    }
    public static boolean inputTipoCita(){
        boolean isActive = false;
        boolean isValidInput;

        do {
            System.out.println("Decide si la cita es presencial(P) o telefonica(T):");
            String respuesta = input.nextLine().trim().toUpperCase();
            isValidInput = true;

            if (respuesta.equals("P") || respuesta.equals("PRESENCIAL")){ isActive = true; }
            else if (respuesta.equals("T") || respuesta.equals("TELEFONICA") || respuesta.equals("TELEFÓNICA")) { isActive = false; }
            else {
                System.out.println("Respuesta no válida. Por favor, ingrese 'P' o 'T'.");
                isValidInput = false;
            }
        } while (!isValidInput);
        return isActive;
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
}