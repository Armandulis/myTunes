/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Arman
 */
public class NewSongController implements Initializable {

    @FXML
    private TextField textFieldTitle;
    @FXML
    private TextField textFieldArtist;
    @FXML
    private TextField textFieldTime;
    @FXML
    private ComboBox<?> ComboBoxCategory;
    @FXML
    private TextField textFieldFile;
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonChoose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
