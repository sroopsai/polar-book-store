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

    public Book updateBookDetails(String isbn, Book book) {
        return bookRepository.find(isbn).map(existingBook -> {
            var bookToUpdate = new Book(existingBook.isbn(),book.title(),
            book.author(),
            book.price());
        return bookRepository.save(bookToUpdate);
        }).orElseGet(() -> addBookToCatalog(book));
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
