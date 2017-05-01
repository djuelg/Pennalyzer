package de.djuelg.pennalyzer.domain.model;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by djuelg on 27.04.17.
 */
public class PartialAmounts {
    private final Map<Character, Double> partialAmounts = new HashMap<>();

    public void add(char buyer, double euros) {
        partialAmounts.put(buyer, partialAmounts.getOrDefault(buyer, 0d) + euros);
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Es gibt %d Käufer.\r\n\n", partialAmounts.size()));
        for (char buyer : partialAmounts.keySet()) {
            sb.append(String.format("Käufer %s bezahlt %s€\r\n",
                            buyer, new DecimalFormat("0.00").format(partialAmounts.get(buyer))));
        }
        return sb.toString();
    }
}
