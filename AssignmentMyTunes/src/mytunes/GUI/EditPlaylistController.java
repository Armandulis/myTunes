/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Arman
 */
public class EditPlaylistController implements Initializable {

    @FXML
    private TextField textFieldName;
    @FXML
    private Button closebutton;
    
    MainWindowController mwc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setMainViewCont(MainWindowController mwc){
        this.mwc=mwc;
    }

    @FXML
    private void buttonSave(ActionEvent event) {
    }

    @FXML
    private void buttonCancel(ActionEvent event) {
          Stage stage = (Stage) closebutton.getScene().getWindow();
            stage.close();
    }
    
    
    
    
    
    
}
