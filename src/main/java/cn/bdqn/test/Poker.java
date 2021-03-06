package cn.bdqn.test;

import java.util.List;

/**
 * @Package: cn.bdqn.test
 * @Description: 扑克类
 * @Author hah
 * @Create 2021年04月19日 10时10分01秒
 */
public class Poker {


    private static String[] suites = {"黑桃", "红桃", "草花", "方块"};
    private static int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    private Card[] cards;

    /**
     * 构造器
     *
     */
    public Poker() {
        cards = new Card[52];
        for(int i = 0; i < suites.length; i++) {
            for(int j = 0; j < faces.length; j++) {
                cards[i * 13 + j] = new Card(suites[i], faces[j]);
            }
        }

        for (int i = 0; i < cards.length; i++) {
//            System.out.println(cards[i]);
        }

    }

    /**
     * 洗牌 （随机乱序）
     *
     */
    public void shuffle() {
        for(int i = 0, len = cards.length; i < len; i++) {
            double random = Math.random();
            int index = (int) (random * len);
            //System.out.println(random);
            Card temp = cards[index];
            cards[index] = cards[i];
            cards[i] = temp;
        }

        for (int i = 0; i < cards.length; i++) {
            System.out.println("第"+(i+1)+"张牌"+cards[i]);
        }
    }

    /**
     * 发牌
     * @param index 发牌的位置
     *
     */
    public Card deal(int index) {
        return cards[index];
    }

    /**
     * 卡片类（一张扑克）
     * [内部类]
     * @author 骆昊
     *
     */
    public class Card {
        private String suite;   // 花色
        private int face;       // 点数

        public Card(String suite, int face) {
            this.suite = suite;
            this.face = face;
        }

        @Override
        public String toString() {
            String faceStr = "";
            switch(face) {
                case 1: faceStr = "A"; break;
                case 11: faceStr = "J"; break;
                case 12: faceStr = "Q"; break;
                case 13: faceStr = "K"; break;
                default: faceStr = String.valueOf(face);
            }
            return suite + faceStr;
        }
    }


}