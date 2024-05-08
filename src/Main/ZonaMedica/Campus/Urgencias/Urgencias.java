package Main.ZonaMedica.Campus.Urgencias;

import Main.ZonaMedica.Personas.Pacientes.Paciente;

public class Urgencias {
    private Paciente paciente;
    private String problema;

    public Urgencias(Paciente paciente, String problema) {
        this.paciente = paciente;
        this.problema = problema;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    @Override
    public String toString() {
        return "Urgencias{" +
                "paciente=" + paciente +
                ", problema='" + problema + '\'' +
                '}';
    }
}
