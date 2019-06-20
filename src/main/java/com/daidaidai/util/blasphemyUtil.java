package com.daidaidai.util;

import com.daidaidai.entity.Servant;
import com.daidaidai.entity.Test;

import java.util.ArrayList;
import java.util.List;

public class blasphemyUtil {

    private static final int MAXSIZE = 7;

    private static final int MAXNUM = 14;

    private static final int XIEDUDAMAGE = 1;

    private static final int DAIDAIDAIDAMAGE = 2;

    private static final int MASTERHP = 3;

    public static boolean calculate (Test test) {
        int type = test.getType();
        List<Servant> oneself = test.getOneself();
        List<Servant> enemy = test.getEnemy();
        boolean flag = false;
        if (type == 1) {
            flag = xiedu(oneself, enemy);
        } else {
            flag = daidaidai(oneself, enemy);
        }
        return flag;
    }

    private static boolean xiedu (List<Servant> oneself, List<Servant> enemy) {
        int count = MAXNUM;
        boolean death = false;
        do {
            int damage = XIEDUDAMAGE + getSpellPower(oneself);
            boolean b1 = calculateOne(damage, oneself);
            boolean b2 = calculateOne(damage, enemy);
            death = b1 || b2;
            count --;
        } while (death && count >= 1);
        return enemy.size() == 0;
    }

    private static boolean daidaidai (List<Servant> oneself, List<Servant> enemy) {
        int count = MAXNUM;
        boolean death = false;
        int damage = DAIDAIDAIDAMAGE;
        do {
            boolean b1 = calculateOne(damage, oneself);
            boolean b2 = calculateOne(damage, enemy);
            death = b1 || b2;
            count --;
        } while (death && count >= 1);
        return enemy.size() == 0;
    }

    private static int getSpellPower (List<Servant> oneself) {
        int sp = 0;
        for (Servant servant : oneself) {
            sp += servant.getSpellPower();
        }
        return sp;
    }

    private static boolean calculateOne (int damage, List<Servant> one) {
        boolean death = false;
        for (Servant servant : one) {
            if (!servant.isImmunity()) {
                if (!servant.isShield()) {
                    servant.setHp(servant.getHp() - damage);
                } else {
                    servant.setShield(false);
                }
            }
        }
        for (int i = 0; i <= MAXSIZE - 1; i ++) {
            if (i >= one.size()) {
                break;
            }
            Servant servant = one.get(i);
            if (servant.isMaster() && servant.getHp() > 0 && one.size() < MAXSIZE) {
                i ++;
                one.add(i, new Servant(MASTERHP, 0, false, true));
            }
        }
        for (int i = 0; i <= MAXSIZE - 1; i ++) {
            if (i > one.size() - 1) {
                break;
            }
            Servant servant = one.get(i);
            if (servant.getHp() <= 0) {
                death = true;
                if (servant.getChild() == null || servant.getChild().size() == 0) {
                    one.remove(i);
                    i --;
                } else {
                    List<Servant> child = servant.getChild();
                    int j = 0;
                    one.set(i, child.get(j));
                    if (child.size() > 1) {
                        while (one.size() < MAXSIZE) {
                            i ++;
                            j ++;
                            one.add(i, child.get(j));
                        }
                    }
                }
            }
        }
        return death;
    }

    public static void main(String[] args) {
        List<Servant> oneself = new ArrayList<>();
        List<Servant> child = new ArrayList<>();
        child.add(new Servant(1, 0, false, false));
        oneself.add(new Servant(1, 0, false, false, child));
        oneself.add(new Servant(3, 0, false, true));

        List<Servant> enemy = new ArrayList<>();
        enemy.add(new Servant(8, 0, false, false));
        enemy.add(new Servant(15, 0, false, false));
        boolean flag = calculate(new Test(1, oneself, enemy));
        System.out.println(oneself);
    }
}
