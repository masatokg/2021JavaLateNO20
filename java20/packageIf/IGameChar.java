package packageIf;
public interface IGameChar {
    public static final String CHOICE_ATTACK = "ごうけき";
    public static final String CHOICE_RECOVER = "かいふく";

    public default void battleChoice(){
        System.out.printf("1 %S ", CHOICE_ATTACK);
        System.out.printf("その他 %S \n", CHOICE_RECOVER);
    };
    public boolean isDead();
    public abstract void statusMsg();
    public          boolean attack(IGameChar enemy);
    public abstract void recover();
    public          boolean guard(int num);
    public abstract boolean superAttack(       enemy, int attack);
}
