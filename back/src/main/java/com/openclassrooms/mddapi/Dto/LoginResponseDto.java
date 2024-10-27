package com.openclassrooms.mddapi.Dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

	private Long id;
	private String firstName;
  private String lastName;
	private String email;
	private Date createdAt;
	private Date updatedAt;
	private String token;
  private String role;

}
