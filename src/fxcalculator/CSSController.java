/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CSSController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label label;
    private long number1 = 0;
    private long number2 = 0;
    private String operator = "";
    private boolean start = true;
    private boolean isClear = false;
    
    Model model = new Model();
    @FXML
    private Button clear;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void processNumber(ActionEvent event) {
        if(start){
            label.setText("");
            start = false;
        }
        if(event.getSource()!= clear){
            String value = ((Button)event.getSource()).getText();
            label.setText(label.getText()+ value);
        }
        
    }

    @FXML
    private void processOperators(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        if(!value.equals("=")){
            if(!operator.isEmpty()){
                return;
            }
            operator = value;
            number1 = Long.parseLong(label.getText());
            label.setText("");
        }
        else{
             if(operator.isEmpty()){
                return;
            }
             number2 = Long.parseLong(label.getText());
             float output = model.calculate(number1, number2,operator);
             label.setText(String.valueOf(output));
             operator = "";
        }
    }

    @FXML
    private void processClear(ActionEvent event) {
        if(event.getSource() == clear){
            number1 = 0;
            number2 = 0;
            label.setText("");
        }
    }
    
}
