package in.roopsai.polarbook.store.catalogservice.domain;

import java.util.Optional;

public interface BookRepository {

    Iterable<Book> findAll();
    Optional<Book> find(String isbn);
    boolean exists(String isbn);
    Book save(Book book);
    void delete(String isbn);


}
