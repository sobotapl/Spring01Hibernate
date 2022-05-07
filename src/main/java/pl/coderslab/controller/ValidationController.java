package pl.coderslab.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.model.Book;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ValidationController {

    private final Validator validator;

    @GetMapping("/validate")
    public void validateObject(){
        Book book = new Book();

        Set<ConstraintViolation<Book>> result = validator.validate(book);
        if(!result.isEmpty()){
            for (ConstraintViolation<Book> violation : result) {
                log.warn("{} -> {}", violation.getPropertyPath(), violation.getMessage());

            }
        }


    }

}
