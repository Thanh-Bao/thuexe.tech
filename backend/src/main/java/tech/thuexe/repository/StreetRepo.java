package tech.thuexe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.thuexe.entity.DistrictEntity;
import tech.thuexe.entity.ProvinceEntity;
import tech.thuexe.entity.StreetEntity;

import java.util.List;

public interface StreetRepo extends JpaRepository<StreetEntity, Integer> {

    List<StreetEntity> findAllByProvinceAndDistrict(ProvinceEntity province, DistrictEntity district);

}
