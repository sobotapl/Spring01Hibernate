package pl.coderslab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
