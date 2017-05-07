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
        sb.append(String.format("Es gibt %d Käufer.\r\n", partialAmounts.size()));
        sb.append(String.format("Die Summe beträgt %s€\r\n\r\n",
                new DecimalFormat("0.00").format(totalCosts())));
        for (char buyer : partialAmounts.keySet()) {
            sb.append(String.format("Käufer %s bezahlt %s€\r\n",
                            buyer, new DecimalFormat("0.00").format(partialAmounts.get(buyer))));
        }
        return sb.toString();
    }

    private double totalCosts() {
        double totalCosts = 0;
        for (char key : partialAmounts.keySet()) {
            totalCosts += partialAmounts.get(key);
        }
        return totalCosts;
    }
}
