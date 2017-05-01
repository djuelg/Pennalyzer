package de.djuelg.pennalyzer.domain.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by djuelg on 27.04.17.
 */
public class Receipt {

    private final List<Product> products;

    public Receipt() {
        this.products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public String calculatePartialAmounts() {
        PartialAmounts partialAmounts = new PartialAmounts();
        for (Product product : products) {
            product.addAmountPerBuyer(partialAmounts);
        }
        return partialAmounts.display();
    }
}
