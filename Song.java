
/**
 * This the Song Class. From here we get the artist name, song title,
 * song lyrics. There are getter methods to get each of them.
 * @author (Minhajur Rahman, Student ID-302258) 
 * @version (Assignment-3, February 7,2019)
 */
public class Song
{
    private String artistName;
    private String songTitle;
    private String lyrics;
    
    //Constructor
    public Song(String artistName, String songTitle, String lyrics)
    {
        this.artistName = artistName;
        this.songTitle = songTitle;
        this.lyrics = lyrics;
    }
    
    /**
     * Get the Artist
     * @return artistName.
     */
    public String getArtist()
    {
        return artistName;
    }
    
    /**
     * Get the title
     * @return songTitle
     */
    public String getTitle()
    {
        return songTitle;
    }
    
    /**
     * Get the lyrics.
     * @return lyrics.
     */
    public String getLyrics()
    {
        return lyrics;
    }
    
    /**
     * Lyrics checking
     * @return this.lyrics.contains(lyrics).
     */
    public boolean contains(String lyrics)
    {
        return this.lyrics.contains(lyrics);
    }
}

