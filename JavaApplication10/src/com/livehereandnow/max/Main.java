/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.max;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author max
 */
public class Main implements CardType {
//時代A共有20張牌遊戲開始時 隨機選出13張牌
    //public Card(int 編號, String 卡名, int 時代, int 類型
    // Card[] showcards=new Card[13];

//    Card card0 = new Card();
//
//    Card card1 = new Card();
//    Card card2 = new Card();
//    Card card3 = new Card(3, "亞里士多得", 0, CardType.領袖);
//    Card card18 = new Card(18, "建築工地", 0, CardType.黃牌);
//    Card card21 = new Card(21, "摩西", 0, CardType.領袖);
//    Card card27 = new Card(27, "空中花園", 0, CardType.奇蹟);
//    Card card28 = new Card(28, "藝術作品", 0, CardType.黃牌);
//
//    Card show0 = card3;
//    Card show1 = card27;
//    Card show2 = card28;
//     class CardTest {
//   private int abc=0; 
//           
//}
//    CardTest firsttest[]=new CardTest[10];
////    for(int i=0;i<10;i++){
//    firsttest[i]=new CardTest();
////}
////  System.out.println(firsttest.abc);  
//    
//    List<CardTest> 測試=new ArrayList<CardTest>();
//     for(int i=0;i<10;i++){
//    測試.add(null)
//}
//    檯面13張.add(時代A內政牌.get(0));
    List<Card> 檯面13張 = new ArrayList<Card>();
    List<Card> 時代內政牌 = new ArrayList<Card>();
    //大概150張.包含4個時代.我們先以2人遊戲為基礎框架，訂定出全部內政牌
    //時代A約20張
    //時代I約40張
    //時代II約50張1
    //時代III約40張
    //洗牌時各時代分開洗
    //有些牌會出現2次 如何處理? 
    //理想的編號為何?.如何辨別想要的某張牌
    //有些牌會因為遊戲人數而抽取掉
    //

    List<Card> 洗過的全部內政牌 = new ArrayList<Card>();//大概150張.有些牌會出現2次 如何處理?
    List<Card> 時代A內政牌 = new ArrayList<Card>();
    List<Card> 時代I內政牌 = new ArrayList<Card>();
    List<Card> 時代II內政牌 = new ArrayList<Card>();
    List<Card> 時代III內政牌 = new ArrayList<Card>();
    List<Card> 洗過的時代A內政牌 = new ArrayList<Card>();
    List<Card> 洗過的時代I內政牌 = new ArrayList<Card>();
    List<Card> 洗過的時代II內政牌 = new ArrayList<Card>();
    List<Card> 洗過的時代III內政牌 = new ArrayList<Card>();

//對目前結構不爽
//1.每張牌都要手工設定2次很麻煩，希望可以批量從資料庫匯入資訊
//2.Card3.Card27.Card28以後要調用時很不方便，如何改程陣列的方式?
//3.初值設定時.時代勉強可以使用0.1.2.3表達，但是類型用0.1.2.3表達時有閱讀上的困難，基於目前的不同類型共有
    Card card4 = new Card();
    Card card5 = new Card();
    Card card6 = new Card();
    Card card7 = new Card();
    Card card8 = new Card();
    Card card9 = new Card();
    Card card10 = new Card();
    Card card11 = new Card();
    Card card12 = new Card();

    Player p1 = new Player();
    Player p2 = new Player();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main myGame = new Main();

