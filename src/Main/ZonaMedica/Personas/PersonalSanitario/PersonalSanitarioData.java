package Main.ZonaMedica.Personas.PersonalSanitario;

import java.util.ArrayList;
import java.util.Date;

import static Main.ZonaMedica.Personas.Estudiantes.EstudianteController.inputAsignarSanitario;

public class PersonalSanitarioData {
    // Crear una dataPersonalSanitario de objetos PersonalSanitario global para poder acceder desde distintas clases.
    public static ArrayList<PersonalSanitario> dataPersonalSanitario = new ArrayList<>();

    public static void main(String args[]) {
        generarDatosPersonalSanitario();
        mostrarPersonal();
        inputAsignarSanitario();
    }

    public static void mostrarPersonal() {
        int cont, cont2;
        System.out.println(String.format("%1$-79s", "-").replace(" ", "-"));
        for (int i = 0; i < dataPersonalSanitario.size() - 1; i += 2) {
            cont = i + 1;
            cont2 = i + 2;
            System.out.println(
                    "| " + String.format("%1$-36s", cont + ".-") +
                            "| " + String.format("%1$-36s", cont2 + ".-") + " |\n" +
                            "| Nombre: " + String.format("%1$-28s", dataPersonalSanitario.get(i).getNombreCompleto()) +
                            "| Nombre: " + String.format("%1$-28s", dataPersonalSanitario.get(cont).getNombreCompleto()) + " |\n" +
                            "| Especialidad: " + String.format("%1$-22s", dataPersonalSanitario.get(i).getEspecialidad()) +
                            "| Especialidad: " + String.format("%1$-22s", dataPersonalSanitario.get(cont).getEspecialidad()) + " |"
            );
            System.out.println(String.format("%1$-79s", "-").replace(" ", "-"));
        }
    }

