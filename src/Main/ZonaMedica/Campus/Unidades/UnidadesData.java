package Main.ZonaMedica.Campus.Unidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UnidadesData {
        public static HashMap<Integer, String> dataUnidadesMap = new HashMap<>();
        public static HashMap<Integer, String> enfermedadesComunesMap = new HashMap<>();
        public static HashMap<Integer, String> consultasExternasMap = new HashMap<>();

        public static void generarUnidades(){

            // Datos para las unidades
            dataUnidadesMap.put(0, "NO ASIGNADO");
            dataUnidadesMap.put(1, "UCI");
            dataUnidadesMap.put(2, "Enfermeria");
            dataUnidadesMap.put(3, "Unidades especializadas");
            dataUnidadesMap.put(4, "Urgencias");
            dataUnidadesMap.put(5, "Unidad de formación");
            dataUnidadesMap.put(6, "Consultas externas");


            // Subunidades para eunidades especializas
            enfermedadesComunesMap.put(1, "Enfermedades Cardiovasculares");
            enfermedadesComunesMap.put(2, "Diabetes");

            // Subunidades para consultas externas

            consultasExternasMap.put(1, "Aparato Digestivo");
            consultasExternasMap.put(2, "Cardiología");
            consultasExternasMap.put(3, "Cirugía General");
            consultasExternasMap.put(4, "Dermatología");
            consultasExternasMap.put(5, "Medicina Interna");
            consultasExternasMap.put(6, "Oncología");
            consultasExternasMap.put(7, "Oftalmología");
            consultasExternasMap.put(8, "Psiquiatría");
            consultasExternasMap.put(9, "Traumatología");
        }


    public static String inputUnidadesMap(){
        String unidades = "";
        // Imprimir el HashMap para verificación
        System.out.println("=======================================");
        System.out.println("         MENU UNIDADES      ");
        System.out.println("=======================================");
        for (Integer key : dataUnidadesMap.keySet()) {
            System.out.println(key + ". " + dataUnidadesMap.get(key));
        }
        try {
            unidades = dataUnidadesMap.get(inputKey());
        }catch (Exception e){
            System.out.println("Opcion no encontrada introduzca una opción valida");
            inputUnidadesMap();
        }
        return unidades;
    }

    public static String inputEnfermedadesComunes(){
        String enfermedades = "";
        System.out.println("=======================================");
        System.out.println("   MENU UNIDAD ENFERMEDADES COMUNES    ");
        System.out.println("=======================================");
        // Imprimir el HashMap para enfermedades comunes
        System.out.println("Enfermedades Comunes:");
        for (Integer key : enfermedadesComunesMap.keySet()) {
            System.out.println(key + ". " + enfermedadesComunesMap.get(key));
        }

        try {
            enfermedades = enfermedadesComunesMap.get(inputKey());
        }catch (Exception e){
            System.out.println("Opcion no encontrada introduzca una opción valida");
            inputEnfermedadesComunes();
        }
        return enfermedades;
    }

    public static String inputConsultasExternas(){
        String consultaElegida = "";
        System.out.println("=======================================");
        System.out.println("         MENU CONSULTAS EXTERNAS       ");
        System.out.println("=======================================");
        // Imprimir el HashMap para consultas externas
        System.out.println("Consultas Externas:");
        for (Integer key : consultasExternasMap.keySet()) {
            System.out.println(key + ". " + consultasExternasMap.get(key));
        }
        try {
            consultaElegida = consultasExternasMap.get(inputKey());
        }catch (Exception e){
            System.out.println("Opcion no encontrada introduzca una opción valida");
            inputConsultasExternas();
        }
        return consultaElegida;
    }

    public static int inputKey(){
        Scanner input = new Scanner(System.in);
        // Input de un número entero con try-catch para manejar excepciones
        int numero = 0;
            System.out.println("Ingrese un número entero:");
            try {
                numero = input.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                input.nextLine(); // Limpiar el buffer del scanner
                inputKey();
            }
            return numero;
    }



}
