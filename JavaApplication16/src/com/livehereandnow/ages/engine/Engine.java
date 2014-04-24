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
package com.livehereandnow.ages.engine;

import com.livehereandnow.ages.components.Card;
import com.livehereandnow.ages.components.CardType;
import com.livehereandnow.ages.components.Cards;
import com.livehereandnow.ages.components.Player;
import com.livehereandnow.ages.exception.AgesException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author chenp_000
 */
public class Engine {
//注意
//class名稱一律大寫開頭
//   變量一律小寫開頭,第二個英文字要大寫開頭,例如cardRow
//    常量一律全大寫,例如NOCARD,並加上修飾詞final

    int[] CARD_POINT = {1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
    private List<Card> ageA內政牌;
    private List<Card> cardRow;
//  待優化  
//    private List<Card> 玩家1手牌;
//    private List<Card> 玩家1桌牌;
//    private List<Card> player2Cards; // on-hand
//    private List<Card> player2CardsOnTable;
//
//    private List<Card> player3Cards;
//    private List<Card> player4Cards;
//
//    private List<Card> player3CardsOnTable;
//    private List<Card> player4CardsOnTable;

//  待優化
    private Player[] 玩家 = new Player[4];
    private Player 當前玩家;

    /**
     * 獲得當前玩家的物件
     *
     * @return
     */
    public Player get當前玩家() {
        return 當前玩家;
    }

    public void set當前玩家(Player current玩家) {
        this.當前玩家 = current玩家;
    }

//    public Player get玩家(int k) {
//        return 玩家[k];
//    }
    final Card NOCARD = new Card(999, "", 0, CardType.EMPTY);
//    int playerm
//    2014-4-16 max 10:32,使用refactor變更變量名稱
    private int 當前玩家ID;
    private int 玩家人數 = 2;
    private int roundNum;

    public int getRoundNum() {
        return roundNum;
    }

//    public void do拿牌扣點(int 點數) {
//        玩家[當前玩家ID - 1].set內政點數(玩家[當前玩家ID - 1].get內政點數() - 點數);
//    }
//    public int get當前玩家拿過的時代A領袖牌數() {
//
//        return 玩家[當前玩家ID - 1].get拿過的時代A領袖牌數();
//    }
//    public int get當前玩家ID() {
//        return 當前玩家ID;
//    }
    public List<Card> getAgeA內政牌() {
        return ageA內政牌;
    }

    public boolean doStatus() {

        showCardRow();
        System.out.println();
        System.out.println("   === Round #" + roundNum + " ===");
        System.out.print("   --- Player A is " + 玩家[0].getName() + " ---");
        玩家[0].showStatus();
        System.out.print("\n\n   --- Player B is " + 玩家[1].getName() + " ---");
        玩家[1].showStatus();
        System.out.println();
        System.out.println();
        return true;
    }

    public void showCardRow() {
        System.out.println("   === Card Row ===");
        System.out.print("   Value 1: ");
        for (int k = 0; k < 5; k++) {
            System.out.print(k + cardRow.get(k).toString(1));
        }
        System.out.println();
        System.out.print("   Value 2: ");
        for (int k = 5; k < 9; k++) {
            System.out.print(k + cardRow.get(k).toString(1));
        }
        System.out.println();
        System.out.print("   Value 3: ");
        for (int k = 9; k < 13; k++) {
            System.out.print(k + cardRow.get(k).toString(1));
        }
        System.out.println();
    }

//    public String getPlayerCardsString(List<Card> list) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(" ");
//        for (int k = 0; k < list.size(); k++) {
////            sb.append("[").append(list.get(k).get卡名()).append("] ");
//            sb.append(list.get(k).get卡名and類型Name());
//        }
//        return sb.toString();
//    }
    public void doNewGame() {

        System.out.println("新的遊戲開始");
    }

    public boolean doChangeTurn() throws AgesException {

        //  System.out.println("運行doChangeTurn");
        get當前玩家().執行生產();

        if ((1 + 當前玩家ID) == 玩家人數) {
            當前玩家ID = 0;
            roundNum++;

//            玩家[0].set內政點數(4);
//            玩家[1].set內政點數(4);
//            玩家[2].set內政點數(4);
//            玩家[3].set內政點數(4);
            玩家[0].getCivilCounter().setPoint(4);
            玩家[1].getCivilCounter().setPoint(4);
            玩家[2].getCivilCounter().setPoint(4);
            玩家[3].getCivilCounter().setPoint(4);

        } else {
            當前玩家ID++;
        }
        this.set當前玩家(玩家[當前玩家ID]);
        return true;
        //System.out.println("Change turn to player " + this.get當前玩家());

    }

    public Engine() throws AgesException {
        init();
    }

    public void init() throws AgesException {
        玩家[0] = new Player();
        玩家[1] = new Player();
        玩家[2] = new Player();
        玩家[3] = new Player();

        玩家[0].setName("Max");
        玩家[1].setName("Amy");

        當前玩家 = 玩家[0];

        //當前玩家ID = 1; // TODO .... PROBLEM
        當前玩家ID = 0; //

        roundNum = 1;

//        玩家[0].set內政點數(1);
//        玩家[1].set內政點數(2);
//        玩家[2].set內政點數(3);
//        玩家[3].set內政點數(4);
        玩家[0].getCivilCounter().setPoint(1);
        玩家[1].getCivilCounter().setPoint(2);
        玩家[2].getCivilCounter().setPoint(3);
        玩家[3].getCivilCounter().setPoint(4);

        Cards cards = new Cards();
        ageA內政牌 = cards.get時代A內政牌();

        cardRow = new ArrayList<>();

        Collections.shuffle(ageA內政牌);

        // only take first 13 cards and discard others
        for (int k = 0; k < 13; k++) {
            cardRow.add(ageA內政牌.get(k));
        }
        System.out.println("   ========================");
        System.out.println("   *    Welcome to XXX    *");
        System.out.println("   ========================");

        this.doStatus();
    }

    public List<Card> getCardRow() {
        return cardRow;
    }

    public boolean doSetCulture(int k) {
        玩家[當前玩家ID - 1].get點數().set文化(k);
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
    public boolean doTakeCard(int k) throws AgesException {
        int cardNum = k;
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

        Card card = cardRow.get(k);
        int cardPoint = CARD_POINT[k];

//        if (card.get卡名().length() == 0) {
//            System.out.println("This card has been taken! ***Nothing happened***");
//            return true;
//        }
        if (get當前玩家().doTakeCard(cardPoint, card)) {//如果當當前玩家成功拿了牌
            // when card is taken successfully
            cardRow.remove(k);//從卡牌列上移除該牌
            cardRow.add(k, NOCARD);//並在卡牌列同一個位置增加空牌
        } else {
//            System.out.println("拿牌沒有成功" + card.get卡名());
            System.out.println("   拿牌沒有成功的原因:" + get當前玩家().get失敗原因());

        }

        //    do拿牌扣點(cardPoint);
        return true;
    }

    public boolean doHelp() {
        System.out.println("\n=== basic commands === (start)");
        System.out.println("   help         this command");
        System.out.println("   take-card X  take number X card, X is 0 base");
        System.out.println("   change-turn  change player's turn");
        System.out.println("   status       to show current game status");
        System.out.println("   version      顯示版本變更歷史");
        System.out.println("  TODO         代辦事項");
        System.out.println("=== basic commands === (end)");
        return true;
    }

    public boolean doTODO() {
        System.out.println();
        System.out.println("  === TODO ===  ");
        System.out.println("    1, 在change-turn的時候 目前玩家可以依照他目前的私有板塊獲得對應的資源，預計花1個小時完成,4/20日完成");
        System.out.println("    2, 在Player內設置當前領袖位置.戰術牌位置.待建奇蹟位置.建好的奇蹟.值民地位置,預計花0.5個小時完成,4/20日完成");
        System.out.println("    done, 在Player內設置I時代所有的科技牌位置");
        System.out.println("    done, 目前第二個玩家有可能用兩個內政點數拿兩張時代A的領袖牌,應予以制止");
        System.out.println("    done, 在指令行能用什麼樣的指令，把數字放到剛剛建好的內部類Score,設定文明指數set-culture 3");//
        return true;
    }

    public boolean doVersion() {

        System.out.println();

        System.out.println("  === ver 0.27 ===  2014-4-24, 8:33, by Mark　");
        System.out.println("    1. introduce AgesException and new Counter class");
        System.out.println("    2. done, not allow to take card when 內政點數不夠");
        System.out.println("    3. add civilCounter");
        System.out.println("    4. TODO add militaryCounter");

        System.out.println("  === ver 0.26 ===  2014-4-23, 12:44, by Max　");
        System.out.println("    1. 實施拿牌沒有成功的原因");
        System.out.println("    2. done 拿牌沒有成功的原因:已經拿過0時代的領袖牌");
        System.out.println("    3. TODO 內政點數不夠，已經拿過該科技牌，尚有未完成的奇蹟");

        System.out.println("  === ver 0.25 ===  2014-4-23, 12:06, by Max　");
        System.out.println("    1. 在Player裡面增加 應對拿牌不同的類型，做出不同的判斷方式(目前只做了領袖跟一半的奇蹟)");
        System.out.println("    2.  在Emgine做take-card如果遭遇回傳false 顯示該牌");

        System.out.println("  === ver 0.24 ===  2014-4-23, 8:30, by Mark　");
        System.out.println("    1. rearrange package");
        System.out.println("    2. new com.livehereandnow.ages.Main");
        System.out.println("    3. new com.livehereandnow.ages.engine.Engine");
        System.out.println("    4. player with name, Max and Amy");

        System.out.println();
        System.out.println("  === ver 0.23 ===  2014-4-22, 20:30, by Mark　");
        System.out.println("    1. create doTakeCard on Player");
        System.out.println("    2. improve doStatus layout --- show 農場 (Ages)黃點=>藍點,  (III)0=>0 (II)0=>0 (I)0=>0 (A)2=>2");
        System.out.println();

        System.out.println("  === ver 0.22 ===  2014-4-22, 18:00, by Mark　");
        System.out.println("    1. implement --- A Wonder goes directly to the table. Only one Wonder can be “under construction”.");
        System.out.println("    2. improve doStatus layout");
        System.out.println();

        System.out.println("  === ver 0.21 ===  2014-4-22, 12:21, by MAX　");
        System.out.println("    1. 新增out-card指令用於打出手牌");
        System.out.println("    2. 增加玩家桌面的牌");
        System.out.println("    3. 顯示桌牌的內容");
        System.out.println("    4. 為方便測試暫時取消點數限制，能在第一回合取多張牌");
        System.out.println("    5.手上多張牌可以一直打第0張，能夠順利打到桌上，但是無法打第1張???");
        System.out.println("  === ver 0.20 ===  2014-4-22, 01:55, by MAX　");
        System.out.println("    1. 展示區改由Player提供方法");
        System.out.println("    2. 重新定義農業、礦業、戰士改為農場、礦山、步兵");
        System.out.println("  === ver 0.19.1 ===  2014-4-21, 11:50, by MAX　");
        System.out.println("    1. 建立展示點數雛型");
        System.out.println("  === ver 0.19 ===  2014-4-21, 11:33, by MAX　");
        System.out.println("    1. 將繁瑣的程式碼，放到該屬於Player自有的地方執行");
        System.out.println("    2. 將單一時代的農業擴展為4個時代");
        System.out.println("    3. 將農業擴展到其他科技");
        System.out.println("  === ver 0.18 ===  2014-4-21, 10:32, by MAX　");
        System.out.println("    1. 設定成功依照私有板塊獲得對應的資源");
        System.out.println("  === ver 0.17.1 ===  2014-4-19, 11:34, by MAX　");
        System.out.println("    1. 變更TODO,預計明日要完成事項");
        System.out.println("  === ver 0.17 ===  2014-4-19, 11:23, by MAX　");
        System.out.println("    1. 在時代A內政牌內匯入正確的牌，包括基礎暴力法和進階的篩選過濾法");
        System.out.println("    2. showcardRow的結構大更新，改由從card給String");
        System.out.println("    3. 單張牌顯示方式,[時代A內政-革新思想-行動]");
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
        return true;
    }

    /**
     * design command as type 1, single word, version help status type 2,
     * keyword + parameter, take-card 1 take 1 play-card 1 play 1
     *
     * @param cmd
     * @return
     * @throws IOException
     */
    public boolean doCmd(String cmd) throws IOException, AgesException {
        int tokenCnt = 0;//命令行裡共有幾個字，給予初值為0
        String keyword = "";//指令是什麼，給予初值空字符串
        int parameter = -1;//指令的參數是什麼，給予初值為-1，-1通常是指不能用的值

        //將命令行的句子拆解為字，以空格格開為依據，空格都不記
        String[] strTokens = cmd.split(" ");
        List<String> tokens = new ArrayList<>();
        for (String item : strTokens) {
            if (item.length() > 0) {
                tokens.add(item);
            }
        }

        //超過兩個字的時候
        if (tokens.size() > 2) {
            System.out.println("Command must be one or two words only!");
            return false;
        }

        //是兩個字的時候
        if (tokens.size() == 2) {
            try {
                parameter = Integer.parseInt(tokens.get(1));
            } catch (Exception ex) {
                System.out.println("Parameter must be 0 or positive integer");
                return false;
            }
        }

        keyword = tokens.get(0);//指令的關鍵字是第0個字，例如take 3的take
        tokenCnt = tokens.size();//賦予變量tokenCnt真正的值，真正的值是指到底打個幾個字

        // === for one word command ===單指令的命令行
        if (tokenCnt == 1) {//如果輸入的是一個字的話
            switch (keyword) {
                case "help":
                    return doHelp();

                case "status":
                    return doStatus();

                case "TODO":
                    return doTODO();

                case "version":
                    return doVersion();

                case "change-turn":
                    return doChangeTurn();

                //     default:
            }
            System.out.println("Unknown keyword, " + keyword);
            return false;
        }

        // === for two words command ===如果你輸入是兩個字元
        switch (keyword) {
            case "打":
            case "out":
            case "play":
            case "play-card":
            case "out-card": {
//                if (玩家1手牌.size() == 0) {
//                    System.out.println("手上沒有牌不能打");
//                    return true;
//                }
//                if (玩家1手牌.size() < parameter + 1) {//當手上只有一張牌時，玩家1手牌SIZE=手上有幾張
//                    System.out.println("你只能選擇0到" + (玩家1手牌.size() - 1));
//                    return true;
//                }
//             
//                玩家1桌牌.add(玩家1手牌.get(parameter));
//                玩家1手牌.remove(parameter);
//                return true;

            }
            case "拿"://在我的環境NetBeans無法執行，但是在DOS可以
            case "拿牌":
            case "take":
            case "take-card": {

                return doTakeCard(parameter);
            }

//在命令行設定文化指數
            case "set-cluture": {

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
            default:
                System.out.println("Unknown keyword, " + keyword);
                return false;

        }
    }
}
