package de.djuelg.pennalyzer.domain;

import java.util.Arrays;
import java.util.List;

import de.djuelg.pennalyzer.domain.model.Buyers;
import de.djuelg.pennalyzer.domain.model.Price;
import de.djuelg.pennalyzer.domain.model.Product;
import de.djuelg.pennalyzer.domain.model.Receipt;

/**
 * Created by djuelg on 27.04.17.
 */
public class ReceiptParser {
    private static final String NEWLINE = "(\n|\r\n)";
    private static final String NUMBER_FROM_LETTER = "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)";
    private static final String NUMERICAL = "^-?\\d+$";

    public static Receipt parse(String text) {
        List<String> lines = Arrays.asList(text.split(NEWLINE));
        Receipt receipt = new Receipt();
        lines.stream().map(s -> s.split(NUMBER_FROM_LETTER))
                .filter(strings -> strings.length == 2)
                .filter(strings -> strings[0].matches(NUMERICAL))
                .forEach(strings -> receipt.addProduct(
                        new Product(
                                new Price(strings[0]),
                                new Buyers(strings[1]))));
        return receipt;
    }
}
