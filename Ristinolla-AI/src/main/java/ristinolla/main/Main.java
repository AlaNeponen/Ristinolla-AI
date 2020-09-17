/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.main;

import java.util.Scanner;
import ristinolla.domain.Pelaaja;
import ristinolla.domain.Pelilauta;
import ristinolla.domain.AI;
/**
 *
 * @author nate
 */
public class Main {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Syötä pelaajan nimi");
        String nimi = lukija.nextLine();
        System.out.println("Syötä pelilaudan leveys ja pituus (yksi numero)");
        int koko = 0;
        while (true) {
            koko = Integer.parseInt(lukija.nextLine());
            if(koko < 3 || koko > 9) {
                System.out.println("Syötä luku välliltä 3-9!");
            }
            if (koko >= 3 && koko <= 9) {
                break;
            }
        }
        
        Pelaaja käyttäjä = new Pelaaja(nimi, "X");
        Pelaaja tietokone = new Pelaaja("Tietokone", "O");
        Pelilauta lauta = new Pelilauta(koko);
        AI Tekoäly = new AI();
        
       while (true) {
 
           lauta.tulosta();
           System.out.println("Syötä siirtosi muodossa: x,y");
           String siirto = lukija.nextLine();
           String[] osat = siirto.split(",");
           int x = Integer.parseInt(osat[0])-1;
           int y = Integer.parseInt(osat[1])-1;
           
           lauta.asetaMerkki(käyttäjä.getMerkki(), x, y);
           if (lauta.tarkastaVoitto(käyttäjä.getMerkki(), x, y)) {
               lauta.tulosta();
               System.out.println("Onnitleut " + käyttäjä.getNimi() + ", voitit pelin!");
               break;
           }
           Tekoäly.seuraavaSiirto();
           while (true) {
               String[][] matriisi = lauta.getLauta();
               if (matriisi[Tekoäly.getX()][Tekoäly.getY()].equals("-")) {
                   break;
               }
               Tekoäly.seuraavaSiirto();
           }
           lauta.asetaMerkki(tietokone.getMerkki(), Tekoäly.getX(), Tekoäly.getY());
           if (lauta.tarkastaVoitto(tietokone.getMerkki(), Tekoäly.getX(), Tekoäly.getY())) {
               lauta.tulosta();
               System.out.println("Harmi, tietokone voitti tällä kertaa.");
               break;
           }
           if (lauta.onkoTäynnä()) {
               lauta.tulosta();
               System.out.println("Tasapeli!");
               break;
           }
       }
            
        
        
        
    }
    
}
