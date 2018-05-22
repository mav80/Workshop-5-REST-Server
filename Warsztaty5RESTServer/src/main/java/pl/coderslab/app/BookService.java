package pl.coderslab.app;

import java.util.List;

public interface BookService {
	
	//long getNextId();
	
	List<Book> getAllBooks();
	Book getSingleBookById(long bookId);
	//void setList(List<Book> list);
	void saveBook(Book book);
	void deleteBook(long bookId);
	Boolean editBook(Book bookToChange);
	
	void bookListReset();

}
