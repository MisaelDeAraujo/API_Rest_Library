package git.misaeldearaujo.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import git.misaeldearaujo.library.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	
}
