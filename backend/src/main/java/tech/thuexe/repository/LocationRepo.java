package tech.thuexe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.thuexe.entity.LocationEntity;

import java.util.List;

public interface LocationRepo extends JpaRepository<LocationEntity, Integer> {
    List<LocationEntity> findAllByProvinceId(int provinceId);
}
