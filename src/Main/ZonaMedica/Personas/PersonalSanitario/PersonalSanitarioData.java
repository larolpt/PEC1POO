package Main.ZonaMedica.Personas.PersonalSanitario;

import java.util.ArrayList;
import java.util.Date;

public class PersonalSanitarioData {
    public static void main (String args[]){
        generarDatosPersonalSanitario();
    }
    public static ArrayList<PersonalSanitario> generarDatosPersonalSanitario(){
        // Crear una lista de objetos PersonalSanitario
        ArrayList<PersonalSanitario> lista = new ArrayList<>();

        // Agregar los objetos PersonalSanitario a la lista
        lista.add(new PersonalSanitario("Rubetta", "Rignall", "Sexty", "07967771T", new Date(22/03/1995), 19990, "Room 321", false, ConsultasExternas.CIRUGIA_GENERAL, Turno.NO_ASIGNADO));
        lista.add(new PersonalSanitario("Adele", "Curtayne", "Sinnatt", "92671651X", new Date(21/06/1990), 60968, "Apt 1870", true, ConsultasExternas.FISIOTERAPIA, Turno.TARDE));
        lista.add(new PersonalSanitario("Celinka", "Rudloff", "Water", "73699587W", new Date(31/02/1984), 27445, "Room 979", false, ConsultasExternas.APARATO_DIGESTIVO, Turno.TARDE));
        lista.add(new PersonalSanitario("Cheston", "Pasterfield", "Tootal", "16302989Z", new Date(19/11/1997), 85325, "2nd Floor", false, ConsultasExternas.TRAUMATOLOGIA, Turno.NO_ASIGNADO));
        lista.add(new PersonalSanitario("Maybelle", "Grunder", "Honsch", "16725391B", new Date(01/03/1981), 40611, "Apt 957", true, ConsultasExternas.ONCOLOGIA, Turno.NO_ASIGNADO));
        lista.add(new PersonalSanitario("Ewart", "Cheverton", "Storrs", "01316456G", new Date(24/01/1980), 69801, "PO Box 9968", false, ConsultasExternas.ENFERMERIA, Turno.TARDE));
        lista.add(new PersonalSanitario("Angus", "Duesberry", "Saffin", "75857770W", new Date(02/07/1992), 59195, "PO Box 20546", true, ConsultasExternas.PSIQUIATRIA, Turno.NOCTURNO));
        lista.add(new PersonalSanitario("Ashien", "Cottam", "Russon", "30642808B", new Date(04/06/1979), 18033, "19th Floor", true, ConsultasExternas.DERMATOLOGIA, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Dewitt", "Glasheen", "Athy", "71321400K", new Date(14/07/1991), 78682, "Room 1220", false, ConsultasExternas.DERMATOLOGIA, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Derward", "Kuhle", "O'Mullally", "37966472E", new Date(17/9/1975), 36477, "15th Floor", true, ConsultasExternas.PSIQUIATRIA, Turno.TARDE));
        lista.add(new PersonalSanitario("Rudie", "Bootman", "Lidgley", "65003664Q", new Date(27/02/1990), 36502, "Room 1739", true, ConsultasExternas.ENFERMERIA, Turno.NOCTURNO));
        lista.add(new PersonalSanitario("Brande", "Bath", "Archbell", "71020018K", new Date(21/03/1988), 73985, "PO Box 13817", true, ConsultasExternas.PSIQUIATRIA, Turno.NO_ASIGNADO));
        lista.add(new PersonalSanitario("Fairfax", "Gatfield", "Peare", "45885486K", new Date(10/03/1997), 18500, "Room 1794", false, ConsultasExternas.MEDICINA_INTERNA, Turno.NO_ASIGNADO));
        lista.add(new PersonalSanitario("Kinna", "Lawlor", "Mariot", "01212662W", new Date(23/10/1979), 41156, "PO Box 48187", false, ConsultasExternas.FISIOTERAPIA, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Deborah", "Dranfield", "Johannes", "67841719B", new Date(12/07/1991), 60097, "Room 1422", true, ConsultasExternas.TRAUMATOLOGIA, Turno.NO_ASIGNADO));
        lista.add(new PersonalSanitario("Georgeanne", "Ridges", "Menguy", "93248035F", new Date(23/04/1970), 78385, "Room 1613", true, ConsultasExternas.CIRUGIA_GENERAL, Turno.TARDE));
        lista.add(new PersonalSanitario("Lisetta", "Merriday", "Rubie", "22756850Z", new Date(10/06/1995), 55634, "1st Floor", false, ConsultasExternas.APARATO_DIGESTIVO, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Julieta", "Cuff", "Friskey", "38257006A", new Date(05/01/1970), 62462, "PO Box 15133", true, ConsultasExternas.MEDICINA_INTERNA, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Claiborn", "Gillard", "Parlet", "39811439C", new Date(6/8/1973), 63897, "PO Box 21694", true, ConsultasExternas.APARATO_DIGESTIVO, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Betta", "Filby", "Hancill", "82233576L", new Date(2/6/1984), 26392, "Suite 11", true, ConsultasExternas.FISIOTERAPIA, Turno.NOCTURNO));
        lista.add(new PersonalSanitario("Ranique", "Burfield", "Bielfelt", "72988577B", new Date(5/12/1999), 24391, "Apt 1405", true, ConsultasExternas.FISIOTERAPIA, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Blakelee", "Fears", "Petrovykh", "75306380W", new Date(2/9/1999), 75780, "19th Floor", false, ConsultasExternas.ONCOLOGIA, Turno.TARDE));
        lista.add(new PersonalSanitario("Carling", "Hurdwell", "Steart", "29579697G", new Date(11/6/1988), 22729, "Apt 796", true, ConsultasExternas.NO_ASIGNADO, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Marigold", "Bratt", "Philpots", "55111174Z", new Date(2/9/1987), 14207, "PO Box 63880", true, ConsultasExternas.MEDICINA_INTERNA, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Jolie", "Moorrud", "Breach", "49367646G", new Date(10/3/1977), 70666, "Room 795", false, ConsultasExternas.MEDICINA_INTERNA, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Jenda", "Goult", "Gandrich", "26472786G", new Date(12/11/1975), 4877, "PO Box 68059", false, ConsultasExternas.MEDICINA_GENERAL, Turno.TARDE));
        lista.add(new PersonalSanitario("Boone", "Tumilty", "Lakey", "82618692W", new Date(29/8/1991), 71302, "Suite 86", true, ConsultasExternas.TRAUMATOLOGIA, Turno.TARDE));
        lista.add(new PersonalSanitario("Guillema", "Snowden", "Rissen", "07048226T", new Date(10/8/1989), 41186, "Suite 27", true, ConsultasExternas.CARDIOLOGIA, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Eleanor", "Seedman", "Jiroudek", "78573128R", new Date(22/7/1979), 10789, "Apt 1497", true, ConsultasExternas.MEDICINA_GENERAL, Turno.TARDE));
        lista.add(new PersonalSanitario("Johny", "Edwardson", "Ennever", "41542445M", new Date(13/3/1992), 47626, "Apt 1411", true, ConsultasExternas.CIRUGIA_GENERAL, Turno.NOCTURNO));
        lista.add(new PersonalSanitario("Jeannine", "Yeulet", "McSpirron", "42502265R", new Date(02/11/1970), 5797, "2nd Floor", true, ConsultasExternas.ENFERMERIA, Turno.TARDE));
        lista.add(new PersonalSanitario("Lucienne", "Lempenny", "Speek", "26128956Y", new Date(25/05/1973), 92669, "Apt 1258", true, ConsultasExternas.NO_ASIGNADO, Turno.NOCTURNO));
        lista.add(new PersonalSanitario("Demott", "Bentley", "Poncet", "03857349F", new Date(27/06/1988), 75238, "4th Floor", false, ConsultasExternas.ENFERMERIA, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Neale", "Faires", "Brands", "80362099L", new Date(16/11/1976), 98603, "Apt 1314", true, ConsultasExternas.CIRUGIA_GENERAL, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Liza", "McNae", "Keetch", "38132534E", new Date(23/01/1993), 61546, "Room 1545", true, ConsultasExternas.ONCOLOGIA, Turno.TARDE));
        lista.add(new PersonalSanitario("Dru", "Kubatsch", "Landsman", "19994733C", new Date(17/11/1974), 81924, "14th Floor", false, ConsultasExternas.NO_ASIGNADO, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Murray", "Keslake", "Darwent", "07202991Q", new Date(06/02/1995), 66582, "PO Box 83888", true, ConsultasExternas.FISIOTERAPIA, Turno.MAÑANA));
        lista.add(new PersonalSanitario("Maddalena", "Iglesias", "Becks", "40327935Q", new Date(25/8/1976), 12947, "PO Box 90642", true, ConsultasExternas.FISIOTERAPIA, Turno.MAÑANA));

        // Imprimir la lista de PersonalSanitario
        for (PersonalSanitario ps : lista) {
            System.out.println(ps);
        }

        return lista;
    }
}
