package git.misaeldearaujo.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import git.misaeldearaujo.library.entity.Book;
import git.misaeldearaujo.library.exception.FullBookException;
import git.misaeldearaujo.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Service
@AllArgsConstructor
@Builder
public class BookService {

	private BookRepository bookRepository;
	
	public Boolean isFullBook(Book book) {
		Boolean condition = book.getAuthor().length() >30 
				|| book.getTitle().length() > 30
				|| book.getIsbn().length() > 13;
		if(condition){
			return true;
		}
		return false;
	}
	
	public Book save(Book book) {
		if(isFullBook(book)) {
			throw new FullBookException();
		}
		return bookRepository.save(book);
	}
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public Optional<Book> findById(Integer id) {
		return bookRepository.findById(id);
	}
}
