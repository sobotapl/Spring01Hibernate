package pl.coderslab.dao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public List<Book> findAll(){
        return entityManager
                .createQuery("SELECT b FROM Book b")
                .getResultList();
    }

    public List<Book> findAllByRating(int rating){
        return entityManager
                .createQuery("SELECT b FROM Book b WHERE b.rating =:rating")
                .getResultList();
    }

    public List<Book> findAllWithPublisher(){
        return entityManager
                .createQuery("SELECT b FROM Book b JOIN b.publisher")
                .getResultList();
    }

    public List<Book> findBooksWithPublishers(Publisher publishers) {
        return entityManager
                .createQuery("SELECT b FROM Book b WHERE b.publisher in :publishers")
                .setParameter("publishers", publishers)
                .getResultList();
    }

    public List<Book> findBooksWithAuthors(Author author) {
        return entityManager.createQuery("SELECT DISTINCT b FROM Book b JOIN FETCH b.authors WHERE :author MEMBER OF b.authors")
                .setParameter("author", author)
                .getResultList();
    }






}