// src/main/java/com/example/poistenie/PoistenciRepository.java
package com.example.poistenie;

import java.util.ArrayList;
import java.util.List;

/**
 * Repozitár pre správu kolekcie poistených osôb.
 * Zodpovednosť: Ukladanie a vyhľadávanie poistených.
 */
public class PoistenciRepository {
    private List<Poisteny> poistenci;

    /**
     * Konštruktor inicializuje prázdny zoznam poistených.
     */
    public PoistenciRepository() {
        poistenci = new ArrayList<>();
    }

    /**
     * Pridá nového poisteného do zoznamu.
     *
     * @param poisteny Objekt poisteného, ktorý sa má pridať.
     */
    public void pridajPoisteneho(Poisteny poisteny) {
        if (poisteny != null) {
            poistenci.add(poisteny);
        }
    }

    /**
     * Vráti zoznam všetkých poistených osôb.
     *
     * @return Nemodifikovateľný zoznam poistených.
     */
    public List<Poisteny> getVsetciPoisteni() {
        // Vrátime kópiu alebo nemodifikovateľný zoznam, aby sa zabránilo externým modifikáciám
        return new ArrayList<>(poistenci); // Vrátiť kópiu je jednoduchšie pre tento prípad
    }

    /**
     * Vyhľadá poisteného podľa mena a priezviska.
     * Hľadanie je case-insensitive.
     *
     * @param meno       Meno na vyhľadanie.
     * @param priezvisko Priezvisko na vyhľadanie.
     * @return Nájdutý objekt Poisteny alebo null, ak sa nenájde.
     */
    public Poisteny vyhladajPoisteneho(String meno, String priezvisko) {
        if (meno == null || meno.trim().isEmpty() || priezvisko == null || priezvisko.trim().isEmpty()) {
            return null; // Nevyhľadávame s prázdnymi vstupmi
        }

        String hladaneMeno = meno.trim().toLowerCase();
        String hladanePriezvisko = priezvisko.trim().toLowerCase();

        for (Poisteny p : poistenci) {
            if (p.getMeno().toLowerCase().equals(hladaneMeno) &&
                p.getPriezvisko().toLowerCase().equals(hladanePriezvisko)) {
                return p;
            }
        }
        return null; // Nenájdené
    }
}
