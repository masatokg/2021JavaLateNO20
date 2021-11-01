package packageCharacters;

import packageIf.IGameChar;
import packageIf.IHero;

public class Hero extends GameChar implements IHero{
    public static final String CNAME="ヒーロー";
    public static final int ATTACK_SUPER_RATIO = 3;
    public static final int DAMAGE_BASE = 15;
    public static final int DAMAGE_SUPER = 2;
    
    public Hero(){
        this.cName = CNAME;
        this.newMsg();
        this.init();
    }

    @Override
    public boolean superAttack(IGameChar enemy, int attack) {
        return this.superHit(enemy, attack); 
    }

    @Override
    protected void init() {
        this.attackNormal = ;
        this.attackSuperRatio = ATTACK_SUPER_RATIO;
        this.damageBase = ;
        this.damageSuper = DAMAGE_SUPER;
        this.hp = (int)(MAX_HP*1.5);
        this.gp = (int)(MAX_GP*1.5);
    }

    @Override
    public boolean superHit(IGameChar enemy, int attack) {
        System.out.printf("かいしんのいちげき！ %d\n", attack);
        return enemy.guard(attack);  
    }

    @Override
    public void gameSave() {
        // 保存ボタン（今回は実装しない）        
    }    
}
