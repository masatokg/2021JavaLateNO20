package packageCharacters;
import java.util.*;

import packageIf.IGameChar;
import packageIf.IStorm;
public class Bird extends GameChar implements IStorm{
    public static final String CNAME="怪鳥";
    public static final int ATTACK_NORMAL = 0;
    public static final int ATTACK_SUPER_RATIO = 5;
    public static final int DAMAGE_BASE = 10;
    public static final int DAMAGE_SUPER = 3;
    private static int count = 0;
    
    public Bird(){
        this.cName =          +"その"+(++count);
        this.newMsg();
        this.init();
    }
    @Override
    public boolean superAttack(IGameChar enemy, int attack) {
        return this.storm(enemy, attack);
    }
    @Override
    protected void init() {
        this.attackNormal = ATTACK_NORMAL;
        this.attackSuperRatio = ATTACK_SUPER_RATIO;
        this.damageBase = DAMAGE_BASE;
        this.damageSuper = DAMAGE_SUPER;
        this.hp = MAX_HP;
        this.gp = MAX_GP; 
    }
    @Override
    public boolean storm(IGameChar enemy, int attack) {
        System.out.printf("ものすごいはばたき！\n");
        return enemy.       (attack); 
    }
}
