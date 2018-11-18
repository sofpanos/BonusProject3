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
    
    
    public Calculator(){
        
    }
    
    public void signNumberButtonPushed(){
        if(displayText.startsWith("-")){
            displayText = displayText.substring(1);
        }
        else{
            displayText = "-" + displayText;
        }
    }
    
    public void pushNumberButton(String buttonText){
        if(result){
            displayText = "";
            result = false;
        }
        if(buttonText.equals(".")){
            if(!displayText.contains(".")){
                if(displayText.length() == 0 || displayText.equals("0")){
                    displayText = "0.";
                }
                else{
                    displayText += ".";
                }
            }
        }
        else if(displayText.equals("0")){
            displayText = buttonText;
        }
        else{
            displayText += buttonText;
        }
    }
    
    public void operationButtonPushed(Operation op){
        if(result){
            doOperation(Double.parseDouble(displayText), op, currentAmount);
        }
        else if(currentOperation != null){
            doOperation(previousAmount, currentOperation, Double.parseDouble(displayText));
        }
        else if(op == Operation.Log || op == Operation.SqrRoot || op == Operation.Sin 
                || op == Operation.Cosin || op == Operation.Tan){
            doOperation(Double.parseDouble(displayText), op, currentAmount);
        }
        else{
            previousAmount = Double.parseDouble(displayText);
            displayText = "";
            currentOperation = op;
        }
        
    }
    
    public void resultButtonPushed(){
        if(result){
            doOperation(Double.parseDouble(displayText), currentOperation, currentAmount);
        }
        else{
            if(displayText.length() != 0){
                doOperation(previousAmount, currentOperation, Double.parseDouble(displayText));
            }
            else{
                doOperation(previousAmount, currentOperation, previousAmount);
            }
        }
    }
    
    public String getText(){
        showPretty();
        return displayText;
    }
    
    private void doOperation(double amount1, Operation operation, double amount2){
        if(operation == null){
            return;
        }
        switch(operation){
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
    
    private void showPretty(){
        if(displayText.length() != 0 && !displayText.endsWith(".")){
            double amount = Double.parseDouble(displayText);
            if((amount * 10) % 10 == 0){
                displayText = ((int)amount) + "";
            }
        }
    }
    
    public void reset(){
        displayText = "";
        currentAmount = 0;
        currentOperation = null;
        previousAmount = 0;
        result = false;
    }
}
