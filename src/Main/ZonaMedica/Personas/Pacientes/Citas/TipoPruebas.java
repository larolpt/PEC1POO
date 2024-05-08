package Main.ZonaMedica.Personas.Pacientes.Citas;

public enum TipoPruebas {
    ANALITICAS(0,50),
    RAYOSX(1,150),
    RESONACIAMAGNETICA(2,200),
    ECOGRAFIA(3,100);

    private final int numAsignado;
    private final int coste;

    TipoPruebas(int numAsignado, int coste) {
        this.numAsignado = numAsignado;
        this.coste = coste;
    }

    public int getNumero(){
        return numAsignado;
    }
    public int getCoste(){
        return coste;
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
