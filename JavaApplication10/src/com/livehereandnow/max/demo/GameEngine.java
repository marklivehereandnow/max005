/*
 遊戲按人數可分為2.3.4人
 按難度，可分為簡易.標準.完整
 先不考慮變型，有9種玩法
 我們先以2人完整遊戲開發這個程式
 紙盒打開後預計有4個時代的185內政牌，155張軍事牌
 2人完整遊戲，拿掉所有的條約牌，以及右上角顯示3+跟4+的牌
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.max.demo;

import com.livehereandnow.max.Card;
import com.livehereandnow.max.CardType;
import com.livehereandnow.max.Cards;
import com.livehereandnow.max.Player;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author chenp_000
 */
public class GameEngine {
//注意
//class名稱一律大寫開頭
//   變量一律小寫開頭,第二個英文字要大寫開頭,例如cardRow
//    常量一律全大寫,例如NOCARD,並加上修飾詞final

    int[] CARD_POINT = {1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
    private List<Card> ageA內政牌;
    private List<Card> cardRow;
    private List<Card> player1Cards;
    private List<Card> player2Cards;
    private List<Card> player3Cards;
    private List<Card> player4Cards;

//    private　Player[] 玩家 = new Player[4];
//        private　Player[] ccddd = new Player[4];
    private Player[] 玩家 = new Player[4];

    public Player get玩家(int k) {
        return 玩家[k];
    }
//    private Player p1;
//    private Player p2;
//    private Player p3;
//    private Player p4;

//    boolean isPlayer1PossessedAgeALeader=false;
//    boolean isPlayer2PossessedAgeALeader=false;
//    boolean isPlayer3PossessedAgeALeader=false;
//    boolean isPlayer4PossessedAgeALeader=false;
    boolean[] playerPossessedAgeALeader = new boolean[5];// for Player 1 to Player 4

    public boolean isPlayerPossessedAgeALeader(int k) {
        return playerPossessedAgeALeader[k];
    }

    public void setPlayerPossessedAgeALeader(int k) {
        this.playerPossessedAgeALeader[k] = true;
    }

//    public Player getP1() {
//        return p1;
//    }
//
//    public Player getP2() {
//        return p2;
//    }
//
//    public Player getP3() {
//        return p3;
//    }
//
//    public Player getP4() {
//        return p4;
//    }
    final Card NOCARD = new Card(999, "", 0, CardType.EMPTY);
//    int playerm
//    2014-4-16 max 10:32,使用refactor變更變量名稱
    int 當前玩家;
    int 玩家人數 = 2;
    int roundNum;

    public int getRoundNum() {
        return roundNum;
    }

    public void do拿牌扣點(int 點數) {

//        if (當前玩家 == 1) {
        玩家[當前玩家 - 1].set內政點數(玩家[當前玩家 - 1].get內政點數() - 點數);
//        }
//        if (當前玩家 == 2) {
//            玩家[1].set內政點數(玩家[1].get內政點數() - 點數);
//        }
//        if (當前玩家 == 3) {
//            p3.set內政點數(p3.get內政點數() - 點數);
//        }
//        if (當前玩家 == 4) {
//            p4.set內政點數(p4.get內政點數() - 點數);
//        }

    }

    public void set拿當前玩家拿過時代A領袖牌() {
//        if (當前玩家 == 1) {
        玩家[當前玩家 - 1].set拿過的時代A領袖牌數(1);
//        }
//        if (當前玩家 == 2) {
//            p2.set拿過的時代A領袖牌數(1);
//        }

    }

    public int get當前玩家內政點數() {
//        if (當前玩家 == 1) {
        return 玩家[當前玩家 - 1].get內政點數();
//        }
//        if (當前玩家 == 2) {
//            return p2.get內政點數();
//        }
//
//        if (當前玩家 == 3) {
//            return p3.get內政點數();
//        }
//
//        if (當前玩家 == 4) {
//            return p4.get內政點數();
//        }
//
//        return -1;//不應該發生
    }

    public int get當前玩家拿過的時代A領袖牌數() {
//        if (當前玩家 == 1) {
        return 玩家[當前玩家 - 1].get拿過的時代A領袖牌數();
//        }
//        if (當前玩家 == 2) {
//            return p2.get拿過的時代A領袖牌數();
//        }
//
//        if (當前玩家 == 3) {
//            return p3.get拿過的時代A領袖牌數();
//        }
//
//        if (當前玩家 == 4) {
//            return p4.get拿過的時代A領袖牌數();
//        }

//        return -1;//不應該發生
    }

    public int get當前玩家() {
        return 當前玩家;
    }

    public List<Card> getAgeA內政牌() {
        return ageA內政牌;
    }

    public void doStatus() {
        showCardRow();
        System.out.println();
        System.out.println("   === Round #" + roundNum + " ===");
        System.out.println("   Player 1 內政點數=" + 玩家[0].get內政點數() + getPlayerCardsString(player1Cards));
        System.out.println("   Player 1 " + 玩家[0].get點數());

        System.out.println("   Player 2 內政點數=" + 玩家[1].get內政點數() + getPlayerCardsString(player2Cards));
        if (玩家人數 >= 3) {
            System.out.println("   Player 3 內政點數=" + 玩家[2].get內政點數() + getPlayerCardsString(player3Cards));
        }
        if (玩家人數 == 4) {
            System.out.println("   Player 4 內政點數=" + 玩家[3].get內政點數() + getPlayerCardsString(player4Cards));
        }
    }

    public void showCardRow() {
        System.out.println("   === Card Row ===");
        //      設定一個String[]　設定初始值為 時代A,時代I,時代II,時代III 當匯入數值時就會改為顯示文字 
//        String[] 時代名 = {"時代A", "時代I", "時代II", "時代III"};

        System.out.print("   Value 1: ");
        for (int k = 0; k < 5; k++) {
            //         System.out.print(k + "[" + cardRow.get(k).get時代() + "-" + cardRow.get(k).get卡名() + "-" + cardRow.get(k).get類型Name() + "] ");
//            System.out.print(k + "[" + 時代名[cardRow.get(k).get時代()] + "-" + cardRow.get(k).get卡名() + "-" + cardRow.get(k).get類型Name() + "] ");
            System.out.print(k + "[" + cardRow.get(k).get時代名() + "-" + cardRow.get(k).get卡名() + "-" + cardRow.get(k).get類型Name() + "] ");

        }
        System.out.println();
        System.out.print("   Value 2: ");
        for (int k = 5; k < 9; k++) {
            System.out.print(k + "[" + cardRow.get(k).get時代名() + "-" + cardRow.get(k).get卡名() + "-" + cardRow.get(k).get類型Name() + "] ");
        }
        System.out.println();
        System.out.print("   Value 3: ");
        for (int k = 9; k < 13; k++) {
            System.out.print(k + "[" + cardRow.get(k).get時代名() + "-" + cardRow.get(k).get卡名() + "-" + cardRow.get(k).get類型Name() + "] ");
        }
        System.out.println();

    }

    public String getPlayerCardsString(List<Card> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int k = 0; k < list.size(); k++) {
//            sb.append("[").append(list.get(k).get卡名()).append("] ");
            sb.append(list.get(k).get卡名and類型Name());
        }
        return sb.toString();
    }

