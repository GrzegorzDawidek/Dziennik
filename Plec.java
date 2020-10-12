package com.company;

import java.util.ArrayList;

public class Plec {
    ListyUczniow listyUczniow;

    public Plec() {
        listyUczniow = new ListyUczniow();
    }

    public void sprawdzPlec(int numer) {
        String sprawdzPlecOsoby;
        ArrayList<String> listaUczniow;
        listaUczniow = listyUczniow.uczniowieKlasaSzkolna();
        sprawdzPlecOsoby = listaUczniow.get(numer);
        if (sprawdzPlecOsoby.endsWith("a") && !sprawdzPlecOsoby.equals("Kuba")) {
            System.out.println("\nWybrano uczennice:");
        } else {
            System.out.println("Wybrano ucznia:");
        }
    }
}
