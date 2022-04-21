package tech.thuexe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.thuexe.entity.ProvinceEntity;

public interface ProvinceRepo extends JpaRepository<ProvinceEntity, Integer> {
}
