package MiniBookStore;

public class Book extends Product{



    private String authorname;
    private String publisher;
    private String isbn;

    public Book(String name, String price, int stock, String authorname, String publisher, String isbn) {
        super(name, price, stock);
        this.authorname = authorname;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
