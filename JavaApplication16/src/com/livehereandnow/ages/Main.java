package com.livehereandnow.ages;

import com.livehereandnow.ages.engine.Engine;
import com.livehereandnow.ages.exception.AgesException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, AgesException {
        Engine ge = new Engine();
        InputStreamReader cin = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(cin);
        while (true) {
            System.out.print("" + ge.get當前玩家().getName() + " >> ");
            ge.doCmd(in.readLine());
        }
    }
}
