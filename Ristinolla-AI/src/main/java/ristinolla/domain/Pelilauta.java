/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.domain;

/**
 * Luokka luo tietorakenteen jota muokkaamalla ja tarkastelemalla voidaan simuloida ristinollaa virtuaalisella pelilaudalla.
 * Luokalla on paljon metodeja jotka liittyvät erilaisten pelitilanteiden tarkastelemiseen
 */
public class Pelilauta {
    String[][] lauta;
    int laudanKoko;
    
    /**
     * Luo halutun kokoisen pelilautaolion sekä alustaa sen tulostettavaan tilaan (kaikissa laudan "ruuduissa" on tyhjää ilmaiseva "-", merkki)
     * @param koko Käyttäjän syöttämä pelilaudan koko (x*x, jossa x on konstruktorin saama parametri)
     */
    public Pelilauta(int koko) {
        this.lauta = new String[koko][koko];
        this.laudanKoko = koko;
        
        for (int i = 0; i < this.laudanKoko; i++) {
            this.lauta[i] = new String[laudanKoko]; 
        }
        for (int i = 0; i < this.laudanKoko; i++) {
            for (int j = 0; j < this.laudanKoko; j++) {
                this.lauta[i][j] = "-";
            }
        }
    }
    /**
     * Tarkistaa onko kyseinen kohta laudalla tyhjä
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @return true jos oli tyhjä, muuten false.
     */
    public boolean onkoTyhja(int x, int y) {
        if (this.lauta[x][y].equals("-")) {
            return true;
        }
        return false;
    }
    /**
     * Asettaa haluttuun kohtaan pelilautaa saamansa merkin
     * @param merkki Siirron tehneen pelaajan pelimerkki (X tai O)
     * @param x Sijanti laudalla vaakasuunnassa (ulomman taulukon indeksi)
     * @param y Sijainti laudalla pystysuunnassa (sisemmän taulukon indeksi)
     */
    public void asetaMerkki(String merkki, int x, int y) {
        lauta[x][y] = merkki;
        
    }
    /**
     * Käy pelilaudan läpi siltä varalta että viimeisin siirto olisi aiheuttanut voiton kyseiselle pelaajalle.
     * Käy järjestyksessä kaikki mahdolliset voittavat rivit läpi (pysty, vaaka, sekä vasemmalta oikealle katsottuna nousevan ja laskevan vinorivin)
     * @param merkki Viimeisimmän siirron tehneen pelaajan pelimerkki
     * @param x Viimeisimmän siirron sijainti laudalla vaakasuunnassa (ulomman taulukon indeksi)
     * @param y Viimeisimmän siirron sijainti laudalla pystysuunnassa (sisemmän taulukon indeksi)
     * @return Palauttaa totuusarvon true jos viimeisin siirto johti voittoon, muussa tapauksessa palauttaa arvon false
     */
    public boolean tarkastaVoitto(String merkki, int x, int y) {
        boolean voittaja = true;
        
        for (int j = 0; j < this.laudanKoko; j++) {
            if (!this.lauta[x][j].equals(merkki)) {
                voittaja = false;
                break;
            }
        }
        
        if (voittaja == true) {
            return voittaja;
        }
        voittaja = true;
        
        for (int k = 0; k < this.laudanKoko; k++) {
            if (!this.lauta[k][y].equals(merkki)) {
                voittaja = false;
                break;
            }
        }
        
        if (voittaja == true) {
            return voittaja;
        }
        voittaja = true;
        
        for (int l = 0; l < this.getlaudanKoko(); l++) {
            if (!this.lauta[l][l].equals(merkki)) {
                voittaja = false;
                break;
            }
        }
        
        if (voittaja == true) {
            return voittaja;
        }
        voittaja = true;
        
        int nouseva = 0;
        for (int laskeva = this.laudanKoko - 1; laskeva >= 0; laskeva--) {
            if (!this.lauta[laskeva][nouseva].equals(merkki)) {
                voittaja = false;
                break;
            }
            nouseva++;
        }
        
        return voittaja;
    }
    /**
     * Tulostaa pelilaudan merkkeineen tekstiriville.
     */
    public void tulosta() {
        System.out.println("");
        for (int i = this.laudanKoko - 1; i >= 0; i--) {
            for (int j = 0; j < this.getlaudanKoko(); j++) {
                System.out.print(this.lauta[j][i]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    /**
     * Tarkastaa onko kaikissa taulukon alkioissa jo jokin pelimerkki, eli onko peli edennyt tasapeliin
     * @return Palauttaa true mikäli pelilauta on täynnä, muuten false
     */
    public boolean onkoTaynna() {
        for (int i = 0; i < this.laudanKoko; i++) {
            for (int j = 0; j < this.laudanKoko; j++) {
                if (this.lauta[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int getlaudanKoko() {
        return this.laudanKoko;
    }
    public String[][] getLauta() {
        return this.lauta;
    }
}
