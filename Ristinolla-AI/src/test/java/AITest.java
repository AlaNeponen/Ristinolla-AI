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
import ristinolla.domain.AI;
import ristinolla.domain.Pelilauta;

/**
 *
 * @author nate
 */
public class AITest {
    private Pelilauta lauta;
    private AI kone;
    public AITest() {
    }
    @Test
    public void tekoalyVoittaaTyhjallaLaudallaKolmellaSiirrolla() {
        for (int i = 0; i < lauta.getlaudanKoko(); i++) {
            kone.seuraavaSiirto(lauta);
            lauta.asetaMerkki("O", kone.getX(), kone.getY());
        }
        assertEquals(true, lauta.tarkastaVoitto("O", kone.getX(), kone.getY()));
    }
    @Test
    public void tekoalyEstaaVoittavanLiikkeen() {
        lauta.asetaMerkki("X", 0, 0);
        lauta.asetaMerkki("X", 0, 1);
        lauta.asetaMerkki("O", 1, 1);
        kone.setAvaus(false);
        kone.seuraavaSiirto(lauta);
        lauta.asetaMerkki("O", kone.getX(), kone.getY());
        assertEquals("O", lauta.getLauta()[0][2]);
    }
    @Test
    public void tekoalyTekeeVoittavanLiikkeen() {
        lauta.asetaMerkki("X", 1, 1);
        lauta.asetaMerkki("O", 1, 0);
        lauta.asetaMerkki("X", 1, 2);
        lauta.asetaMerkki("O", 0, 0);
        lauta.asetaMerkki("X", 0, 2);
        kone.setAvaus(false);
        kone.seuraavaSiirto(lauta);
        lauta.asetaMerkki("O", kone.getX(), kone.getY());
        assertEquals("O", lauta.getLauta()[2][0]);
    }
    @Test
    public void tekoalyAvaaKulmaanJosPelaajaEiAvaaKulmaan() {
        lauta.asetaMerkki("X", 1, 1);
        kone.seuraavaSiirto(lauta);
        lauta.asetaMerkki("O", kone.getX(), kone.getY());
        assertEquals("O", lauta.getLauta()[0][0]);
    }
    @Test
    public void tekoalyAvaaKeskelleJosPelaajaAvasiKulmaan() {
        lauta.asetaMerkki("X", 0, 0);
        kone.seuraavaSiirto(lauta);
        lauta.asetaMerkki("O", kone.getX(), kone.getY());
        assertEquals("O", lauta.getLauta()[1][1]);
    }
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.lauta = new Pelilauta(3);
        this.kone = new AI();
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
