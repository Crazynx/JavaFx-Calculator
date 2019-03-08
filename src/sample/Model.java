package sample;

public class Model {

    public static int calculate(int numberOne, int numberTwo, String operator) {

        switch (operator) {
            case "x":
                return numberOne * numberTwo;
            case "+":
                return numberOne + numberTwo;
            case "-":
                return numberOne - numberTwo;
            case "/":
                return numberOne / numberTwo;
            default:
                return 0;
        }
    }
}
