package pl.coderslab.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;

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