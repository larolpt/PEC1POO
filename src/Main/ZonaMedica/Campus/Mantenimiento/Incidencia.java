package Main.ZonaMedica.Campus.Mantenimiento;

public class Incidencia {
    private boolean arreglada;
    private String problema;

    public Incidencia(String problema) {
        this.arreglada = false;
        this.problema = problema;
    }

    public boolean estaArreglada() {
        return arreglada;
    }

    public void setArreglada(boolean arreglada) {
        this.arreglada = arreglada;
    }

    public String getProblema() {
        return problema;
    }

    @Override
    public String toString() {
        return "Incidencia: " + problema + " | Arreglada: " + (arreglada ? "Sí" : "No");
    }
}

