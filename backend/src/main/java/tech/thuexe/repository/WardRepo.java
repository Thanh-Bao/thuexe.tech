package tech.thuexe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.thuexe.entity.DistrictEntity;
import tech.thuexe.entity.ProvinceEntity;
import tech.thuexe.entity.WardEntity;

import java.util.List;

public interface WardRepo extends JpaRepository<WardEntity, Integer> {
    List<WardEntity> findAllByProvinceAndDistrict(ProvinceEntity province, DistrictEntity district);
}
