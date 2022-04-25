package com.finki.backend.service;

import com.finki.backend.domain.Author;
import com.finki.backend.domain.Book;
import com.finki.backend.domain.dto.BookDto;
import com.finki.backend.domain.exceptions.AuthorNotFoundException;
import com.finki.backend.domain.exceptions.BookNotFoundException;
import com.finki.backend.repository.AuthorRepository;
import com.finki.backend.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public Optional<Book> save(BookDto bookDto) {

        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));

        bookRepository.deleteByName(bookDto.getName());
        return Optional.of(bookRepository.save(new Book(0L, bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies())));
    }

    public Optional<Book> edit(Long id, BookDto bookDto) {

        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));

        book.setName(bookDto.getName());
        book.setBookCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> markAsTaken(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        if(book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
        }

        return Optional.of(this.bookRepository.save(book));
    }
}
