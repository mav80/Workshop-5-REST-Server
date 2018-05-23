package pl.coderslab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import pl.coderslab.app.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	@Query(value = "SELECT * FROM books", nativeQuery = true)
	List<Book> customFindAllMoje();

}
