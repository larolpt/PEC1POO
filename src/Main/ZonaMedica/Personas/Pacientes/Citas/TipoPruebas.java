package Main.ZonaMedica.Personas.Pacientes.Citas;

import Main.ZonaMedica.Personas.PersonalSanitario.ConsultasExternas;

public enum TipoPruebas {
    ANALITICAS(0),
    RAYOSX(1),
    RESONACIAMAGNETICA(2),
    ECOGRAFIA(3);

    private final int numAsignado;

    TipoPruebas(int numAsignado) {
        this.numAsignado = numAsignado;
    }

    public int getNumero(){
        return numAsignado;
    }

    public static void mostrarPruebas(){
        int cont = 0;
        System.out.print("Titulo");
        for (TipoPruebas enumItem : TipoPruebas.values()) {
            if(cont%2 == 0){
                System.out.print("\n");
            }
            System.out.print(enumItem.getNumero() + ".-" + enumItem + "\t");
            cont++;
        }
        System.out.print("\nFin");
    }

    public static TipoPruebas asignarPrueba(int numPrueba){
        for (TipoPruebas prueba : TipoPruebas.values()) {
            if (prueba.getNumero() == numPrueba) {
                return prueba;
            }
        }
        throw new IllegalArgumentException("No se encontró ninguna prueba con ese numero: " + numPrueba);
    }
}
