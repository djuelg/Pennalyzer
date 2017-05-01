package de.djuelg.pennalyzer.domain.model;

/**
 * Created by djuelg on 27.04.17.
 */
public class Product {
    private final Price price;
    private final Buyers buyers;

    public Product(Price price, Buyers buyers) {
        this.price = price;
        this.buyers = buyers;
    }

    public void addAmountPerBuyer(PartialAmounts partialAmounts) {
        buyers.shareAmount(partialAmounts, price);
    }
}
