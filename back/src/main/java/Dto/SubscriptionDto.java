package Dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class SubscriptionDto {

    private Long id;
   // private User userId;
   // private Subject themeId;
    private LocalDateTime dateOfSubscription;
    private LocalDateTime dateOfunSubscription;

}
