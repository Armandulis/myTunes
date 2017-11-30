/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.BLL;

import java.util.List;
import mytunes.BE.Playlists;
import mytunes.BE.Songs;
import mytunes.DAL.MyTunesDA;

/**
 *
 * @author Arman
 */
public class MyTunesBLL {
    
     MyTunesDA da = new MyTunesDA();
    
     public List<Songs> getFilteredSongs(String searched) {
        return da.getFilteredSongs(searched);
    }
     
     public List<Songs> getAllSongs(){
     return da.getAllSongs();
     }
     
     public List<Playlists> getAllPlaylists(){
     return da.getAllPlaylists();
     }
     
     public List<Playlists> getAllPlaylistsdded(Playlists playlist){
           
         da.addPlaylist(playlist);
            
     return da.getAllPlaylists();
     }

    public List<Songs> getAllSongsAdded(Songs song) {
       da.addSong(song);
               return da.getAllSongs();
               
    }
     
     

    
    
    
   
     
    
    
    
}
