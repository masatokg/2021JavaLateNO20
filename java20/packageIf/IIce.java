package packageIf;
// こおりのモンスター用のインターフェース
public interface IIce extends IGameChar{
    // こおりのまほう攻撃の抽象メソッド
    public abstract boolean ice(IGameChar enemy, int attack);
}
