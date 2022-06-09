package com.weedprj.springserver.domain.user.dao;

import com.weedprj.springserver.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
  boolean existsUserByEmail(String email);

  Optional<User> findByEmailAndPassword(String email, String password);

  @Query("UPDATE User SET name=:name, img_url=:imgUrl WHERE idx=:idx")
  void updateProfile(
      @Param(value = "idx") long idx,
      @Param(value = "name") String name,
      @Param(value = "imgUrl") String imgUrl);
}
