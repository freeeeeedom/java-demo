package demo.designPatterns.MediatorPattern.partner;

public abstract class AbstractCardPartner {
    protected int money;

    public AbstractCardPartner(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public abstract void win(int money);

    public abstract void lose(int money);
}
