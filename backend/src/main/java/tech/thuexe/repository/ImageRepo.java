package tech.thuexe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.thuexe.entity.ImageEntity;

public interface ImageRepo extends JpaRepository<ImageEntity, Integer> {
    ImageEntity findById(int id);
}
