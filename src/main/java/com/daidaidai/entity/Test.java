package com.daidaidai.entity;

import java.util.List;

public class Test {

    private int type;

    private List<Servant> oneself;

    private List<Servant> enemy;

    public Test() {
    }

    public Test(int type, List<Servant> oneself, List<Servant> enemy) {
        this.type = type;
        this.oneself = oneself;
        this.enemy = enemy;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Servant> getOneself() {
        return oneself;
    }

    public void setOneself(List<Servant> oneself) {
        this.oneself = oneself;
    }

    public List<Servant> getEnemy() {
        return enemy;
    }

    public void setEnemy(List<Servant> enemy) {
        this.enemy = enemy;
    }

    @Override
    public String toString() {
        return "Test{" +
                "type=" + type +
                ", oneself=" + oneself +
                ", enemy=" + enemy +
                '}';
    }
}
