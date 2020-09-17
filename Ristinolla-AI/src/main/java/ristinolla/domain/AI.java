/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.domain;
import java.util.Random;
/**
 *
 * @author nate
 */
public class AI {
    int SiirronX;
    int SiirronY;
    Random satunnainen;
    public AI() {
        this.SiirronX = 0;
        this.SiirronY = 0;
    }
    public void seuraavaSiirto(Pelilauta lauta) {
        
        int parhaanX = -1;
        int parhaanY = -1;
        int parhaanArvo = -1000;
        
        for (int i = 0; i < lauta.getlaudanKoko(); i++) {
            for (int j = 0; j < lauta.getlaudanKoko(); j++) {
                if (lauta.getLauta()[i][j].equals("-")) {
                    lauta.asetaMerkki("O", i, j);
                    int siirronArvo = minimax(lauta, false, 0, i ,j);
                    lauta.asetaMerkki("-", i, j);
                    if (siirronArvo > parhaanArvo) {
                        parhaanArvo = siirronArvo;
                        parhaanX = i;
                        parhaanY = j;
                    }
                }
                
            }
        } 
        this.SiirronX = parhaanX;
        this.SiirronY = parhaanY;
    }
    private int minimax(Pelilauta lauta, Boolean tietokoneenVuoro, int syvyys, int x, int y) {
        if (!tietokoneenVuoro && lauta.tarkastaVoitto("O", x, y)) {
            return 500 - syvyys;
        }
        if (tietokoneenVuoro && lauta.tarkastaVoitto("X", x, y)) {
            return -500 + syvyys;
        }
        if (lauta.onkoTäynnä()) {
            return 0;
        }
        if (tietokoneenVuoro) {
            int maksimi = -1000;
            for (int i = 0; i < lauta.getlaudanKoko(); i++) {
                for (int j = 0; j < lauta.getlaudanKoko(); j++) {
                    if (lauta.getLauta()[i][j].equals("-")) {
                        lauta.asetaMerkki("O", i, j);
                        int arvo = minimax(lauta, !tietokoneenVuoro, syvyys++, i, j);
                        if (arvo > maksimi) {
                            maksimi = arvo;
                        }
                        lauta.asetaMerkki("-", i, j);
                    }
                }
            }
            return maksimi;
        }
        else {
            int minimi = 1000;
            for (int l = 0; l < lauta.getlaudanKoko(); l++) {
                for (int m = 0; m < lauta.getlaudanKoko(); m++) {
                    if (lauta.getLauta()[l][m].equals("-")) {
                        lauta.asetaMerkki("X", l, m);
                        int arvo = minimax(lauta, !tietokoneenVuoro, syvyys++, l, m);
                        if (arvo < minimi) {
                            minimi = arvo;
                        }
                        lauta.asetaMerkki("-", l, m);
                    }
                }
            }
            return minimi;
        }
    }
    public int getX() {
        return this.SiirronX;
    }
    public int getY() {
        return this.SiirronY;
    }
}
