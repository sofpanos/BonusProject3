/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorresponsive;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import sun.audio.AudioPlayer;


/**
 *
 * @author Konstantinos
 */
public class FXMLDocumentController implements Initializable {
    //Controls
    @FXML
    private TextField display;
    @FXML
    private GridPane btnsGrid;
    @FXML
    private Button powerBtn;
    
    private final Calculator calculator = new Calculator();
    
    @FXML
    private void powerButtonClicked(ActionEvent e){
        btnsGrid.getChildren().forEach((node) ->{
            if(!node.getId().equals(powerBtn.getId())){
                node.setDisable(!node.disableProperty().get());
            }
        });
        resetButtonClicked(e);
    }
    
    @FXML
    private void resetButtonClicked(ActionEvent e){
        calculator.reset();
        displayText(calculator.getText());
    }
    
    @FXML
    private void equalsButtonClicked(ActionEvent e){
        calculator.resultButtonPushed();
        displayText(calculator.getText());
    }
    
    @FXML
    private void plusButtonClicked(ActionEvent e){
        calculator.operationButtonPushed(Operation.Addition);
        displayText(calculator.getText());
    }
    
    @FXML
    private void numberButtonClicked(ActionEvent e){
        calculator.pushNumberButton(((Button)e.getSource()).getText());
        displayText(calculator.getText());
    }
    
    @FXML
    private void minusButtonClicked(ActionEvent e){
        calculator.operationButtonPushed(Operation.Subtraction);
        displayText(calculator.getText());
    }
    
    @FXML
    private void multiplyButtonClicked(ActionEvent e){
        calculator.operationButtonPushed(Operation.Multiplication);
        displayText(calculator.getText());
    }
    
    @FXML
    private void divideButtonClicked(ActionEvent e){
        calculator.operationButtonPushed(Operation.Division);
        displayText(calculator.getText());
    }
    
    @FXML
    private void handleKeyPressed(KeyEvent e){
        switch(e.getCode()){
            case NUMPAD0:
            case DIGIT0:
                calculator.pushNumberButton("0");
                break;
            case NUMPAD1:
            case DIGIT1:
                calculator.pushNumberButton("1");
                break;
            case NUMPAD2:
            case DIGIT2:
                calculator.pushNumberButton("2");
                break;
            case NUMPAD3:
            case DIGIT3:
                calculator.pushNumberButton("3");
                break;
            case NUMPAD4:
            case DIGIT4:
                calculator.pushNumberButton("4");
                break;
            case NUMPAD5:
            case DIGIT5:
                calculator.pushNumberButton("5");
                break;
            case NUMPAD6:
            case DIGIT6:
                calculator.pushNumberButton("6");
                break;
            case NUMPAD7:
            case DIGIT7:
                calculator.pushNumberButton("7");
                break;
            case NUMPAD8:
            case DIGIT8:
                calculator.pushNumberButton("8");
                break;
            case NUMPAD9:
            case DIGIT9:
                calculator.pushNumberButton("9");
                break;
            case DIVIDE:
            case SLASH:
                calculator.operationButtonPushed(Operation.Division);
                break;
            case MULTIPLY:
            case STAR:
                calculator.operationButtonPushed(Operation.Multiplication);
                break;
            case ADD:
            case PLUS:
                calculator.operationButtonPushed(Operation.Addition);
                break;
            case SUBTRACT:
            case MINUS:
                calculator.operationButtonPushed(Operation.Subtraction);
                break;
            case PERIOD:
            case DECIMAL:
                calculator.pushNumberButton(".");
                break;
            default:
                break;
        }
        displayText(calculator.getText());
    }
    
   
    private void displayText(String text){
        if(text.length() > 15){
            display.setAlignment(Pos.CENTER_LEFT);
        }
        else{
            display.setAlignment(Pos.CENTER_RIGHT);
        }
        display.setText(text);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
