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
    private AI tekoaly;
    private Pelaaja kayttaja;
    private Pelaaja tietokone;
    
    public RistinollaUI(Scanner lukija) {
        this.lukija = lukija;
        this.tekoaly = new AI();
    }
    public void kaynnista() {
        System.out.println("Syötä pelaajan nimi");
        String nimi = lukija.nextLine();
        System.out.println("Syötä pelilaudan koko (3 tai 4)");
        int koko = 0;
        while (true) {
            koko = Integer.parseInt(lukija.nextLine());
            if (koko < 3 || koko > 4) {
                System.out.println("Psst, Syötä luku 3 tai 4!");
            }
            if (koko >= 3 && koko <= 4) {
                break;
            }
        }
        this.kayttaja = new Pelaaja(nimi, "X");
        this.tietokone = new Pelaaja("Tietokone", "O");
        this.lauta = new Pelilauta(koko);
        
        while (true) {
 
            this.lauta.tulosta();
            System.out.println("Syötä siirtosi muodossa: x,y");
            String siirto = this.lukija.nextLine();
            String[] osat = siirto.split(",");
            int x = Integer.parseInt(osat[0]) - 1;
            int y = Integer.parseInt(osat[1]) - 1;
           
            this.lauta.asetaMerkki(this.kayttaja.getMerkki(), x, y);
            if (this.lauta.tarkastaVoitto(this.kayttaja.getMerkki(), x, y)) {
                this.lauta.tulosta();
                System.out.println("Onnitleut " + this.kayttaja.getNimi() + ", voitit pelin!");
                break;
            }
            if (this.lauta.onkoTaynna()) {
                this.lauta.tulosta();
                System.out.println("Tasapeli!");
                break;
            }
            this.tekoaly.seuraavaSiirto(lauta);
            this.lauta.asetaMerkki(tietokone.getMerkki(), this.tekoaly.getX(), this.tekoaly.getY());
            if (this.lauta.tarkastaVoitto(this.tietokone.getMerkki(), this.tekoaly.getX(), this.tekoaly.getY())) {
                this.lauta.tulosta();
                System.out.println("Harmi, tietokone voitti tällä kertaa.");
                break;
            }
            if (this.lauta.onkoTaynna()) {
                this.lauta.tulosta();
                System.out.println("Tasapeli!");
                break;
            }
        }
        
    }
}
