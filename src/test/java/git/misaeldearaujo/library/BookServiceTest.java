package git.misaeldearaujo.library;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import git.misaeldearaujo.library.entity.Book;
import git.misaeldearaujo.library.service.BookService;

@SpringBootTest
public class BookServiceTest {

	@Test
	void isFullBook() {
		Book book = Book.builder().title("livro1").Author("testtesttesttesttestv"
				+ "testtesttesttesttesttesttesttesttesttesttesttesttesttest"
				+ "testtesttesttesttesttesttesttesttesttesttesttesttesttest"
				+ "testtesttesttesttesttesttesttesttesttesttesttesttesttest")
				.isbn("1234").releaseDate("data").build();
		
		BookService bookService = BookService.builder().build();
		
		Boolean result = bookService.isFullBook(book);
		
		assertTrue(result);
	}
	
	@Test
	@BeforeEach
	void isNotFullBook() {
		Book book = Book.builder().title("livro1").Author("testtesttestte")
				.isbn("1234").releaseDate("data").build();
		
		BookService bookService = BookService.builder().build();
		
		Boolean result = bookService.isFullBook(book);
		
		assertFalse(result);
	}
	
	
}
