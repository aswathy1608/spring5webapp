package guru.springframework.spring5webapp.bootStrapData;

import guru.springframework.spring5webapp.models.Author;
import guru.springframework.spring5webapp.models.Book;
import guru.springframework.spring5webapp.models.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookAuthorData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private  final PublisherRepository publisherRepository;

    public BookAuthorData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author auth1 = new Author("Evan","Presley");
        Book book1 = new Book("Domains","IS1224");
        auth1.getBooks().add(book1);
        book1.getAuthors().add(auth1);

        Author auth2 = new Author("Melvis","Presley");
        Book book2 = new Book("Art","IS1225");
        auth1.getBooks().add(book2);
        book1.getAuthors().add(auth2);

        System.out.println("started in bootstarp");


        authorRepository.save(auth1);
        bookRepository.save(book1);
        authorRepository.save(auth2);
        bookRepository.save(book2);

        Publisher pub1= new Publisher("Penguin Publications","3rd Street","Bangalore","Karnataka",560100);
        book1.setPublisher(pub1);
        book2.setPublisher(pub1);

        pub1.getBooks().add(book1);
        pub1.getBooks().add(book2);


        publisherRepository.save(pub1);
        System.out.println("books count"+ bookRepository.count());
        System.out.println("publisher count "+ publisherRepository.count());
        System.out.println("count of books for publisher "+pub1.getBooks().size());

    }
}
