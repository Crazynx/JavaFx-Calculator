package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label result; // label for result output

    private boolean isFirstInput = true;
    private int numberOne = 0;
    private int numberTwo = 0;
    private int output;
    private String operator = "";

    @FXML
    public void processNumber(ActionEvent event) {
        if (isFirstInput) { // first time input
            result.setText("");
            isFirstInput = false;
        }
        String valueOfResult = ((Button)event.getSource()).getText();
        result.setText(result.getText() + valueOfResult);
    }

    @FXML
    public void processOperator(ActionEvent event) {
        String selectedOperator = ((Button)event.getSource()).getText();
        if (!selectedOperator.equals("=")) { // if the operator is '+', '-', '/' or 'x'
            if (!operator.isEmpty()) {
                return;
            } else {
                numberOne = Integer.parseInt(result.getText().split("\\D", 0)[0]);
                System.out.println(numberOne);
                operator = selectedOperator;
                result.setText(result.getText() + operator);
            }
        } else { // if the operator is '='
            if (operator.isEmpty()) {
                return;
            } else {
                numberTwo = Integer.parseInt(result.getText().split("\\D", 0)[1]);
                output = Model.calculate(numberOne, numberTwo, operator);
                result.setText(result.getText() + " = " + output);

                isFirstInput = true;
                operator = "";
            }
        }
    }
}
