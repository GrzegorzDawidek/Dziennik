package com.company;

import java.util.Scanner;

public class WczytywanieTekstu {
    public int wczytajLiczby() {
        return new Scanner(System.in).nextInt();
    }
    public double wczytajLiczby1() {
        return new Scanner(System.in).nextDouble();
    }
    public String wczytajLinie() {
        return new Scanner(System.in).nextLine();
    }
}
