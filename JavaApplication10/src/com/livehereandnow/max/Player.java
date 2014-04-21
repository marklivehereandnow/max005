/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.max;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max
 */

public class Player {

//    //生產
//Agriculture[] 農業 = new Agriculture[4];
//    Agriculture[] 礦場 = new Agriculture[4];//礦業的需求與農業相同，
//    public class Procreati{
//        for(int k=0;k<4;k++){
//        
//    }
//           }

    public class Score{
        int 文化;
        int 科技;
        int 食物;
        int 資源;

        @Override
        public String toString() {
            return "Score{" + "\u6587\u5316=" + 文化 + ", \u79d1\u6280=" + 科技 + ", \u98df\u7269=" + 食物 + ", \u8cc7\u6e90=" + 資源 + '}';
        }
        
        public int get文化() {
            return 文化;
        }

        public void set文化(int 文化) {
            this.文化 = 文化;
        }

        public int get科技() {
            return 科技;
        }

        public void set科技(int 科技) {
            this.科技 = 科技;
        }

        public int get食物() {
            return 食物;
        }

        public void set食物(int 食物) {
            this.食物 = 食物;
        }

        public int get資源() {
            return 資源;
        }

        public void set資源(int 資源) {
            this.資源 = 資源;
        }
        
    }
    
//  A{文明,食物,资源,科技}={0,0,0,0}
    private int 文明;
    private Score 點數;

    public Score get點數() {
        return 點數;
    }
    
    private int 食物;//請列出食物點數的計算方式
    //當我們要計算花費食物的時候要呼叫食物的副程式
    //
    //[農業0的值]=農業0的藍點數*1
    //[農業1的值]=農業1的藍點數*2
    //[農業2的值]=農業2的藍點數*3
    //[農業3的值]=農業3的藍點數*5
    //加總起來 回傳
    //[食物]=[農業0的值]+[農業1的值]+[農業2的值]+[農業3的值]
    //[農業0的藍點數]獲得方式
    //1.回合結束時每個在農業的黃點會生產一個符合該等級的藍點
    //2.事件獲得
    //3.侵略、戰爭獲得
    //4.黃牌獲得
    private int 拿過的時代A領袖牌數;

    public int get拿過的時代A領袖牌數() {
        return 拿過的時代A領袖牌數;
    }

    public void set拿過的時代A領袖牌數(int 拿過的時代A領袖牌數) {
        this.拿過的時代A領袖牌數 = 拿過的時代A領袖牌數;
    }
    private int 資源;
    private int 科技;
//政府的影響
    private int 內政點數;//該玩家即時的內政點數
    private int 軍事點數;
//        System.out.println("    2, 在Player內設置當前領袖位置.戰術牌位置.待建奇蹟位置.建好的奇蹟.值民地位置,預計花0.5個小時完成,4/20日完成");
     
    //起始面板設置
//    private int 農業;//黃點數量
//    private int 農業0;
//    private int 農業1;
//    private int 農業2;
//    private int 農業3;
//  農業系列用於，記錄黃點數量，記錄藍點數量，記錄是否拿取科技，記錄是否已經打出這項科技。
//  希望有類似什麼樣的指令來操作
//  我希望有指令可以對農業黃點作存取，農業黃點必須是正整數或0，農業黃點需要是個陣列，要四個值
//　農業藍點同農業黃點
//    另外需要同樣陣列來標記農業科技是否拿取
//    同時需要類似陣列來標記農業科技是否打出
// === 需求分析 ===
//    農業我們需要有四個物件
//    每個物件要能記錄黃點、藍點、是否拿取、是否打出
//   public void get農業黃點[x](int 農業黃點) 
//   public void set農業黃點[x](int 農業黃點)
//   public void get農業藍點[x](int 農業藍點) 
//   public void set農業藍點[x](int 農業藍點) 
//   public void get拿取農業科技[x](boolean 拿取農業科技) 
//   public void set拿取農業科技[x](boolean 拿取農業科技)
//   public void get打出農業科技[x](boolean 打出農業科技) 
//   public void set打出農業科技[x](boolean 打出農業科技)
//    private int[] 農業=new int[4];//存放黃點數量
//    private boolean[] 打出農業科技=new boolean[4];//記錄科技是否已經啟用
////    private boolean[] 打出農業科技=new boolean[4];//記錄科技是否已經啟用
    
