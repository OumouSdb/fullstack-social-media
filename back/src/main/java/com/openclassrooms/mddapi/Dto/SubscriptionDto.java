package com.openclassrooms.mddapi.Dto;

import com.openclassrooms.mddapi.Models.Subject;
import com.openclassrooms.mddapi.Models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDto {

    private Long id;
   private User user;
    private Subject subject;

}
