package rr.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import rr.bookstore.domain.Book;
import rr.bookstore.domain.BookRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BookController {
        
@Autowired
private BookRepository bookRepository;

//login
@RequestMapping(value={"/booklist"})
public String bookList(Model model) {
    model.addAttribute ("books", bookRepository.findAll());
    return "booklist";    
}
//add
@RequestMapping(value="/add")
public String addBook(Model model) {
    model.addAttribute("book", new Book());
    return "addbook";
}
//save
@PostMapping(value="/save")
public String save(Book book) {
    //TODO: process POST request
    bookRepository.save(book);
    
    return "redirect:booklist";
}
//delete
@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    bookRepository.deleteById(bookId);
    return "redirect:../booklist";
}
//editing
@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
public String editBook(@PathVariable("id") Long bookId, Model model){

    model.addAttribute("book", bookRepository.findById(bookId));
    return "editbook";

}
}
