package com.daidaidai.entity;

import java.util.List;

public class Servant {

    //生命值
    private int hp;

    //法强
    private int spellPower;

    //是否具有免疫
    private boolean immunity;

    //是否具有圣盾
    private boolean shield;

    //是否具有奴隶主的效果
    private boolean master;

    //亡语儿子的集合
    private List<Servant> child;

    public Servant() {
    }

    public Servant(int hp, int spellPower, boolean shield, boolean master, List<Servant> child) {
        this.hp = hp;
        this.spellPower = spellPower;
        this.shield = shield;
        this.master = master;
        this.child = child;
    }

    public Servant(int hp, int spellPower, boolean shield, boolean master) {
        this.hp = hp;
        this.spellPower = spellPower;
        this.shield = shield;
        this.master = master;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(int spellPower) {
        this.spellPower = spellPower;
    }

    public boolean isShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    public List<Servant> getChild() {
        return child;
    }

    public void setChild(List<Servant> child) {
        this.child = child;
    }

    public boolean isImmunity() {
        return immunity;
    }

    public void setImmunity(boolean immunity) {
        this.immunity = immunity;
    }

    @Override
    public String toString() {
        return "Servant{" +
                "hp=" + hp +
                ", spellPower=" + spellPower +
                ", immunity=" + immunity +
                ", shield=" + shield +
                ", master=" + master +
                ", child=" + child +
                '}';
    }
}
