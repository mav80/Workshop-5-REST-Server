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
		return bookRepository.findAll();
	}

	@Override
	public Book getSingleBookById(long bookId) {
		return bookRepository.getOne(bookId);
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
		Book book = bookRepository.getOne(bookToChange.getId());
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
		book.setTitle("Wampir z MO");
		book.setAuthor("Andrzej Pilipiuk");
		book.setPublisher("Fabryka Słów");
		book.setType("science-fiction");
		bookRepository.save(book);
		
		Book book2 = new Book();
		book2.setIsbn("2645673");
		book2.setTitle("Szczury Wrocławia");
		book2.setAuthor("Robert J. Szmidt");
		book2.setPublisher("Helion");
		book2.setType("horror");
		bookRepository.save(book2);
		
		Book book3 = new Book();
		book3.setIsbn("345635467354");
		book3.setTitle("Cyfrowa twierdza");
		book3.setAuthor("Dan Brown");
		book3.setPublisher("Amber");
		book3.setType("thriller");
		bookRepository.save(book3);
		
		Book book4 = new Book();
		book4.setIsbn("97675743");
		book4.setTitle("Księga jesiennych demonów");
		book4.setAuthor("Jarosław Grzędowicz");
		book4.setPublisher("Fabryka Słów");
		book4.setType("horror");
		bookRepository.save(book4);
		
		Book book5 = new Book();
		book5.setIsbn("3456347");
		book5.setTitle("Dallas '63");
		book5.setAuthor("Stephen King");
		book5.setPublisher("Prószyński i S-ka");
		book5.setType("fantastyka");
		bookRepository.save(book5);
		
	}

}
