package pl.coderslab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    // List<Book> findByAuthor_FirstName(Author author);
    List<Book> findByAuthor_FirstName(String authorFirstName);


    //Listę książek dla zadanego wydawcy
    List<Book> findBookByPublisher(Publisher publisher);


    //Listę książek dla określonego ratingu
    List<Book> findByRatingIsLessThan(int rating);


    //Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.
    Book findFirstByCategory(Category category);


    //metodę wyszukującą książki dla zadanego tytułu.
    @Query("SELECT b FROM Book b WHERE b.title = :title")
    Optional<Book> customFindBookByTitle(@Param("title") String title);


    // metodę wyszukującą książki dla zadanej kategorii
    @Query("SELECT b FROM Book b WHERE b.category =:category")
    List<Book> customFindByCategory(@Param("category") Category category);

    //Listę książek dla których rating jest pomiędzy zadanymi parametrami np. między 3 a 5.
    @Query("SELECT b FROM Book b where b.rating > 3 AND b.rating <5")
    List<Book> customFindRatingBeetween(@Param("rating") int rating);

//    @Query("SELECT b FROM Book b WHERE b.rating BETWEEN :min AND :max")
//    List<Book> customFindByRating(@Param("minValue")int min, @Param("maxValue") int min);

    //Listę książek dla zadanego wydawcy.
    @Query("SELECT b FROM Book b WHERE b.publisher =:publisher")
    List<Book> customFindByPublisher(@Param("publisher") Publisher publisher);

    //Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.
    @Query(value = "SELECT * FROM Book b WHERE category = ?1 ORDER BY title ASC LIMIT 1", nativeQuery = true)
    Optional<Book> customFindByCategorySortByTitle(@Param("category")Category category);

}
