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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Konstantinos
 */
public class CalculatorResponsive extends Application {
    
    private static final Number MEDIUM_WIDTH = 195;
    
    private static final Number LARGE_WIDTH = 255;
    
    public static final Calculator CALCULATOR = new Calculator();
    
    private static Scene LargeScene;
    private static Scene MediumScene;
    private static Scene SmallScene;

    
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
        
        stage.setScene(scene);
        stage.show();
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
