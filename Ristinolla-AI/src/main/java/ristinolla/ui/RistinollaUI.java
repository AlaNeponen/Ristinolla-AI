/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.ui;

import java.util.Scanner;
import ristinolla.domain.AI;
import ristinolla.domain.Pelaaja;
import ristinolla.domain.Pelilauta;

/**
 *
 * @author nate
 */
public class RistinollaUI {
    private Scanner lukija;
    private Pelilauta lauta;
    private AI tekoäly;
    private Pelaaja käyttäjä;
    private Pelaaja tietokone;
    
    public RistinollaUI(Scanner lukija) {
        this.lukija = lukija;
        this.tekoäly = new AI();
    }
    public void käynnistä() {
        System.out.println("Syötä pelaajan nimi");
        String nimi = lukija.nextLine();
        System.out.println("Syötä pelilaudan koko (3 tai 4)");
        int koko = 0;
        while (true) {
            koko = Integer.parseInt(lukija.nextLine());
            if(koko < 3 || koko > 4) {
                System.out.println("Psst, Syötä luku 3 tai 4!");
            }
            if (koko >= 3 && koko <= 4) {
                break;
            }
        }
        this.käyttäjä = new Pelaaja(nimi, "X");
        this.tietokone = new Pelaaja("Tietokone", "O");
        this.lauta = new Pelilauta(koko);
        
        while (true) {
 
           this.lauta.tulosta();
           System.out.println("Syötä siirtosi muodossa: x,y");
           String siirto = this.lukija.nextLine();
           String[] osat = siirto.split(",");
           int x = Integer.parseInt(osat[0])-1;
           int y = Integer.parseInt(osat[1])-1;
           
           this.lauta.asetaMerkki(this.käyttäjä.getMerkki(), x, y);
           if (this.lauta.tarkastaVoitto(this.käyttäjä.getMerkki(), x, y)) {
               this.lauta.tulosta();
               System.out.println("Onnitleut " + this.käyttäjä.getNimi() + ", voitit pelin!");
               break;
           }
           if (this.lauta.onkoTäynnä()) {
               this.lauta.tulosta();
               System.out.println("Tasapeli!");
               break;
           }
           this.tekoäly.seuraavaSiirto(lauta);
           this.lauta.asetaMerkki(tietokone.getMerkki(), this.tekoäly.getX(), this.tekoäly.getY());
           if (this.lauta.tarkastaVoitto(this.tietokone.getMerkki(), this.tekoäly.getX(), this.tekoäly.getY())) {
               this.lauta.tulosta();
               System.out.println("Harmi, tietokone voitti tällä kertaa.");
               break;
           }
           if (this.lauta.onkoTäynnä()) {
               this.lauta.tulosta();
               System.out.println("Tasapeli!");
               break;
           }
       }
        
    }
}
