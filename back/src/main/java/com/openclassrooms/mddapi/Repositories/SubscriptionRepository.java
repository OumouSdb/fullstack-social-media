package com.openclassrooms.mddapi.Repositories;

import com.openclassrooms.mddapi.Models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

  @Query("SELECT s FROM Subscription s WHERE s.user.id = :userId")
  List<Subscription> findSubscriptionsByUserId(@Param("userId") Long userId);
}
