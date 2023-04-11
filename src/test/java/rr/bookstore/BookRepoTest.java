package rr.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import rr.bookstore.domain.Book;
import rr.bookstore.domain.BookRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepoTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired 
    private TestEntityManager entityManager;

    @Test
    public void findByTitleShouldReturnTitle() {
        List<Book> books = bookRepository.findByTitle("Romeo");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Aleks");
    }

    @Test
    public void createNewBook() {
        Book book = new Book("Pokemon", "Nintendo", "6969420", 10.0, "1980", null);
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        Book book = new Book("Pokemon2", "Nintendo", "6969420", 10.0, "1980", null);
        final Long id= entityManager.persistAndGetId(book, Long.class);
        bookRepository.deleteById(id);
        entityManager.flush();
        Book after = entityManager.find(Book.class, id);
        bookRepository.deleteById(book.getId());
        assertThat(after).isNull();
    }
    
}
