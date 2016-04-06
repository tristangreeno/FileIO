import java.util.Scanner;

/**
 * Holds all the information about the books entered.
 */
public class BookInfo {

    public String title;
    public String author;
    public String dateOfPublication;
    public String publisher;
    public String genre;

    private Scanner titleScan = new Scanner(System.in);
    private Scanner authorScan = new Scanner(System.in);
    private Scanner dateScan = new Scanner(System.in);
    private Scanner publisherScan = new Scanner(System.in);
    private Scanner genreScan = new Scanner(System.in);

    @Override
    public String toString(){
        return  String.format("The book's title is %s, and was written by %s and published by %s on %s in the %s genre",
                title, author, dateOfPublication, publisher, genre);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle() {
        System.out.println("Enter the title of the book.");
        this.title = titleScan.nextLine();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor() {
        System.out.println("Enter the author of the book.");
        this.author = authorScan.nextLine();
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication() {
        System.out.println("Enter the date of publication in the following format: [MM/DD/YYYY].");
        this.dateOfPublication = dateScan.nextLine();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher() {
        System.out.println("Enter the name of the publisher.");
        this.publisher = publisherScan.nextLine();
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre() {
        System.out.println("Enter the genre of the book.");
        this.genre = genreScan.nextLine();
    }
}
