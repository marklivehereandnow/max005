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
public class Cards implements CardType{
    List<Card> cards;

    public Cards() {
        cards=new ArrayList<>();
//        cards.add(new Card(1, "亞歷山大大帝", 0,內政, 領袖,綠色,"","每一個紅色科技牌上的黃點，軍力+1"));
        cards.add(new Card(1,"亞歷山大大帝",0,內政,領袖,綠色,"領袖","每一個紅色科技牌上的黃點，軍力+1"));
    }
//ageA內政牌.add(new Card(0, "亞歷山大大帝", 0, CardType.領袖, 100));
//SELECT CONCAT(   'cards.add(new Card(',ID,','  ,'"' ,名稱 ,'",',時代,',',牌背,',',類型,',',顏色,',','"',右上,'"','"',內容,'"));') FROM `AGES` WHERE 1

    
    
}
