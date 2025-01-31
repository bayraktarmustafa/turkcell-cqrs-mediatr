package com.turkcell.turkcellcqrs.application.book.service;

import com.turkcell.turkcellcqrs.domain.entity.Book;
import com.turkcell.turkcellcqrs.persistence.book.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findById(UUID id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAll() {
       return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public UUID delete(UUID id) {
        bookRepository.deleteById(id);
      return id;
    }
}
