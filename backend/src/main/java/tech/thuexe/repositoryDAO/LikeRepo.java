package tech.thuexe.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.thuexe.entity.LikeEntity;
import tech.thuexe.entity.PostEntity;
import tech.thuexe.entity.UserEntity;

public interface LikeRepo extends JpaRepository<LikeEntity, Integer> {
    LikeEntity findByUserAndPostLiked(UserEntity user, PostEntity postLiked);
}
