package pl.coderslab.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MemoryBookService implements BookService {
	
	private List<Book> list;
	
	public MemoryBookService() {
		list = new ArrayList<>();
		bookListReset();
	}
	
	public long getNextId() {
		List<Book> books = getAllBooks();
		long nextId = 0;
		
		if(!books.isEmpty()) {
			for(Book book : books) {
				if(book.getId() > nextId) {
					nextId = book.getId();
				}
			}
		}
		System.out.println("Następne wolne id wynosi " + (nextId+1));
		return ++nextId;
	}
	
	@Override
	public List<Book> getAllBooks() {
		return list;
	}
	
	
	public void setList(List<Book> list) {
		this.list = list;
	}
	
	
	@Override
	public Book getSingleBookById(long bookId) {
		
		List<Book> books = getAllBooks();
		
		if(!books.isEmpty()) {
			for(Book book : books) {
				if(book.getId() == bookId) {
					return book;
				}
			}
		}
		
		return null;
	}
	
	
	@Override
	public void saveBook(Book book) {
		if(book != null) {
			book.setId(getNextId());
			list.add(book);
		}
	}
	
	
	@Override
	public void deleteBook(long bookId) {
		List<Book> books = getAllBooks();
		
		Book bookToRemove = new Book();
		
		if(!books.isEmpty()) {
			for(Book book : books) {
				if(book.getId() == bookId) {
					bookToRemove = book;
					break;
				}
			}
			books.remove(bookToRemove);
		}
	}
	
	
	
	@Override
	public Boolean editBook(Book bookToChange) {
		List<Book> books = getAllBooks();
		
		if(!books.isEmpty()) {
			for(Book book : books) {
				if(book.getId() == bookToChange.getId()) {
					book.setAuthor(bookToChange.getAuthor());
					book.setPublisher(bookToChange.getPublisher());
					book.setTitle(bookToChange.getTitle());
					book.setType(bookToChange.getType());
					book.setIsbn(bookToChange.getIsbn());
					return true;
				}
				return false;
			}
		}
		return false;
	}
	
	@Override
	public void bookListReset() {
		list.clear();
		list.add(new Book(1L, "8854433", "Wampir z MO", "Andrzej Pilipiuk",	"Fabryka Słów", "science-fiction"));
		list.add(new Book(2L, "656857", "Szczury Wrocławia", "Robert J. Szmidt", "Helion", "horror"));
		list.add(new Book(3L, "24785332", "Cyfrowa twierdza", "Dan Brown", "Amber", "thriller"));
		list.add(new Book(4L, "57454356", "Księga jesiennych demonów", "Jarosław Grzędowicz", "Fabryka Słów", "horror"));
		list.add(new Book(5L, "8532", "Dallas '63", "Stephen King", "Prószyński i S-ka", "fantastyka"));
		list.add(new Book(6L, "85434677", "The Catcher in the Rye", "Jerome David Salinger", "Albatros", "powieść"));
		list.add(new Book(7L, "8945345", "Motoświat", "Jeremy Clarkson", "Insignis", "podróżnicze"));
		list.add(new Book(8L, "76857697846", "Java 2 - podstawy", "Cay Horstmann, Gary Cornell", "Kwazar", "programowanie"));
		list.add(new Book(9L, "86983", "Kroniki Jakuba Wędrowycza", "Andrzej Pilipiuk", "Fabryka Słów", "fantasy"));
		list.add(new Book(10L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programowanie"));
//		list.add(new Book(11L, "5470941", "Uczta dla wron", "George R.R. Martin", "Zysk i S-ka", "fantasy"));
//		list.add(new Book(12L, "1556875434", "Silmarillion", "John Ronald Reuel Tolkien", "Czytelnik", "fantasy"));
//		list.add(new Book(13L, "543254", "Zabij mnie tato", "Stefan Darda", "Videograf", "thriller"));
//		list.add(new Book(14L, "12345678", "Nieznajomi", "Dean Koontz", "Albatros", "horror"));
//		list.add(new Book(15L, "54643453", "Dom na wyrębach", "Stefan Darda", "Videograf", "horror"));
//		list.add(new Book(16L, "23453467", "Czas pogardy", "Andrzej Sapkowski", "Putnam", "fantasy"));
//		list.add(new Book(17L, "354673456", "Rusz głową - Java", "Sierra Kathy, Bates Bert", "Menio", "programowanie"));
//		list.add(new Book(18L, "5476487", "W pustyni i w paszczy", "Henryk Sienkiewicz", "Horyzonty", "przygodowa"));
//		list.add(new Book(19L, "6967532", "Pan Tadeusz, czyli Ostatni zajazd na Litwie", "Adam Mickiewicz", "Ossolineum", "poemat"));
//		list.add(new Book(20L, "31q3544676", "Trawa jest zielona", "Captain Obvious", "Jakiś wydawca", "oczywistość"));
	}
	
	

}