    public void doChangeTurn() {

        if (當前玩家 == 玩家人數) {
            當前玩家 = 1;
            roundNum++;
            玩家[0].set內政點數(4);
            玩家[1].set內政點數(4);
            玩家[2].set內政點數(4);
            玩家[3].set內政點數(4);

        } else {
            當前玩家++;
        }
        System.out.println("change turn to player" + this.get當前玩家());

    }

    public GameEngine() {
        玩家[0] = new Player();
        玩家[1] = new Player();
        玩家[2] = new Player();
        玩家[3] = new Player();

//        p1 = 玩家[0];
//        p2 = 玩家[1];
//        p3 = 玩家[2];
//        p4 = 玩家[3];
        當前玩家 = 1;
        roundNum = 1;
//        p1.set內政點數(1);
//        p2.set內政點數(2);
//        p3.set內政點數(3);
//        p4.set內政點數(4);

        玩家[0].set內政點數(1);
        玩家[1].set內政點數(2);
        玩家[2].set內政點數(3);
        玩家[3].set內政點數(4);

        Cards cards = new Cards();
//        ageA內政牌 = new ArrayList<>();
        ageA內政牌 = cards.get所有的牌();
        cardRow = new ArrayList<>();
        player1Cards = new ArrayList<>();
        player2Cards = new ArrayList<>();
        player3Cards = new ArrayList<>();
        player4Cards = new ArrayList<>();

        // init Age A cards
//        ageA內政牌.add(new Card(0, "亞歷山大大帝", 0, CardType.領袖, 100));
//        ageA內政牌.add(new Card(1, "亞里士多得", 0, CardType.領袖, 950));
//        ageA內政牌.add(new Card(2, "凱薩", 0, CardType.領袖, 999));
//        ageA內政牌.add(new Card(3, "摩西", 0, CardType.領袖, 300));
//        ageA內政牌.add(new Card(4, "漢摩拉比", 0, CardType.領袖, 130));
//        ageA內政牌.add(new Card(5, "亞歷山大圖書館", 0, CardType.奇蹟, 250));
//        ageA內政牌.add(new Card(6, "巨人像", 0, CardType.奇蹟, 50));
//        ageA內政牌.add(new Card(7, "空中花園", 0, CardType.奇蹟, 500));
//        ageA內政牌.add(new Card(8, "金字塔", 0, CardType.奇蹟, 900));
//        ageA內政牌.add(new Card(15, "富饒之土", 0, CardType.黃牌, 200));
//        ageA內政牌.add(new Card(16, "工程天才", 0, CardType.黃牌, 850));
//        ageA內政牌.add(new Card(17, "藝術作品", 0, CardType.黃牌, 1));
//        ageA內政牌.add(new Card(18, "節儉", 0, CardType.黃牌, 150));
//        ageA內政牌.add(new Card(19, "荷馬", 0, CardType.領袖, 600));
//        ageA內政牌.add(new Card(20, "建築工地", 0, CardType.黃牌, 630));
//        ageA內政牌.add(new Card(21, "愛國主義", 0, CardType.黃牌, 529));
//        ageA內政牌.add(new Card(22, "革新思想", 0, CardType.黃牌, 774));
//        ageA內政牌.add(new Card(23, "建築工地", 0, CardType.黃牌, 630));
//        ageA內政牌.add(new Card(24, "愛國主義", 0, CardType.黃牌, 529));
//        ageA內政牌.add(new Card(25, "革新思想", 0, CardType.黃牌, 774));
        //
//        System.out.println("system >>> init Age A 內政牌");
//        System.out.println("system >>> " + ageA內政牌);
        // shuffle cards
        Collections.shuffle(ageA內政牌);
//        System.out.println("system >>> shuffle Age A 內政牌");
//        System.out.println("system >>> " + ageA內政牌);

        // only take first 13 cards and discard others
        for (int k = 0; k < 13; k++) {
            cardRow.add(ageA內政牌.get(k));
        }
//        System.out.println("system >>> Card Row");
//        System.out.println("system >>> " + cardRow);

        System.out.println("   ========================");
        System.out.println("   *    Welcome to XXX    *");
        System.out.println("   ========================");

        this.doStatus();
    }

