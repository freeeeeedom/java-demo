package demo.designPatterns.MediatorPattern.partner.impl;

import demo.designPatterns.MediatorPattern.partner.AbstractCardPartner;

public class S_CardPartner extends AbstractCardPartner {
    public S_CardPartner(int money) {
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
