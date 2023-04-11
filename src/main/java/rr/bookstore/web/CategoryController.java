package rr.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import rr.bookstore.domain.CategoryRepository;
import rr.bookstore.domain.Category;


@Controller
public class CategoryController {
    
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/categorylist")
    public String categoryList(Model model) {

        model.addAttribute("categories", categoryRepository.findAll());

        return "categorylist";

        
    }
       
    

    @RequestMapping(value="/addcategory")
    public String addCategory(Model model) {
	
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @RequestMapping(value = "/save-category", method = RequestMethod.POST)
    public String saveCategory(Category category) {

	categoryRepository.save(category);
	return "redirect:/categorylist";

    }
    
}
