package Main.ZonaMedica.PersonalHospital;


public enum ConsultasExternas {
    NO_ASIGNADO(0),
    ENFERMERIA(1),
    APARATO_DIGESTIVO(2),
    CARDIOLOGIA(3),
    CIRUGIA_GENERAL(4),
    DERMATOLOGIA(5),
    MEDICINA_INTERNA(6),
    ONCOLOGIA(7),
    OFTALMOLOGIA(8),
    PSIQUIATRIA(9),
    TRAUMATOLOGIA(10),
    MEDICINA_GENERAL(11),
    FISIOTERAPIA(12);

    private final int numAsignado;

    ConsultasExternas(int numAsignado) {
        this.numAsignado = numAsignado;
    }

    public int getNumero(){
        return numAsignado;
    }

    public static void mostrarConsultasExternas(){
        int cont = 0;
        System.out.print("Titulo");
        for (ConsultasExternas enumItem : ConsultasExternas.values()) {
            if(cont%2 == 0){
                System.out.print("\n");
            }
            System.out.print(enumItem.getNumero() + ".-" + enumItem + "\t");
            cont++;
        }
        System.out.print("\nFin");
    }

    public static ConsultasExternas asignarConsultaExterna(int numConsulta){
        for (ConsultasExternas consulta : ConsultasExternas.values()) {
            if (consulta.getNumero() == numConsulta) {
                return consulta;
            }
        }
        throw new IllegalArgumentException("No se encontró ninguna consulta con ese numero: " + numConsulta);
    }
    public static void main(String[] args) {
        mostrarConsultasExternas();
        System.out.print(asignarConsultaExterna(1));
    }
}

