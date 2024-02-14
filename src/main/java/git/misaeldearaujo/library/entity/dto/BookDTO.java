package git.misaeldearaujo.library.entity.dto;

import jakarta.validation.constraints.NotEmpty;

public record BookDTO(
		@NotEmpty
		String title,
		@NotEmpty
		String author,
		@NotEmpty
		String isbn) {

}
