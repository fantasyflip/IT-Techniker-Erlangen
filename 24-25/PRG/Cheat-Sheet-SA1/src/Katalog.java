public class Katalog {
    public static void main(String[] args) {
        // Anlage eines Array, der 5 Benziner enthalten kann
        Benziner [] benzinerKatalog = new Benziner[5];

        // Anlage der Benziner im Array
        benzinerKatalog[0] = new Benziner("BMW", "435i", 340, 3000, 6, "Super-Plus", 98);
        benzinerKatalog[1] = new Benziner("Audi", "S3", 310, 2000, 4, "Super", 95);
        benzinerKatalog[2] = new Benziner("Mercedes-Benz", "C43 AMG", 390, 3000, 6, "Super-Plus", 98);
        benzinerKatalog[3] = new Benziner("Volkswagen", "Golf GTI", 245, 2000, 4, "Super", 95);
        benzinerKatalog[4] = new Benziner("Porsche", "911 Carrera", 385, 3000, 6, "Super-Plus", 98);

        // Data-Sheet für alle Elemente im Array ausgeben
        for(int i = 0; i < benzinerKatalog.length; i++){
            benzinerKatalog[i].printDataSheet();
        }

        // String Funktionen
        System.out.println("------ String-Funktionen ------");

        String mercedes = benzinerKatalog[2].getMake();
        String lowerCaseMercedes = mercedes.toLowerCase();
        String volkswagen = benzinerKatalog[3].getMake();

        System.out.println(" 1: " + lowerCaseMercedes); // "mercedes-benz"
        System.out.println(" 2: " + mercedes.charAt(3)); // "c" -> Der Character an der 4. Position
        System.out.println(" 3: " + mercedes.compareTo(volkswagen)); // "-9" -> "V" olkswagen ist 9 Stellen unter "M" ercedes-Benz
        System.out.println(" 4: " + volkswagen.endsWith("wagen")); // "true"
        System.out.println(" 5: " + mercedes.equals(lowerCaseMercedes)); // "false" -> da Case-Sensitive
        System.out.println(" 6: " + mercedes.equalsIgnoreCase(lowerCaseMercedes)); // "true" -> nicht Case-Sensitive
        System.out.println(" 7: " + mercedes.indexOf("-")); // "8" -> Bindestrich an 8. Stelle
        System.out.println(" 8: " + mercedes.indexOf("Ben")); // "9" -> beginn des substrings an 9. Stelle
        System.out.println(" 9: " + mercedes.indexOf("BMW")); // "-1" -> Substring ist nicht in String enthalten
        System.out.println("10: " + mercedes.length()); // "13" -> "Mercedes-Benz" hat 13 Zeichen
        System.out.println("11: " + mercedes.replace('e', 'x')); // "Mxrcxdxs-Bxnz" -> alle 'e' werden durch 'x' ersetzt
        System.out.println("12: " + mercedes.repeat(2)); // "Mercedes-BenzMercedes-Benz" -> String wird zwei mal hintereinander gehängt
        System.out.println("13: " + mercedes.startsWith("Schoen")); // "false" -> String beginnt nicht mit "Schoen"
        System.out.println("14: " + mercedes.substring(4)); // "edes-Benz" -> String beginnt an 4. Stelle
        System.out.println("15: " + mercedes.substring(5,12)); // "des-Ben" -> string beginnt an 5. Stelle und endet VOR 12.
        System.out.println("16: " + volkswagen.toLowerCase()); // "volkswagen" -> alle Großbuchstaben werden in Kleinbuchstaben umgewandelt
        System.out.println("17: " + volkswagen.toUpperCase()); // "VOLKSWAGEN" -> alle Kleinbuchstaben werden in Großbuchstaben umgewandelt
        System.out.println("18: " + String.valueOf(1.5e2)); // "150.0" -> wird in lesbaren String umgewandelt

    }
}
