/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.main;

import java.util.Scanner;
import ristinolla.ui.RistinollaUI;
/**
 *
 * @author nate
 */
public class Main {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        RistinollaUI ui = new RistinollaUI(lukija);    
        ui.käynnistä();
    }
    
}
