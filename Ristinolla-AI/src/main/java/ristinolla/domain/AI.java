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
        this.satunnainen = new Random();
    }
    public void seuraavaSiirto() {
        this.SiirronX = this.satunnainen.nextInt(3);
        this.SiirronY = this.satunnainen.nextInt(3);
    }
    
    public int getX() {
        return this.SiirronX;
    }
    public int getY() {
        return this.SiirronY;
    }
}
