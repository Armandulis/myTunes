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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Arman
 */
public class EditSongController implements Initializable {

    @FXML
    private TextField textFieldTitle;
    @FXML
    private TextField textFieldArtist;
    @FXML
    private TextField textFieldTime;
    @FXML
    private ComboBox<String> ComboBoxCategory;
    @FXML
    private Button buttonClosefx;
    
    MainWindowController mwc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeComboBox();
    }    
    public void setMainViewCont(MainWindowController mwc){
        this.mwc=mwc;
    }
    
    private void makeComboBox(){
        ComboBoxCategory.getItems().add("Rap");
        ComboBoxCategory.getItems().add("Country");
        ComboBoxCategory.getItems().add("Pop");
        ComboBoxCategory.getItems().add("Rock");
        ComboBoxCategory.getItems().add("Metal");
        ComboBoxCategory.getItems().add("Jazz");
        ComboBoxCategory.getItems().add("Classic");
    }

    @FXML
    private void buttonSave(ActionEvent event) {
    }

    @FXML
    private void buttonCancel(ActionEvent event) {
            Stage stage = (Stage) buttonClosefx.getScene().getWindow();
            stage.close();
    }
    
}
