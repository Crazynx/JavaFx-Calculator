package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label result;

    private boolean isFirstInput = true;
    private int numberOne = 0;
    private int numberTwo = 0;
    private String operator = "";

    @FXML
    public void processNumber(ActionEvent event) {
        if (isFirstInput) {
            result.setText("");
            isFirstInput = false;
        }
        String valueOfResult = ((Button)event.getSource()).getText();
        result.setText(result.getText() + valueOfResult);
    }

    @FXML
    public void processOperator(ActionEvent event) {
        String valueOfOperator = ((Button)event.getSource()).getText();
        if (!valueOfOperator.equals("=")) {
            if (!operator.isEmpty()) {
                return;
            } else {
                System.out.println("ddddd");
                operator = valueOfOperator;
                numberOne = Integer.parseInt(result.getText());
                result.setText("");
            }
        } else {
            if (operator.isEmpty()) {
                return;
            } else { // do the final task, calculation
                numberTwo = Integer.parseInt(result.getText());
                System.out.println(numberTwo + " number two");
                int output = Model.calculate(numberOne, numberTwo, operator);
                result.setText(Integer.toString(output));

                isFirstInput = true;
                operator = "";
            }
        }
    }
}
