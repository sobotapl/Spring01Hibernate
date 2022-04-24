package pl.coderslab.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherdao;
    private final AuthorDao authorDao;


    @RequestMapping("/book/add/{author1Id}/{author2Id}")
    @ResponseBody
    public String addBook(@PathVariable long author1Id, @PathVariable long author2Id ) {
        Publisher publisher = new Publisher();
        publisher.setName("Piotr");
        publisherdao.save(publisher);

        Author author1 = authorDao.findById(author1Id);
        Author author2 = authorDao.findById(author1Id);

        Book book = new Book();
        book.setPublisher(publisher);
        book.setTitle("Thinking in Java");
        book.setDescription("test");
        book.setRating(3);

        book.getAuthors().add(author1);
        book.getAuthors().add(author2);
        bookDao.saveBook(book);

        return "Id dodanej książki to:"
                + book.getId();
    }

    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }


    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }

}