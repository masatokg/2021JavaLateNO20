package packageCharacters;
import java.util.*;
import packageIf.IGameChar;
import packageIf.IIce;

public class Wizard extends GameChar implements IIce{
    public static final String CNAME="魔法使い";
    // 通常攻撃の基準値
    public static final int ATTACK_NORMAL = 0;
    // スーパー攻撃の分母
    public static final int ATTACK_SUPER_RATIO = 5;
    // 算出用の基本値。DAMAGE_BASEは申し訳ない、未使用です。
    public static final int DAMAGE_BASE = 10;
    public static final int DAMAGE_SUPER = 3;
    private static int count = 0; // 同種族カウント

    // コンストラクタ
    public Wizard(){
        this.cName = CNAME+"その"+(++count);// キャラクタ名。他キャラを参考にしてください 
        this.newMsg();  // 登場メッセージ
        this.init();    // 初期化処理
    }

    // 魔法使いの初期化
    @Override
    protected void init() {
        this.attackNormal = ATTACK_NORMAL;   // 通常攻撃の時の判定値。
        this.attackSuperRatio = ATTACK_SUPER_RATIO; // スーパー攻撃判定の分母
        // this.damageBase = DAMAGE_BASE; // 申し訳ない、未使用です
        this.damageSuper = DAMAGE_SUPER;    // スーパー攻撃のダメージ算出用値
        this.hp = new Random().nextInt(MAX_HP); // HPを0～MAX-1の範囲で設定
        this.gp = new Random().nextInt(MAX_GP); // GPを0～MAX-1の範囲で設定
    }
    // キャラクターごとに内容が違うスーパー攻撃
    @Override
    public boolean superAttack(IGameChar enemy, int attack) {
        // return false;   バグってました。申し訳ないです
        // こおりのまほうを呼び出す
        return this.ice(enemy, attack);
    }

    // こおりのまほう
    @Override
    public boolean ice(IGameChar enemy, int attack) {
        System.out.printf("こおりのまほう！\n");
        return enemy.guard(attack);   // 敵が耐えた結果を受け取る（生死）
    }
}
