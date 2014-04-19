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
public interface CardType {

    int 內政 =0;
    int 軍事=1;
    int 綠色=0;
    int 紫色=1;
    int 橙色=2;
    int 灰色=3;
    int 棕色=4;
    int 紅色=5;
    int 黃色=6;
    int 政府 = 0;
    int 奇蹟 = 1;
    int 領袖 = 2;
    int 科技 = 3;
    int 黃牌 = 4;
    int 事件 = 5;
    int 殖民地 = 6;
    int 戰術 = 7;
    int 侵略 = 8;
    int 戰爭 = 9;
    int 條約 = 10;
    int EMPTY=11;
    String[] CARD_TYPE_NAME={"政府","奇蹟","領袖","科技","黃牌","事件","殖民地","戰術","侵略","戰爭","條約","EMPTY"};
}
