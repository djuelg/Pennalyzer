package de.djuelg.pennalyzer.domain.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by djuelg on 27.04.17.
 */
public class Buyers {
    private final List<Buyer> buyers = new LinkedList<>();

    public Buyers(String buyers) {
        for (char buyer : buyers.toCharArray()) {
            this.buyers.add(new Buyer(buyer));
        }
    }

    public void shareAmount(PartialAmounts partialAmounts, Price price) {
        for (Buyer buyer : buyers) {
            buyer.pay(partialAmounts, price.sharedBy(buyers.size()));
        }
    }
}
