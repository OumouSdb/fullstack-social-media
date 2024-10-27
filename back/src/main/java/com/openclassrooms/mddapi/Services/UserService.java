package com.openclassrooms.mddapi.Services;

import com.openclassrooms.mddapi.Dto.LoginResponseDto;
import com.openclassrooms.mddapi.Dto.UserDto;
import com.openclassrooms.mddapi.Models.User;
import com.openclassrooms.mddapi.Repositories.UserRepository;
import com.openclassrooms.mddapi.configuration.CustomUserDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private JWTService jwtService;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  private UserDto convertToDto(User user) {
    return modelMapper.map(user, UserDto.class);
  }

  private User convertToEntity(UserDto userDto) {
    return modelMapper.map(userDto, User.class);
  }

  public UserDto saveUser(UserDto userDto) {
    User user = convertToEntity(userDto);
    User savedUser = this.userRepository.save(user);
    return convertToDto(savedUser);
  }

  public Optional<UserDto> findById(long id) {
    Optional<User> user = this.userRepository.findById(id);
    return user.map(this::convertToDto);
  }

  public void deleteById(long id) {
    this.userRepository.deleteById(id);
  }

  public List<UserDto> getAll() {
    List<User> users = this.userRepository.findAll();
    return users.stream()
      .map(this::convertToDto)
      .collect(Collectors.toList());
  }

  public Optional<UserDto> findByEmail(String email) {
    User user = userRepository.findByEmail(email);
    if (user != null) {
      return Optional.of(modelMapper.map(user, UserDto.class));
    } else {
      return Optional.empty();
    }
  }

  public LoginResponseDto getCurrentUser(String token) {
    String jwtToken = token.replace("Bearer ", "");
    String username = jwtService.extractUsername(jwtToken);
    User user = userRepository.findByEmail(username);

    String role = user.getRole();

    // Utilisation des bons getters
    return new LoginResponseDto(user.getId(), user.getFirstname(), user.getLastname(),
      user.getEmail(), user.getCreated_at(), user.getUpdated_at(),
      token, role);
  }


  public LoginResponseDto getCurrentUser(User user) {

    String role = user.getRole();

    return new LoginResponseDto(user.getId(), user.getFirstname(), user.getLastname(),
      user.getEmail(), user.getCreated_at(), user.getUpdated_at(),
      null, role);
  }

  public UserDto save(UserDto uDto) {
    uDto.setPassword(passwordEncoder.encode(uDto.getPassword()));
    if (uDto.getRole() == null || uDto.getRole() == "") {
      uDto.setRole("USER");
    }
    User u = modelMapper.map(uDto, User.class);
    User savedUser = userRepository.save(u);
    UserDetails userDetails = customUserDetailsService.loadUserByUsername(uDto.getEmail());
    String token = jwtService.generateToken(userDetails, savedUser.getId());
    savedUser.setToken(token);
    UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
    System.out.println("Generated JWT: " + token);

    return savedUserDto;
  }

}
