package packageCharacters;
import packageIf.*;
import java.util.*;
// ゲームキャラクターの抽象クラス。IGameCharインターフェースを実装
public abstract class GameChar implements IGameChar{
    // 通常攻撃の判定値（定数）
    public static final int ATTACK_NORMAL = 0;
    // 通常攻撃の判定値（変数）
    protected int attackNormal=0;
    // スーパー攻撃の判定割合値（変数）
    protected int attackSuperRatio = 5;
    // ダメージの計算基本値
    protected int damageBase = 10;
    // ダメージの計算基本値
    protected int damageSuper = 3;

    // HP最大値
    protected static int MAX_HP=100;
    // GP最大値
    protected static int MAX_GP=10;
    protected int hp;   // HP変数
    protected int gp;   // GP変数
    protected String cName; // キャラクター名
    protected boolean isDead; // 死亡フラグ true==死亡

    // 死亡フラグを返す
    public boolean isDead(){return this.isDead;};
    // キャラクターの各表示メッセージ
    public void newMsg(){ System.out.printf("%sがあらわれた！\n", cName);};
    public void attackMsg(){ System.out.printf("%sのこうげき！\n", cName);};
    public void gurdMsg(){ System.out.printf("%sはみをまもった！", cName);};
    public void damageMsg(){ System.out.printf("%dのダメージ！\n", cName);};
    public void endMsg(){ System.out.printf("%sは死んでしまった！\n", cName);};

    // ステータスを表示するメッセージ
    public void statusMsg(){ 
        if(hp<=0){ System.out.printf("【DEAD】");}  // HP<=0の時だけ頭につける
        System.out.printf("%s HP:%d GP:%d", cName, hp, gp);
        System.out.printf("\n");
    };
    // キャラクターインスタンスの初期かメソッド
    protected abstract void init();

    // 攻撃メソッド。引数は攻撃対象のインスタンス
    @Override
    public boolean attack(IGameChar enemy) {
        boolean rt; // 攻撃結果の戻り値
        System.out.printf("%s のこうげき！ HP:%d \n", this.cName, this.hp);
        // スパー攻撃をするか 0～this.attackSuperRatio の乱数で決める。
        int rdm = new Random().nextInt(this.attackSuperRatio);
        // 攻撃値を算出する。(0～HPの半分)+1 で算出
        int attack = new Random().nextInt((this.hp/2)+1);
        if(rdm==this.attackNormal){ // 乱数が0なら通常攻撃
            rt = enemy.guard(      ); // 攻撃値を与えて敵にガードさせる
        }else{ // その他はスパー攻撃。攻撃値はthis.damageSuperの倍数
            rt = this.superAttack(enemy, attack*this.damageSuper);
        }
        return rt;
    }
    // 回復処理メソッド
    @Override
    public void recover() {
        // 回復値を 0～this.hp(現在のHP)の範囲の乱数で算出する
        int recover = new Random().nextInt(this.hp);
        // 回復値を調整
        if(recover>=MAX_HP){recover=MAX_HP;}
        System.out.printf("しかし %d のかいふく！\n", recover);
    }

    // 攻撃に対して身構えて耐えるメソッド処理。引数は攻撃値
    @Override
    public boolean guard(int num) {
        System.out.printf("%sは%d のこうげきを受けた！ ", this.cName, num);
        // 攻撃値 - GP でダメージの乱数の最大値 bound を取得
        int bound = (num - this.gp);
        bound = (bound>0? bound:1); // bound 0 は許されないので調整
        // ダメージ値を 0～bound の乱数で取得
        int damage = new Random().nextInt(bound);
        if(damage<=0){damage=0;} // ダメージ値はマイナスにならないよう調整 
        this.gurdMsg(); // 身構えるメッセージ
        System.out.printf("%d のダメージ！\n", damage);
        this.hp -= damage;  // 現在のHPからダメージ値を引く
        // もしHPが0以下になったら、死亡フラグを立ててメッセージを表示、フラグをリターン
        if(this.hp<=0){this.isDead=true;this.endMsg();return this.isDead;}
        else{ this.recover(); } // 死んでなければ、回復を試みる
        return this.isDead; // 生死をリターン
    }
}
