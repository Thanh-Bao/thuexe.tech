package tech.thuexe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.thuexe.entity.DistrictEntity;
import tech.thuexe.entity.ProvinceEntity;

import java.util.List;

public interface DistrictRepo extends JpaRepository<DistrictEntity, Integer> {
    List<DistrictEntity> findAllByProvince(ProvinceEntity province);
}
