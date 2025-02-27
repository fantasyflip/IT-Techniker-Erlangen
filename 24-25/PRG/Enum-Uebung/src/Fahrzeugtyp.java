public enum Fahrzeugtyp {
    AUTO(200),
    MOTORRAD(300),
    LKW(80),
    FAHRRAD(25);

    private final int maxGeschwindigkeit;

    Fahrzeugtyp(int max){
        maxGeschwindigkeit = max;
    }

    public int getMaxGeschwindigkeit(){
        return maxGeschwindigkeit;
    }

    //geht alle Enums des Fahrzeugtyps durch → ForEach
    public static void listeFahrzeugtypen() {
        for (Fahrzeugtyp typ : Fahrzeugtyp.values()) {
            System.out.println(typ + " hat eine Höchstgeschwindigkeit von " + typ.getMaxGeschwindigkeit() + " km/h.");
        }
    }
}
