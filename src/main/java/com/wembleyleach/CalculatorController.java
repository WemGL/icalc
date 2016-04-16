package com.wembleyleach;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {

    private float firstOperand = 0;
    private String operator = "";
    private boolean start = true;
    private boolean addedDecimal = false;

    private Calculator calculator = new Calculator();

    @FXML
    private Label screen;

    @FXML
    public void processNumbers(ActionEvent actionEvent) {
        initCalculator();
        String value = ((Button) actionEvent.getSource()).getText();
        screen.setText(screen.getText() + value);
    }

    @FXML
    public void processOperators(ActionEvent actionEvent) {
        String value = ((Button) actionEvent.getSource()).getText();

        if(!value.equals("=")) {
            if(!operator.isEmpty()) return;

            operator = value;
            String screenText = screen.getText();
            firstOperand = Float.parseFloat(screenText);
            screen.setText("");
        } else {
            if(operator.isEmpty())
                return;

            float secondOperand = Float.parseFloat(screen.getText());
            float result = calculator.calculate(firstOperand, secondOperand, operator);
            screen.setText(String.valueOf(result));

            operator = "";
            start = true;
        }
        addedDecimal = false;
    }

    @FXML
    public void processNegation(ActionEvent actionEvent) {
        if (!screen.getText().isEmpty()) {
            float currentValue = Float.parseFloat(screen.getText());
            float negatedCurrentValue = calculator.negate(currentValue);
            screen.setText(String.valueOf(negatedCurrentValue));
        }
    }

    @FXML
    public void processPercentage(ActionEvent actionEvent) {
        if(!screen.getText().isEmpty()) {
            float currentValue = Float.parseFloat(screen.getText());
            float percentage = calculator.convertToPercentage(currentValue);
            screen.setText(String.valueOf(percentage));
        }
    }

    @FXML
    public void clearScreen(ActionEvent actionEvent) {
        start = true;
        addedDecimal = false;
        firstOperand = 0;
        operator = "";
        screen.setText("0");
    }

    @FXML
    public void appendDecimal(ActionEvent actionEvent) {
        initCalculator();
        if (addedDecimal) return;
        screen.setText(screen.getText() + ".");
    }

    private void initCalculator() {
        if (start) {
            screen.setText("");
            start = false;
        }
    }
}
