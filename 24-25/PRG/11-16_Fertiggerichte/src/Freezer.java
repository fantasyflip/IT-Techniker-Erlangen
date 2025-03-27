import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Freezer {
    Map<ReadyMeal, Integer> items = new HashMap<ReadyMeal, Integer>();

    public Freezer() {
        items.put(new ReadyMeal("Pizza", 5.99),2);
        items.put(new ReadyMeal("Nudeln", 3.99),5);
        items.put(new ReadyMeal("Pommes", 4.99),1);
        items.put(new ReadyMeal("Chicken Wings", 7.99),1);
    }

    private  void printSectionSeparator(){
        for(int i = 0; i < 3; i++){
            System.out.println();
        }
        for(int i = 0; i <20;i++){
            System.out.print("-");
        }
        for(int i = 0; i < 3; i++){
            System.out.println();
        }
    }

    private int getTaskNumber(){
        System.out.println("Was möchten Sie tun?");
        System.out.println();
        System.out.println("1. Inhalt anzeigen");
        System.out.println("2. Einkauf verbuchen");
        System.out.println("3. Verzehr verbuchen");
        System.out.println("4. Beenden");

        // User input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Auswahl: ");
        int taskNumber = scanner.nextInt();

        printSectionSeparator();

        return taskNumber;
    }

    public void selectAction(){
        boolean runLoop = true;

        while(runLoop) {
            int taskNumber = getTaskNumber();

            switch (taskNumber) {
                case 1: {
                    printItems(false);
                    break;
                }
                case 2: {
                    addItem();
                    break;
                }
                case 3: {
                    removeItem();
                    break;
                }
                case 4: {
                    System.out.println("Beenden");
                    runLoop = false;
                    break;
                }
                default: {
                    break;
                }
            }

        }
    }

    public void printItems(boolean displayIndex){

        System.out.println("Schrankinhalt");
        System.out.println();

        int i = 0;

        for (Map.Entry<ReadyMeal, Integer> entry : items.entrySet()) {
            if(displayIndex){
                System.out.print(i + ": ");
                i++;
            }
            System.out.println(entry.getKey().name() + " ("+ entry.getKey().price() + ")" + " - Menge: " + entry.getValue());
        }

        printSectionSeparator();
    }

    public void addItem(){
        System.out.println();


        System.out.print("Name des Fertiggerichts: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println();
        System.out.print("Preis des Fertiggerichts: ");
        Double price = scanner.nextDouble();

        ReadyMeal f = new ReadyMeal(name, price);

        //check if same item is already in map
        if(items.containsKey(f)){
            //if it is already in the map increase count by one
            items.put(f, items.get(f) + 1);
        } else {
            items.put(f, 1);
        }

        System.out.println("Einkauf hinzugefügt: " + f.name() +" - " + f.price() + " (Gesamtanzahl: " + items.get(f) + ")");

        printSectionSeparator();
    }

    public void removeItem() {
        if (items.isEmpty()) {
            System.out.println("Der Schrank ist leer. Es gibt nichts zu entfernen.");
            printSectionSeparator();
            return;
        }

        printItems(true);

        System.out.println("Welches Fertiggericht soll entfernt werden? Nummer:");
        Scanner scanner = new Scanner(System.in);

        int itemIndex;
        try {
            itemIndex = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ungültige Eingabe. Bitte eine Zahl eingeben.");
            return;
        }

        // Get the item at the given index
        int i = 0;
        ReadyMeal selectedMeal = null;
        for (Map.Entry<ReadyMeal, Integer> entry : items.entrySet()) {
            if (i == itemIndex) {
                selectedMeal = entry.getKey();
                break;
            }
            i++;
        }

        // Check if the index was valid
        if (selectedMeal == null) {
            System.out.println("Ungültige Auswahl. Bitte eine korrekte Nummer eingeben.");
            printSectionSeparator();
            removeItem();
            return;
        }

        // Check if the amount is greater than one
        if (items.get(selectedMeal) > 1) {
            // Reduce by one
            items.put(selectedMeal, items.get(selectedMeal) - 1);
            System.out.println("Ein Exemplar von " + selectedMeal.name() + " entfernt. Verbleibende Menge: " + items.get(selectedMeal));
        } else {
            // Remove item completely
            items.remove(selectedMeal);
            System.out.println(selectedMeal.name() + " wurde vollständig entfernt.");
        }

        printSectionSeparator();
    }

}
