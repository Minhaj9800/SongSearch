import java.util.ArrayList;
import java.util.Scanner;
/**
 * This ConsoleDriver class is basically the tester class. In this class
 * we creating a ConsoloProgressBar object, besides asking user for the lyrics
 * When user provide lyrics, it searched for it display the expected output.
 * This class contains only the main method.
 * @author (Minhajur Rahman,Student ID-302258) 
 * @version (Assignment-3, February 7, 2019)
 */
public class ConsoleDriver
{
    public static void main(String [] args)
    {
        ArrayList<String> returned;
        Scanner in = new Scanner(System.in);
        ConsoleProgressBar progress = new ConsoleProgressBar();

        System.out.println("Loading the Database of the Songs:");
        returned = progress.loadDatabase();
        
        System.out.println("Loaded "+returned.size()+" into the database");

        System.out.println("Enter song lyrics you want to serach for: (or QUIT to quit)");
        String want = in.nextLine();
        while (!want.equalsIgnoreCase("QUIT"))
        {
            returned = progress.searchDatabase(want);
            
            for(String str : returned)
            {
                System.out.println(" "+str);
            }

            System.out.println("Enter what you want: (QUIT to quit)");
            want = in.nextLine();
        }
    }

}