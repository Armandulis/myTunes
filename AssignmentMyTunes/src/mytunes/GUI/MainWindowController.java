/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mytunes.BE.Playlists;
import mytunes.BE.Songs;
import mytunes.BLL.MyTunesBLL;

/**
 *
 * @author Arman
 */
public class MainWindowController implements Initializable {
    @FXML
    private TextField textFieldSearch;
    MyTunesBLL playsongs = new MyTunesBLL();
    
    private MediaPlayer mp;
     private Media me;
    @FXML
    private Button buttonClosefx;
    @FXML
    private Button buttonSearchfx;
    
    MyTunesBLL  bll = new MyTunesBLL();
    
    int switchSearchButton = 0;
    @FXML
    private TableColumn<Songs, String> titleColumn;
    @FXML
    private TableColumn<Songs, String> ArtistColumn;
    @FXML
    private TableColumn<Songs, String> categoryColumn;
    @FXML
    private TableColumn<Songs, String> timeColumn;
    
    
    private ObservableList<Songs> songList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Playlists, String> columnName;
    
    private ObservableList<Playlists> playlistList = FXCollections.observableArrayList();
    @FXML
    private ListView<Playlists> listSongsInPlaylist;
    @FXML
    private TableView<Songs> tableListSongs;
    @FXML
    private TableView<Playlists> tablePlaylistslist;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        titleColumn.setCellValueFactory( new PropertyValueFactory("title"));
        ArtistColumn.setCellValueFactory( new PropertyValueFactory("artist"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory("category"));
        timeColumn.setCellValueFactory( new PropertyValueFactory("time"));
        columnName.setCellValueFactory(new PropertyValueFactory("name"));
        
        addAllPlaylists();
        addAllSongs();
        
        
        String path = new File("cinema.mp3").getAbsolutePath();
        me = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(me);
    }    
    
    
   

    @FXML
    private void buttonNewPlaylist(ActionEvent event) throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewPlaylist.fxml"));
        Parent root1 = loader.load();
        NewPlaylistController contrl = loader.getController();
        contrl.setMainViewCont(this);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void buttonEditPlaylist(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditPlaylist.fxml"));
        Parent root1 = loader.load();
        EditSongController contrl = loader.getController();
        contrl.setMainViewCont(this);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
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
        NewSongController contrl = loader.getController();
        contrl.setMainViewCont(this);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();
        
    }

    @FXML
    private void buttonEditSong(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditSong.fxml"));
        Parent root1 = loader.load();
        EditSongController contrl = loader.getController();
        contrl.setMainViewCont(this);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void buttonDeleteSong(ActionEvent event) {
    }

    @FXML
    private void buttonClose(ActionEvent event) {
            Stage stage = (Stage) buttonClosefx.getScene().getWindow();
            stage.close();
            
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
        mp.pause();
    }

    @FXML
    private void buttonNext(ActionEvent event) {
    }
    
    @FXML
    private void buttonSearch(ActionEvent event) {
        if (switchSearchButton ==0){

        songList.clear();
        String searched = textFieldSearch.getText();
        songList.addAll(bll.getFilteredSongs(searched));
        tableListSongs.setItems(songList);
        buttonSearchfx.setText("Clear");
        switchSearchButton ++;}
        else {
            songList.clear();
            tableListSongs.getItems().clear();
            addAllSongs();
            textFieldSearch.clear();
            switchSearchButton = 0; 
            buttonSearchfx.setText("Search");
        }
    }

    @FXML
    private void buttonPlay(ActionEvent event) {
        mp.play();
    }
    
    private void addAllSongs(){
     songList.addAll(bll.getAllSongs());
     tableListSongs.setItems(songList);
    }
    
    private void addAllPlaylists(){
        playlistList.clear();
        playlistList.addAll(bll.getAllPlaylists());
        tablePlaylistslist.setItems(playlistList);
    
    }
    
    public void getAllPlaylistsdded(Playlists playlist){
        tablePlaylistslist.getItems().clear();
        playlistList.clear();
        bll.getAllPlaylistsdded(playlist);
        addAllPlaylists();
    }
    
    public void getAllSongsAdded(Songs song){
        songList.clear();
        tableListSongs.getItems().clear();
    bll.getAllSongsAdded(song);
    addAllSongs();
    
    }
    
    
    
    
     
     
        
}
