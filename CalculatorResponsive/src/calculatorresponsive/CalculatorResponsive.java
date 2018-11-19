/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorresponsive;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Konstantinos
 */
public class CalculatorResponsive extends Application {
    
    private static final Number MEDIUM_WIDTH = 182;
    
    private static final Number LARGE_WIDTH = 261;
    
    public static final Calculator CALCULATOR = new Calculator();
    
    public static Scene LargeScene;
    public static Scene MediumScene;
    public static Scene SmallScene;

    
    @Override
    public void start(Stage stage) throws Exception {
        MediumScene = new Scene(FXMLLoader.load(getClass().getResource("FXMLDocumentMedium.fxml")));
        LargeScene = new Scene(FXMLLoader.load(getClass().getResource("FXMLDocumentLarge.fxml")));
        SmallScene = new Scene(FXMLLoader.load(getClass().getResource("FXMLDocumentSmall.fxml")));
        
        
        
        Scene scene = MediumScene;
        stage.widthProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Number newWidth = null;//For compiler satisfaction!
                if(newValue instanceof Number){
                    newWidth = (Number) newValue;
                }
                Scene newScene = null;
                if(newWidth == null){
                    return;
                }
                if(newWidth.doubleValue() > LARGE_WIDTH.intValue()){
                    newScene = LargeScene;
                }
                else if(newWidth.doubleValue() > MEDIUM_WIDTH.intValue()){
                    newScene = MediumScene;
                }
                else{
                    newScene = SmallScene;
                }
                
                stage.setScene(newScene);
                stage.show();
            }
        });
        stage.sceneProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                TextField display = (TextField)((Scene)newValue).lookup("#display");
                CalculatorResponsive.displayText(display, CalculatorResponsive.CALCULATOR.getText());
            }
        
        });
        stage.setScene(scene);
        stage.show();
    }
    
    private static void displayText(TextField display, String text){
        if(text.length() > 15){
            display.setAlignment(Pos.CENTER_LEFT);
        }
        else{
            display.setAlignment(Pos.CENTER_RIGHT);
        }
        display.setText(text);
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
