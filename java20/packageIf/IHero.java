package packageIf;
// ヒーロー用のインターフェース
public interface IHero extends IGameChar {
    // かいしんのいちげき攻撃の抽象メソッド
    public abstract boolean superHit(IGameChar enemy, int attack);
    // 保存ボタン。未定義
    public abstract void gameSave();
}
