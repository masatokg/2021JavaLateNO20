package packageCharacters;
import packageIf.*;
import java.util.*;
public abstract class GameChar implements IGameChar{
    public static final int ATTACK_NORMAL = 0;
    protected int attackNormal=0;
    protected int attackSuperRatio = 5;
    protected int damageBase = 10;
    protected int damageSuper = 3;

    protected static int MAX_HP=100;
    protected static int MAX_GP=10;
    protected int hp;
    protected int gp;
    protected String cName;
    protected boolean isDead;

    public boolean isDead(){return this.isDead;};
    public void newMsg(){ System.out.printf("%sがあらわれた！\n", cName);};
    public void attackMsg(){ System.out.printf("%sのこうげき！\n", cName);};
    public void gurdMsg(){ System.out.printf("%sはみをまもった！", cName);};
    public void damageMsg(){ System.out.printf("%dのダメージ！\n", cName);};
    public void endMsg(){ System.out.printf("%sは死んでしまった！\n", cName);};

    public void statusMsg(){ 
        if(hp<=0){ System.out.printf("【DEAD】");}
        System.out.printf("%s HP:%d GP:%d", cName, hp, gp);
        System.out.printf("\n");
    };
    protected abstract void init();

    // @Override
    public boolean attack(IGameChar enemy) {
        boolean rt;
        System.out.printf("%s のこうげき！ HP:%d \n", this.cName, this.hp);
        int rdm = new Random().nextInt(this.attackSuperRatio);
        int attack = new Random().nextInt((this.hp/2)+1);
        if(rdm==this.attackNormal){
            rt = enemy.guard(      );
        }else{
            rt = this.superAttack(enemy, attack*this.damageSuper);
        }
        return rt;
    }
    @Override
    public void recover() {
        int recover = new Random().nextInt(this.hp);
        if(recover>=MAX_HP){recover=MAX_HP;}
        System.out.printf("しかし %d のかいふく！\n", recover);
    }

    @Override
    public boolean guard(int num) {
        System.out.printf("%sは%d のこうげきを受けた！ ", this.cName, num);
        int bound = (num - this.gp);
        bound = (bound>0? bound:1);
        int damage = new Random().nextInt(bound);
        if(damage<=0){damage=0;}
        this.gurdMsg();
        System.out.printf("%d のダメージ！\n", damage);
        this.hp -= damage;
        if(this.hp<=0){this.isDead=true;this.endMsg();return this.isDead;}
        else{ this.recover(); }
        return this.isDead;
    }
}
