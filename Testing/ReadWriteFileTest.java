import jodd.json.JsonException;
import jodd.json.JsonParser;
import org.junit.Assert;
import org.junit.Test;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by tristangreeno on 4/7/16.
 */
public class ReadWriteFileTest {

    @Test
    public void retrieveBook() throws Exception {

        File bookFile = new File("books.json");
        Scanner scanInfo = new Scanner(bookFile);
        scanInfo.useDelimiter("\\Z");
        String contents = scanInfo.next();

        JsonParser parser = new JsonParser();
        try {
            parser.parse(contents, BookInfo.class);
        }catch(JsonException e){
            System.out.println(e.getMessage());
            System.out.println("The parser could not complete the operation.");

        }
    }
    @Test
    public void printBookInfoIfNotNull() {
        BookInfo bookInfo = new BookInfo();

        if (bookInfo.getAuthor() != null) {
            System.out.printf("The book %s, written by %s, was published by %s on %s for the %s genre.",
                    bookInfo.getTitle(), bookInfo.getAuthor(), bookInfo.getPublisher(),
                    bookInfo.getDateOfPublication(), bookInfo.getGenre());
            assert false;
        }

        bookInfo.setAuthor("James");
        bookInfo.setDateOfPublication("11/11/2011");
        bookInfo.setGenre("Horror");
        bookInfo.setPublisher("Random House");
        bookInfo.setTitle("Ghastly");

        if (bookInfo.getAuthor() != null) {
            System.out.printf("The book %s, written by %s, was published by %s on %s for the %s genre.",
                    bookInfo.getTitle(), bookInfo.getAuthor(), bookInfo.getPublisher(),
                    bookInfo.getDateOfPublication(), bookInfo.getGenre());
            assert true;
        }
    }


    @Test
    public void initializeBook() {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setAuthor("Jim");

        Assert.assertEquals("Not equivalent", bookInfo.getAuthor(), "Jim");
    }

    @Test
    public void enterBookInfoIfNull() {
        BookInfo info = new BookInfo();
        if(info.getGenre() == null) {
            assert true;
        }else assert false;
    }

    @Test
    public void correctBookInfo() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = "u";
        if(input.equalsIgnoreCase("U")) {
            ReadWriteFile.enterBook();
            assert true; }
        else assert false;
    }
}