// src/main/java/com/example/poistenie/ConsoleUI.java
package com.example.poistenie;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Trieda pre interakciu s používateľom cez konzolu.
 * Zodpovednosť: Čítanie vstupov a zobrazovanie výstupov.
 * Nezodpovedá za správu dát.
 */
public class ConsoleUI {
    private Scanner scanner;

    /**
     * Konštruktor inicializuje Scanner pre čítanie z konzoly.
     */
    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    /**
     * Zobrazí hlavné menu aplikácie.
     */
    public void zobrazMenu() {
        System.out.println("\n--- Správa poistených ---");
        System.out.println("Vyberte akciu:");
        System.out.println("1 - Pridať nového poisteného");
        System.out.println("2 - Zobraziť zoznam všetkých poistených");
        System.out.println("3 - Vyhľadať poisteného");
        System.out.println("4 - Koniec");
        System.out.print("Vaša voľba: ");
    }

    /**
     * Načíta voľbu používateľa z menu.
     * Ošetruje nečíselný vstup.
     *
     * @return Číslo voľby používateľa.
     */
    public int citajVolbu() {
        while (true) {
            try {
                int volba = scanner.nextInt();
                scanner.nextLine(); // Spotrebovať zvyšok riadku po nextInt()
                return volba;
            } catch (InputMismatchException e) {
                System.out.println("Neplatný vstup. Zadajte prosím číslo.");
                scanner.next(); // Spotrebovať neplatný vstup
                System.out.print("Vaša voľba: ");
            }
        }
    }

    /**
     * Načíta údaje pre nového poisteného od používateľa s validáciou.
     *
     * @return Objekt Poisteny vytvorený na základe vstupov od používateľa.
     */
    public Poisteny citajPoisteneho() {
        System.out.println("\nZadajte údaje o novom poistenom:");

        String meno = citajNePrazdnyRetazec("Zadajte meno: ");
        String priezvisko = citajNePrazdnyRetazec("Zadajte priezvisko: ");
        int vek = citajCislo("Zadajte vek: ");
        String telefon = citajRetazec("Zadajte telefónne číslo: ");

        return new Poisteny(meno, priezvisko, vek, telefon);
    }

    /**
     * Načíta neprázdny reťazec od používateľa.
     * Opakuje výzvu, kým používateľ nezadá neprázdny reťazec.
     * DRY princíp - použitie metódy pre opakujúcu sa validáciu vstupu.
     *
     * @param vyzva Text výzvy pre používateľa.
     * @return Neprázdny reťazec zadaný používateľom.
     */
    private String citajNePrazdnyRetazec(String vyzva) {
        String vstup;
        do {
            System.out.print(vyzva);
            vstup = scanner.nextLine().trim();
            if (vstup.isEmpty()) {
                System.out.println("Vstup nesmie byť prázdny. Prosím, zadajte hodnotu.");
            }
        } while (vstup.isEmpty());
        return vstup;
    }

    /**
     * Načíta reťazec od používateľa (môže byť aj prázdny, vhodné pre telefónne číslo).
     * DRY princíp.
     *
     * @param vyzva Text výzvy pre používateľa.
     * @return Reťazec zadaný používateľom.
     */
    private String citajRetazec(String vyzva) {
        System.out.print(vyzva);
        return scanner.nextLine().trim();
    }

    /**
     * Načíta celé číslo od používateľa.
     * Ošetruje nečíselný vstup.
     * DRY princíp.
     *
     * @param vyzva Text výzvy pre používateľa.
     * @return Celé číslo zadané používateľom.
     */
    private int citajCislo(String vyzva) {
        while (true) {
            System.out.print(vyzva);
            try {
                int cislo = scanner.nextInt();
                scanner.nextLine(); // Spotrebovať zvyšok riadku
                return cislo;
            } catch (InputMismatchException e) {
                System.out.println("Neplatný vstup. Zadajte prosím celé číslo.");
                scanner.next(); // Spotrebovať neplatný vstup
            }
        }
    }


    /**
     * Zobrazí zoznam všetkých poistených osôb.
     *
     * @param poistenci Zoznam poistených osôb na zobrazenie.
     */
    public void zobrazPoistenych(List<Poisteny> poistenci) {
        System.out.println("\n--- Zoznam všetkých poistených ---");
        if (poistenci.isEmpty()) {
            System.out.println("Momentálne nie sú evidovaní žiadni poistení.");
        } else {
            // Hlavička tabuľky
            System.out.println(String.format("%-15s %-15s %-5s %s", "Meno", "Priezvisko", "Vek", "Telefón"));
            System.out.println("--------------------------------------------------");

            for (Poisteny poisteny : poistenci) {
                System.out.println(poisteny); // Používa metódu toString() z triedy Poisteny
            }
            System.out.println("--------------------------------------------------");
        }
    }

    /**
     * Načíta meno a priezvisko pre vyhľadanie od používateľa.
     * DRY princíp.
     *
     * @return Pole String[2], kde index 0 je meno a index 1 je priezvisko.
     */
    public String[] citajMenoPriezviskoPreVyhladanie() {
        System.out.println("\nZadajte meno a priezvisko poisteného na vyhľadanie:");
        String meno = citajNePrazdnyRetazec("Zadajte meno: ");
        String priezvisko = citajNePrazdnyRetazec("Zadajte priezvisko: ");
        return new String[]{meno, priezvisko};
    }


    /**
     * Zobrazí detaily jedného poisteného.
     *
     * @param poisteny Objekt Poisteny na zobrazenie.
     */
    public void zobrazPoisteneho(Poisteny poisteny) {
        if (poisteny == null) {
            System.out.println("Poistený s daným menom a priezviskom nebol nájdený.");
        } else {
             System.out.println("\n--- Nájdutý poistený ---");
             System.out.println(String.format("%-15s %-15s %-5s %s", "Meno", "Priezvisko", "Vek", "Telefón"));
             System.out.println("--------------------------------------------------");
             System.out.println(poisteny);
             System.out.println("--------------------------------------------------");
        }
    }

    /**
     * Zobrazí všeobecnú správu pre používateľa.
     *
     * @param sprava Text správy na zobrazenie.
     */
    public void zobrazSpravu(String sprava) {
        System.out.println(sprava);
    }

    /**
     * Zavrie Scanner po ukončení práce.
     */
    public void zavriScanner() {
        scanner.close();
    }
}
