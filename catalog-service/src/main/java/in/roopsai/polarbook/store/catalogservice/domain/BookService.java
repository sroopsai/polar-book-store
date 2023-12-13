package in.roopsai.polarbook.store.catalogservice.domain;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> viewBooksList() {
        return bookRepository.findAll();
    }

    public Book viewBookDetails(String isbn) {
        return bookRepository.find(isbn).orElseThrow(()->new BookNotFoundException(isbn));
    }


    public Book addBookToCatalog(Book book) {
        if (bookRepository.exists(book.isbn())) {
            throw new BookAlreadyExistsException(book.isbn());
        } else {
            return bookRepository.save(book);
        }
    }

    public void removeBookFromCatalog(String isbn) {
        bookRepository.delete(isbn);
    }


}
