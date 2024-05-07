package Main.ZonaMedica.Campus.Unidades;

import java.util.ArrayList;

public class Unidades {

    //attribute
    private String nombreUnidad;
    private String subunidad;


    //builder

    public Unidades(String nombreUnidad, String subunidad) {
        this.nombreUnidad = nombreUnidad;
        this.subunidad = subunidad;
    }

    //getters and setter
    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public String getSubunidad() {
        return subunidad;
    }

    public void setSubunidad(String subunidad) {
        this.subunidad = subunidad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Unidades other = (Unidades) obj;
        return nombreUnidad.equals(other.nombreUnidad) && subunidad.equals(other.subunidad);
    }

    @Override
    public String toString() {
        return "Unidades{" +
                "nombreUnidad='" + nombreUnidad + '\'' +
                ", subunidad='" + subunidad + '\'' +
                '}';
    }
}
