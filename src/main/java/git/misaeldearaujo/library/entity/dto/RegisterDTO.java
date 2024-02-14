package git.misaeldearaujo.library.entity.dto;

import git.misaeldearaujo.library.entity.enums.UserRole;

public record RegisterDTO (
		String login,
		String password,
		UserRole role){

}
