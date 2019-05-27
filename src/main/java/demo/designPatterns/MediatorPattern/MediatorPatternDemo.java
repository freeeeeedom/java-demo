package demo.designPatterns.MediatorPattern;

import demo.designPatterns.MediatorPattern.mediator.MediatorPartner;
import demo.designPatterns.MediatorPattern.partner.AbstractCardPartner;
import demo.designPatterns.MediatorPattern.partner.impl.F_CardPartner;
import demo.designPatterns.MediatorPattern.partner.impl.S_CardPartner;
import demo.designPatterns.MediatorPattern.partner.impl.T_CardPartner;

/**
 * 中介模式
 * @author: Nevernow
 * @Date: 9:37 2019/5/23
 */ 
public class MediatorPatternDemo {
    public static void main(String[] args) {
        AbstractCardPartner p1 = new F_CardPartner(100);
        AbstractCardPartner p2 = new S_CardPartner(200);
        AbstractCardPartner p3 = new T_CardPartner(300);
        AbstractCardPartner p4 = new F_CardPartner(500);
        showAllMoney(p1, p2, p3, p4);
        MediatorPartner.aWin(p1, p2, 100);
        System.out.println("p1 win p2 500");
        showAllMoney(p1, p2, p3, p4);
    }

    private static void showAllMoney(AbstractCardPartner... p) {
        for (int i = 0; i < p.length; i++) {
            System.out.println("p" + (i + 1) + " " + p[i].getMoney());
        }
    }
}
