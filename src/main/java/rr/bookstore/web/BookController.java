package rr.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import rr.bookstore.domain.Book;
import rr.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BookController {
        
@Autowired
private BookRepository bookRepository;

@RequestMapping(value={"/booklist"})
public String bookList(Model model) {
    model.addAttribute ("books", bookRepository.findAll());
    return "booklist";    
}
@RequestMapping(value="/add")
public String addBook(Model model) {
    model.addAttribute("book", new Book());
    return "addbook";
}
@PostMapping(value="/save")
public String save(Book book) {
    //TODO: process POST request
    bookRepository.save(book);
    
    return "redirect:booklist";
}

}
