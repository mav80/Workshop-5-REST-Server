package pl.coderslab.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MemoryBookService implements BookService {
	
	private List<Book> list;
	
	public MemoryBookService() {
		list = new ArrayList<>();
		listReset();
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
	public void editBook(Book bookToChange) {
		List<Book> books = getAllBooks();
		
		if(!books.isEmpty()) {
			for(Book book : books) {
				if(book.getId() == bookToChange.getId()) {
					book.setAuthor(bookToChange.getAuthor());
					book.setPublisher(bookToChange.getPublisher());
					book.setTitle(bookToChange.getTitle());
					book.setType(bookToChange.getType());
					book.setIsbn(bookToChange.getIsbn());
					break;
				}
			}
		}
	}
	
	public void listReset() {
		list.clear();
		list.add(new Book(1L, "8854433", "Wampir z MO", "Andrzej Pilipiuk",	"Fabryka Słów", "science-fiction"));
		list.add(new Book(2L, "656857", "Szczury Wrocławia", "Robert J. Szmidt", "Helion", "horror"));
		list.add(new Book(3L, "24785332", "Cyfrowa twierdza", "Dan Brown", "Amber", "thriller"));
		list.add(new Book(4L, "57454356", "Księga jesiennych demonów", "Jarosław Grzędowicz", "Fabryka Słów", "horror"));
	}
	
	

}
