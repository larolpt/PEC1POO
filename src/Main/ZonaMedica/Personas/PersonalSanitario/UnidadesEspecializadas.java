package Main.ZonaMedica.Personas.PersonalSanitario;

import Main.ZonaMedica.Personas.Pacientes.Citas.TipoPruebas;

public enum UnidadesEspecializadas {
    NO_NECESARIA(0),
    CARDIOVASCULARES(1),
    DIABETES(2);

    private final int numAsignado;

    UnidadesEspecializadas(int numAsignado) {
        this.numAsignado = numAsignado;
    }

    public int getNumero(){
        return numAsignado;
    }

    public static void mostrarUnidades(){
        int cont = 0;
        System.out.print("Titulo");
        for (UnidadesEspecializadas enumItem : UnidadesEspecializadas.values()) {
            if(cont%2 == 0){
                System.out.print("\n");
            }
            System.out.print(enumItem.getNumero() + ".-" + enumItem + "\t");
            cont++;
        }
        System.out.print("\n");
    }

    public static UnidadesEspecializadas asignarUnidad(int numUnidad){
        for (UnidadesEspecializadas unidad : UnidadesEspecializadas.values()) {
            if (unidad.getNumero() == numUnidad) {
                return unidad;
            }
        }
        throw new IllegalArgumentException("No se encontró ninguna unidad con ese numero: " + numUnidad);
    }
}
