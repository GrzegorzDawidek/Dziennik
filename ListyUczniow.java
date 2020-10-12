package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class ListyUczniow {

    WczytywanieTekstu wczytywanieTekstu;

    public ListyUczniow() {
        wczytywanieTekstu = new WczytywanieTekstu();
    }

    public ArrayList<String> uczniowieKlasaSzkolna() {
        ArrayList<String> listaUczniow = new ArrayList<>();
        listaUczniow.add("\nLista uczniów:");
        listaUczniow.add("Macior Karol");
        listaUczniow.add("Damaga Lidia");
        listaUczniow.add("Żelazny Kacper");
        listaUczniow.add("Roślik Sebastian");
        listaUczniow.add("Waleczny Oliwier");
        listaUczniow.add("Chlebik Anna");
        listaUczniow.add("Siepsiak Agata");
        Collections.sort(listaUczniow);
        return listaUczniow;
    }

    public int pobierzNumerUcznia() {
        int numer;
        do {
            System.out.println("\nWybierz Ucznia: ");
            numer = wczytywanieTekstu.wczytajLiczby();
        } while (numer < 1 || numer > 31);
        return numer;
    }

    public void wyswietlUcznia(ArrayList<String> lista) {
        System.out.println(lista.get(0));
        for (int i = 1; i < lista.size(); i++) {
            System.out.println(i + "." + lista.get(i));
        }
    }


    public String dodajUcznia() {
        String nazwa;
        System.out.println("Wprowadz Imie Nazwisko: ");
        nazwa = wczytywanieTekstu.wczytajLinie();
        return nazwa;
    }

    public int usunUcznia() {
        int numer;
        System.out.println("Wprowadz numer ucznia do usunięcia: ");
        numer = wczytywanieTekstu.wczytajLiczby();
        return numer;
    }
}
