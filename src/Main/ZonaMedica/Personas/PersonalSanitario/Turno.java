package Main.ZonaMedica.Personas.PersonalSanitario;

public enum Turno {
    NO_ASIGNADO(0),
    MAÑANA(1),
    TARDE(2);

    private final int numAsignado;

    Turno(int numAsignado) {
        this.numAsignado = numAsignado;
    }
    public int getNumero(){
        return numAsignado;
    }

    /**
     * Muestra todos los turnos disponibles, con sus números asignados.
     */
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

    /**
     * Asigna un turno basado en su número.
     *
     * @param numTurno el número del turno a asignar.
     * @return el turno correspondiente al número proporcionado.
     * @throws IllegalArgumentException si no se encuentra ningún turno con el número proporcionado.
     */
    public static Turno asignarTurno(int numTurno){
        for (Turno turno : Turno.values()) {
            if (turno.getNumero() == numTurno) {
                return turno;
            }
        }
        throw new IllegalArgumentException("No se encontró ningun turno con ese numero: " + numTurno);
    }
}
