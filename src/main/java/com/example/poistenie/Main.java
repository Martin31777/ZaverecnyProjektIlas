// src/main/java/com/example/poistenie/Main.java
package com.example.poistenie;

/**
 * Hlavná trieda aplikácie pre správu poistených.
 * Zodpovednosť: Spustenie aplikácie a riadenie hlavného cyklu.
 * Oddeľuje logiku od dátového úložiska a používateľského rozhrania (SoC).
 */
public class Main {

    public static void main(String[] args) {
        // Inicializácia repozitára pre správu dát a UI pre interakciu s používateľom
        PoistenciRepository poistenciRepository = new PoistenciRepository();
        ConsoleUI consoleUI = new ConsoleUI();

        int volba;
        // Hlavný aplikačný cyklus
        do {
            consoleUI.zobrazMenu(); // Zobrazenie menu
            volba = consoleUI.citajVolbu(); // Načítanie voľby od používateľa

            // Spracovanie voľby
            switch (volba) {
                case 1:
                    // Pridanie nového poisteného
                    Poisteny novyPoisteny = consoleUI.citajPoisteneho(); // UI načíta údaje
                    poistenciRepository.pridajPoisteneho(novyPoisteny); // Repozitár uloží údaje
                    consoleUI.zobrazSpravu("Poistený bol úspešne pridaný.");
                    break;
                case 2:
                    // Zobrazenie všetkých poistených
                    consoleUI.zobrazPoistenych(poistenciRepository.getVsetciPoisteni()); // UI zobrazí údaje z repozitára
                    break;
                case 3:
                    // Vyhľadanie poisteného
                    String[] menoPriezvisko = consoleUI.citajMenoPriezviskoPreVyhladanie(); // UI načíta kritériá
                    Poisteny najdenyPoisteny = poistenciRepository.vyhladajPoisteneho(menoPriezvisko[0], menoPriezvisko[1]); // Repozitár vyhľadá
                    consoleUI.zobrazPoisteneho(najdenyPoisteny); // UI zobrazí výsledok
                    break;
                case 4:
                    // Koniec aplikácie
                    consoleUI.zobrazSpravu("Ukončujem aplikáciu.");
                    break;
                default:
                    // Neplatná voľba
                    consoleUI.zobrazSpravu("Neplatná voľba. Zvoľte prosím číslo z menu.");
            }
        } while (volba != 4); // Cyklus beží, kým používateľ nezvolí možnosť 4

        // Uvoľnenie zdrojov
        consoleUI.zavriScanner();
    }
}
