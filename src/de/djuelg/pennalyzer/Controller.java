package de.djuelg.pennalyzer;

import de.djuelg.pennalyzer.domain.ReceiptParser;
import de.djuelg.pennalyzer.domain.model.Receipt;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML
    private TextArea products;
    @FXML
    private TextArea result;

    public void handleCalculationAction() {
        Receipt receipt = ReceiptParser.parse(products.getText());
        result.setText(receipt.calculatePartialAmounts());
    }
}
