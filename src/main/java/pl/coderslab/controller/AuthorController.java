package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;

import javax.validation.Valid;

@Controller
public class AuthorController {

    AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/author/add")
    @ResponseBody
    public String addAuthor() {
        Author author = new Author();
        author.setFirstName("Jan");
        author.setLastName("Nowak");
        authorDao.save(author);
        return "Id Autora:"
                + author.getId();
    }

    @PostMapping("/authorAdd")
    public String saveNewBook(@ModelAttribute("author") @Valid Author author, BindingResult result){
        if(result.hasErrors()){
            return "author-add";
        }
        authorDao.save(author);
        return "redirect:/authorAll";
    }

    @GetMapping("/authorAdd")
    public String addNewBook(Model model){
        model.addAttribute("author", new Author());
        return "author-add";
    }

    @GetMapping("/authorAll")
    public String showAllAuthors(Model model){
        model.addAttribute("author", authorDao.findAll());
        return "author-all";
    }


    @RequestMapping("/author/update/{id}/{name}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String name ) {
        Author author = authorDao.findById(id);
        author.setLastName(name);
        authorDao.update(author);
        return author.toString();
    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }


    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "deleted";
    }

}