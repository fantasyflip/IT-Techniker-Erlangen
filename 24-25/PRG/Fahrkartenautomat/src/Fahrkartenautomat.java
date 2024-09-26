
// Fahrkartenautomat aus C in Java übersetzen

//    int main() {
//        int is_child = 1, single = 0, series = 0, month = 1;
//        double price, output, input = 123.43;
//
//        if (series) {
//            if (is_child) {
//                price = 4.50;
//            } else {
//                price = 6.50;
//            }
//        } else if (month) {
//            if (is_child) {
//                price = 25.50;
//            } else {
//                price = 30.00;
//            }
//        } else if (single) {
//            if (is_child) {
//                price = 2.50;
//            } else {
//                price = 3.50;
//            }
//        }
//
//        output = input - price;
//
//        if (output < 0.0) {
//            printf("Ihr Einwurf ist nicht ausreichend, um das gewuenschte Produkt zu erhalten. Bitte versuchen Sie es erneut.");
//        } else {
//            if (series) {
//                if (is_child) {
//                    printf("Sie erhalten eine Streifenkarte fuer Kinder. Vielen Dank fuer Ihren Einkauf!\n");
//                } else {
//                    printf("Sie erhalten eine Streifenkarte fuer Erwachsene. Vielen Dank fuer Ihren Einkauf!\n");
//                }
//            } else if (month) {
//                if (is_child) {
//                    printf("Sie erhalten eine Monatskarte fuer Kinder. Vielen Dank fuer Ihren Einkauf!\n");
//                } else {
//                    printf("Sie erhalten eine Monatskarte fuer Erwachsene. Vielen Dank fuer Ihren Einkauf!\n");
//                }
//            } else if (single) {
//                if (is_child) {
//                    printf("Sie erhalten eine Einzelkarte fuer Kinder. Vielen Dank fuer Ihren Einkauf!\n");
//                } else {
//                    printf("Sie erhalten eine Einzelkarte fuer Erwachsene. Vielen Dank fuer Ihren Einkauf!\n");
//                }
//            }
//
//            if (output != 0.0) {
//                printf("Ihr Rueckgeld betraegt %.2lf Euro und wird in folgender Konstellation ausgegeben:\n\n", output);
//
//                double currencySteps[] = {500.00, 200.00, 100.00, 50.00, 20.00, 10.00, 5.00, 2.00, 1.00, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};
//                int currencyItemsAmount = sizeof(currencySteps) / sizeof(currencySteps[0]);
//
//                // output zu int in cent casten
//                int centOutput = (int) (output * 100);
//
//                // ---- CAST IST NOTWENDIG UM RUNDUNGSFEHLER BEI DOUBLE ZU UMGEHEN ----
//                // ---- Bsp: 134.72 - 100.0 = 34.7199999                           ----
//                // ----      -> Würde einen Cent unterschlagen.                    ----
//                // ----      -> Int hat dieses Problem nicht -> Euro in Cent       ----
//
//                for (int i = 0; i < currencyItemsAmount; i++) {
//                    int count = 0;
//                    int stepCents = (int) (currencySteps[i] * 100);
//
//                    while (centOutput >= stepCents) {
//                        count++;
//                        centOutput = centOutput - stepCents;
//                    }
//
//                    if (count != 0) {
//                        if (stepCents < 100) {
//
//                            printf("%i %i ", count, stepCents);
//                            printf("Cent ");
//                        } else {
//                            // cent zurück zu double in euro casten
//                            printf("%i %.2lf ", count, (double) (stepCents / 100));
//                            printf("Euro ");
//                        }
//
//                        if (stepCents < 500) {
//                            if (count > 1) {
//                                printf("Muenzen");
//                            } else {
//                                printf("Muenze");
//                            }
//                        } else {
//                            if (count > 1) {
//                                printf("Scheine");
//                            } else {
//                                printf("Schein");
//                            }
//                        }
//
//                        printf("\n");
//                    }
//                }
//            }
//        }
//
//
//        printf("\n\n");
//
//        return 0;
//    }


public class Fahrkartenautomat {

    public static void main(String[] args) {
        boolean is_child = true;
        double input = 123.43;
        int type = 2;

//      0: Single
//      1: Series
//      2: Month
        double price = getPrice(is_child, type);

        double output = input - price;

        printOutput(output, is_child, type);
    }

    public static double getPrice(boolean is_child, int type) {
        double price = 0.0;

        if (type == 0) {

            if (is_child) {
                price = 2.5;
            } else {
                price = 3.5;
            }
        } else if (type == 1) {
            if (is_child) {
                price = 4.5;
            } else {
                price = 6.5;
            }
        } else if (type == 2) {
            if (is_child) {
                price = 25.5;
            } else {
                price = 30.0;
            }
        }

        return price;
    }

    public static void printOutput(double output, boolean is_child, int type) {
        if (output < 0.0) {
            System.out.println("Ihr Einwurf ist nicht ausreichend, um das gewuenschte Produkt zu erhalten. Bitte versuchen Sie es erneut.");
        } else {
            if (type == 0) {
                if (is_child) {
                    System.out.println("Sie erhalten eine Einzelkarte fuer Kinder. Vielen Dank fuer Ihren Einkauf!");
                } else {
                    System.out.println("Sie erhalten eine Einzelkarte fuer Erwachsene. Vielen Dank fuer Ihren Einkauf!");
                }
            } else if (type == 1) {
                if (is_child) {
                    System.out.println("Sie erhalten eine Streifenkarte fuer Kinder. Vielen Dank fuer Ihren Einkauf!");
                } else {
                    System.out.println("Sie erhalten eine Streifenkarte fuer Erwachsene. Vielen Dank fuer Ihren Einkauf!");
                }
            } else if (type == 2) {
                if (is_child) {
                    System.out.println("Sie erhalten eine Monatskarte fuer Kinder. Vielen Dank fuer Ihren Einkauf!");
                } else {
                    System.out.println("Sie erhalten eine Monatskarte fuer Erwachsene. Vielen Dank fuer Ihren Einkauf!");
                }
            }
        }

        if (output != 0.0) {
            System.out.println("Ihr Rueckgeld betraegt " + output + " Euro und wird in folgender Konstellation ausgegeben:");
            double currencySteps[] = {500.00, 200.00, 100.00, 50.00, 20.00, 10.00, 5.00, 2.00, 1.00, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};

            int centOutput = (int) (output * 100);

            for (int i = 0; i < currencySteps.length; i++) {
                int count = 0;
                int stepCents = (int) (currencySteps[i] * 100);

                while (centOutput >= stepCents) {
                    count++;
                    centOutput = centOutput - stepCents;
                }

                if (count != 0) {
                    if (stepCents < 100) {

                        System.out.print(count + "x " + stepCents + " Cent ");
                    } else {
                        // cent zurück zu double in euro casten
                        System.out.print(count + "x " + (double) (stepCents / 100) + " Euro ");
                    }

                    if (stepCents < 500) {
                        if (count > 1) {
                            System.out.println("Muenzen");
                        } else {
                            System.out.println("Muenze");
                        }
                    } else {
                        if (count > 1) {
                            System.out.println("Scheine");
                        } else {
                            System.out.println("Schein");
                        }
                    }

                }
            }
        }
    }
}