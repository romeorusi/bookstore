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
import rr.bookstore.domain.User;
import rr.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);

		
	}


	@Bean
		public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository UserRepository) {
			return (args) -> {
 		// Your code...add some demo data to db
		 categoryRepository.save(new Category("Horror"));
		 categoryRepository.save(new Category("Drama"));
		 categoryRepository.save(new Category("Action"));
		 categoryRepository.save(new Category("Fantasy"));
		 
		 

		bookRepository.save(new Book("Romeo", "Aleks", "1999293", 30.0, "1929", categoryRepository.findByName("Horror").get(0)));
		bookRepository.save(new Book("Romeo", "Aleks", "1999293", 30.0, "1999", categoryRepository.findByName("Action").get(0)));

		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@bookstore.com" ,"USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "user2@bookstore.com" ,"ADMIN");
		 
		UserRepository.save(user1);
		UserRepository.save(user2);
		 

			};
		}
	}
