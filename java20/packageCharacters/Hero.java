package packageCharacters;

import packageIf.IGameChar;
import packageIf.IHero;

// ヒーロークラス
public class Hero extends GameChar implements IHero{
    public static final String CNAME="ヒーロー";
    // スーパー攻撃の分母
    public static final int ATTACK_SUPER_RATIO = 3;
    // 算出用の基本値。DAMAGE_BASEは申し訳ない、未使用です。
    public static final int DAMAGE_BASE = 15;
    public static final int DAMAGE_SUPER = 2;
    
    // ヒーローのコンストラクタ
    public Hero(){
        this.cName = CNAME;
        this.newMsg();  // 登場メッセージ
        this.init();    // 初期化処理
    }

    // キャラクターごとに内容が違うスーパー攻撃
    @Override
    public boolean superAttack(IGameChar enemy, int attack) {
        // かいしんのいちげきをよびだす
        return this.superHit(enemy, attack); 
    }

    // キャラクターの初期化
    @Override
    protected void init() {
        this.attackNormal = ;   // 通常攻撃の時の判定値。ほかのキャラクターを見てください。
        this.attackSuperRatio = ATTACK_SUPER_RATIO; // スーパー攻撃判定の分母
        // this.damageBase = DAMAGE_BASE; // 申し訳ない、未使用です
        this.damageSuper = DAMAGE_SUPER;    // スーパー攻撃のダメージ算出用値
        this.hp = (int)(MAX_HP*1.5);    // ヒーローは複数相手に戦うので強めに調整
        this.gp = (int)(MAX_GP*1.5);    // ヒーローは複数相手に戦うので強めに調整
    }

    // スーパー攻撃（かいしんのいちげき）
    @Override
    public boolean superHit(IGameChar enemy, int attack) {
        System.out.printf("かいしんのいちげき！ %d\n", attack);
        return enemy.guard(attack);  // 敵が耐えた結果を受け取る（生死）
    }

    @Override
    public void gameSave() {
        // 保存ボタン（今回は実装しない）        
    }    
}