    public List<Card> getCardRow() {
        return cardRow;
    }

    public boolean doSetCulture(int k) {
        玩家[當前玩家 - 1].get點數().set文化(k);
        return true;
    }

    /**
     * 1. take card
     *
     * (1)enough point to take card
     *
     * (2)not allow to take any card which is being taken within this round
     *
     * (3)not allow to take AgeA leader if you ever took it successfully
     *
     * 2. maintain points when take card successfully
     *
     * @param k
     * @return true: perform take-card successfully
     */
    public boolean doTakeCard(int k) {
        // System.out.println("DOING TAKE CARD ...");

        Card card = cardRow.get(k);

        // === preparation for take-card ===拿牌前的準備
        //(1)enough point to take card點數要夠
        int cardPoint = CARD_POINT[k];
        if (get當前玩家內政點數() < cardPoint) {
            System.out.println("Not enough point to take card. ***Nothing happened***");
            return true;
        }

        //(2)not allow to take any card which is being taken within this round 不允許拿空牌
        if (card.get卡名().length() == 0) {
            System.out.println("This card has been taken! ***Nothing happened***");
            return true;
        }

        //(3)not allow to take AgeA leader if you ever took it successfully 不允許拿兩張A時代領袖的牌
        if (card.get時代() == 0 && card.get類型() == CardType.領袖) {
            if (isPlayerPossessedAgeALeader(get當前玩家())) {
                System.out.println("You are/were holing Age A leader before!***Nothing happened***");
                return true;
            }
            setPlayerPossessedAgeALeader(get當前玩家());
        }
        //TODO(4)不允許拿兩張同名的科技牌
        // === maintain take-card successfully ===
        switch (當前玩家) {
            case 1:
                player1Cards.add(cardRow.get(k));
                break;
            case 2:
                player2Cards.add(cardRow.get(k));
                break;
            case 3:
                player3Cards.add(cardRow.get(k));
                break;
            case 4:
                player4Cards.add(cardRow.get(k));
                break;
            default:
                return false;
        }
        System.out.println("player" + 當前玩家 + " 拿取 [" + cardRow.get(k).get卡名() + "]");
        do拿牌扣點(cardPoint);
        cardRow.remove(k);//從卡牌列上移除該牌
        cardRow.add(k, NOCARD);//並在卡牌列同一個位置增加空牌

        return true;
    }

