package rr.bookstore.domain;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String publicationYear;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    
   
    public Book() {}

    public Book(String title, String author, String isbn, double price, String publicationYear, Category category) {
        super();
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.publicationYear = publicationYear;
        this.category = category;
    }



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }
    
    @Override
    public String toString() {

        if (this.category != null)

            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
                    + ", publicationYear=" + publicationYear + ", category=" + this.getCategory() + "]";
                    
        else

        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
                + ", publicationYear=" + publicationYear + "]";
    }
    
    
}
