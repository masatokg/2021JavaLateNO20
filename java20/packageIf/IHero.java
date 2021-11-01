package packageIf;
public interface IHero extends IGameChar {
    public abstract boolean superHit(IGameChar enemy, int attack);
    public abstract void gameSave();
}
