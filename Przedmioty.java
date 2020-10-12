package com.company;

import java.util.ArrayList;

public class Przedmioty {

    WczytywanieTekstu wczytywanieTekstu;
    ListyUczniow listyUczniow;
    Plec plec;
    Oceny oceny;

    public Przedmioty() {
        wczytywanieTekstu = new WczytywanieTekstu();
        listyUczniow = new ListyUczniow();
        plec = new Plec();
        oceny = new Oceny();
    }

    public ArrayList<String> listaPrzedmioty() {
        ArrayList<String> listaPrzedmiotow = new ArrayList<>();
        listaPrzedmiotow.add("");
        listaPrzedmiotow.add("Matematyka");
        listaPrzedmiotow.add("Język Polski");
        listaPrzedmiotow.add("Język Angielski");
        listaPrzedmiotow.add("Biologia");
        listaPrzedmiotow.add("Geografia");
        listaPrzedmiotow.add("Informatyka");

        return listaPrzedmiotow;
    }

    public void wyswietlanieListyPrzedmiotow() {

        ArrayList<String> listaPrzedmiotow;
        listaPrzedmiotow = listaPrzedmioty();
        for (int i = 1; i < listaPrzedmiotow.size(); i++) {
            System.out.println(i + "." + listaPrzedmiotow.get(i));
        }

    }


    public int wybranyPrzedmiot(int numerUcznia) {
        int numer;
        ArrayList<String> listaPrzedmiotow;
        listaPrzedmiotow = listaPrzedmioty();
        do {
            System.out.println("\nWybierz Przedmiot: ");
            numer = wczytywanieTekstu.wczytajLiczby();
        } while (numer < 1 || numer > 6);
        plec.sprawdzPlec(numerUcznia);
        System.out.println(numerUcznia + "." + listyUczniow.uczniowieKlasaSzkolna().get(numerUcznia));
        System.out.println("Wybrany przedmiot: " + listaPrzedmiotow.get(numer));
        return numer;
    }

}
