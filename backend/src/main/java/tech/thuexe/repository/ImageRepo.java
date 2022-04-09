package tech.thuexe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.thuexe.entity.ImageEntity;

import java.awt.print.Pageable;

public interface ImageRepo extends JpaRepository<ImageEntity, Integer> {

}
