package com.lessons;
/**
Goods it`s class wich describe buyer behavour
 */
class Buyer {

    /**
     * Cuccernt posoition in a array where save goods
     */
    int curPos;
    /**
     * current cache
     */
    private double haveCash;
    /**
     * goods wich he has
     */
    private Goods[] haveGoods;

    /**
     * return if his bag is fill
     * @return
     */
    public boolean getPlace(){
        if (curPos == haveGoods.length)
            return false;
        else
            return true;
    }

    /**
     * describe procedure buy goods
     * @param good
     */
    public void buyGoods(com.lessons.Goods good){

        haveCash -= good.getPrice();
        haveGoods[curPos++] = good;

    }

    /**
     * return gurren
     * @return
     */
    public boolean isCasheEnought(double price) {
       return price >  haveCash ? false:true;
    }

    /**
     * constructor of our class
     * @param haveCash
     * @param size
     */

    public Buyer(double haveCash, int size) {
        curPos = 0;
        this.haveCash = haveCash;
        haveGoods = new Goods[size];
    }
}
