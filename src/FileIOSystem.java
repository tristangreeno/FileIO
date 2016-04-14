import java.io.IOException;
import java.util.Scanner;

/**
 * This program stores information from the user about books.
 * The program will store each book's genre, date of publication (month, day, year), publisher, author, and title.
 * If the program finds a JSON file previously made by the user, then its contents will be printed.
 * If there is no JSON file found, then a new one will be made.
 * All book JSONs are named in all lower-case letters.
 */

public class FileIOSystem {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Book Storage.");
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Here is the list of books stored:");
            BookInfo bookInfo = ReadWriteFile.retrieveBook();

            if (bookInfo != null) {
                    System.out.printf("The book %s, written by %s, was published by %s on %s for the %s genre.",
                            bookInfo.getTitle(), bookInfo.getAuthor(), bookInfo.getPublisher(),
                            bookInfo.getDateOfPublication(), bookInfo.getGenre());
                }

            else System.out.println("No information was found.");
            System.out.println("\nIf any information needs to be updated, enter 'U'.");
                System.out.println("Otherwise, enter any other key to query another book.");


            if(scanner.nextLine().equalsIgnoreCase("U")) ReadWriteFile.enterBook();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Entering new book...");
            ReadWriteFile.enterBook();
        }
    }
}
