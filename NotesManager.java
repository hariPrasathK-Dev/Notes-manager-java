import java.io.*;
import java.util.Scanner ;

public class NotesManager {
    static final String FILE_NAME = "notes.txt" ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int choice ;
        do {
            System.out.println("Note-Take Application");
            System.out.println("1) Add Notes");
            System.out.println("2) View Notes");
            System.out.println("3) Exit");
            System.out.println("Enter your choice");

            choice = scanner.nextInt() ;
            scanner.nextLine() ;
            switch(choice)
            {
                case 1 -> addNote(scanner) ;
                case 2 -> viewNote() ;
                case 3 -> System.out.println("Exiting Notes Application !") ;
                default -> System.out.println("Please enter a valid Choice !") ;

            }
        }while(choice != 3) ;
    }

    public static void addNote(Scanner scanner)
    {
        System.out.println("Enter Your Notes : ") ;
        String note = scanner.nextLine() ;

        try(FileWriter writer = new FileWriter(FILE_NAME,true))
        {
            writer.write(note+System.lineSeparator());
            System.out.println("Note added Successfully!") ;
        }
        catch(IOException e)
        {
            System.err.println("Error Writing to the File : "+e.getMessage()) ;
        }
    }

    public static void viewNote() {

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String line ;
            boolean haslines = false ;

            while((line = reader.readLine()) != null)
            {
                haslines = true ;
                System.out.println(" "+line) ;
            }

            if(!haslines)
            {
                System.err.println("Notes is empty!") ;
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println("File doesn't exist!Can be created upon creation of your first note !") ;
        }
        catch(IOException e)
        {
            System.err.println("Error fetching your notes from the file!"+e.getMessage()) ;
        }
    }
}
