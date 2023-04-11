package rr.bookstore;

import org.apache.catalina.startup.ClassLoaderFactory.RepositoryType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rr.bookstore.domain.Book;
import rr.bookstore.domain.BookRepository;
import rr.bookstore.domain.Category;
import rr.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);

		
	}


	@Bean
		public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
			return (args) -> {
 		// Your code...add some demo data to db
		 categoryRepository.save(new Category("Horror"));
		 categoryRepository.save(new Category("Drama"));
		 categoryRepository.save(new Category("Action"));
		 categoryRepository.save(new Category("Fantasy"));
		 
		 

		 bookRepository.save(new Book("Romeo", "Aleks", "1999293", 30.0, "1929", categoryRepository.findByName("Horror").get(0)));
		 bookRepository.save(new Book("Romeo", "Aleks", "1999293", 30.0, "1999", categoryRepository.findByName("Action").get(0)));

				

			};
		}
	}
