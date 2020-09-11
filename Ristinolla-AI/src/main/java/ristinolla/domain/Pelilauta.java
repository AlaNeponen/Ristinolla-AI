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
public class Pelilauta {
    String[][] lauta;
    int laudanKoko;
    
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
    
    public void asetaMerkki(String merkki, int x, int y) {
        lauta[x][y] = merkki;
        
    }
    
    public Boolean tarkastaVoitto(String merkki, int x, int y) {
        Boolean voittaja = true;
        
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
        for (int laskeva = this.laudanKoko -1; laskeva >= 0; laskeva--) {
            if (!this.lauta[laskeva][nouseva].equals(merkki)) {
                voittaja = false;
                break;
            }
            nouseva++;
        }
        
        return voittaja;
    }
    public void tulosta() {
        System.out.println("");
        for (int i = this.laudanKoko -1; i >= 0 ; i--) {
            for (int j = 0; j < this.getlaudanKoko(); j++) {
                System.out.print(this.lauta[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public Boolean onkoTäynnä() {
        for (int i = 0; i < this.laudanKoko; i++) {
            for (int j = 0; j < this.laudanKoko; j++) {
                if (this.lauta[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public Integer getlaudanKoko() {
        return this.laudanKoko;
    }
    public String[][] getLauta() {
        return this.lauta;
    }
}
