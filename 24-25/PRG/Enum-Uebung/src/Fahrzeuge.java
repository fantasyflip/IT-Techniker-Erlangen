public class Fahrzeuge {
    public static void main(String[] args) {
        Fahrzeug a = new Fahrzeug("BASN332", Fahrzeugtyp.AUTO);
        Fahrzeug b = new Fahrzeug("ERZZ123", Fahrzeugtyp.LKW);

        Fahrzeugtyp.listeFahrzeugtypen();
    }
}
