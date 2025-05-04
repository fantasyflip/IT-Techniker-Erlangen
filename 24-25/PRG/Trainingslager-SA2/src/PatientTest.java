public class PatientTest {
    public static void main(String[] args) {
        Patient[] patienten = new Patient[3];

        patienten[0] = new Privatpatient("Meier", "Hans", 45);
        patienten[1] = new Kassenpatient("Müller", "Peter", 23, true);
        patienten[2] = new Kassenpatient("Müller", "Daniela", 51, false);

        for(int i = 0; i < patienten.length; i++){
            System.out.println(patienten[i].toString());
        }
    }
}
