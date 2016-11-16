package pl.akademiakodu.library.dao;

import pl.akademiakodu.library.domain.Book;

import java.util.List;

/**
 * Created by Lenovo on 2016-11-16.
 */
public interface BookDao {
    void addBook(Book book);
    void removeBook(Book book);
    List<Book> getAllBooks();
}
