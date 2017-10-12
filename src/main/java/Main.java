import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Database database = new Database();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[\\r\\n]+");


        while (true) {
            System.out.println("Jei norite įvesti naują vartotoją, įveskite 1." +
                    " Jei norite naudotis paieška, įveskite 2. ");
            int atsakymas = scanner.nextInt();
            if (atsakymas == 1) {
                System.out.println("Įveskite vardą:");
                String vardas = scanner.next();
                System.out.println("Įveskite pavardę:");
                String pavarde = scanner.next();
                System.out.println("Įveskite adresą:");
                String adresas = scanner.next();
                System.out.println("Įveskite el. paštą:");
                String el_pastas = scanner.next();
                database.insert(vardas, pavarde, adresas, el_pastas);
                System.out.println("Vartotojas įvestas.");
            } else if (atsakymas == 2) {
                System.out.println("Jei norite ieškoti pagal vardą, įveskite 1." +
                        " Jei norite ieškoti pagal pavardę, įveskite 2." +
                        " Jei norite ieškoti pagal el. paštą, įveskite 3.");
                int paieska = scanner.nextInt();
                if (paieska == 1) {
                    System.out.println("Įveskite vardą:");
                    String vardas = scanner.next();
                    database.selectVardas(vardas);
                } else if (paieska == 2) {
                    System.out.println("Įveskite pavardę:");
                    String pavarde = scanner.next();
                    database.selectPavarde(pavarde);
                } else if (paieska == 3) {
                    System.out.println("Įveskite el. paštą:");
                    String el_pastas = scanner.next();
                    database.selectElPastas(el_pastas);
                } else System.out.println("Klaida!");
            } else System.out.println("Klaida!");

        }
    }
}

