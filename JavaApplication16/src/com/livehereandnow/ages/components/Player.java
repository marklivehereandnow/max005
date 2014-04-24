/*
 === 需求 ===
 想要降低 在GameEngine裡面程式碼的
 玩家[當前玩家].get農業(0).set藍點(玩家[當前玩家].get農業(0).get藍點()+玩家[當前玩家].get農業(0).get黃點());


 */
package com.livehereandnow.ages.components;

import com.livehereandnow.ages.exception.AgesException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max
 */
public class Player {

    private Counter civilCounter;

    public Counter getCivilCounter() {
        return civilCounter;
    }

    private String name;

    private String 失敗原因;

    public String getName() {
        return name;
    }

    public String get失敗原因() {
        return 失敗原因;
    }

    public void set失敗原因(String 失敗原因) {
        this.失敗原因 = 失敗原因;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class Score {

        public int get文化生產() {
            return 文化生產;
        }

        public void set文化生產(int 文化生產) {
            this.文化生產 = 文化生產;
        }

        public int get科技生產() {
            return 科技生產;
        }

        public void set科技生產(int 科技生產) {
            this.科技生產 = 科技生產;
        }

        public int get笑臉() {
            return 笑臉;
        }

        public void set笑臉(int 笑臉) {
            this.笑臉 = 笑臉;
        }

        public int get軍力() {
            return 軍力;
        }

        public void set軍力(int 軍力) {
            this.軍力 = 軍力;
        }

        int 食物;
        int 資源;
        int 文化;
        int 文化生產;
        int 科技;
        int 科技生產;
        int 笑臉;
        int 軍力;

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
//    private int 內政點數;//該玩家即時的內政點數
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
    // === 原本想要的，就跟醫生講說開個止痛藥給我 ===
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
    private Agriculture[] 農場 = new Agriculture[4];
    private Agriculture[] 礦山 = new Agriculture[4];//礦業的需求與農業相同，
    private Agriculture[] 神廟 = new Agriculture[4];
    private Agriculture[] 實驗室 = new Agriculture[4];
    private Agriculture[] 步兵 = new Agriculture[4];
    private Agriculture[] 騎兵 = new Agriculture[4];
    private Agriculture[] 砲兵 = new Agriculture[4];
    private Agriculture[] 飛機 = new Agriculture[4];
    private Agriculture[] 競技場 = new Agriculture[4];
    private Agriculture[] 劇院 = new Agriculture[4];
    private Agriculture[] 圖書館 = new Agriculture[4];
    private boolean[] 已拿取時代領袖 = new boolean[4];

    public Agriculture[] get農場() {
        return 農場;
    }

    public void set農場(Agriculture[] 農場) {
        this.農場 = 農場;
    }

    public Agriculture[] get礦山() {
        return 礦山;
    }

    public void set礦山(Agriculture[] 礦山) {
        this.礦山 = 礦山;
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

    public Agriculture[] get步兵() {
        return 步兵;
    }

    public void set步兵(Agriculture[] 步兵) {
        this.步兵 = 步兵;
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

    public Agriculture get農場(int k) {
        return 農場[k];
    }

    public Agriculture get礦山(int k) {
        return 礦山[k];
    }

    public Agriculture get神廟(int k) {
        return 神廟[k];
    }

    public Agriculture get實驗室(int k) {
        return 實驗室[k];
    }

    public Agriculture get步兵(int k) {
        return 步兵[k];
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

    private int 工人閒置區;
    private int 黃點工人供應區;
    private int 藍點資源供應區;

//    public int get內政點數() {
//        return 內政點數;
//    }
//
//    public void set內政點數(int 內政點數) {
//        this.內政點數 = 內政點數;
//    }

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
    private List<Card> cardsOnTable;

    public boolean is已拿取時代領袖(int k) {//是不是已拿過該時代的領袖牌
        return 已拿取時代領袖[k];
    }

    public void set已拿取時代領袖(int k) {//標示已拿過該時代的領袖牌
        this.已拿取時代領袖[k] = true;
    }

    //起始設定
    public Player() {
        civilCounter = new Counter();
        失敗原因 = "";
        點數 = new Score();
        for (int k = 0; k < 4; k++) {
            已拿取時代領袖[k] = false;
            農場[k] = new Agriculture(0, 0, false, false);
            礦山[k] = new Agriculture(0, 0, false, false);
            神廟[k] = new Agriculture(0, 0, false, false);
            實驗室[k] = new Agriculture(0, 0, false, false);

            競技場[k] = new Agriculture(0, 0, false, false);
            劇院[k] = new Agriculture(0, 0, false, false);
            圖書館[k] = new Agriculture(0, 0, false, false);

            步兵[k] = new Agriculture(0, 0, false, false);
            騎兵[k] = new Agriculture(0, 0, false, false);
            砲兵[k] = new Agriculture(0, 0, false, false);
            飛機[k] = new Agriculture(0, 0, false, false);

        }
        農場[0] = new Agriculture(2, 0, true, true);
        礦山[0] = new Agriculture(2, 0, true, true);
        神廟[0] = new Agriculture(0, 0, true, true);
        實驗室[0] = new Agriculture(1, 0, true, true);
        步兵[0] = new Agriculture(1, 0, true, true);

        文明 = 0;
        食物 = 0;
        資源 = 0;
        科技 = 0;
        手上的牌 = new ArrayList<Card>();
        cardsOnTable = new ArrayList<Card>();
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
//

    public void 執行生產() {
        for (int k = 0; k < 4; k++) {
            //
//            get農場(k).set藍點(get農場(k).get藍點() + get農場(k).get黃點());
//            get礦山(k).set藍點(get礦山(k).get藍點() + get礦山(k).get黃點());
            get農場(k).doProduction();
            get礦山(k).doProduction();

        }
    }

//    待加入 非起始科技，特殊科技，領袖，奇蹟，殖民地
//      食物 資源
//      文化 文化生產
//    科技 科技生產
//    軍力 笑臉
    public void 展示現況() {
//        System.out.println("執行展示...");
//        for (int k = 0; k < 4; k++) {
        for (int k = 3; k >= 0; k--) {
//            System.out.println("k="+k);
            if (get農場(k).is打出() == true) {
                System.out.print("農場" + k + "  " + get農場(k).get黃點() + "(黃點)/" + get農場(k).get藍點() + "(藍點)  ");
            } else {
                System.out.print("                        ");
            }
            if (get礦山(k).is打出() == true) {
                System.out.print("礦山" + k + "  " + get礦山(k).get黃點() + "(黃點)/" + get農場(k).get藍點() + "(藍點)  ");
            } else {
                System.out.print("                        ");
            }
            if (get實驗室(k).is打出() == true) {
                System.out.print("實驗室" + k + "  " + get實驗室(k).get黃點() + "(黃點)  ");
            } else {
                System.out.print("                        ");
            }
            if (get神廟(k).is打出() == true) {
                System.out.print("神廟" + k + "  " + get神廟(k).get黃點() + "(黃點)  ");
            } else {
                System.out.print("                        ");
            }
            if (get步兵(k).is打出() == true) {
                System.out.println("步兵" + k + "  " + get步兵(k).get黃點() + "(黃點)  ");
            } else {
                System.out.print("                        ");
            }
        }

    }

    /**
     * 玩家拿牌，基本規則可查詢，http://www.livehereandnow.com/?page_id=2259 1.1.1.2.1
     * 拿過領袖的記錄，在Player 設定一個boolean 領袖牌[k] k為時代 1.1.1.3.1
     * 當拿取領袖牌的時候，先檢測是否拿過該時代的領袖牌 1.1.1.3.1.1 如果沒有拿過，則依照該領袖牌的時代，在玩家數據內做拿過的記錄
     * 1.1.1.3.1.2 如果拿過，則提示已經拿過，並否決玩家的行動 不能拿拿過的科技牌 不能拿同時
     *
     * @param cost
     * @param card
     * @return true:表示拿牌成功
     */
    public boolean doTakeCard(int cost, Card card) throws AgesException {
        //TODO check any not allowed...

        this.set失敗原因("無失敗紀錄");

        if (!civilCounter.isEnoughToPay(cost)) {
            this.set失敗原因("NOT ENOUGH CIVIL POINTS TO PAY THIS CARD," + card.卡名);
            return false;
        }

        switch (card.get類型()) {
            case CardType.奇蹟: {
                cardsOnTable.add(card);
                break;
            }
            case CardType.領袖: {//當拿取領袖牌的時候，

                if (this.is已拿取時代領袖(card.時代)) {//先檢測是否拿過該時代的領袖牌

                    this.set失敗原因("已經拿過" + card.時代 + "時代的領袖牌");
//                    System.out.println("已經拿過" + card.時代 + "時代的領袖牌");//          如果拿過，則提示已經拿過， 
                    return false;//並否決玩家的行動，以return false告知調用的程序，這次拿牌沒有成功
                } else {
//                     System.out.println("還沒拿過"+card.時代+"時代的領袖牌");
                    set已拿取時代領袖(card.時代);//          如果沒有拿過，則依照該領袖牌的時代，在玩家數據內做拿過的記錄

                    手上的牌.add(card);
                }
                break;
            }
            case CardType.科技: {
                手上的牌.add(card);
                break;
            }
            case CardType.行動: {
                手上的牌.add(card);
                break;
            }
            default:
        }
        //拿牌扣點
//        set內政點數(get內政點數() - cost);

        getCivilCounter().payPoint(cost);
        return true;
    }

    public void showStatus() {
//        System.out.print("\n   內政點數=" + get內政點數());
        System.out.print("\n   內政點數=" + getCivilCounter().getPoint());
        
        showCards();
        System.out.println("\n   " + get點數());
        show農場礦山實驗室神廟步兵();
    }

//            礦山 實驗室 神廟  步兵
    public void show農場礦山實驗室神廟步兵() {
        String strAges[] = {"A", "I", "II", "III"};

        System.out.print("   農場 (Ages)黃點=>藍點, ");
        for (int k = 3; k >= 0; k--) {
            System.out.print(" (" + strAges[k] + ")" + get農場(k).toString(1));
        }

        System.out.print("\n   礦山 (Ages)黃點=>藍點, ");
        for (int k = 3; k >= 0; k--) {
            System.out.print(" (" + strAges[k] + ")" + get礦山(k).toString(1));
        }
        System.out.print("\n   實驗室 (Ages)黃點=>藍點, ");
        for (int k = 3; k >= 0; k--) {
            System.out.print(" (" + strAges[k] + ")" + get實驗室(k).toString(1));
        }
        System.out.print("\n   神廟 (Ages)黃點=>藍點, ");
        for (int k = 3; k >= 0; k--) {
            System.out.print(" (" + strAges[k] + ")" + get神廟(k).toString(1));
        }
        System.out.print("\n   步兵 (Ages)黃點=>藍點, ");
        for (int k = 3; k >= 0; k--) {
            System.out.print(" (" + strAges[k] + ")" + get步兵(k).toString(1));
        }

    }

    public void showCards() {
        System.out.print("\n   手牌 ");
        showCardsOnHand();
        System.out.print("   桌牌 ");
        showCardsOnTable();
    }

    public void showCardsOnHand() {
        for (int k = 0; k < 手上的牌.size(); k++) {
            System.out.print(" " + 手上的牌.get(k).toString(1));
        }
        System.out.println();
    }

    public void showCardsOnTable() {
        for (int k = 0; k < cardsOnTable.size(); k++) {
            System.out.print(" " + cardsOnTable.get(k).toString(1));
        }
        //   System.out.println();
    }

//
//    public void show() {
//        System.out.print(" 手上的牌 ");
//        show手上的牌();
//        System.out.print("  礦場=" + 礦山);
//        System.out.print("  神廟=" + 神廟);
//        System.out.print("  實驗室=" + 實驗室);
//        System.out.print("  戰士=" + 步兵);
//        System.out.print("  工人閒置區=" + 工人閒置區);
//        System.out.println("  " + toString());
//
//    }
    @Override
    public String toString() {
        return "現有資源{" + "\u6587\u660e=" + 文明 + ", \u98df\u7269=" + 食物 + ", \u8cc7\u6e90=" + 資源 + ", \u79d1\u6280=" + 科技 + '}';
    }

}
