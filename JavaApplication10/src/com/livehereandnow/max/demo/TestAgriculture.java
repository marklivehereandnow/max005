/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.max.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.livehereandnow.max.Agriculture;

/**
 *
 * @author chenp_000
 */
public class TestAgriculture {

    public static void main(String[] args) throws IOException {
        Agriculture[] 農業 = new Agriculture[4];
        農業[0] = new Agriculture(2, 0, true, true);
        農業[1] = new Agriculture(0, 0, false, false);
        農業[2] = new Agriculture(0, 0, false, false);
        農業[3] = new Agriculture(0, 0, false, false);
        System.out.println("農業0"+農業[0]);
        System.out.println("農業1"+農業[1]);
        System.out.println("農業2"+農業[2]);
        System.out.println("農業3"+農業[3]);
        農業[3].set打出(true);
    System.out.println("農業3"+農業[3]);
    }

}
