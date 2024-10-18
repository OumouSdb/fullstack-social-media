package Dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class SubjectDto {

    private Long id;
    private String name;
    private LocalDateTime creation_date;
}