        myGame.startGame();

    }

    public void 顯示狀態() {

        //    System.out.println("第一回合結束");
        System.out.print("玩家1");
        p1.show();
        System.out.print("玩家2");
        p2.show();
        System.out.println("-------------------------------------------------");

    }
    /*    Card card3 = new Card(3, "亞里士多得", 0, CardType.領袖);
     Card card18 = new Card(18, "建築工地", 0, CardType.黃牌);
     Card card21 = new Card(21, "摩西", 0, CardType.領袖);
     Card card27 = new Card(27, "空中花園", 0, CardType.奇蹟);
     Card card28 = new Card(28, "藝術作品", 0, CardType.黃牌);
     */

    public void startGame() {
//        時代A內政牌.add(new Card(0, " 亞歷山大大帝 ", 0, CardType.領袖,999));
//        時代A內政牌.add(new Card(1, " 亞里士多得 ", 0, CardType.領袖));
//        時代A內政牌.add(new Card(2, " 凱薩 ", 0, CardType.領袖));
//        時代A內政牌.add(new Card(3, " 摩西 ", 0, CardType.領袖));
//        時代A內政牌.add(new Card(4, " 漢摩拉比 ", 0, CardType.領袖));
//        時代A內政牌.add(new Card(5, " 亞歷山大圖書館 ", 0, CardType.奇蹟));
//        時代A內政牌.add(new Card(6, " 巨人像 ", 0, CardType.奇蹟));
//        時代A內政牌.add(new Card(7, " 空中花園 ", 0, CardType.奇蹟));
//        時代A內政牌.add(new Card(8, " 金字塔 ", 0, CardType.奇蹟));
//        時代A內政牌.add(new Card(15, " 富饒之土 ", 0, CardType.黃牌));
//        時代A內政牌.add(new Card(16, " 工程天才 ", 0, CardType.黃牌));
//        時代A內政牌.add(new Card(17, " 藝術作品 ", 0, CardType.黃牌));
//        時代A內政牌.add(new Card(18, " 節儉 ", 0, CardType.黃牌));
//        時代A內政牌.add(new Card(19, " 荷馬 ", 0, CardType.黃牌));
//        時代A內政牌.add(new Card(20, " 建築工地 ", 0, CardType.黃牌));
//        時代A內政牌.add(new Card(21, " 愛國主義 ", 0, CardType.黃牌));
//        時代A內政牌.add(new Card(22, " 革新思想 ", 0, CardType.黃牌));
//        時代A內政牌.add(new Card(23, " 節儉 ", 0, CardType.黃牌));
//        時代A內政牌.add(new Card(24, " 建築工地 ", 0, CardType.黃牌));
//        時代A內政牌.add(new Card(25, " 富饒之土 ", 0, CardType.黃牌));

//        時代A內政牌.add(new Card(0, "	亞歷山大大帝	", 0, CardType.領袖, 100));
//        時代A內政牌.add(new Card(1, "	亞里士多得	", 0, CardType.領袖, 950));
//        時代A內政牌.add(new Card(2, "	凱薩	", 0, CardType.領袖, 999));
//        時代A內政牌.add(new Card(3, "	摩西	", 0, CardType.領袖, 300));
//        時代A內政牌.add(new Card(4, "	漢摩拉比	", 0, CardType.領袖, 130));
//        時代A內政牌.add(new Card(5, "	亞歷山大圖書館	", 0, CardType.奇蹟, 250));
//        時代A內政牌.add(new Card(6, "	巨人像	", 0, CardType.奇蹟, 50));
//        時代A內政牌.add(new Card(7, "	空中花園	", 0, CardType.奇蹟, 500));
//        時代A內政牌.add(new Card(8, "	金字塔	", 0, CardType.奇蹟, 900));
//        時代A內政牌.add(new Card(15, "	富饒之土	", 0, CardType.黃牌, 200));
//        時代A內政牌.add(new Card(16, "	工程天才	", 0, CardType.黃牌, 850));
//        時代A內政牌.add(new Card(17, "	藝術作品	", 0, CardType.黃牌, 1));
//        時代A內政牌.add(new Card(18, "	節儉	", 0, CardType.黃牌, 150));
//        時代A內政牌.add(new Card(19, "	荷馬	", 0, CardType.黃牌, 600));
//        時代A內政牌.add(new Card(20, "	建築工地	", 0, CardType.黃牌, 630));
//        時代A內政牌.add(new Card(21, "	愛國主義	", 0, CardType.黃牌, 529));
//        時代A內政牌.add(new Card(22, "	革新思想	", 0, CardType.黃牌, 774));
//        時代A內政牌.add(new Card(23, "	建築工地	", 0, CardType.黃牌, 630));
//        時代A內政牌.add(new Card(24, "	愛國主義	", 0, CardType.黃牌, 529));
//        時代A內政牌.add(new Card(25, "	革新思想	", 0, CardType.黃牌, 774));
//
//        時代I內政牌.add(new Card(0, "	哥倫布	", 1, CardType.領袖));
//        時代I內政牌.add(new Card(1, "	聖女貞德	", 1, CardType.領袖));
//        時代I內政牌.add(new Card(2, "	巴巴羅薩	", 1, CardType.領袖));
//        時代I內政牌.add(new Card(3, "	成吉思汗	", 1, CardType.領袖));
//        時代I內政牌.add(new Card(4, "	米開朗基羅	", 1, CardType.領袖));
//        時代I內政牌.add(new Card(5, "	達文西	", 1, CardType.領袖));
//        時代I內政牌.add(new Card(6, "	萬里長城	", 1, CardType.奇蹟));
//        時代I內政牌.add(new Card(7, "	卡羅琳娜大學	", 1, CardType.奇蹟));
//        時代I內政牌.add(new Card(8, "	聖彼得大教堂	", 1, CardType.奇蹟));
//        時代I內政牌.add(new Card(9, "	泰姬陵	", 1, CardType.奇蹟));
//        時代I內政牌.add(new Card(10, "	戰爭機構	", 1, CardType.科技));
//        時代I內政牌.add(new Card(11, "	製圖術	", 1, CardType.科技));
//        時代I內政牌.add(new Card(12, "	劍士	", 1, CardType.科技));
//        時代I內政牌.add(new Card(13, "	印刷術	", 1, CardType.科技));
//        時代I內政牌.add(new Card(14, "	君主制	", 1, CardType.科技));
//        時代I內政牌.add(new Card(15, "	河蟹娛樂	", 1, CardType.科技));
//        時代I內政牌.add(new Card(16, "	戲劇	", 1, CardType.科技));
//        時代I內政牌.add(new Card(17, "	法典	", 1, CardType.科技));
//        時代I內政牌.add(new Card(18, "	灌溉	", 1, CardType.科技));
//        時代I內政牌.add(new Card(19, "	煉金術	", 1, CardType.科技));
//        時代I內政牌.add(new Card(20, "	石工學	", 1, CardType.科技));
//        時代I內政牌.add(new Card(21, "	神學	", 1, CardType.科技));
//        時代I內政牌.add(new Card(22, "	神權政治	", 1, CardType.科技));
//        時代I內政牌.add(new Card(23, "	鐵礦	", 1, CardType.科技));
//        時代I內政牌.add(new Card(24, "	騎士	", 1, CardType.科技));
//        時代I內政牌.add(new Card(25, "	豐收	", 1, CardType.黃牌));
//        時代I內政牌.add(new Card(26, "	富饒之土	", 1, CardType.黃牌));
//        時代I內政牌.add(new Card(27, "	工程天才	", 1, CardType.黃牌));
//        時代I內政牌.add(new Card(28, "	建築工地	", 1, CardType.黃牌));
//        時代I內政牌.add(new Card(29, "	愛國主義	", 1, CardType.黃牌));
//        時代I內政牌.add(new Card(30, "	突破	", 1, CardType.黃牌));
//        時代I內政牌.add(new Card(31, "	藝術作品	", 1, CardType.黃牌));
//        時代I內政牌.add(new Card(32, "	節儉	", 1, CardType.黃牌));
//        時代I內政牌.add(new Card(33, "	革新思想	", 1, CardType.黃牌));
//        時代I內政牌.add(new Card(34, "	高效升級	", 1, CardType.黃牌));
        /*
         for (int k = 0; k < 時代A內政牌.size(); k++) {
         System.out.println("   第" + k + "張 " + 時代A內政牌.get(k).卡名);
         }
         */
//        System.out.println("時代A內政牌---洗牌前");
//          System.out.println(時代A內政牌);

        Collections.shuffle(時代A內政牌);
//              System.out.println("時代A內政牌---洗牌後");
//        System.out.println(時代A內政牌);
        時代A內政牌.remove(13);
        時代A內政牌.remove(13);
        時代A內政牌.remove(13);
        時代A內政牌.remove(13);
        時代A內政牌.remove(13);
        時代A內政牌.remove(13);
        時代A內政牌.remove(13);
//        System.out.println(時代A內政牌);
        /*    for (int k = 0; k < 時代A內政牌.size(); k++) {
         System.out.println("   第" + k + "張 " + 時代A內政牌.get(k).卡名);
         }*/

        檯面13張.add(時代A內政牌.get(0));
        檯面13張.add(時代A內政牌.get(1));
        檯面13張.add(時代A內政牌.get(2));
        檯面13張.add(時代A內政牌.get(3));
        檯面13張.add(時代A內政牌.get(4));
        檯面13張.add(時代A內政牌.get(5));
        檯面13張.add(時代A內政牌.get(6));
        檯面13張.add(時代A內政牌.get(7));
        檯面13張.add(時代A內政牌.get(8));
        檯面13張.add(時代A內政牌.get(9));
        檯面13張.add(時代A內政牌.get(10));
        檯面13張.add(時代A內政牌.get(11));
        檯面13張.add(時代A內政牌.get(12));

        System.out.println("檯面13張");
        System.out.println(檯面13張);
        System.out.println("-------------------------------------------------");
        System.out.println("第一回合開始");
        //  顯示狀態();
        //    System.out.println("玩家1" + p1.toString());
        //   System.out.println("玩家2" + p2.toString());
//        //初始狀態
//        p1.set起始(2, 2, 1, 0, 1, 1);//表示起始科技卡片上黃點的數量
//        //分別代表[農業][礦場][神廟][實驗室][戰士][工人閒置區]
//        p2.set起始(2, 2, 1, 0, 1, 1);
        p1.set文明食物資源科技(0, 0, 0, 0);//
        p2.set文明食物資源科技(0, 0, 0, 0);

        System.out.println("初始狀態");
        顯示狀態();
        System.out.println("第一回合開始");
        System.out.println("給第1個玩家1個內政點");
        p1.set內政點數(1);
        System.out.println("第1個玩家用唯一的內政點去取得13張牌裡面的其中一張牌,只限於前5張");

        for (int k = 0; k < 5; k++) {
         //   System.out.println("   第" + k + "張 " + 時代A內政牌.get(k).卡名);
            System.out.println("   第" + k + "張 " + 檯面13張.get(k).卡名+檯面13張.get(k).加權值);
        }
        System.out.println("我的選擇優先次序是取加權值最大的");
        System.out.println("目前按程序開發先盲目選第0張");
           p1.do拿取(1,檯面13張.get(0));
        System.out.println("給第2玩家2個內政點");
        // 顯示狀態();
        //模擬第一回合的動作

        顯示狀態();

    }

}
