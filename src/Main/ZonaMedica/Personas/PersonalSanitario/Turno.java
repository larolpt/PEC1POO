package Main.ZonaMedica.Personas.PersonalSanitario;

public enum Turno {
    NO_ASIGNADO(0),
    MAÑANA(1),
    TARDE(2),
    NOCTURNO(3);

    private final int numAsignado;

    Turno(int numAsignado) {
        this.numAsignado = numAsignado;
    }
    public int getNumero(){
        return numAsignado;
    }
    public static void mostrarTurnos(){
        int cont = 0;

        for (Turno enumItem : Turno.values()) {
            if(cont%2 == 0){
                System.out.print("\n");
            }
            System.out.print(enumItem.getNumero() + ".-" + enumItem + "\t");
            cont++;
        }
        System.out.print("\n");
    }
    public static Turno asignarTurno(int numTurno){
        for (Turno turno : Turno.values()) {
            if (turno.getNumero() == numTurno) {
                return turno;
            }
        }
        throw new IllegalArgumentException("No se encontró ningun turno con ese numero: " + numTurno);
    }
}
