package com.example.sreactive.services;


import com.example.sreactive.repository.BookRepository;
import com.example.sreactive.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceReactive {

    private final BookRepository repository;

    @Autowired
    public BookServiceReactive(BookRepository repository) {
        this.repository = repository;
    }

    public Flux<Book> getAllBooks() {
        return repository.findAll();
    }

    public Mono<Book> getBookById(Long id) {
        return repository.findById(id);
    }

    public Mono<Book> saveBook(Book book) {
        return repository.save(book);
    }

    public Mono<Book> updateBook(Long id, Book book) {
        return repository
                .findById(id)
                .flatMap(
                        existing -> {
                            existing.setName(book.getName());
                            existing.setAuthor(book.getAuthor());
                            existing.setQuantity(book.getQuantity());
                            existing.setPrice(book.getPrice());
                            return repository.save(existing);
                        });
    }

    public Mono<Void> deleteBook(Long id) {
        return repository.deleteById(id);
    }
}
