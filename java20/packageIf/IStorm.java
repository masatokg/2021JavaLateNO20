package packageIf;
// かぜのモンスター用のインターフェース
public interface IStorm extends IGameChar{
    // ものすごいはばたき攻撃の抽象メソッド
    public abstract boolean storm(IGameChar enemy, int attack);
}
