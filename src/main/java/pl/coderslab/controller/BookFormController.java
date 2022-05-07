package pl.coderslab.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("bookForm")
@RequiredArgsConstructor
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    @GetMapping("add")
    public String addNewBook(Model model){
        model.addAttribute("book", new Book());
        return "bookForm-add";
    }
    @PostMapping("add")
    public String saveNewBook(@ModelAttribute("book") @Valid Book book, BindingResult result){
        if(result.hasErrors()){
            return "bookForm-add";
        }
        bookDao.saveBook(book);
        return "redirect:/bookForm/all";
    }

    @GetMapping("edit/{id}")
    public String editBook(@PathVariable long id,Model model){
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "bookForm-edit";
    }

    @PostMapping("edit")
    public String editBook(@ModelAttribute("book") @Valid Book book, BindingResult result){
        if(result.hasErrors()){
            return "bookForm-add";
        }
        bookDao.update(book);
        return "redirect:/bookForm/all";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable long id){
        bookDao.delete(bookDao.findById(id));
        return "redirect:/bookForm/all";
    }


    @GetMapping("all")
    public String showAllBooks(Model model){
        model.addAttribute("books", bookDao.findAll());
        return "bookForm-all";
    }


    @ModelAttribute("publishers")
    public List<Publisher> getAllPublishers(){
        return publisherDao.findAll();
    }


}
