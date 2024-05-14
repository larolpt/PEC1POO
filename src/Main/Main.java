package Main;

import Main.ZonaMedica.menus.ServicioMedicinaMenu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static Main.ZonaMedica.Campus.Hospitalizacion.PlantaHabitaciones.generarHabitaciones;
import static Main.ZonaMedica.Campus.Unidades.UnidadesData.generarUnidades;
import static Main.ZonaMedica.Campus.Urgencias.UrgenciasData.irUrgencias;
import static Main.ZonaMedica.Personas.Estudiantes.EstudianteData.generarEstudiantes;
import static Main.ZonaMedica.Personas.Pacientes.PacienteData.genDatosPaciente;
import static Main.ZonaMedica.Personas.PersonaController.inputFechaNacimiento;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import static Main.ZonaMedica.Personas.PersonalSanitario.PersonalSanitarioData.generarDatosPersonalSanitario;
import static Main.ZonaMedica.menus.AparcamientoMenu.aparcamientoMenu;
import static Main.ZonaMedica.menus.EstudianteMenu.estudianteMenu;
import static Main.ZonaMedica.menus.GerenteMenu.menuGerentes;
import static Main.ZonaMedica.menus.MantenimientoMenu.mantenimientoMenuTrabajadores;
import static Main.ZonaMedica.menus.PacienteMenu.pacienteMenu;
import static Main.ZonaMedica.menus.ServicioMedicinaMenu.menuPersonalSanitario;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Date());
        generarDatosPersonalSanitario();
        generarHabitaciones();
        generarUnidades();
        generarEstudiantes();
        genDatosPaciente();
        mainMenu();
    }


    public static void mainMenu(){
        Scanner input = new Scanner(System.in);
        int opcion;
        do {
            // Mostrar el menú
            System.out.println("=======================================");
            System.out.println("             MENU DE PRINCIPAL        ");
            System.out.println("=======================================");
            System.out.println("1. Menu Gerentes.");
            System.out.println("2. Menu Personal Sanitario.");
            System.out.println("3. Menu Paciente.");
            System.out.println("4. Menu Estudiante");
            System.out.println("5. Menu Mantenimiento");
            System.out.println("6. Aparcamiento");
            System.out.println("0. Apagar");
            System.out.print("Ingrese su opción: ");
            // Leer la opción del usuario
            opcion = input.nextInt();

            // Realizar acciones basadas en la opción seleccionada
            switch (opcion) {
                case 1:
                    menuGerentes();
                    break;
                case 2:
                    menuPersonalSanitario();
                    break;
                case 3:
                    pacienteMenu();
                    break;
                case 4:
                    estudianteMenu();
                    break;
                case 5:
                    mantenimientoMenuTrabajadores();
                    break;
                case 6:
                    aparcamientoMenu();
                    break;
                case 0:
                    System.out.println("Apagando...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 0);
    }
}