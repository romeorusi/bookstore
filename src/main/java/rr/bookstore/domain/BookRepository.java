package rr.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findById(String bookId);

    void deleteById(Long bookId);

    List<Book> findByTitle(String title);

    Book findById(Book book);

	void deleteById(Book book);
}