    public void doHelp() {
        System.out.println("\n=== basic commands === (start)");
        System.out.println("   help         this command");
        System.out.println("   take-card X  take number X card, X is 0 base");
        System.out.println("   change-turn  change player's turn");
        System.out.println("   status       to show current game status");
        System.out.println("   version      顯示版本變更歷史");
        System.out.println("  TODO         代辦事項");
        System.out.println("=== basic commands === (end)");
    }

    public void doTODO() {
        System.out.println();
        System.out.println("  === TODO ===  ");
        System.out.println("    1, 在change-turn的時候 目前玩家可以依照他目前的農業獲得食物");
        System.out.println("    1, 在Player內設置I時代所有的科技牌位置");
        System.out.println("    1, 在Player內設置I時代所有的科技牌位置");

        System.out.println("    1, 在Player內設置I時代所有的科技牌位置");
        System.out.println("    2, 在Player內設置當前領袖位置.戰術牌位置.待建奇蹟位置.建好的奇蹟.值民地位置");
        System.out.println("    done, 目前第二個玩家有可能用兩個內政點數拿兩張時代A的領袖牌,應予以制止");
        System.out.println("    done, 在指令行能用什麼樣的指令，把數字放到剛剛建好的內部類Score,設定文明指數set-culture 3");//

    }

    public void doVersion() {

        System.out.println();
        System.out.println("  === ver 0.16 ===  2014-4-19, 10:34, by MAX　");
        System.out.println("    1. 在時代A內政牌暫時匯入所有的卡牌");
        System.out.println("    2. 在status裡面標示出卡牌的時代0.1.2.3");
        System.out.println("    2. 在status裡面標示出卡牌的時代名,時代A,時代I,時代II,時代III");
        System.out.println();
        System.out.println("  === ver 0.15 ===  2014-4-19, 9:14, by MAX　");
        System.out.println("    1. 新增class Cards 用於放所有的卡牌");
        System.out.println();
        System.out.println("  === ver 0.14 ===  2014-4-18, 10:48, by MAX　");
        System.out.println("    1. 已經可以在命令行設定文化指數");
        System.out.println();
        System.out.println("  === ver 0.13 ===  2014-4-18, 10:12, by MAX　");
        System.out.println("    1. 在class Player新增了一個內部類(Score),用於顯示玩家目前的分數");
        System.out.println();
        System.out.println("  === ver 0.12 ===  2014-4-17, 11:58, by MAX　");
        System.out.println("    1. Player 本來的p1~p4 改成陣列型態 大幅結構更動");
        System.out.println();
        System.out.println("  === ver 0.11 ===  2014-4-17, 11:34, by MAX　");
        System.out.println("    1. 建立科技陣列框架(特殊科技除外)，並在TestPlayer測試執行可用");
        System.out.println();

        System.out.println("  === ver 0.10 ===  2014-4-17, 11:08, by MAX　");
        System.out.println("    1. 建立資源陣列框架，並在TestPlayer測試執行可用");
        System.out.println();

        System.out.println("  === ver 0.9 ===  2014-4-16, 19:31, by MAX　");
        System.out.println("    1. 修復3個玩家和4個玩家時的拿牌扣點");
        System.out.println("    2. 新增簡易指令take");
        System.out.println();

        System.out.println("  === ver 0.8 ===  2014-4-16, 18:40, by Mark");
        System.out.println("    1. 2nd round forward, set points 4 to each player");
        System.out.println();

        System.out.println("  === ver 0.7 ===  2014-4-16, 18:00, by Mark");
        System.out.println("    1. fix 禁止讓玩家拿兩張A時代領袖");
        System.out.println("    2. enhance status layout, show card with typename");
        System.out.println("    3. enhance 4 player on first round taking cards");
        System.out.println();

        System.out.println();
        System.out.println("  === ver 0.6 ===  2014-4-16, 12:42");
        System.out.println("    1. 禁止讓玩家拿兩張A時代領袖");
        System.out.println();

        System.out.println("  === ver 0.5.1 ===  2014-4-16, 11:49");
        System.out.println("    1. 取消輸入英文變成小寫");
        System.out.println("    2. 新增TODO指令,記錄應該要處理的待辦事項");
        System.out.println();

        System.out.println("  === ver 0.5 ===  2014-4-16, 11:27");
        System.out.println("    1. 玩家再也無法拿空牌");
        System.out.println("    2. 玩家可以有效的拿取卡牌列上的牌,並有效的支付點數");
        System.out.println();

        System.out.println("  === ver 0.4 ===  2014-4-16, 11:00");
        System.out.println("    1. do拿牌扣點 可以有效的扣除該玩家拿牌後的內政點數");
        System.out.println("    2. 玩家內政點數沒有時無法拿取卡牌列0~4");
        System.out.println();

        System.out.println("  === ver 0.3 ===  2014-4-16, 09:50");
        System.out.println("    1. 拿牌限制在前13張,也就是take-card 0到12是有效值,不在這範圍的是無效指令");
        System.out.println();

        System.out.println("  === ver 0.2.2 ===  2014-4-16, 09:30");
        System.out.println("    1. 增加中文說明");
        System.out.println("    2. 增加version到help");
        System.out.println();

        System.out.println("  === ver 0.2.1 ===  2014-4-16, 08:30");
        System.out.println("    1. hide player 1 is going to 拿取 card#0");
        System.out.println("    2. show player 1 拿取 [凱薩]");
        System.out.println("    3. improve help command增加幫助指令");
        System.out.println();

        System.out.println("  === ver 0.2 ===  2014-4-16, 08:00");
        System.out.println("    1. allow palyers to take-card增加拿牌的指令,暫時沒有檢查有沒有足夠的內政點數");
        System.out.println("    2. design NOCARD when card was taken from CardRow牌拿走之後,該格補上一張空白牌");
        System.out.println("    3. show Player's on-hand cards顯示玩家們的手牌");
        System.out.println();

        System.out.println("  === ver 0.1 ===  2014-4-15, 18:00");
        System.out.println("    1. allow 2 to 4 players to change-turn讓2~4的玩家可以做 換下一位");
        System.out.println("    2. show CardRow with value 1,2 and 3展示卡牌列，並顯示各卡牌的價格");

        System.out.println("  === 版本控制說明 ===");
        System.out.println("    1. ver X.Y.Z");
        System.out.println("    2. X最大版本,基本功能尚未完備前為0");
        System.out.println("    3. Y中版本,任何和業務邏輯相關的新增移除功能,Y版本+1,只要Y的值增加,Z值歸0,當有重大結構性調整時仍然歸屬在Y版本");
        System.out.println("    4. Z最小版本,任何使用者介面的調整或增刪說明,與功能無關");

    }

