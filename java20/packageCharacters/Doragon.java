package packageCharacters;
import java.util.*;
import packageIf.IFire;
import packageIf.IGameChar;
// ドラゴンクラス
public class Doragon extends GameChar implements IFire{
    public static final String CNAME="ドラゴン";
    // 通常攻撃の基準値
    public static final int ATTACK_NORMAL = 0;
    // スーパー攻撃の分母
    public static final int ATTACK_SUPER_RATIO = 5;
    // 算出用の基本値。DAMAGE_BASEは申し訳ない、未使用です。
    public static final int DAMAGE_BASE = 10;
    public static final int DAMAGE_SUPER = 3;
    private static int count = 0; // 同種族カウント

    // コンストラクタ
    public Doragon(){
        this.cName = CNAME+"その"+(     );// キャラクタ名。他キャラを参考にしてください 
        this.newMsg();  // 登場メッセージ
        this.       ;   // 初期化処理。ほかのキャラクターを参考にしてください
    }

    // ドラゴンの初期化
    @Override
    protected void init() {
        this.attackNormal = ATTACK_NORMAL;   // 通常攻撃の時の判定値。
        this.attackSuperRatio = ATTACK_SUPER_RATIO; // スーパー攻撃判定の分母
        // this.damageBase = DAMAGE_BASE; // 申し訳ない、未使用です
        this.damageSuper =        ;    // スーパー攻撃のダメージ算出用値。ほかのキャラクターを参考にしてください
        this.hp = new Random().nextInt(MAX_HP); // HPを0～MAX-1の範囲で設定
        this.gp = new Random().nextInt(      ); // GPを0～MAX-1の範囲で設定
    }
    // キャラクターごとに内容が違うスーパー攻撃
    @Override
    public boolean superAttack(IGameChar enemy, int attack) {
        // ほのおのいちげきをよびだす。
        return this.     (enemy, attack);
    }

    // ほのおのいちげき
    @Override
    public boolean fire(IGameChar enemy, int attack) {
        System.out.printf("ほのおのいちげき！\n");
        return enemy.guard(      );   // 敵が耐えた結果を受け取る（生死）
    }
}
