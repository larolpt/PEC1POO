package Main.ZonaMedica.Personas;

import com.sun.jdi.Value;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class PersonaController {
    private static Scanner input = new Scanner(System.in);
    /**
     * Solicita al usuario que introduzca su nombre.
     *
     * @return el nombre ingresado por el usuario, recortado de espacios en blanco.
     */
    public static String inputNombre(){
        System.out.print("Introduce el nombre: ");
        return input.nextLine().trim();
    }
    /**
     * Solicita al usuario que introduzca su primer apellido.
     *
     * @return el primer apellido ingresado por el usuario, recortado de espacios en blanco.
     */
    public static String inputApellido1(){
        System.out.print("Introduce el primer apellido: ");
        return input.nextLine().trim();
    }
    /**
     * Solicita al usuario que introduzca su segundo apellido.
     *
     * @return el segundo apellido ingresado por el usuario, recortado de espacios en blanco.
     */
    public static String inputApellido2(){
        System.out.print("Introduce el segundo apellido: ");
        return input.nextLine().trim();
    }
    /**
     * Solicita al usuario que introduzca su DNI.
     * El DNI debe estar en el formato correcto(8 dígitos seguidos de una letra).
     *
     * @return el DNI ingresado por el usuario, en mayúsculas.
     */
    public static String inputDNI(){
        String dni;
        System.out.print("Introduce el dni: ");
        dni = input.nextLine().toUpperCase().trim();
        if(!dni.matches("\\d{8}[A-HJ-NP-TV-Z]")){//Se comprueba con una expresion regular si el dni esta en el formato correcto español
            System.out.println("Formato del dni no aceptado formato debe ser(12345678X)");
            inputDNI();
        }
        return dni;
    }
    /**
     * Solicita al usuario que introduzca su lugar de residencia.
     *
     * @return el lugar de residencia ingresado por el usuario.
     */
    public static String inputResidencia(){
        System.out.print("Introduce el lugar de residencia: ");
        return input.nextLine().trim();
    }
    /**
     * Solicita al usuario que introduzca su código postal.
     * El código postal debe estar en el formato correcto de 5 dígitos.
     *
     * @return el código postal ingresado por el usuario.
     */
    public static int inputCodigoPostal() {
        String cp = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Introduce el código postal: ");
            cp = input.nextLine().trim();
            // Se comprueba con una expresión regular si el cp está en el formato correcto
            if (cp.matches("\\b\\d{5}\\b")) {
                isValid = true;
            } else {
                System.out.println("Formato del código postal no aceptado. El formato debe ser 5 cifras.");
            }
        }
        return Integer.parseInt(cp);
    }
    /**
     * Solicita al usuario que introduzca su fecha de nacimiento.
     * La fecha debe estar en el formato dd/MM/yyyy.
     *
     * @return la fecha de nacimiento ingresada por el usuario.
     */
    public static Date inputFechaNacimiento(){
        String fecha;
        Date fechaNacimiento = null;
        System.out.print("Introduce la fecha de nacimiento en formato dd/MM/yyyy: ");
        fecha = input.nextLine().trim();

        try {
            fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
            String[] partes = fecha.split("/");
            LocalDate.of(Integer.parseInt(partes[2]), Integer.parseInt(partes[1]), Integer.parseInt(partes[0]));

        } catch (ParseException e) {
            // Manejar una excepción si la entrada no está en el formato esperado
            System.out.println("Error: La fecha ingresada no está en el formato dd/MM/yyyy.");
            inputFechaNacimiento();
        }catch (DateTimeException e ){
            // Manejar si la fecha introducida es correcta
            System.out.println("Error: La fecha ingresada no es correcta.");
            inputFechaNacimiento();
        }
        return fechaNacimiento;
    }
    /**
     * Solicita al usuario que introduzca su número de teléfono.
     * El número de teléfono debe estar en el formato correcto de 9 dígitos.
     *
     * @return el número de teléfono ingresado por el usuario.
     */
    public static int inputTelefono() {
        String tel = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Introduce el número de teléfono: ");
            tel = input.nextLine().trim();
            // Se comprueba con una expresión regular si el cp está en el formato correcto
            if (tel.matches("\\b\\d{9}\\b")) {
                isValid = true;
            } else {
                System.out.println("Formato del teléfono erroneo. El formato debe ser 9 cifras.");
            }
        }
        return Integer.parseInt(tel);
    }
}
