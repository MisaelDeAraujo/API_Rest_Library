package git.misaeldearaujo.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import git.misaeldearaujo.library.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
   
	UserDetails findByLogin(String login);
}

