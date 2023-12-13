package in.roopsai.polarbook.store.catalogservice.domain;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String isbn) {
        super("The book with ISBN "+isbn+" does not exist");
    }
}
