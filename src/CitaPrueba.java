import java.sql.Time;
import java.util.Date;

public class CitaPrueba extends Cita{
    //attribute
    protected TipoPruebas prueba;

    //builder

    public CitaPrueba() {
        super();
        this.prueba = null;
    }

    public CitaPrueba(Date dia, Time hora, TipoPruebas prueba) {
        super(dia, hora);
        this.prueba = prueba;
    }

    //getters and setters

    public TipoPruebas getPrueba() {
        return prueba;
    }

    public void setPrueba(TipoPruebas prueba) {
        this.prueba = prueba;
    }

    @Override
    public String toString() {
        return "CitaPrueba{" +
                "prueba=" + prueba +
                ", dia=" + dia +
                ", hora=" + hora +
                '}';
    }
}