    //科技區
    Agriculture[] 農業 = new Agriculture[4];
    Agriculture[] 礦場 = new Agriculture[4];//礦業的需求與農業相同，
    Agriculture[] 神廟 = new Agriculture[4];
    Agriculture[] 實驗室 = new Agriculture[4];
    Agriculture[] 戰士 = new Agriculture[4];
    Agriculture[] 騎兵 = new Agriculture[4];
    Agriculture[] 砲兵 = new Agriculture[4];
    Agriculture[] 飛機 = new Agriculture[4];
    Agriculture[] 競技場 = new Agriculture[4];
    Agriculture[] 劇院 = new Agriculture[4];
    Agriculture[] 圖書館 = new Agriculture[4];

    public Agriculture[] get農業() {
        return 農業;
    }

    public void set農業(Agriculture[] 農業) {
        this.農業 = 農業;
    }

    public Agriculture[] get礦場() {
        return 礦場;
    }

    public void set礦場(Agriculture[] 礦場) {
        this.礦場 = 礦場;
    }

    public Agriculture[] get神廟() {
        return 神廟;
    }

    public void set神廟(Agriculture[] 神廟) {
        this.神廟 = 神廟;
    }

    public Agriculture[] get實驗室() {
        return 實驗室;
    }

    public void set實驗室(Agriculture[] 實驗室) {
        this.實驗室 = 實驗室;
    }

    public Agriculture[] get戰士() {
        return 戰士;
    }

    public void set戰士(Agriculture[] 戰士) {
        this.戰士 = 戰士;
    }

    public Agriculture[] get騎兵() {
        return 騎兵;
    }

    public void set騎兵(Agriculture[] 騎兵) {
        this.騎兵 = 騎兵;
    }

    public Agriculture[] get砲兵() {
        return 砲兵;
    }

    public void set砲兵(Agriculture[] 砲兵) {
        this.砲兵 = 砲兵;
    }

    public Agriculture[] get飛機() {
        return 飛機;
    }

    public void set飛機(Agriculture[] 飛機) {
        this.飛機 = 飛機;
    }

    public Agriculture[] get競技場() {
        return 競技場;
    }

    public void set競技場(Agriculture[] 競技場) {
        this.競技場 = 競技場;
    }

    public Agriculture[] get劇院() {
        return 劇院;
    }

    public void set劇院(Agriculture[] 劇院) {
        this.劇院 = 劇院;
    }

    public Agriculture[] get圖書館() {
        return 圖書館;
    }

    public void set圖書館(Agriculture[] 圖書館) {
        this.圖書館 = 圖書館;
    }

    public List<Card> get手上的牌() {
        return 手上的牌;
    }

    public void set手上的牌(List<Card> 手上的牌) {
        this.手上的牌 = 手上的牌;
    }

    public Agriculture get農業(int k) {
        return 農業[k];
    }

    public Agriculture get礦場(int k) {
        return 礦場[k];
    }

    public Agriculture get神廟(int k) {
        return 神廟[k];
    }

    public Agriculture get實驗室(int k) {
        return 實驗室[k];
    }

    public Agriculture get戰士(int k) {
        return 戰士[k];
    }

    public Agriculture get騎兵(int k) {
        return 騎兵[k];
    }

    public Agriculture get砲兵(int k) {
        return 砲兵[k];
    }

    public Agriculture get競技場(int k) {
        return 競技場[k];
    }

    public Agriculture get飛機(int k) {
        return 飛機[k];
    }

    public Agriculture get劇院(int k) {
        return 劇院[k];
    }

    public Agriculture get圖書館(int k) {
        return 圖書館[k];
    }

//    public void set農業(Agriculture[] 農業) {
//        this.農業 = 農業;
//    }
//    private int 神廟;
//    private int 實驗室;
//    private int 戰士;
//    private int 騎兵;
//    private int 砲兵;
//    private int 飛機;
//    private int 競技場;
//    private int 劇院;
//    private int 圖書館;

    private int 工人閒置區;
    private int 黃點工人供應區;
    private int 藍點資源供應區;

////      === TODO ===  
//    1, 在Player內設置I時代所有的科技牌位置
//    2, 在Player內設置當前領袖位置.戰術牌位置.待建奇蹟位置.建好的奇蹟.值民地位置
//    done, 目前第二個玩家有可能用兩個內政點數拿兩張時代A的領袖牌,應予以制止
    public int get內政點數() {
        return 內政點數;
    }

