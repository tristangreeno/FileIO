import jodd.json.JsonException;
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Writes a file to be converted into JSON. Takes data entered by the user.
 */
public class ReadWriteFile {


    public static void enterBook() throws IOException {
        BookInfo bookInfo = new BookInfo();

        if(bookInfo.author == null) bookInfo.setAuthor();
        if(bookInfo.dateOfPublication == null) bookInfo.setDateOfPublication();
        if(bookInfo.genre == null) bookInfo.setGenre();
        if(bookInfo.publisher == null) bookInfo.setPublisher();
        if(bookInfo.title == null) bookInfo.setTitle();

        JsonSerializer serializer = new JsonSerializer();
        String bookJson = serializer.include("*").serialize(bookInfo);
        File bookFile = new File("books.json");
        FileWriter bookFileWriter = new FileWriter(bookFile);
        bookFileWriter.write(bookJson);
        bookFileWriter.close();
    }

    public static BookInfo retrieveBook() throws FileNotFoundException {
        File bookFile = new File("books.json");
        Scanner scanInfo = new Scanner(bookFile);
        scanInfo.useDelimiter("\\Z");
        String contents = scanInfo.next();

        JsonParser parser = new JsonParser();
        try {
            return parser.parse(contents, BookInfo.class);
        }catch(JsonException e){
            System.out.println(e.getMessage());
            System.out.println("The parser could not complete the operation.");
            return null;
        }
    }

}