    public static void generarDatosPersonalSanitario() {

        // Agregar los objetos PersonalSanitario a la dataPersonalSanitario
        dataPersonalSanitario.add(new PersonalSanitario("Rubetta", "Rignall", "Sexty", "07967771T", new Date(22 / 03 / 1995), 19990, "Room 321", ConsultasExternas.CIRUGIA_GENERAL, Turno.NO_ASIGNADO, 123456789));
        dataPersonalSanitario.add(new PersonalSanitario("Adele", "Curtayne", "Sinnatt", "92671651X", new Date(21 / 06 / 1990), 60968, "Apt 1870", ConsultasExternas.FISIOTERAPIA, Turno.TARDE, 987654321));
        dataPersonalSanitario.add(new PersonalSanitario("Celinka", "Rudloff", "Water", "73699587W", new Date(31 / 02 / 1984), 27445, "Room 979", ConsultasExternas.APARATO_DIGESTIVO, Turno.TARDE, 456123789));
        dataPersonalSanitario.add(new PersonalSanitario("Cheston", "Pasterfield", "Tootal", "16302989Z", new Date(19 / 11 / 1997), 85325, "2nd Floor", ConsultasExternas.TRAUMATOLOGIA, Turno.NO_ASIGNADO, 789456123));
        dataPersonalSanitario.add(new PersonalSanitario("Maybelle", "Grunder", "Honsch", "16725391B", new Date(01 / 03 / 1981), 40611, "Apt 957", ConsultasExternas.ONCOLOGIA, Turno.NO_ASIGNADO, 321654987));
        dataPersonalSanitario.add(new PersonalSanitario("Ewart", "Cheverton", "Storrs", "01316456G", new Date(24 / 01 / 1980), 69801, "PO Box 9968", ConsultasExternas.ENFERMERIA, Turno.TARDE, 789654123));
        dataPersonalSanitario.add(new PersonalSanitario("Angus", "Duesberry", "Saffin", "75857770W", new Date(02 / 07 / 1992), 59195, "PO Box 20546", ConsultasExternas.PSIQUIATRIA, Turno.NOCTURNO, 123987456));
        dataPersonalSanitario.add(new PersonalSanitario("Ashien", "Cottam", "Russon", "30642808B", new Date(04 / 06 / 1979), 18033, "19th Floor", ConsultasExternas.DERMATOLOGIA, Turno.MAÑANA, 987654321));
        dataPersonalSanitario.add(new PersonalSanitario("Dewitt", "Glasheen", "Athy", "71321400K", new Date(14 / 07 / 1991), 78682, "Room 1220", ConsultasExternas.DERMATOLOGIA, Turno.MAÑANA, 456123789));
        dataPersonalSanitario.add(new PersonalSanitario("Derward", "Kuhle", "O'Mullally", "37966472E", new Date(17 / 9 / 1975), 36477, "15th Floor", ConsultasExternas.PSIQUIATRIA, Turno.TARDE, 789456123));
        dataPersonalSanitario.add(new PersonalSanitario("Rudie", "Bootman", "Lidgley", "65003664Q", new Date(27 / 02 / 1990), 36502, "Room 1739", ConsultasExternas.ENFERMERIA, Turno.NOCTURNO, 321654987));
        dataPersonalSanitario.add(new PersonalSanitario("Brande", "Bath", "Archbell", "71020018K", new Date(21 / 03 / 1988), 73985, "PO Box 13817", ConsultasExternas.PSIQUIATRIA, Turno.NO_ASIGNADO, 123987456));
        dataPersonalSanitario.add(new PersonalSanitario("Fairfax", "Gatfield", "Peare", "45885486K", new Date(10 / 03 / 1997), 18500, "Room 1794", ConsultasExternas.MEDICINA_INTERNA, Turno.NO_ASIGNADO, 789654123));
        dataPersonalSanitario.add(new PersonalSanitario("Kinna", "Lawlor", "Mariot", "01212662W", new Date(23 / 10 / 1979), 41156, "PO Box 48187", ConsultasExternas.FISIOTERAPIA, Turno.MAÑANA, 123456789));
        dataPersonalSanitario.add(new PersonalSanitario("Deborah", "Dranfield", "Johannes", "67841719B", new Date(12 / 07 / 1991), 60097, "Room 1422", ConsultasExternas.TRAUMATOLOGIA, Turno.NO_ASIGNADO, 987654321));
        dataPersonalSanitario.add(new PersonalSanitario("Georgeanne", "Ridges", "Menguy", "93248035F", new Date(23 / 04 / 1970), 78385, "Room 1613", ConsultasExternas.CIRUGIA_GENERAL, Turno.TARDE, 456123789));
        dataPersonalSanitario.add(new PersonalSanitario("Lisetta", "Merriday", "Rubie", "22756850Z", new Date(10 / 06 / 1995), 55634, "1st Floor", ConsultasExternas.APARATO_DIGESTIVO, Turno.MAÑANA, 789456123));
        dataPersonalSanitario.add(new PersonalSanitario("Julieta", "Cuff", "Friskey", "38257006A", new Date(05 / 01 / 1970), 62462, "PO Box 15133", ConsultasExternas.MEDICINA_INTERNA, Turno.MAÑANA, 321654987));
        dataPersonalSanitario.add(new PersonalSanitario("Claiborn", "Gillard", "Parlet", "39811439C", new Date(6 / 8 / 1973), 63897, "PO Box 21694", ConsultasExternas.APARATO_DIGESTIVO, Turno.MAÑANA, 123987456));
        dataPersonalSanitario.add(new PersonalSanitario("Betta", "Filby", "Hancill", "82233576L", new Date(2 / 6 / 1984), 26392, "Suite 11", ConsultasExternas.FISIOTERAPIA, Turno.NOCTURNO, 456123789));
        dataPersonalSanitario.add(new PersonalSanitario("Ranique", "Burfield", "Bielfelt", "72988577B", new Date(5 / 12 / 1999), 24391, "Apt 1405", ConsultasExternas.FISIOTERAPIA, Turno.MAÑANA, 789654123));
        dataPersonalSanitario.add(new PersonalSanitario("Blakelee", "Fears", "Petrovykh", "75306380W", new Date(2 / 9 / 1999), 75780, "19th Floor", ConsultasExternas.ONCOLOGIA, Turno.TARDE, 123456789));
        dataPersonalSanitario.add(new PersonalSanitario("Carling", "Hurdwell", "Steart", "29579697G", new Date(11 / 6 / 1988), 22729, "Apt 796", ConsultasExternas.NO_ASIGNADO, Turno.MAÑANA, 987654321));
        dataPersonalSanitario.add(new PersonalSanitario("Marigold", "Bratt", "Philpots", "55111174Z", new Date(2 / 9 / 1987), 14207, "PO Box 63880", ConsultasExternas.MEDICINA_INTERNA, Turno.MAÑANA, 456123789));
        dataPersonalSanitario.add(new PersonalSanitario("Jolie", "Moorrud", "Breach", "49367646G", new Date(10 / 3 / 1977), 70666, "Room 795", ConsultasExternas.MEDICINA_INTERNA, Turno.MAÑANA, 789654123));
        dataPersonalSanitario.add(new PersonalSanitario("Jenda", "Goult", "Gandrich", "26472786G", new Date(12 / 11 / 1975), 4877, "PO Box 68059", ConsultasExternas.MEDICINA_GENERAL, Turno.TARDE, 123456789));
        dataPersonalSanitario.add(new PersonalSanitario("Boone", "Tumilty", "Lakey", "82618692W", new Date(29 / 8 / 1991), 71302, "Suite 86", ConsultasExternas.TRAUMATOLOGIA, Turno.TARDE, 987654321));
        dataPersonalSanitario.add(new PersonalSanitario("Guillema", "Snowden", "Rissen", "07048226T", new Date(10 / 8 / 1989), 41186, "Suite 27", ConsultasExternas.CARDIOLOGIA, Turno.MAÑANA, 456123789));
        dataPersonalSanitario.add(new PersonalSanitario("Eleanor", "Seedman", "Jiroudek", "78573128R", new Date(22 / 7 / 1979), 10789, "Apt 1497", ConsultasExternas.MEDICINA_GENERAL, Turno.TARDE, 789654123));
        dataPersonalSanitario.add(new PersonalSanitario("Johny", "Edwardson", "Ennever", "41542445M", new Date(13 / 3 / 1992), 47626, "Apt 1411", ConsultasExternas.CIRUGIA_GENERAL, Turno.NOCTURNO, 123456789));
        dataPersonalSanitario.add(new PersonalSanitario("Jeannine", "Yeulet", "McSpirron", "42502265R", new Date(02 / 11 / 1970), 5797, "2nd Floor", ConsultasExternas.ENFERMERIA, Turno.TARDE, 987654321));
        dataPersonalSanitario.add(new PersonalSanitario("Lucienne", "Lempenny", "Speek", "26128956Y", new Date(25 / 05 / 1973), 92669, "Apt 1258", ConsultasExternas.NO_ASIGNADO, Turno.NOCTURNO, 456123789));
        dataPersonalSanitario.add(new PersonalSanitario("Demott", "Bentley", "Poncet", "03857349F", new Date(27 / 06 / 1988), 75238, "4th Floor", ConsultasExternas.ENFERMERIA, Turno.MAÑANA, 789654123));
        dataPersonalSanitario.add(new PersonalSanitario("Neale", "Faires", "Brands", "80362099L", new Date(16 / 11 / 1976), 98603, "Apt 1314", ConsultasExternas.CIRUGIA_GENERAL, Turno.MAÑANA, 123456789));
        dataPersonalSanitario.add(new PersonalSanitario("Liza", "McNae", "Keetch", "38132534E", new Date(23 / 01 / 1993), 61546, "Room 1545", ConsultasExternas.ONCOLOGIA, Turno.TARDE, 987654321));
        dataPersonalSanitario.add(new PersonalSanitario("Dru", "Kubatsch", "Landsman", "19994733C", new Date(17 / 11 / 1974), 81924, "14th Floor", ConsultasExternas.NO_ASIGNADO, Turno.MAÑANA, 456123789));
        dataPersonalSanitario.add(new PersonalSanitario("Murray", "Keslake", "Darwent", "07202991Q", new Date(06 / 02 / 1995), 66582, "PO Box 83888", ConsultasExternas.FISIOTERAPIA, Turno.MAÑANA, 789654123));
        dataPersonalSanitario.add(new PersonalSanitario("Maddalena", "Iglesias", "Becks", "40327935Q", new Date(25 / 8 / 1976), 12947, "PO Box 90642", ConsultasExternas.FISIOTERAPIA, Turno.MAÑANA, 123456789));

    }
}