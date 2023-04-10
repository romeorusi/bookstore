package rr.bookstore;

import org.apache.catalina.startup.ClassLoaderFactory.RepositoryType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rr.bookstore.domain.Book;
import rr.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);

		
	}


	@Bean
		public CommandLineRunner demo(BookRepository bookRepository) {
			return (args) -> {
 		// Your code...add some demo data to db
				Book s1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", "123456789", 10.0, "1954");
				Book s2 = new Book("Valorant player", "J Tolkien", "198765432", 20.0, "1924");

				bookRepository.save(s1);
				bookRepository.save(s2);

			};
		}
	}
