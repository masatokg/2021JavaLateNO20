package packageCharacters;
import java.util.*;
import packageIf.IGameChar;
import packageIf.IIce;

public class Wizard extends GameChar implements IIce{
    public static final String CNAME="魔法使い";
    public static final int ATTACK_NORMAL = 0;
    public static final int ATTACK_SUPER_RATIO = 5;
    public static final int DAMAGE_BASE = 10;
    public static final int DAMAGE_SUPER = 3;
    private static int count = 0;

    public Wizard(){
        this.cName = CNAME+"その"+(++count);
        this.newMsg();
        this.init();
    }

    @Override
    protected void init() {
        this.attackNormal = ATTACK_NORMAL;
        this.attackSuperRatio = ATTACK_SUPER_RATIO;
        this.damageBase = DAMAGE_BASE;
        this.damageSuper = DAMAGE_SUPER;
        this.hp = new Random().nextInt(MAX_HP);
        this.gp = new Random().nextInt(MAX_GP);
    }

    @Override
    public boolean superAttack(IGameChar enemy, int attack) {
        return false;   
    }

    @Override
    public boolean ice(IGameChar enemy, int attack) {
        System.out.printf("こおりのまほう！\n");
        return enemy.guard(attack);
    }
}
