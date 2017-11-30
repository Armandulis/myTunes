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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mytunes.BE.Songs;

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
    private ComboBox<String> ComboBoxCategory;
    @FXML
    private TextField textFieldFile;
    @FXML
    private Button buttonChoose;
    @FXML
    private Button buttonClosefx;
    
    MainWindowController mwc;
        
        Songs song = new Songs();
    @FXML
    private Label labelError;
    

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
   
    
    private void makeSongsList(){
       
        song.setArtist(textFieldArtist.getText());
        song.setCategory(ComboBoxCategory.getValue());
        song.setTime(textFieldTime.getText());
        song.setTitle(textFieldTitle.getText());
        song.setFile(textFieldFile.getText());
        mwc.getAllSongsAdded(song);
        
    }
     

    @FXML
    private void buttonSave(ActionEvent event) {
        if(textFieldArtist.equals("") && ComboBoxCategory.equals("") && ComboBoxCategory.equals("") && textFieldTime.equals("") & textFieldTitle.equals("")){
        makeSongsList();
        Stage stage = (Stage) buttonClosefx.getScene().getWindow();
        stage.close();}
        else { labelError.setText("Please fill in all the fields!");}
        
    }

    @FXML
    private void buttonCancel(ActionEvent event) {
            Stage stage = (Stage) buttonClosefx.getScene().getWindow();
            stage.close();
    }
    
}
