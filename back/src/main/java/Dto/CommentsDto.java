package Dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class CommentsDto {

    private Long id;
    private String content;
   // private Article articleId;
  //  private User userId;
    private LocalDateTime date;

}
