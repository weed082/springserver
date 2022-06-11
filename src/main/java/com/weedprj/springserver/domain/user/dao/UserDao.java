package com.weedprj.springserver.domain.user.dao;

import com.weedprj.springserver.domain.user.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
  boolean existsUserByEmail(String email);

  Optional<User> findByEmailAndPassword(String email, String password);

  Optional<User> findByEmail(String email);

  @Query("UPDATE User SET name=:name, image_idx=:image_idx WHERE idx=:idx")
  @Modifying
  void updateProfile(
      @Param(value = "idx") long idx,
      @Param(value = "name") String name,
      @Param(value = "image_idx") String imageIdx);

  @Query(
      value =
          "SELECT friend.* FROM user friend INNER JOIN user user ON user.idx=:user_idx  WHERE"
              + " JSON_CONTAINS(user.friends->'$', CAST(friend.idx AS JSON))  ORDER BY"
              + " friend.name LIMIT :limit OFFSET :offset",
      nativeQuery = true)
  List<User> getFriends(
      @Param(value = "user_idx") long userIdx,
      @Param(value = "limit") int limit,
      @Param(value = "offset") int offset);

  @Query(
      value =
          "UPDATE user SET friends=JSON_ARRAY_APPEND(friends, '$', :friend_idx) WHERE"
              + " idx=:user_idx AND NOT JSON_CONTAINS(friends, CAST(:friend_idx AS JSON))",
      nativeQuery = true)
  @Modifying
  void addFriend(
      @Param(value = "user_idx") long userIdx, @Param(value = "friend_idx") long friendIdx);
}
