/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.domain;

/**
 * Luokkalla voidaan luoda tietyn niminen pelaaja jolla on oma pelimerkki.
 * Luokan avulla tietty pelaaja voidaan yhdistää tiettyyn pelimerkkiin
 */
public class Pelaaja {
    String nimi;
    String merkki;
    
    /**
     * Luo halutun nimisen pelaajaolion jokä käyttää haluttua pelimerkkiä
     * @param nimi pelaajan nimi (esim. käyttäjän syöttämä nimi)
     * @param merkki pelaajan käyttämä pelimerkki (tässä sovelluksessa X tai O)
     */
    public Pelaaja(String nimi, String merkki) {
        this.nimi = nimi;
        this.merkki = merkki;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    public String getMerkki() {
        return this.merkki;
    }
}
