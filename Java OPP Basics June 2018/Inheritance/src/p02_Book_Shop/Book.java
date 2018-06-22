package p02_Book_Shop;

public class Book {
    protected String title;
    protected String author;
    protected double price;

    public Book(){

    }
    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    protected String getTitle() {
        return this.title;
    }

    protected void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    protected String getAuthor() {
        return this.author;
    }

    protected void setAuthor(String author) {
        String[] tokens = author.split("\\s+");
        if (tokens.length > 1 && Character.isDigit(tokens[1].charAt(0))) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    protected double getPrice() {
        return this.price;
    }

    protected void setPrice(double price) {
        if (price < 1) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Type: %s" + System.lineSeparator() +
                "Title: %s" + System.lineSeparator() +
                "Author: %s" + System.lineSeparator() +
                "Price: %s"+System.lineSeparator(),
                this.getClass().getSimpleName(), this.getTitle(), this.getAuthor(), this.getPrice());
    }
}
