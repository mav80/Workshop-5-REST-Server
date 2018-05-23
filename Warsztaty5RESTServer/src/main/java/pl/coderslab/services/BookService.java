package pl.coderslab.services;

import java.util.List;

import pl.coderslab.app.Book;

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
