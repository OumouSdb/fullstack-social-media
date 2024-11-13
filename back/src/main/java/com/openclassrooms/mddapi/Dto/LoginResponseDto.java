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
	private String firstname;
  private String lastname;
	private String email;
	private Date createdAt;
	private Date updatedAt;
	private String token;
  private String role;

}
