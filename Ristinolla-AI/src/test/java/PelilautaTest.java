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
    public void voittajaLöytyySivuttaissuunnassa() {
        for (int i = 0; i < lauta.getlaudanKoko(); i++){
            lauta.asetaMerkki("X", i, 0);
        }
        Boolean totta = true;
        assertEquals(totta, lauta.tarkastaVoitto("X", lauta.getlaudanKoko()-1, 0));
    }
    @Test
    public void voittajaLöytyyPystysuunnassa() {
        for (int i = 0; i < lauta.getlaudanKoko(); i++) {
            lauta.asetaMerkki("X", 0, i);
        }
        Boolean totta = true;
        assertEquals(totta, lauta.tarkastaVoitto("X", 0, lauta.getlaudanKoko()-1));
    }
    @Test
    public void voittajaLöytyyVinosuunnastaNouseva() {
        for (int i = 0; i < lauta.getlaudanKoko(); i++) {
            lauta.asetaMerkki("X", i, i);
        }
        Boolean totta = true;
        assertEquals(totta, lauta.tarkastaVoitto("X", lauta.getlaudanKoko()-1, lauta.getlaudanKoko()-1));
    }
    @Test
    public void voittajaLöytyyVinosuunnastaLaskeva() {
        int laskeva = lauta.getlaudanKoko()-1;
        for (int i = 0; i < lauta.getlaudanKoko(); i++) {
            lauta.asetaMerkki("X", laskeva, i);
            if (laskeva < 0) {
                laskeva--;
            }
        }
        Boolean totta = true;
        assertEquals(totta, lauta.tarkastaVoitto("X", laskeva, lauta.getlaudanKoko()-1));
    }
    @Test
    public void onkoTäysiTunnistaaTäynnäOlevanLaudan() {
        for (int i = 0; i < lauta.getlaudanKoko(); i++) {
            for (int j = 0; j < lauta.getlaudanKoko(); j++) {
                lauta.asetaMerkki("täysi", i, j);
            }
        }
        Boolean totta = true;
        assertEquals(totta, lauta.onkoTäynnä());
    }
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lauta = new Pelilauta(3);
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
