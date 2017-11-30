/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mytunes.BE.Playlists;
import mytunes.BE.Songs;
import mytunes.BLL.MyTunesBLL;
import mytunes.ConnectionManager;

/**
 *
 * @author Arman
 */
public class MyTunesDA {
    
     private static ConnectionManager cm =  new ConnectionManager();
    
    
    public List<Songs> getFilteredSongs(String searched) {

        System.out.println("connecting");
        List<Songs> filteredSongs = new ArrayList();

        try (Connection con = cm.getConnection()) {

            String query = "SELECT * FROM SongsInfo WHERE Title LIKE ? OR artist LIKE ? OR category LIKE ?  ";

            // Protect against SQL injection
            PreparedStatement pstmt= con.prepareStatement(query);
            pstmt.setString(1, "%" + searched + "%");
            pstmt.setString(2, "%" + searched + "%");
            pstmt.setString(3, "%" + searched + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Songs song = new Songs();
                song.setTitle(rs.getString("title"));
                song.setCategory(rs.getString("category"));
                song.setArtist(rs.getString("artist"));
                song.setTime(rs.getString("time"));
                song.setFile(rs.getString("fiel"));

                filteredSongs.add(song);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(MyTunesBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filteredSongs;

    }
    
     public List<Songs> getAllSongs() {

        List<Songs> allSongs = new ArrayList();

        try (Connection con = cm.getConnection()) {

            String query = "SELECT * FROM SongsInfo";
            PreparedStatement pstmt= con.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Songs song = new Songs();
                song.setTitle(rs.getString("title"));
                song.setCategory(rs.getString("category"));
                song.setArtist(rs.getString("artist"));
                song.setTime(rs.getString("time"));
                song.setFile(rs.getString("fiel"));

                allSongs.add(song);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(MyTunesBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allSongs;

    }
     
      public List<Playlists> getAllPlaylists() {

        List<Playlists> allPlaylists = new ArrayList();

        try (Connection con = cm.getConnection()) {

            String query = "SELECT * FROM PlaylistInfo";
            PreparedStatement pstmt= con.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Playlists playlist = new Playlists();
                playlist.setName(rs.getString("name"));

                allPlaylists.add(playlist);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(MyTunesBLL.class.getName()).log( Level.SEVERE, null, ex);
        }
        return allPlaylists;

    }

  
    public void addPlaylist(Playlists playlist) {
        try (Connection con = cm.getConnection()) {
            String sql  = "INSERT INTO PlaylistInfo (name) VALUES(?)";
            PreparedStatement pstmt = con.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, playlist.getName());
            

            int affected = pstmt.executeUpdate();
            if (affected<1)
                throw new SQLException("Playlist could not be added");

        }
        catch (SQLException ex) {
            Logger.getLogger(MyTunesDA.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    public void addSong(Songs song) {
        try (Connection con = cm.getConnection()) {
            String sql  = "INSERT INTO SongsInfo (title,artist,category,fiel,time) VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, song.getTitle());
            pstmt.setString(2, song.getArtist());
            pstmt.setString(3, song.getCategory());
            pstmt.setString(4, song.getFile());
            pstmt.setString(5, song.getTime());
            

            int affected = pstmt.executeUpdate();
            if (affected<1)
                throw new SQLException("Song could not be added");

        }
        catch (SQLException ex) {
            Logger.getLogger(MyTunesDA.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        
        
    }
    
}
