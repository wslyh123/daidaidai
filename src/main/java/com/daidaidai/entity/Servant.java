package com.daidaidai.entity;

import java.util.List;

public class Servant {

    private int hp;

    private int spellPower;

    private boolean shield;

    private boolean master;

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

    @Override
    public String toString() {
        return "Servant{" +
                "hp=" + hp +
                ", spellPower=" + spellPower +
                ", shield=" + shield +
                ", master=" + master +
                ", child=" + child +
                '}';
    }
}
