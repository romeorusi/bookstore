package rr.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import rr.bookstore.domain.Book;
import rr.bookstore.domain.BookRepository;
import rr.bookstore.domain.CategoryRepository;


@Controller
public class BookController {
        
@Autowired
private BookRepository bookRepository;

@Autowired
private CategoryRepository categoryRepository;

//login
@RequestMapping(value="/login")
public String login() {
    return "login";
}

//show books
@RequestMapping(value={"/booklist"})
public String bookList(Model model) {

    model.addAttribute ("books", bookRepository.findAll());
    model.addAttribute("categories", categoryRepository.findAll());
    
    return "booklist";    
}
//rest tietojen hakemiseen
@RequestMapping(value="/books", method=RequestMethod.GET)
public @ResponseBody List<Book> bookListRest() {
    return (List<Book>) bookRepository.findAll();
}

//rest tietojen hakemiseen ID:llä
@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
public @ResponseBody Optional<Book> findBookRest(@PathVariable("id")Long bookId){
    return bookRepository.findById(bookId);
}



//add
@RequestMapping(value="/add")
public String addBook(Model model) {

    model.addAttribute("book", new Book());
    model.addAttribute("categories", categoryRepository.findAll());

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
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    bookRepository.deleteById(bookId);
    return "redirect:../booklist";
}
//editing
@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
public String editBook(@PathVariable("id") Long bookId, Model model){

    model.addAttribute("book", bookRepository.findById(bookId));
    model.addAttribute("categories", categoryRepository.findAll());
    return "editbook";

}
}
