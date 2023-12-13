package in.roopsai.polarbook.store.catalogservice.domain;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String isbn) {
        super("The book with ISBN " + isbn + " already exists");
    }
}
