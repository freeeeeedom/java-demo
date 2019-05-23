package demo.designPatterns.MediatorPattern.mediator;

import demo.designPatterns.MediatorPattern.partner.AbstractCardPartner;

public class MediatorPartner {

    public static void aWin(AbstractCardPartner a, AbstractCardPartner b, int money) {
        a.win(money);
        b.lose(money);
    }

    public static void bWin(AbstractCardPartner a, AbstractCardPartner b, int money) {
        b.win(money);
        a.lose(money);
    }
}
