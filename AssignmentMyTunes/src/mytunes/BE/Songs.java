/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.BE;

/**
 *
 * @author Arman
 */
public class Songs {

    private String title;
    private String artist;
    private String category;
    private String time;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
   
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Songs{" + "title=" + title + ", artist=" + artist + ", category=" + category + ", time=" + time + ", file=" + file + '}';
    }

   

    
}
