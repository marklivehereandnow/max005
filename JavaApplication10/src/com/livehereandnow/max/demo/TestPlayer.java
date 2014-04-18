/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.max.demo;

import com.livehereandnow.max.Agriculture;
import com.livehereandnow.max.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author chenp_000
 */
public class TestPlayer {

    public static void main(String[] args) throws IOException {
        Player p1 = new Player();
        p1.get礦場(0);
        System.out.println(p1.get礦場(0));
        p1.get礦場(0).set黃點(999);
        System.out.println(p1.get礦場(0));
        for (int k = 0; k < 4; k++) {
            System.out.println("礦場" + k + " " + p1.get礦場(k));
        }
                //    private int 神廟;
//    private int 實驗室;
//    private int 戰士;
//    private int 騎兵;
//    private int 砲兵;
//    private int 飛機;
//    private int 競技場;
//    private int 劇院;
//    private int 圖書館;
        for (int k = 0; k < 4; k++) {
            System.out.println("農業" + k + " " + p1.get農業(k));
            System.out.println("神廟" + k + " " + p1.get神廟(k));
            System.out.println("砲兵" + k + " " + p1.get砲兵(k));
            System.out.println("競技場" + k + " " + p1.get競技場(k));
            System.out.println("圖書館" + k + " " + p1.get圖書館(k));
            System.out.println("劇院" + k + " " + p1.get劇院(k));
        }

    }

}
