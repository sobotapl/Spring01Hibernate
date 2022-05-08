package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByEmail(String email);
    Optional<Author> findByPesel(String pesel);
    List<Author> findByLastName(String lastName);

//    Listę autorów, których email zaczyna się od wskazanego ciągu znaków.
    @Query("SELECT a FROM Author a WHERE a.email LIKE :startWith%")
    List<Author> findByEmailStartWith(@Param("startWith")String startWith);

//    Listę autorów których pesel zaczyna się od wskazanych znaków, np 83.
    @Query("SELECT a FROM Author a WHERE a.pesel LIKE :startWith%")
    List<Author> findByPeselStartWith(@Param("startWith")String startWith);
}
