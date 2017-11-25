/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import newpackage.BLL.PlaySongs;

/**
 *
 * @author Arman
 */
public class MainWindowController implements Initializable {

    @FXML
    private ListView<?> listSongs;
    @FXML
    private ListView<?> listPlaylists;
    @FXML
    private ListView<?> listSongsInPlaylist;
    @FXML
    private Label labelCurrentSong;
    @FXML
    private TextField textFieldSearch;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonNewPlaylist(ActionEvent event) throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewPlaylist.fxml"));
        Parent root1 = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void buttonEditPlaylist(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditPlaylist.fxml"));
        Parent root1 = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void buttonDeletePlaylist(ActionEvent event) {
    }

    @FXML
    private void buttonNewSong(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewSong.fxml"));
        Parent root1 = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void buttonEditSong(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditSong.fxml"));
        Parent root1 = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void buttonDeleteSong(ActionEvent event) {
    }

    @FXML
    private void buttonClose(ActionEvent event) {
    }

    @FXML
    private void buttonDeleteSongFromList(ActionEvent event) {
    }

    @FXML
    private void buttonMoveSongUp(ActionEvent event) {
    }

    @FXML
    private void buttonMoveSongDown(ActionEvent event) {
    }

    @FXML
    private void buttonAddSong(ActionEvent event) {
    }


    @FXML
    private void dragVolume(MouseEvent event) {
    }

    @FXML
    private void buttonPreviuos(ActionEvent event) {
    }

    @FXML
    private void buttonPause(ActionEvent event) {
        PlaySongs playsongs = new PlaySongs();
        playsongs.playSong();
    }

    @FXML
    private void buttonNext(ActionEvent event) {
    }

    @FXML
    private void buttonSearch(ActionEvent event) {
    }
    
}
