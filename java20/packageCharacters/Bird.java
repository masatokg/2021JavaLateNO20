package packageCharacters;
import java.util.*;

import packageIf.IGameChar;
import packageIf.IStorm;
public class Bird extends GameChar implements IStorm{
    public static final String CNAME="怪鳥";
    // 通常攻撃の基準値
    public static final int ATTACK_NORMAL = 0;
    // スーパー攻撃の分母
    public static final int ATTACK_SUPER_RATIO = 5;
    // 算出用の基本値。DAMAGE_BASEは申し訳ない、未使用です。
    public static final int DAMAGE_BASE = 10;
    public static final int DAMAGE_SUPER = 3;
    private static int count = 0; // 同種族カウント
    
    // コンストラクタ
    public Bird(){
        this.cName =          +"その"+(++count); // キャラクタ名。他キャラを参考にしてください 
        this.newMsg();  // 登場メッセージ
        this.init();    // 初期化処理
    }
    // キャラクターごとに内容が違うスーパー攻撃
    @Override
    public boolean superAttack(IGameChar enemy, int attack) {
        // ものすごいはばたきをよびだす
        return this.storm(enemy, attack);
    }
    // 怪鳥の初期化処理
    @Override
    protected void init() {
        this.attackNormal = ATTACK_NORMAL;   // 通常攻撃の時の判定値。
        this.attackSuperRatio = ATTACK_SUPER_RATIO; // スーパー攻撃判定の分母
        // this.damageBase = DAMAGE_BASE; // 申し訳ない、未使用です
        this.damageSuper = DAMAGE_SUPER;    // スーパー攻撃のダメージ算出用値
        this.hp = MAX_HP;   // HPを強めにMAX値で設定
        this.gp = MAX_GP;    // HPを強めにMAX値で設定
    }
    // ものすごいはばたき
    @Override
    public boolean storm(IGameChar enemy, int attack) {
        System.out.printf("ものすごいはばたき！\n");
        return enemy.       (attack);   // 敵が耐えた結果を受け取る（生死）
    }
}
