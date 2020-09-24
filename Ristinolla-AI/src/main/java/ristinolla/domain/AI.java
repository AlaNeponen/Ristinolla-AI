/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.domain;
/**
 * Luokka sisältää käyttäjää vastaan pelaavan tekoälyn. Metodeilla lasketaan paras mahdollinen siirto, jonka koordinaatit säilötään olion muuttujiin.
 * @author nate
 */
public class AI {
    int SiirronX;
    int SiirronY;

    /**
     * Luo AI-olion ja asettaa seuraavan siirron arvoksi taulun vasemman alanurkan (tätä arvoa ei kuitenkaan koskaan käytetä sellaisenaan ja on olemassa vain alustustarkoituksiin)
     */
    public AI() {
        this.SiirronX = 0;
        this.SiirronY = 0;
    }
    /**
     * Metodi käy läpi kaikki tällä hetkellä mahdolliset siirrot minimax-metodin avulla ja asettaa oliomuuttujien arvoiksi parhaan siirron x- ja y-koordinaatin.
     * @param lauta Pelilauta-olio jonka talukkoesityksessä on talessa tämän hetkinen pelitilanne.
     */
    public void seuraavaSiirto(Pelilauta lauta) {
        
        int parhaanX = -1;
        int parhaanY = -1;
        int parhaanArvo = -1000;
        
        for (int i = 0; i < lauta.getlaudanKoko(); i++) {
            for (int j = 0; j < lauta.getlaudanKoko(); j++) {
                if (lauta.getLauta()[i][j].equals("-")) {
                    lauta.asetaMerkki("O", i, j);
                    int siirronArvo = minimax(lauta, false, 0, i ,j, -5000, 5000);
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
    /**
     * Rekursiivinen metodi joka käy läpi mahdollisia siirtoja eri pelipuun tasoilla kunnes päätyy tilanteeseen jossa lauta on täynnä, tai jompikumpi pelaaja on voittanut.
     * Metodi karsii alfa- ja beta-arvojen avulla laskennasta sellaisia pelipuun oksia/lehtiä (eli siirtoja) joita ei ikinä valittaisi (olettaen että molemat pelaajat pelaavat "täydellisesti").
     * Metodi palauttaa arvon joka kertoo mihin tilanteeseen peli päättyy kyseisellä siirolla (olettaen että kaikki sitä mahdollisesti seuraavat siirrot molemmilta pelaajilta ovat "täydellisiä").
     * @param lauta Pelilauta-olio jonka mukana kulkevassa taulukkoesityksessä on säilöttynä sen hetkinen pelitilanne.
     * @param tietokoneenVuoro Totuusarvo kertoo onko seuraava siirto tekoälyn, vai käyttäjän tekemä.
     * @param syvyys Kertoo millä tasolla pelipuuta sillä hetkellä edetään (kuinka monta siirtoa ollaan edetty alkuperäisestä kutsusta). Tämän avulla voidaan muokata metodin palauttamia arvoja siten, että mitä nopeammin kyseinen siirto johtaa voittoon/häviöön, sitä suuremman/pienemmän arvon se saa.
     * @param x Kutsua edeltäneen siirron x-koordinaatti laudalla.
     * @param y Kutsua edeltäneen siirron y-koordinaatti laudalla.
     * @param alfa Suurin arvo (eli tekoälyn kannalta paras) jonka metodi voisi palauttaa siirron arvoksi. Alustetaan alkuperäiseen kutsuun hyvin pieneksi. 
     * @param beta Pienin arvo (eli käyttäjän kannalta paras) jonka metodi voisi palauttaa siirron arvoksi. Alustetaan alkuperäiseen kutsuun hyvin suureksi.
     * @return Arvo kertoo kuinka suotuisa kyseinen siirto (Huom! eli alkuperäistä kutsua EDELTÄVÄ siirto) on tekoälyn kannalta (mitä suurempi arvo, sitä nopeammin se johtaa voittoon ja mitä pienempi, sitä nopeammin se johtaa häviöön).
     */
    private int minimax(Pelilauta lauta, Boolean tietokoneenVuoro, int syvyys, int x, int y, int alfa, int beta) {
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
                        int arvo = minimax(lauta, !tietokoneenVuoro, syvyys++, i, j, alfa, beta);
                        if (arvo > maksimi) {
                            maksimi = arvo;
                        }
                        if (maksimi > alfa) {
                            alfa = maksimi;
                        }
                        lauta.asetaMerkki("-", i, j);
                    }
                    if (beta <= alfa) {
                        break;
                    }
                }
                if (beta <= alfa) {
                    break;
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
                        int arvo = minimax(lauta, !tietokoneenVuoro, syvyys++, l, m, alfa, beta);
                        if (arvo < minimi) {
                            minimi = arvo;
                        }
                        if (minimi < beta) {
                            beta = minimi;
                        }
                        lauta.asetaMerkki("-", l, m);
                    }
                    if (beta <= alfa) {
                        break;
                    }
                }
                if (beta <= alfa) {
                    break;
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