    public void set內政點數(int 內政點數) {
        this.內政點數 = 內政點數;
    }

    public int get軍事點數() {
        return 軍事點數;
    }

    public void set軍事點數(int 軍事點數) {
        this.軍事點數 = 軍事點數;
    }


    public int get工人閒置區() {
        return 工人閒置區;
    }

    public void set工人閒置區(int 工人閒置區) {
        this.工人閒置區 = 工人閒置區;
    }

    public int get黃點工人供應區() {
        return 黃點工人供應區;
    }

    public void set黃點工人供應區(int 黃點工人供應區) {
        this.黃點工人供應區 = 黃點工人供應區;
    }

    public int get藍點資源供應區() {
        return 藍點資源供應區;
    }

    public void set藍點資源供應區(int 藍點資源供應區) {
        this.藍點資源供應區 = 藍點資源供應區;
    }

    private List<Card> 手上的牌;

    public Player() {

        //    private int 神廟;
//    private int 實驗室;
//    private int 戰士;
//    private int 騎兵;
//    private int 砲兵;
//    private int 飛機;
//    private int 競技場;
//    private int 劇院;
//    private int 圖書館;
        點數=new Score();
        for(int k=0;k<4;k++){
            農業[k] = new Agriculture(0, 0, false, false);
            礦場[k] = new Agriculture(0, 0, false, false);
            神廟[k] = new Agriculture(0, 0, false, false);
            實驗室[k] = new Agriculture(0, 0, false, false);
            戰士[k] = new Agriculture(0, 0, false, false);
            騎兵[k] = new Agriculture(0, 0, false, false);
            砲兵[k] = new Agriculture(0, 0, false, false);
            飛機[k] = new Agriculture(0, 0, false, false);
            競技場[k] = new Agriculture(0, 0, false, false);
            劇院[k] = new Agriculture(0, 0, false, false);
            圖書館[k] = new Agriculture(0, 0, false, false);
            
        }
        農業[0] = new Agriculture(2, 0, true, true);
        礦場[0] = new Agriculture(2, 0, true, true);
        神廟[0] = new Agriculture(0, 0, true, true);
        實驗室[0] = new Agriculture(1, 0, true, true);
        戰士[0] = new Agriculture(1, 0, true, true);

        
        文明 = 0;
        食物 = 0;
        資源 = 0;
        科技 = 0;
        手上的牌 = new ArrayList<Card>();
    }

    public int get文明() {
        return 文明;
    }
//實例 物件 對象

    public void set文明(int 文明) {
        this.文明 = 文明;
    }

    public void set文明食物資源科技(int 文明, int 食物, int 資源, int 科技) {
        this.文明 = 文明;
        this.食物 = 食物;
        this.資源 = 資源;
        this.科技 = 科技;
    }

    public int get食物() {
        return 食物;
    }

    public void set食物(int 食物) {
        this.食物 = 食物;
    }

    public int get資源() {
        return 資源;
    }

    public void set資源(int 資源) {
        this.資源 = 資源;
    }

    public int get科技() {
        return 科技;
    }

    public void set科技(int 科技) {
        this.科技 = 科技;
    }

    public void do拿取(int 內政點數, Card 內政牌) {
        手上的牌.add(內政牌);
    }

    public void show手上的牌() {

        for (int k = 0; k < 手上的牌.size(); k++) {
            System.out.println(" " + 手上的牌.get(k));
        }
    }

    public void show() {
        System.out.print(" 手上的牌 ");
        show手上的牌();
        System.out.print("  礦場=" + 礦場);
        System.out.print("  神廟=" + 神廟);
        System.out.print("  實驗室=" + 實驗室);
        System.out.print("  戰士=" + 戰士);
        System.out.print("  工人閒置區=" + 工人閒置區);
        System.out.println("  " + toString());

    }

    @Override
    public String toString() {
        return "現有資源{" + "\u6587\u660e=" + 文明 + ", \u98df\u7269=" + 食物 + ", \u8cc7\u6e90=" + 資源 + ", \u79d1\u6280=" + 科技 + '}';
    }

}
