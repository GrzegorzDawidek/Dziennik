package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class KlasaSzkolna {

    ListyUczniow listyUczniow;
    Przedmioty przedmioty;
    Oceny oceny;
    WczytywanieTekstu wczytywanieTekstu;
    Plec plec;

    public KlasaSzkolna() {
        listyUczniow = new ListyUczniow();
        przedmioty = new Przedmioty();
        oceny = new Oceny();
        wczytywanieTekstu = new WczytywanieTekstu();
        plec = new Plec();
    }

    public void czasStop() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        menu();
    }


    public void menu() {
        System.out.println("Menu");
        System.out.println("1.Wyświetl listę uczniów");
        System.out.println("2.Dodaj ucznia");
        System.out.println("3.Usuń ucznia");
        System.out.println("4.Wstaw Ocene");
        System.out.println("5.Oblicz średnią");
        System.out.println("6.Wyświetl oceny ucznia");
        System.out.println("7.Drukuj świadectwo");
        System.out.println("8.Zagrożenia");
        System.out.println("9.Wyjście");
        System.out.println("Inne.Pokaż Menu");
    }


    public void wyswietlanie() {
        int numer, numer1;
        ArrayList<String> lista;
        ArrayList<ArrayList<Double>> tablica;
        lista = listyUczniow.uczniowieKlasaSzkolna();
        menu();
        while (true) {
            System.out.println("\nWpisz numer: ");
            numer = wczytywanieTekstu.wczytajLiczby();

            switch (numer) {
                case 1:
                    listyUczniow.wyswietlUcznia(lista);
                    czasStop();
                    break;
                case 2:
                    lista.add(listyUczniow.dodajUcznia());
                    listyUczniow.wyswietlUcznia(lista);
                    czasStop();
                    break;
                case 3:
                    listyUczniow.wyswietlUcznia(lista);
                    lista.remove(listyUczniow.usunUcznia());
                    czasStop();
                    break;

                case 4:
                    listyUczniow.wyswietlUcznia(lista);
                    numer = listyUczniow.pobierzNumerUcznia();
                    przedmioty.wyswietlanieListyPrzedmiotow();
                    numer1 = przedmioty.wybranyPrzedmiot(numer);
//                    double n1= numer1;
                    tablica = oceny.zwracanaTablica(numer1);
                    oceny.dziennikOcen(tablica, numer);
                    czasStop();
                    break;

                case 5:
                    listyUczniow.wyswietlUcznia(lista);
                    numer = listyUczniow.pobierzNumerUcznia();
                    przedmioty.wyswietlanieListyPrzedmiotow();
                    numer1 = przedmioty.wybranyPrzedmiot(numer);
                    tablica = oceny.zwracanaTablica(numer1);
                    oceny.srednia(tablica, numer);
                    czasStop();
                    break;
                case 6:
                    listyUczniow.wyswietlUcznia(lista);
                    numer = listyUczniow.pobierzNumerUcznia();
                    oceny.wyswietl_Oceny(numer);
                    czasStop();
                    break;
                case 7:
                    listyUczniow.wyswietlUcznia(lista);
                    numer = listyUczniow.pobierzNumerUcznia();
                    oceny.drukujSwiadectwo(numer);
                    czasStop();
                    break;
                case 8:
                    listyUczniow.wyswietlUcznia(lista);
                    numer = listyUczniow.pobierzNumerUcznia();
                    oceny.zagrozenia(numer);
                    czasStop();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    menu();
                    break;
            }
        }
    }
}
