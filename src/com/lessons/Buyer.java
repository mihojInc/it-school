package com.lessons;
class Buyer {

    int curPos;

    private double haveCash;

    public boolean getPlace(){
        if (curPos == 0)
            return false;
        else
            return true;
    }

    public void setHaveCash(double haveCash) {
        this.haveCash = haveCash;
    }

    public double getHaveCash() {
        return haveCash;
    }

    private Goods[] haveGoods;

    public Buyer(double haveCash, int size) {
        curPos = 0;
        this.haveCash = haveCash;
        haveGoods = new Goods[size];
    }
}
