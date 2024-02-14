package git.misaeldearaujo.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import git.misaeldearaujo.library.entity.dto.AuthenticationDTO;
import git.misaeldearaujo.library.entity.dto.LoginResponseDTO;
import git.misaeldearaujo.library.entity.dto.RegisterDTO;
import git.misaeldearaujo.library.repository.UserRepository;
import git.misaeldearaujo.library.service.TokenService;
import jakarta.validation.Valid;
import git.misaeldearaujo.library.entity.User;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;	
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public ResponseEntity login (@RequestBody @Valid AuthenticationDTO authenticationDto) {
		var userNamePassword = new UsernamePasswordAuthenticationToken(authenticationDto.login(),
				authenticationDto.password());
		var auth = this.authenticationManager.authenticate(userNamePassword);
		var token = tokenService.generateToken((User) auth.getPrincipal());
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDto) {
        if(this.userRepository.findByLogin(registerDto.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.password());
        User newUser = new User(registerDto.login(), encryptedPassword, registerDto.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
			
		}
}
