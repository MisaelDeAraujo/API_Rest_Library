package git.misaeldearaujo.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import git.misaeldearaujo.library.entity.Book;
import git.misaeldearaujo.library.entity.dto.BookDTO;
import git.misaeldearaujo.library.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/library")
@AllArgsConstructor
public class BookController {

	private BookService bookService;
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseEntity<Object> save(@Valid @RequestBody BookDTO bookDTO){
		var book = Book.builder().build();
		BeanUtils.copyProperties(bookDTO, book);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> findAll(){
		return ResponseEntity.ok(bookService.findAll());
	}
	
	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@PathVariable(value = "id") Integer id,
			@RequestBody @Valid BookDTO bookDTO){
		Optional<Book> bookId = bookService.findById(id);
		if(bookId.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
		} // Levar essa condição para Service.
		
		var book = bookId.get();
		BeanUtils.copyProperties(bookDTO, book);
		return ResponseEntity.status(HttpStatus.OK).body(bookService.save(book));
	}
}
