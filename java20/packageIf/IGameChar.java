package packageIf;
// ゲームキャラクター共通のインターフェース
public interface IGameChar {
    // 選択式バトルにしようとした名残。難易度が上がりそうなのでやめました。
    // 誰か挑戦してみて見せてください。
    // public static final String CHOICE_ATTACK = "ごうけき";
    // public static final String CHOICE_RECOVER = "かいふく";

    // public default void battleChoice(){
    //     System.out.printf("1 %S ", CHOICE_ATTACK);
    //     System.out.printf("その他 %S \n", CHOICE_RECOVER);
    // };
    // 生死を返す
    public boolean isDead();
    // ステータスを表示する抽象メソッド
    public abstract void statusMsg();
    // 攻撃して結果を取得する抽象メソッド
    public          boolean attack(IGameChar enemy);
    // 回復する抽象メソッド
    public abstract void recover();
    // 防御する抽象メソッド
    public          boolean guard(int num);
    // スーパー攻撃の抽象メソッド 。implements側のoverrideを参考にしてください
    public abstract boolean superAttack(       enemy, int attack);
}
