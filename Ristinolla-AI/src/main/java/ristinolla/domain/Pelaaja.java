/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.domain;

/**
 *
 * @author nate
 */
public class Pelaaja {
    String nimi;
    String merkki;
    
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
