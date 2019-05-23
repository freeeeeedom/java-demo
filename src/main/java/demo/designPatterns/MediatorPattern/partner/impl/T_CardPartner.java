package demo.designPatterns.MediatorPattern.partner.impl;

import demo.designPatterns.MediatorPattern.partner.AbstractCardPartner;

public class T_CardPartner extends AbstractCardPartner {
    public T_CardPartner(int money) {
        super(money);
    }

    @Override
    public void win(int money) {
        this.money += money;
    }

    @Override
    public void lose(int money) {
        this.money -= money;
    }
}
