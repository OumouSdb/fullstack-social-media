package Dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class ArticleDto {
    private Long id;
    private String title;
    //private Subject subjectId;
    //private User userId;
    private LocalDateTime date;
   private String content;

}
