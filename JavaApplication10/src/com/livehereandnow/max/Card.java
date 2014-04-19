/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.max;

/**
 *
 * @author max
 */
public class Card implements CardType {

    public Card(int ID, String 卡名, int 時代, int 牌背, int 類型, int 顏色, String 右上, String 內容,String 建造成本) {

        this.右上 = 右上;
        this.內容 = 內容;
        this.顏色 = 顏色;
        this.ID = ID;
        this.牌背 = 牌背;
        this.卡名 = 卡名;
        this.時代 = 時代;
        this.類型 = 類型;
        this.建造成本=建造成本;
    }

    String 右上;
    int 編號;
    int 加權值;
    String 內容;
    int 顏色;
    int ID;
    int 牌背;
    int 時代;
        String 卡名;
        String 建造成本;
    int 類型;//0=領袖,1=奇蹟.2=黃牌

    public int get加權值() {
        return 加權值;
    }

    public void set加權值(int 加權值) {
        this.加權值 = 加權值;
    }

    public Card(int 編號, String 卡名, int 時代, int 類型) {
        this.編號 = 編號;
        this.卡名 = 卡名;
        this.時代 = 時代;
        this.類型 = 類型;
    }

    public Card(int 編號, String 卡名, int 時代, int 類型, int 加權值) {
        this.編號 = 編號;
        this.卡名 = 卡名;
        this.時代 = 時代;
        this.類型 = 類型;
        this.加權值 = 加權值;
    }

    public Card() {
    }

    public int get編號() {
        return 編號;
    }

    public void set編號(int 編號) {
        this.編號 = 編號;
    }

    public String get卡名() {
        return 卡名;
    }

    public void set卡名(String 卡名) {
        this.卡名 = 卡名;
    }

    public int get時代() {
        return 時代;
    }
    
    

    public void set時代(int 時代) {
        this.時代 = 時代;
    }

    public int get類型() {
        return 類型;
    }

    // ver 0.7, by Mark, 2014-4-16
    public String get類型Name() {
        return CardType.CARD_TYPE_NAME[類型];
    }

    // ver 0.7, by Mark, 2014-4-16
    public String get卡名and類型Name() {
        return "[" + 卡名 + "-" + CardType.CARD_TYPE_NAME[類型] + "] ";
    }
//    待理解，時代為什麼可以這麼明確　2014-4-19 MAX
        public String get時代名() {
            String[] 時代名 = {"時代A", "時代I", "時代II", "時代III"};
        return 時代名[時代];
    }
        public String get牌背名() {
            String[] 牌背名 = {"內政", "軍事"};
        return 牌背名[牌背];
    }

    public void set類型(int 類型) {
        this.類型 = 類型;
    }

    //String 卡名;


    @Override
    public String toString() {
        return 卡名 + "(" + 加權值 + ")";
    }

        public String toString(int k) {
        return "[" + get時代名()+get牌背名() + "-" +get卡名() + "-" + get類型Name() + "] ";
    }

//        System.out.print(k + "[" + cardRow.get(k).get時代名()+cardRow.get(k).get牌背名() + "-" + cardRow.get(k).get卡名() + "-" + cardRow.get(k).get類型Name() + "] ");

}
