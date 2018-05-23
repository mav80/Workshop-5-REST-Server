package pl.coderslab.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.coderslab.repositories.BookRepository;

@Component
public class DatabaseBookService implements BookService{
	
	@Autowired
	public BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.customFindAllMine();
	}

	@Override
	public Book getSingleBookById(long bookId) {
		return bookRepository.findFirstById(bookId);
	}

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(long bookId) {
		Book book = bookRepository.getOne(bookId);
		bookRepository.delete(book);
	}

	@Override
	public Boolean editBook(Book bookToChange) {
		Book book = bookRepository.findFirstById(bookToChange.getId());
		if(book!=null) {
			bookRepository.save(bookToChange);
			return true;
		}
		return false;
	}

	@Override
	public void bookListReset() {
		bookRepository.deleteAll();
		
		Book book = new Book();
		book.setIsbn("56766453");
		book.setTitle("Uczta dla wron");
		book.setAuthor("George R.R. Martin");
		book.setPublisher("Zysk i S-ka");
		book.setType("fantasy");
		bookRepository.save(book);
		
		Book book2 = new Book();
		book2.setIsbn("2645673");
		book2.setTitle("Silmarillion");
		book2.setAuthor("John Ronald Reuel Tolkien");
		book2.setPublisher("Czytelnik");
		book2.setType("fantasy");
		bookRepository.save(book2);
		
		Book book3 = new Book();
		book3.setIsbn("345635467354");
		book3.setTitle("Zabij mnie tato");
		book3.setAuthor("Stefan Darda");
		book3.setPublisher("Videograf");
		book3.setType("thriller");
		bookRepository.save(book3);
		
		Book book4 = new Book();
		book4.setIsbn("97675743");
		book4.setTitle("Nieznajomi");
		book4.setAuthor("Dean Koontz");
		book4.setPublisher("Albatros");
		book4.setType("horror");
		bookRepository.save(book4);
		
		Book book5 = new Book();
		book5.setIsbn("95463453");
		book5.setTitle("Trawa jest zielona");
		book5.setAuthor("Captain Obvious");
		book5.setPublisher("Muj wydafca");
		book5.setType("oczywistość");
		bookRepository.save(book5);
		
		Book book6 = new Book();
		book6.setIsbn("132435546");
		book6.setTitle("Dom na wyrębach");
		book6.setAuthor("Stefan Darda");
		book6.setPublisher("Videograf");
		book6.setType("horror");
		bookRepository.save(book6);
		
		Book book7 = new Book();
		book7.setIsbn("34647");
		book7.setTitle("Czas pogardy");
		book7.setAuthor("Andrzej Sapkowski");
		book7.setPublisher("Putnam");
		book7.setType("fantasy");
		bookRepository.save(book7);
		
		Book book8 = new Book();
		book8.setIsbn("789843543");
		book8.setTitle("Rusz głową - Java");
		book8.setAuthor("Sierra Kathy, Bates Bert");
		book8.setPublisher("Menio");
		book8.setType("programowanie");
		bookRepository.save(book8);
		
		Book book9 = new Book();
		book9.setIsbn("435354654");
		book9.setTitle("W pustyni i w paszczy");
		book9.setAuthor("Henryk Sienkiewicz");
		book9.setPublisher("Horyzonty");
		book9.setType("przygodowa");
		bookRepository.save(book9);
		
		Book book10 = new Book();
		book10.setIsbn("768745675");
		book10.setTitle("Pan Tadeusz, czyli Ostatni zajazd na Litwie");
		book10.setAuthor("Adam Mickiewicz");
		book10.setPublisher("Ossolineum");
		book10.setType("poemat");
		bookRepository.save(book10);
		
	}

}
