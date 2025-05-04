public class Patient {
    private String name;
    private String vorname;
    private int patientNr;
    private int alter;
    private static int anzahl;

    public Patient(String name, String vorname, int alter) {
        this.name = name;
        this.vorname = vorname;
        this.alter = alter;
    }

    public String getName(){
        return this.name;
    }

    public String getVorname(){
        return this.vorname;
    }

    public int getAlter(){
        return this.alter;
    }

    public int getPatientNr(){
        return this.patientNr;
    }

    public static int getAnzahl(){
        return anzahl;
    }

    public void setPatientNr(){
        this.patientNr = (int)((Math.random() * 100) + 1)*42;
    }

    public String toString(){
        return this.name + ", " + this.vorname + ", " + this.alter + ", " + this.patientNr;
    }
}
