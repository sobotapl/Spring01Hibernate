package pl.coderslab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //metodę wyszukującą książki dla zadanego tytułu.
    Optional<Book> findByTitle(String title);

    //metodę wyszukującą książki dla zadanej kategorii
    List<Book> findByCategory(Category category);

    //metodę wyszukującą książki dla zadanego id kategorii
    List<Book> findByCategoryId(Long categoryId);

    //Listę książek dla zadanego autora.
    //List<Book> findByAuthor(Author author);


    //Listę książek dla zadanego wydawcy
    List<Book> findBookByPublisher(Publisher publisher);


    //Listę książek dla określonego ratingu
    List<Book> findByRatingIsLessThan(int rating);


    //Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.
    Book findFirstByCategory(Category category);

}
