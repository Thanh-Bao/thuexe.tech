package tech.thuexe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.thuexe.entity.PostEntity;

public interface PostRepo extends JpaRepository<PostEntity, Integer> {
}
