// convert C project to java

// #include <stdio.h>

//int main() {
//    int jahr = 2024;

//    if ((jahr % 4 == 0 && jahr % 100 != 0) || (jahr % 400 == 0)) {
//        printf("%d ist ein Schaltjahr.\n", jahr);
//    } else {
//        printf("%d ist kein Schaltjahr.\n", jahr);
//    }

//    return 0;
//}

public class Schaltjahr {
    public static void main(String[] args) {
        int year = 2023;

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " ist ein Schaltjahr.");

        } else {
            System.out.println(year + " ist kein Schaltjahr.");
        }
    }
}