    public boolean doCmd(String cmd) throws IOException {
        String cleanCmd = cmd.trim();//           取消全部轉小寫
        String[] strTokens = cmd.split(" ");
        List<String> tokens = new ArrayList<>();
        for (String item : strTokens) {
            if (item.length() > 0) {
                tokens.add(item);
            }
        }

        switch (cleanCmd) {
            case "help": {
                doHelp();
                return true;
            }

            case "hint": {
                System.out.println("to show what user can do now");
                return true;
            }

            case "status": {
                doStatus();
                return true;
            }

            case "TODO": {
                doTODO();
                return true;
            }
            case "version": {
                doVersion();
                return true;
            }
            case "change-turn": {
                doChangeTurn();
                return true;
            }

            default:

                if (tokens.get(0).equalsIgnoreCase("take-card") || tokens.get(0).equalsIgnoreCase("take")) {//簡易指令take
                    if (tokens.size() != 2) { // take-card X, X is a must 目前只支持一次拿一張卡
                        return false;
                    }
                    int cardNum = Integer.parseInt(tokens.get(1));//將第二個字符串轉為整數,第二個的序號為1
                    if (cardNum > 12 || cardNum < 0) { // card number must be 0 to 12 only 
//                        System.out.println("card number must be 0 to 12 only *** Nothing happened ***");
                        System.out.println("拿的牌號必須要在0~12之內 *** 什麼事情都沒發生 ***");
                        return true;
                    }
                    if (cardRow.get(cardNum).get編號() == 999) {
//                        System.out.println("不讓玩家拿空牌 *** Nothing happened ***");
                        System.out.println("不讓玩家拿空牌 *** 什麼事情都沒發生 ***");

                        return true;
                    }
                    return doTakeCard(cardNum);
                }

                //在命令行設定文化指數
                if (tokens.get(0).equalsIgnoreCase("set-culture") || tokens.get(0).equalsIgnoreCase("culture")) {//簡易指令take
                    if (tokens.size() != 2) { // set-culture X,X應該是正整數
                        return false;
                    }
                    int cardNum = Integer.parseInt(tokens.get(1));//將第二個字符串轉為整數,第二個的序號為1
                    if (cardNum > 998 || cardNum < 0) { // card number must be 0 to 12 only 
//                        System.out.println("card number must be 0 to 12 only *** Nothing happened ***");
                        System.out.println("設定的文化指數應該在0~998 *** 什麼事情都沒發生 ***");
                        return true;
                    }
                    return doSetCulture(cardNum);
                }

                return false;
        }
    }

}
