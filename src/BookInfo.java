import java.util.Scanner;

/**
 * Holds all the information about the books entered.
 */
public class BookInfo {

    private String title;
    private String author;
    private String dateOfPublication;
    private String publisher;
    private String genre;

    private Scanner scanner = new Scanner(System.in);

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return  String.format("The book's title is %s, and was written by %s and published by %s on %s in the %s genre",
                title, author, publisher, dateOfPublication, genre);
    }

    public String getTitle() {
        return title;
    }

    public void enterTitle() {
        System.out.println("Enter the title of the book.");
        do {
            this.title = scanner.nextLine();
        }while(this.title == null);
    }

    public String getAuthor() {
        return author;
    }

    public void enterAuthor() {
        System.out.println("Enter the author of the book.");
        do{
            this.author = scanner.nextLine();
        }while(this.author == null);
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void enterDate() {
        System.out.println("Enter the date of publication in the following format: [MM/DD/YYYY].");
        do {
            this.dateOfPublication = scanner.nextLine();
        }while(this.dateOfPublication == null);
    }

    public String getPublisher() {
        return publisher;
    }

    public void enterPublisher() {
        System.out.println("Enter the name of the publisher.");
        do {
            this.publisher = scanner.nextLine();
        }while(this.publisher == null);
    }

    public String getGenre() {
        return genre;
    }

    public void enterGenre() {
        System.out.println("Enter the genre of the book.");
        do {
            this.genre = scanner.nextLine();
        }while(this.genre == null);
    }
}
