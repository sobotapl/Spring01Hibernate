package pl.coderslab.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.PublisherRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("spring-data/book")
public class SpringDataBookController {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @GetMapping("all")
    public void findAll(){
        List<Book> all = bookRepository.findAll();
        all.forEach(b -> log.info("{}", b.getId()));
    }

    @GetMapping("publisher")
    public void findByNip(){
        Optional<Publisher> pb = publisherRepository.findByNip("0");
        log.info("{}", pb.get().getNip());

    }





}


