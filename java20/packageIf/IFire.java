package packageIf;
// ほのおのモンスター用のインターフェース
public interface IFire extends IGameChar{
    // ほのおのいちげき攻撃
    public abstract boolean fire(IGameChar enemy, int attack);
}
