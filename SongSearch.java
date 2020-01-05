import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * This is SongSearch class.This class do the searching from the given database.
 * In order to flexible searching it cleans all the some chrarcters.
 * This class doesn't have any communication to user. This class read the files
 * search, it also search with update. This class has searchWithUpdate,
 * loadDatabase method, and one method called readFile to do its tasks
 * @author (Minhajur Rahman, Student ID-302258) 
 * @version (a version number or a date)
 */
public class SongSearch
{
    // constant that going to be removed if exist.
    private static final String CLEAN = "[!,.? ]";
    //This the size of the files in the given folder (named songlyrics).
    private static final int LIST_SIZE = 2884;

    private ArrayList <Song> songs;
    
    public SongSearch()// constructor
    {
        songs = new ArrayList<Song>();
    }
    
    /**
     * Searching for update.
     * @param lyricsTosearch.
     * @parma whoToUpdate.
     * @return songList.
     */
    public ArrayList<String> searchWithUpdate(String lyricsToSearch,Progressable whoToUpdate)
    {
        ArrayList <String> songList = new ArrayList<String>();
        String cleanLyrics = lyricsToSearch.toLowerCase().replace(CLEAN, "").trim();
        
        whoToUpdate.reset();
        
        int i = 0;
        System.out.print("      ");
        for(Song song: songs)
        {
            if(song.contains(cleanLyrics))
            {
                songList.add(song.getArtist() +" : "+song.getTitle());
            }
            whoToUpdate.update(++i / (double) LIST_SIZE);
        }
        return songList;
    }
    
    /**
     * Load the database
     * @param whoToUpdate.
     * @return songList.
     */
    public ArrayList<String> loadDatabase(Progressable whoToUpdate)
    {
        Song song;
        ArrayList <String> songList = new ArrayList<String>();
        
        whoToUpdate.reset();
        System.out.print("      ");
        for(int i = 0; i < LIST_SIZE; i++)
        {
            //given a folder namely "songlyrics" which has the song textfiles.
            song = readFile(new File("songlyrics/song"+i+".txt"));
            if(song != null)
            {
                songs.add(song);
                songList.add(song.getTitle() +" : "+song.getArtist());
            }
            whoToUpdate.update(+i / (double) LIST_SIZE);
        }

        return songList;
    }
    
    /**
     * Read the file
     * @ param file
     * @return song of type Song
     */
    private Song readFile(File file)
    {
        Scanner in;
        Song song = null;
        
        //handling exception. 
        try {
            in = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            return null;
        }

        if (!in.hasNextLine()) return null;

        StringBuilder lyrics = new StringBuilder();

        String artist, title, firstLine[];

        firstLine = in.nextLine().trim().split("---");// clean "---" dashes.
        artist = firstLine[0];// artist
        title = firstLine[1];// title

        while(in.hasNextLine())
        {
            lyrics.append(in.nextLine().toLowerCase().replace(CLEAN, "").trim()).append(" ");
        }
        song = new Song(artist, title, lyrics.toString());

        return song;
    }

}
