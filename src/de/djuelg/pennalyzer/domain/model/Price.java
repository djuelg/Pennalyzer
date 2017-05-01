package de.djuelg.pennalyzer.domain.model;

/**
 * Created by djuelg on 27.04.17.
 */
public class Price {
    private final double cents;

    public Price(String cents) {
        this.cents = Double.valueOf(cents);
    }

    public double sharedBy(int size) {
        return cents / size / 100;
    }
}
