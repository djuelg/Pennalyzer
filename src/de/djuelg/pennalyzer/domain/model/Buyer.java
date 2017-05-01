package de.djuelg.pennalyzer.domain.model;

/**
 * Created by djuelg on 27.04.17.
 */
public class Buyer {
    private final char name;

    public Buyer(char name) {
        this.name = name;
    }

    public void pay(PartialAmounts partialAmounts, double euros) {
        partialAmounts.add(name, euros);
    }
}
