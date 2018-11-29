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

/**
 * FXML Controller class
 *
 * @author Konstantinos
 */
public class FXMLCalculatorController implements Initializable {

    @FXML
    private TextField display;
    @FXML
    private GridPane btnsGrid;
    @FXML
    private Button powerBtn;

    @FXML
    private void signButtonClicked(ActionEvent e) {
        CalculatorResponsive.CALCULATOR.signNumberButtonPushed();
        displayText(CalculatorResponsive.CALCULATOR.getText());
    }

    @FXML
    private void sqrtButtonClicked(ActionEvent e) {
        CalculatorResponsive.CALCULATOR.operationButtonPushed(Operation.SqrRoot);
        displayText(CalculatorResponsive.CALCULATOR.getText());
    }

    @FXML
    private void sinButtonClicked(ActionEvent e) {
        CalculatorResponsive.CALCULATOR.operationButtonPushed(Operation.Sin);
        displayText(CalculatorResponsive.CALCULATOR.getText());
    }

    @FXML
    private void cosinButtonClicked(ActionEvent e) {
        CalculatorResponsive.CALCULATOR.operationButtonPushed(Operation.Cosin);
        displayText(CalculatorResponsive.CALCULATOR.getText());
    }

    @FXML
    private void tanButtonClicked(ActionEvent e) {
        CalculatorResponsive.CALCULATOR.operationButtonPushed(Operation.Tan);
        displayText(CalculatorResponsive.CALCULATOR.getText());
    }

    @FXML
    private void logButtonClicked(ActionEvent e) {
        CalculatorResponsive.CALCULATOR.operationButtonPushed(Operation.Log);
        displayText(CalculatorResponsive.CALCULATOR.getText());
    }

    @FXML
    private void powerButtonClicked(ActionEvent e) {
        btnsGrid.getChildren().forEach((node) -> {
            if (!node.getId().equals(powerBtn.getId())) {
                node.setDisable(!node.disableProperty().get());
            }
        });
        resetButtonClicked(e);
    }

    @FXML
    private void resetButtonClicked(ActionEvent e) {
        CalculatorResponsive.CALCULATOR.reset();
        displayText(CalculatorResponsive.CALCULATOR.getText());
    }

    @FXML
    private void equalsButtonClicked(ActionEvent e) {
        CalculatorResponsive.CALCULATOR.resultButtonPushed();
        displayText(CalculatorResponsive.CALCULATOR.getText());
    }

    @FXML
    private void plusButtonClicked(ActionEvent e) {
        CalculatorResponsive.CALCULATOR.operationButtonPushed(Operation.Addition);
        displayText(CalculatorResponsive.CALCULATOR.getText());
    }

    @FXML
    private void numberButtonClicked(ActionEvent e) {
        CalculatorResponsive.CALCULATOR.pushNumberButton(((Button) e.getSource()).getText());
        displayText(CalculatorResponsive.CALCULATOR.getText());
    }

    @FXML
    private void minusButtonClicked(ActionEvent e) {
        CalculatorResponsive.CALCULATOR.operationButtonPushed(Operation.Subtraction);
        displayText(CalculatorResponsive.CALCULATOR.getText());
    }

    @FXML
    private void multiplyButtonClicked(ActionEvent e) {
        CalculatorResponsive.CALCULATOR.operationButtonPushed(Operation.Multiplication);
        displayText(CalculatorResponsive.CALCULATOR.getText());
    }

    @FXML
    private void divideButtonClicked(ActionEvent e) {
        CalculatorResponsive.CALCULATOR.operationButtonPushed(Operation.Division);
        displayText(CalculatorResponsive.CALCULATOR.getText());
    }

    @FXML
    private void handleKeyPressed(KeyEvent e) {
        switch (e.getCode()) {
            case NUMPAD0:
            case DIGIT0:
                CalculatorResponsive.CALCULATOR.pushNumberButton("0");
                break;
            case NUMPAD1:
            case DIGIT1:
                CalculatorResponsive.CALCULATOR.pushNumberButton("1");
                break;
            case NUMPAD2:
            case DIGIT2:
                CalculatorResponsive.CALCULATOR.pushNumberButton("2");
                break;
            case NUMPAD3:
            case DIGIT3:
                CalculatorResponsive.CALCULATOR.pushNumberButton("3");
                break;
            case NUMPAD4:
            case DIGIT4:
                CalculatorResponsive.CALCULATOR.pushNumberButton("4");
                break;
            case NUMPAD5:
            case DIGIT5:
                CalculatorResponsive.CALCULATOR.pushNumberButton("5");
                break;
            case NUMPAD6:
            case DIGIT6:
                CalculatorResponsive.CALCULATOR.pushNumberButton("6");
                break;
            case NUMPAD7:
            case DIGIT7:
                CalculatorResponsive.CALCULATOR.pushNumberButton("7");
                break;
            case NUMPAD8:
            case DIGIT8:
                CalculatorResponsive.CALCULATOR.pushNumberButton("8");
                break;
            case NUMPAD9:
            case DIGIT9:
                CalculatorResponsive.CALCULATOR.pushNumberButton("9");
                break;
            case DIVIDE:
            case SLASH:
                CalculatorResponsive.CALCULATOR.operationButtonPushed(Operation.Division);
                break;
            case MULTIPLY:
            case STAR:
                CalculatorResponsive.CALCULATOR.operationButtonPushed(Operation.Multiplication);
                break;
            case ADD:
            case PLUS:
                CalculatorResponsive.CALCULATOR.operationButtonPushed(Operation.Addition);
                break;
            case SUBTRACT:
            case MINUS:
                CalculatorResponsive.CALCULATOR.operationButtonPushed(Operation.Subtraction);
                break;
            case PERIOD:
            case DECIMAL:
                CalculatorResponsive.CALCULATOR.pushNumberButton(".");
                break;
            default:
                break;
        }

        displayText(CalculatorResponsive.CALCULATOR.getText());
    }

    public void displayText(String text) {
        if (text.length() > 15) {
            display.setAlignment(Pos.CENTER_LEFT);
        } else {
            display.setAlignment(Pos.CENTER_RIGHT);
        }
        display.setText(text);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
