package com.openclassrooms.mddapi.Dto;

import com.openclassrooms.mddapi.Models.Article;
import com.openclassrooms.mddapi.Models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto {

    private Long id;
    private String content;
    private Article article;
   private User user;
    private LocalDateTime date;

}
