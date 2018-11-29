/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorresponsive;

/**
 *
 * @author Konstantinos
 */
public class Calculator {

    private String displayText = "0";
    private double previousAmount = 0;
    private double currentAmount = 0;
    private Operation currentOperation = null;
    private boolean result = false;

    public Calculator() {

    }

    public void signNumberButtonPushed() {
        if (displayText.startsWith("-")) {
            displayText = displayText.substring(1);
        } else {
            displayText = "-" + displayText;
        }
        showPretty();
    }

    public void pushNumberButton(String buttonText) {
        if (result) {
            displayText = "";
            result = false;
        }
        if (buttonText.equals(".")) {
            if (!displayText.contains(".")) {
                if (displayText.length() == 0 || displayText.equals("0")) {
                    displayText = "0.";
                } else {
                    displayText += ".";
                }
            }
        } else if (displayText.equals("0")) {
            displayText = buttonText;
        } else {
            displayText += buttonText;
        }
    }

    public void operationButtonPushed(Operation op) {
        if (result) {
            doOperation(Double.parseDouble(displayText), op, currentAmount);
        } else if (currentOperation == null) {
            previousAmount = Double.parseDouble(displayText);
            displayText = "";
            currentOperation = op;
        } else if (currentOperation != null) {
            if (displayText.length() == 0) {
                doOperation(previousAmount, currentOperation, previousAmount);
            } else {
                doOperation(previousAmount, currentOperation, Double.parseDouble(displayText));
            }
            currentOperation = op;
        }
        showPretty();
    }

    public void resultButtonPushed() {
        if (result) {
            doOperation(Double.parseDouble(displayText), currentOperation, currentAmount);
        } else {
            if (displayText.length() != 0) {
                doOperation(previousAmount, currentOperation, Double.parseDouble(displayText));
            } else {
                doOperation(previousAmount, currentOperation, previousAmount);
            }
        }
        showPretty();
    }

    public String getText() {

        return displayText;
    }

    private void doOperation(double amount1, Operation operation, double amount2) {
        if (operation == null) {
            return;
        }
        switch (operation) {
            case Addition:
                displayText = (amount1 + amount2) + "";
                currentAmount = amount2;
                break;
            case Subtraction:
                displayText = (amount1 - amount2) + "";
                currentAmount = amount2;
                break;
            case Multiplication:
                displayText = (amount1 * amount2) + "";
                currentAmount = amount2;
                break;
            case Division:
                displayText = (amount1 / amount2) + "";
                currentAmount = amount2;
                break;
            case Sin:
                displayText = Math.sin(amount1) + "";
                break;
            case Cosin:
                displayText = Math.cos(amount1) + "";
                break;
            case Tan:
                displayText = Math.tan(amount1) + "";
                break;
            case SqrRoot:
                displayText = Math.sqrt(amount1) + "";
                break;
            default:
                break;
        }
        currentOperation = operation;
        result = true;
    }

    private void showPretty() {
        if (displayText.length() != 0 && displayText.endsWith(".0")) {
            double amount = Double.parseDouble(displayText);
            displayText = ((long) amount) + "";
        }
    }

    public void reset() {
        displayText = "0";
        currentAmount = 0;
        currentOperation = null;
        previousAmount = 0;
        result = false;
    }
}
