/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ristinolla.domain.Pelilauta;
import java.util.Random;

/**
 *
 * @author nate
 */
public class PelilautaTest {
    private Pelilauta lauta;
    public PelilautaTest() {
    }
    @Before
    public void setUp() {
        lauta = new Pelilauta(3);
    }
    @Test
    public void konstruktoriLuoHalutunKokoisenLaudan() {
        assertEquals(3, lauta.getlaudanKoko());
    
    }
    @Test
    public void konstruktoriAlustaaLaudanOikein() {
        String[][] pelilauta = lauta.getLauta();
        for (int i = 0; i < lauta.getlaudanKoko(); i++) {
            for (int j = 0; j < lauta.getlaudanKoko(); j++) {
                assertEquals("-", pelilauta[i][j]);
            }
        }
    }
    @Test 
    public void laudalleVoiAsettaaMerkin() {
        Random satunnainen = new Random();
        int x = satunnainen.nextInt(lauta.getlaudanKoko());
        int y = satunnainen.nextInt(lauta.getlaudanKoko());
        lauta.asetaMerkki("testi", x, y);
        String[][] pelilauta = lauta.getLauta();
        assertEquals("testi", pelilauta[x][y]);
    }
    @Test
    public void voittajaLoytyySivuttaissuunnassa() {
        for (int i = 0; i < lauta.getlaudanKoko(); i++) {
            lauta.asetaMerkki("X", i, 0);
        }
        Boolean totta = true;
        assertEquals(totta, lauta.tarkastaVoitto("X", lauta.getlaudanKoko() - 1, 0));
    }
    @Test
    public void voittajaLoytyyPystysuunnassa() {
        for (int i = 0; i < lauta.getlaudanKoko(); i++) {
            lauta.asetaMerkki("X", 0, i);
        }
        Boolean totta = true;
        assertEquals(totta, lauta.tarkastaVoitto("X", 0, lauta.getlaudanKoko() - 1));
    }
    @Test
    public void voittajaLoytyyVinosuunnastaNouseva() {
        for (int i = 0; i < lauta.getlaudanKoko(); i++) {
            lauta.asetaMerkki("X", i, i);
        }
        Boolean totta = true;
        assertEquals(totta, lauta.tarkastaVoitto("X", lauta.getlaudanKoko() - 1, lauta.getlaudanKoko() - 1));
    }
    @Test
    public void voittajaLoytyyVinosuunnastaLaskeva() {
        int nouseva = 0;
        for (int laskeva = lauta.getlaudanKoko() - 1; laskeva >= 0; laskeva--) {
            lauta.asetaMerkki("X", laskeva, nouseva);
            nouseva++;
        }
        Boolean totta = true;
        assertEquals(totta, lauta.tarkastaVoitto("X", 0, lauta.getlaudanKoko() - 1));
    }
    @Test
    public void onkoTaysiTunnistaaTaynnaOlevanLaudan() {
        for (int i = 0; i < lauta.getlaudanKoko(); i++) {
            for (int j = 0; j < lauta.getlaudanKoko(); j++) {
                lauta.asetaMerkki("täysi", i, j);
            } 
        }
        Boolean totta = true;
        assertEquals(totta, lauta.onkoTaynna());
    }
    @Test
    public void tarkistaVoittoPalauttaaFalseJosEiOleVoittajaa() {
        lauta.asetaMerkki("X", 0, 2);
        Boolean eiOle = false;
        assertEquals(eiOle, lauta.tarkastaVoitto("X", 0, 2));
    }
    @Test
    public void onkoTyhjaPalauttaaTrueJosTyhja() {
        lauta.asetaMerkki("X", 0, 0);
        assertEquals(true, lauta.onkoTyhja(0, 1));
    }
    @Test
    public void onkoTyhjaPalauttaaFalseJosTaynna() {
        lauta.asetaMerkki("X", 1, 2);
        assertEquals(false, lauta.onkoTyhja(1, 2));
    }
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
