package com.openclassrooms.mddapi.Controllers;

import com.openclassrooms.mddapi.Dto.LoginDto;
import com.openclassrooms.mddapi.Dto.LoginResponseDto;
import com.openclassrooms.mddapi.Dto.UserDto;
import com.openclassrooms.mddapi.Services.JWTService;
import com.openclassrooms.mddapi.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

	@Autowired
	private UserService usersService;

	@Autowired
	private AuthenticationManager authenticationManager;

@Autowired
	private JWTService jwtService;

  @PostMapping(value = "/login")
  public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginRequest) {
    try {
      Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
      SecurityContextHolder.getContext().setAuthentication(authentication);

      UserDetails userDetails = (UserDetails) authentication.getPrincipal();
      UserDto user = usersService.findByEmail(userDetails.getUsername())
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));

      String token = jwtService.generateToken(userDetails, user.getId());

      String role = user.getRole();

      LoginResponseDto response = new LoginResponseDto(user.getId(), user.getFirstname(), user.getLastname(),
        user.getEmail(), user.getCreated_at(), user.getUpdated_at(), token, role);

      return ResponseEntity.ok(response);
    } catch (AuthenticationException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }


	@GetMapping(value = "/me")
	public ResponseEntity<LoginResponseDto> getCurrentUser(@RequestHeader("Authorization") String token) {
		try {
			LoginResponseDto currentUser = usersService.getCurrentUser(token);
			return ResponseEntity.ok(currentUser);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

  @PostMapping(value = "/register")
  public ResponseEntity<UserDto> saveUser(@RequestBody UserDto u) {
    UserDto savedUser = usersService.save(u);
    return ResponseEntity.ok(savedUser);
  }
}
