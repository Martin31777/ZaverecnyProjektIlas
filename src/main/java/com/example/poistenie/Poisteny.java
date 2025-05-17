// src/main/java/com/example/poistenie/Poisteny.java
package com.example.poistenie;

/**
 * Trieda reprezentujúca poistenú osobu.
 */
public class Poisteny {
    private String meno;
    private String priezvisko;
    private int vek;
    private String telefonneCislo;

    /**
     * Konštruktor pre vytvorenie novej poistenej osoby.
     *
     * @param meno           Meno poisteného.
     * @param priezvisko     Priezvisko poisteného.
     * @param vek            Vek poisteného.
     * @param telefonneCislo Telefónne číslo poisteného.
     */
    public Poisteny(String meno, String priezvisko, int vek, String telefonneCislo) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.vek = vek;
        this.telefonneCislo = telefonneCislo;
    }

    // Getters (optional but good practice)
    public String getMeno() {
        return meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public int getVek() {
        return vek;
    }

    public String getTelefonneCislo() {
        return telefonneCislo;
    }

    /**
     * Vracia reťazcovú reprezentáciu poistenej osoby.
     *
     * @return Formátovaný reťazec s detailmi poistenej osoby.
     */
    @Override
    public String toString() {
        return String.format("%-15s %-15s %-5d %s", meno, priezvisko, vek, telefonneCislo);
    }
}
