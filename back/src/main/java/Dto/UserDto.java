package Dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
public class UserDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
