package com.daidaidai.util;

import com.daidaidai.entity.Servant;
import com.daidaidai.entity.Test;

import java.util.ArrayList;
import java.util.List;

public class blasphemyUtil {

    //一方的最大随从数量
    private static final int MAXSIZE = 7;
    //亵渎daidaidai最大执行次数
    private static final int MAXNUM = 14;
    //亵渎的基础伤害
    private static final int XIEDUDAMAGE = 1;
    //daidaidai的基础伤害
    private static final int DAIDAIDAIDAMAGE = 2;
    //奴隶主的基础血量
    private static final int MASTERHP = 3;

    //计算能否清场
    public static boolean calculate (Test test) {
        //1表示亵渎2表示带带带
        int type = test.getType();
        List<Servant> oneself = test.getOneself();
        List<Servant> enemy = test.getEnemy();
        //解光对面场面的标识
        boolean flag = false;
        if (type == 1) {
            flag = xiedu(oneself, enemy);
        } else {
            flag = daidaidai(oneself, enemy);
        }
        return flag;
    }

    //执行亵渎操作
    private static boolean xiedu (List<Servant> oneself, List<Servant> enemy) {
        int count = MAXNUM;
        //单次伤害出现随从死亡的标识
        boolean death = false;
        do {
            int damage = XIEDUDAMAGE + getSpellPower(oneself);
            death = calculateOne(damage, oneself) || calculateOne(damage, enemy);
            count --;
        } while (death && count >= 1);
        return enemy.size() == 0;
    }
    
    //执行带带带操作
    private static boolean daidaidai (List<Servant> oneself, List<Servant> enemy) {
        int count = MAXNUM;
        //单次伤害出现随从死亡的标识
        boolean death = false;
        int damage = DAIDAIDAIDAMAGE;
        do {
            death = calculateOne(damage, oneself) || calculateOne(damage, enemy);
            count --;
        } while (death && count >= 1);
        return enemy.size() == 0;
    }

    //计算己方场面的法强
    private static int getSpellPower (List<Servant> oneself) {
        int sp = 0;
        for (Servant servant : oneself) {
            sp += servant.getSpellPower();
        }
        return sp;
    }

    //执行一次基础的伤害操作
    //damage    基础的伤害值
    //one   场面的集合
    private static boolean calculateOne (int damage, List<Servant> one) {
        //单次伤害出现随从死亡的标识
        boolean death = false;
        //首先从左至右执行造成伤害操作
        for (Servant servant : one) {
            //免疫不收伤害
            if (!servant.isImmunity()) {
                //圣盾免疫该次伤害并将圣盾取消
                if (!servant.isShield()) {
                    servant.setHp(servant.getHp() - damage);
                } else {
                    servant.setShield(false);
                }
            }
        }
        //从左至右执行奴隶主生成逻辑
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
        //从左至右执行死亡结算和亡语生儿子操作
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
