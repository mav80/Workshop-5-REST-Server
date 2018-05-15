package pl.coderslab.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MemoryBookService {
	
	private List<Book> list;
	
	public MemoryBookService() {
		
	list = new ArrayList<>();
	list.add(new Book(1L, "8854433", "Wampir z MO", "Andrzej Pilipiuk",	"Fabryka Słów", "science-fiction"));
	list.add(new Book(2L, "656857", "Szczury Wrocławia", "Robert J. Szmidt", "Helion", "horror"));
	list.add(new Book(3L, "24785332", "Cyfrowa twierdza", "Dan Brown", "Amber", "thriller"));
	list.add(new Book(4L, "57454356", "Księga jesiennych demonów", "Jarosław Grzędowicz", "Fabryka Słów", "horror"));
	}
	
	public List<Book> getList() {
		return list;
		}
	
	public void setList(List<Book> list) {
		this.list = list;
		}
	
	public Book getSingleBookById(long bookId) {
		
		List<Book> books = getList();
		
		for(Book book : books) {
			if(book.getId() == bookId) {
				return book;
			}
		}
		
		return null;
	}

}
