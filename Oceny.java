package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Oceny {

    WczytywanieTekstu wczytywanieTekstu;
    ListyUczniow listyUczniow;

    ArrayList<ArrayList<Double>> przedmiotMatematyka = tablica();
    ArrayList<ArrayList<Double>> przedmiotJezykPolski = tablica();
    ArrayList<ArrayList<Double>> przedmiotJezykAngielski = tablica();
    ArrayList<ArrayList<Double>> przedmiotBiologia = tablica();
    ArrayList<ArrayList<Double>> przedmiotGeografia = tablica();
    ArrayList<ArrayList<Double>> przedmiotInformatyka = tablica();

    public Oceny() {
        wczytywanieTekstu = new WczytywanieTekstu();
        listyUczniow = new ListyUczniow();
    }

    public ArrayList<ArrayList<Double>> tablica() {
        int dane = 31;
        ArrayList<ArrayList<Double>> tablica = new ArrayList<>(dane);

        for (int i = 0; i < dane; i++) {
            tablica.add(new ArrayList());
        }

        return tablica;
    }

    public ArrayList<ArrayList<Double>> zwracanaTablica(int numer) {
        if (numer == 1) {
            return przedmiotMatematyka;
        } else if (numer == 2) {
            return przedmiotJezykPolski;
        } else if (numer == 3) {
            return przedmiotJezykAngielski;
        } else if (numer == 4) {
            return przedmiotBiologia;
        } else if (numer == 5) {
            return przedmiotGeografia;
        } else {
            return przedmiotInformatyka;
        }
    }

    public void dziennikOcen(ArrayList<ArrayList<Double>> tablica, double numerZDziennika) {
        double liczba;

        do {
            System.out.println("Podaj ocene: ");
            liczba = wczytywanieTekstu.wczytajLiczby1();
        } while (liczba < 1.0 || liczba > 6.0);
        tablica.get((int) numerZDziennika).add(liczba);
        System.out.println("Oceny: ");
        int licznik1 = tablica.get((int) numerZDziennika).size();
        for (int j = 0; j < licznik1; j++) {
            Double wywolanie = tablica.get((int) numerZDziennika).get(j);
            System.out.print(wywolanie + " ");
        }

    }

    public void srednia(ArrayList<ArrayList<Double>> tablica, int numerZDziennika) {
        int wielkosc = tablica.get(numerZDziennika).size();
        double srednia = 0;
        int licznik = 0;
        for (int i = 0; i < wielkosc; i++) {
            Double krawedz = tablica.get(numerZDziennika).get(i);
            srednia = srednia + krawedz;
            licznik++;
        }
        System.out.println("Średnia: " + srednia / licznik);
    }

    public void zagrozenia(int numerZDziennika) {
        double matematyka = ocenaMatematykaSwiadectwo(numerZDziennika);
        double jezykPolski = ocenaJezykPolskiSwiadectwo(numerZDziennika);
        double jezykAngielski = ocenaJezykAngielskiSwiadectwo(numerZDziennika);
        double biologia = ocenaBiologiaSwiadectwo(numerZDziennika);
        double geografia = ocenaGeografiaSwiadectwo(numerZDziennika);
        double informatyka = ocenaInformatykaSwiadectwo(numerZDziennika);
        if (matematyka < 2) {
            System.out.println("Zagrożenie z matematyki: " + matematyka);
        }
        if (jezykPolski < 2) {
            System.out.println("Zagrożenie z języka polskiego " + jezykPolski);
        }
        if (jezykAngielski < 2) {
            System.out.println("Zagrożenie z języka angielskiego " + jezykAngielski);
        }
        if (biologia < 2) {
            System.out.println("Zagrożenie z biologii: " + biologia);
        }
        if (geografia < 2) {
            System.out.println("Zagrożenie z geografii: " + geografia);
        }
        if (informatyka < 2) {
            System.out.println("Zagrożenie z informatyki: " + informatyka);
        }else System.out.println("Brak zagrożeń");


    }

    public double ocenaMatematykaSwiadectwo(int numerZDziennika) {
        double sredniaMatematyka = 0;
        int licznikMatematyka = 0;
        double ocenaKoncowaMatematyka;
        for (double ocena : przedmiotMatematyka.get(numerZDziennika)
        ) {
            sredniaMatematyka = sredniaMatematyka + ocena;
            licznikMatematyka++;
        }
        ocenaKoncowaMatematyka = sredniaMatematyka / licznikMatematyka;
        return ocenaKoncowaMatematyka;
    }

    public double ocenaJezykPolskiSwiadectwo(int numerZDziennika) {
        double sredniaJezykPolski = 0;
        int licznikJezykPolski = 0;
        double ocenaJezykPolski;
        for (double ocena : przedmiotJezykPolski.get(numerZDziennika)
        ) {
            sredniaJezykPolski = sredniaJezykPolski + ocena;
            licznikJezykPolski++;
        }
        ocenaJezykPolski = sredniaJezykPolski / licznikJezykPolski;
        return ocenaJezykPolski;
    }

    public double ocenaJezykAngielskiSwiadectwo(int numerZDziennika) {
        double sredniaJezykAngielski = 0;
        int licznikJezykAngielski = 0;
        double ocenaJezykAngielski;
        for (double ocena : przedmiotJezykAngielski.get(numerZDziennika)
        ) {
            sredniaJezykAngielski = sredniaJezykAngielski + ocena;
            licznikJezykAngielski++;
        }
        ocenaJezykAngielski = sredniaJezykAngielski / licznikJezykAngielski;
        return ocenaJezykAngielski;
    }

    public double ocenaBiologiaSwiadectwo(int numerZDziennika) {
        double sredniaBiologia = 0;
        int licznikBiologia = 0;
        double ocenaBiologia;
        for (double ocena : przedmiotBiologia.get(numerZDziennika)
        ) {
            sredniaBiologia = sredniaBiologia + ocena;
            licznikBiologia++;
        }
        ocenaBiologia = sredniaBiologia / licznikBiologia;
        return ocenaBiologia;
    }

    public double ocenaGeografiaSwiadectwo(int numerZDziennika) {
        double sredniaGeografia = 0;
        int licznikGeografia = 0;
        double ocenaGeografia;
        for (double ocena : przedmiotGeografia.get(numerZDziennika)
        ) {
            sredniaGeografia = sredniaGeografia + ocena;
            licznikGeografia++;
        }
        ocenaGeografia = sredniaGeografia / licznikGeografia;
        return ocenaGeografia;
    }

    public double ocenaInformatykaSwiadectwo(int numerZDziennika) {
        double sredniaInformatyka = 0;
        int licznikInformatyka = 0;
        double ocenaInformatyka;
        for (double ocena : przedmiotInformatyka.get(numerZDziennika)
        ) {
            sredniaInformatyka = sredniaInformatyka + ocena;
            licznikInformatyka++;
        }
        ocenaInformatyka = sredniaInformatyka / licznikInformatyka;
        return ocenaInformatyka;
    }

    public void drukujSwiadectwo(int numerZDziennika) {
        System.out.println(numerZDziennika + "." + listyUczniow.uczniowieKlasaSzkolna().get(numerZDziennika));
        double ocenaMatematyka, ocenaJezykPolski, ocenaJezykAngielski, ocenaBiologia, ocenaGeografia, ocenaInformatyka;

        ocenaMatematyka = ocenaMatematykaSwiadectwo(numerZDziennika);
        ocenaJezykPolski = ocenaJezykPolskiSwiadectwo(numerZDziennika);
        ocenaJezykAngielski = ocenaJezykAngielskiSwiadectwo(numerZDziennika);
        ocenaBiologia = ocenaBiologiaSwiadectwo(numerZDziennika);
        ocenaGeografia = ocenaGeografiaSwiadectwo(numerZDziennika);
        ocenaInformatyka = ocenaInformatykaSwiadectwo(numerZDziennika);

        ocenaMatematyka = Math.round(ocenaMatematyka);
        ocenaJezykPolski = Math.round(ocenaJezykPolski);
        ocenaJezykAngielski = Math.round(ocenaJezykAngielski);
        ocenaBiologia = Math.round(ocenaBiologia);
        ocenaGeografia = Math.round(ocenaGeografia);
        ocenaInformatyka = Math.round(ocenaInformatyka);

        System.out.println("Matematyka: " + ocenaMatematyka);
        System.out.println("Jezyk Polski: " + ocenaJezykPolski);
        System.out.println("Jezyk Angielski: " + ocenaJezykAngielski);
        System.out.println("Biologia: " + ocenaBiologia);
        System.out.println("Geografia: " + ocenaGeografia);
        System.out.println("Informatyka: " + ocenaInformatyka);

    }


    public void ocenyMatematyka(int numerZDziennika) {
        StringBuilder ocenyMatematyka = new StringBuilder();
        String napisMatematyka = "Matematyka: ";
        ocenyMatematyka.append(napisMatematyka);
        for (double ocena : przedmiotMatematyka.get(numerZDziennika)) {
            System.out.println(ocena);
            ocenyMatematyka.append(ocena)
                    .append(" ");
        }
        System.out.println(ocenyMatematyka.toString());
    }

    public void ocenyJezykAngielski(int numerZDziennika) {
        StringBuilder ocenyJezykAngielski = new StringBuilder();
        String napisJezykAngielski = "Język Angielski: ";
        ocenyJezykAngielski.append(napisJezykAngielski);
        for (double ocena : przedmiotJezykAngielski.get(numerZDziennika)) {
            ocenyJezykAngielski.append(ocena)
                    .append(" ");
        }
        System.out.println(ocenyJezykAngielski.toString());
    }

    public void ocenyBiologia(int numerZDziennika) {
        StringBuilder ocenyBiologia = new StringBuilder();
        String napisBiologia = "Biologia: ";
        ocenyBiologia.append(napisBiologia);
        for (double ocena : przedmiotBiologia.get(numerZDziennika)) {
            ocenyBiologia.append(ocena)
                    .append(" ");
        }
        System.out.println(ocenyBiologia.toString());
    }

    public void ocenyGeografia(int numerZDziennika) {
        StringBuilder ocenyGeografia = new StringBuilder();
        String napisGeografia = "Geografia: ";
        ocenyGeografia.append(napisGeografia);
        for (double ocena : przedmiotGeografia.get(numerZDziennika)) {
            ocenyGeografia.append(ocena)
                    .append(" ");
        }
        System.out.println(ocenyGeografia.toString());
    }

    public void ocenyJezykPolski(int numerZDziennika) {
        StringBuilder ocenyJezykPolski = new StringBuilder();
        String napisJezykPolski = "Język Polski: ";
        ocenyJezykPolski.append(napisJezykPolski);
        for (double ocena : przedmiotJezykPolski.get(numerZDziennika)) {
            ocenyJezykPolski.append(ocena)
                    .append(" ");
        }
        System.out.println(ocenyJezykPolski.toString());
    }

    public void ocenyInformatyka(int numerZDziennika) {
        StringBuilder ocenyInformatyka = new StringBuilder();
        String napisInformatyka = "Informatyka: ";
        ocenyInformatyka.append(napisInformatyka);
        for (double ocena : przedmiotInformatyka.get(numerZDziennika)) {
            ocenyInformatyka.append(ocena)
                    .append(" ");
        }
        System.out.println(ocenyInformatyka.toString());
    }

    public void wyswietl_Oceny(int numerZDziennika) {
        ocenyMatematyka(numerZDziennika);
        ocenyJezykPolski(numerZDziennika);
        ocenyJezykAngielski(numerZDziennika);
        ocenyBiologia(numerZDziennika);
        ocenyGeografia(numerZDziennika);
        ocenyInformatyka(numerZDziennika);
    }
}
