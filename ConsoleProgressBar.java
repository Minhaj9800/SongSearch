import java.util.ArrayList;
/**
 * This ConsoleProgressBar class implements the Progressable interface
 * This class giving implementation to the method update and reset.It has
 * others method namely loadDatabase(), and searchDatabase.This class facilate
 * asking the user for input and handle the print option of song and artist 
 * according the user given input lyrics. The methods of this class implemented to do so.
 * @author (Minhajur Rahman, Student ID-302258) 
 * @version (Assignment-3, February 7, 2019)
 */
public class ConsoleProgressBar implements Progressable
{
    // constant for bar length to print star according to update.
    // 20 stars print means 100% done loaded.
    private static final int BAR_LENGTH = 20;
    // Tolerance for handling the double round of error in print star.
    private static final double TOL = 0.0001;

    private double progress;
    private int printStar;
    private SongSearch search;
    private ArrayList<String> songs;

    public ConsoleProgressBar ()// constructor
    {
        progress = 0;
        printStar = 0;

        search = new SongSearch();
    }
    
    /**
     * Load database
     * @return songs
     */
    public ArrayList<String> loadDatabase()
    {
        for (int i = 0; i < BAR_LENGTH; i++) System.out.print("");

        System.out.println();
        System.out.print("Start|                    |End");
        System.out.println();
        songs = search.loadDatabase(this);
        System.out.println();
        return songs;
    }
    
    /**
     * Search the database according to the user input
     * @param want( which will be user given)
     * @return results
     */
    public ArrayList<String> searchDatabase(String want)
    {
        
        for (int i = 0; i < BAR_LENGTH; i++)System.out.print("");
        System.out.println();
        System.out.println("Search for lyrics: "+ want);
        System.out.println();
        System.out.print("Start|                    |End");
        System.out.println();
        
        ArrayList<String> results = search.searchWithUpdate(want, this);
        System.out.println();

        return results;

    }
    
    /**
     * Know the update of the system
     * @param progress
     */
    public void update(double progress)
    {
        this.progress = progress;
        if(progress >= (1.0/BAR_LENGTH)*(printStar+1) - TOL)
        {
            System.out.print("*");
            printStar++;
        }
    }
    
    /**
     * Reset the system
     */
    public void reset()
    {
        progress = 0;
        printStar = 0;
    }
}
